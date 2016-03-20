package com.medelp.backend.utils;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

import com.medelp.backend.models.Customer;
import com.medelp.backend.models.Driver;

/**
 * 
 * @author vasanth
 *
 */
public final class OfyService {
    /**
     * Default constructor, never called.
     */
    private OfyService() {
    }

    static {
            factory().register(Driver.class);
            factory().register(Customer.class);
    }

    /**
     * Returns the Objectify service wrapper.
     * @return The Objectify service wrapper.
     */
    public static Objectify ofy() {
        return ObjectifyService.ofy();
    }

    /**
     * Returns the Objectify factory service.
     * @return The factory service.
     */
    public static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }
}
