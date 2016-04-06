package com.medelp.backend.apis;

import static com.medelp.backend.utils.OfyService.ofy;

import java.util.logging.Logger;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.config.Nullable;
import com.google.appengine.api.oauth.OAuthRequestException;
import com.google.appengine.api.users.User;
import com.googlecode.objectify.Key;
import com.medelp.backend.Constants;
import com.medelp.backend.models.Driver;

/**
 * 
 * @author vasanth
 *
 */
@Api(name = "driverApis", version = "v1", namespace = @ApiNamespace(ownerDomain = Constants.API_OWNER, ownerName = Constants.API_OWNER, packagePath = Constants.API_PACKAGE_PATH), scopes = {
		Constants.EMAIL_SCOPE }, clientIds = { Constants.WEB_CLIENT_ID, Constants.ANDROID_CLIENT_ID,
				Constants.IOS_CLIENT_ID, Constants.API_EXPLORER_CLIENT_ID }, audiences = { Constants.AUDIENCE_ID })
public class DriverApis {
	private static final Logger log = Logger.getLogger(DriverApis.class.getName());
	
	@ApiMethod(name = "createDriver")
	public Driver createDriver(final User user, @Named("phoneNumber") String phoneNumber,@Nullable @Named("deviceId") String deviceId, @Nullable @Named("address") String address) throws OAuthRequestException {
		
		log.info("------------Inside the createDriver API");
		if(user == null)
			throw new OAuthRequestException("Authorization required.");
		
		String userId = user.getUserId();
		
		if (userId == null)
			userId = user.getEmail();
		
		Key<Driver> driverKey = Key.create(Driver.class, userId);
		
		Driver driver = (Driver) ofy().load().key(driverKey).now();
		log.info("loaded if exists");
		if (driver == null) {
			log.info("Creating new driver with userId: " + userId);
			driver = new Driver(userId, user.getEmail(), phoneNumber, deviceId, address);
		} else {
			log.info("Retrieved driver with userId: " + userId);
			driver.updateDetails(phoneNumber, address, deviceId);
		}
		ofy().save().entity(driver).now();
		return driver;
	}
	
	@ApiMethod(name = "getDriver")
	public Driver getDriver(final User user) throws OAuthRequestException {

		log.info("------------Inside the getDriver API ------------");

		if(user == null)
			throw new OAuthRequestException("Authorization required.");
		
		String userId = user.getUserId();
		Key<Driver> driverKey = Key.create(Driver.class, userId);;
		
		Driver driver = (Driver) ofy().load().key(driverKey).now();
		if (driver == null) {
			log.info("No driver found with userId: " + userId);
			throw new IllegalArgumentException("No driver found with userId: " + userId);
		} else {
			log.info("Retrieved driver with userId: " + userId);
			return driver;
		}
	}
	
	@ApiMethod(name = "updateDriverStatus")
	public Driver updateDriverStatus(final User user, @Named("phoneNumber") boolean status) throws OAuthRequestException {
		
		log.info("------------Inside the updateDriverStatus API ------------");
		
		if(user == null)
			throw new OAuthRequestException("Authorization required.");
		String userId = user.getUserId();
		Key<Driver> driverKey = Key.create(Driver.class, userId);
		Driver driver = (Driver) ofy().load().key(driverKey).now();
		if (driver == null) {
			log.info("No driver found with userId: " + userId);
			throw new IllegalArgumentException("No driver found with userId: " + userId);
		} else {
			log.info("Updating status of driver with userId: " + userId + " to " + status);
			driver.setCheckedIn(status);
			return driver;
		}
	}
}
