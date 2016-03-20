package com.medelp.backend.apis;

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
import com.medelp.backend.utils.AuthenticateUser;

/**
 * 
 * @author vasanth
 *
 */
@Api(name = "driverApis", version = "v1", 
namespace = @ApiNamespace(ownerDomain = Constants.API_OWNER, ownerName = Constants.API_OWNER, packagePath = Constants.API_PACKAGE_PATH))
public class DriverApis {
	private static final Logger log = Logger.getLogger(DriverApis.class.getName());
	
	@ApiMethod(name = "createDriver")
	public Driver createDriver(@Named("phoneNumber") String phoneNumber,@Nullable @Named("deviceId") String deviceId, @Nullable @Named("address") String address) throws OAuthRequestException {
		
		log.info("------------Inside the createDriver API");
		AuthenticateUser authUser = AuthenticateUser.getInstance();
		User user = authUser.authenticate();
		
		Key<Driver> driverKey = Key.create(Driver.class, user.getUserId());
		return new Driver("sdsd", "ddsf", "fdfsaf", "sdfdf", "dfse", true);
	}
}
