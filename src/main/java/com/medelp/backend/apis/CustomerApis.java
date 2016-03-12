package com.medelp.backend.apis;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.config.Nullable;
import com.google.appengine.api.oauth.OAuthRequestException;
import com.google.appengine.api.users.User;
import com.googlecode.objectify.Key;
import com.medelp.backend.models.Customer;
import com.medelp.backend.Constants;
import static com.medelp.backend.utils.OfyService.ofy;
import java.util.logging.Logger;

/**
 * 
 * @author vasanth
 *
 */
@Api(name = "customerApis", version = "v1", 
	clientIds = { Constants.API_EXPLORER_CLIENT_ID, Constants.WEB_CLIENT_ID,Constants.ANDROID_CLIENT_ID, Constants.IOS_CLIENT_ID }, 
	audiences = {Constants.AUDIENCE_ID }, 
	namespace = @ApiNamespace(ownerDomain = Constants.API_OWNER, ownerName = Constants.API_OWNER, packagePath = Constants.API_PACKAGE_PATH))
public class CustomerApis {

	private static final Logger log = Logger.getLogger(CustomerApis.class.getName());

	@ApiMethod(name = "createCustomer")
	public Customer createCustomer(final User user, @Named("phoneNumber") String phoneNumber,
			@Nullable @Named("deviceId") String deviceId, @Nullable @Named("address") String address) throws OAuthRequestException {

		log.info("------------Inside the createCustomer API----------");
		if (user == null) {
			throw new OAuthRequestException("Authorization required");
		}
		Key<Customer> customerKey = Key.create(Customer.class, user.getUserId());
		Customer customer = (Customer) ofy().load().key(customerKey).now();
		if (customer == null) {
			log.info("Creating new customer with userId: " + user.getUserId());
			customer = new Customer(user.getUserId(), user.getEmail(), phoneNumber, deviceId, address);
		}
		else {
			log.info("Retrieved customer with userId: " + user.getUserId());
			customer.updateDetails(phoneNumber, address);
		}
		ofy().save().entity(customer).now();
		return customer;
	}
}
