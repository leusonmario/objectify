package com.googlecode.objectify;

import com.google.appengine.api.datastore.Transaction;


/**
 * <p>This is a simple container for a single static instance of ObjectifyFactory.
 * You can choose to use this class or build your own equivalent.  You may prefer
 * to use a dependency injection system like Weld or Guice directly with an
 * ObjectifyFactory and eschew this class entirely.</p>
 * 
 * <p>For further advice, see the
 * <a href="http://code.google.com/p/objectify-appengine/wiki/BestPractices">BestPractices</a>.</p>
 * 
 * @author Jeff Schnitzer <jeff@infohazard.org>
 */
public class ObjectifyService
{
	/** Singleton instance */
	protected static ObjectifyFactory factory = new ObjectifyFactory();
	
	/** Call this to get the instance */
	public static ObjectifyFactory factory() { return factory; }

	//
	// All static methods simply pass-through to the singleton factory
	//

	/** @see ObjectifyFactory#begin() */
	public static Objectify begin() { return factory().begin(); }
	
	/** @see ObjectifyFactory#beginTransaction() */
	public static Objectify beginTransaction() { return factory().beginTransaction(); }
	
	/** @see ObjectifyFactory#withTransaction(Transaction) */
	public static Objectify withTransaction(Transaction txn) { return factory().withTransaction(txn); }

	/** @see ObjectifyFactory#register(Class) */
	public static void register(Class<?> clazz) { factory().register(clazz); }
	
	/** @see ObjectifyFactory#setDatastoreTimeoutRetryCount(int) */
	public static void setDatastoreTimeoutRetryCount(int value) { factory().setDatastoreTimeoutRetryCount(value); }

	/** @see ObjectifyFactory#getDatastoreTimeoutRetryCount() */
	public static int getDatastoreTimeoutRetryCount() { return factory().getDatastoreTimeoutRetryCount(); }
	
	//
	// Methods equivalent to those on KeyFactory, but which use typed Classes instead of kind.
	//
	
	/** @see ObjectifyFactory#createKey(Class, long) */
	public static <T> OKey<T> createKey(Class<T> kind, long id) { return factory().createKey(kind, id); }
	
	/** @see ObjectifyFactory#createKey(Class, String) */
	public static <T> OKey<T> createKey(Class<T> kind, String name) { return factory().createKey(kind, name); }
	
	/** @see ObjectifyFactory#createKey(OKey, Class, long) */
	public static <T> OKey<T> createKey(OKey<?> parent, Class<T> kind, long id) { return factory().createKey(parent, kind, id); }
	
	/** @see ObjectifyFactory#createKey(OKey, Class, String) */
	public static <T> OKey<T> createKey(OKey<?> parent, Class<T> kind, String name) { return factory().createKey(parent, kind, name); }
	
	/** @see ObjectifyFactory#createKey(Object) */
	public static <T> OKey<T> createKey(T entity) { return factory().createKey(entity); }
	
	//
	// Friendly query creation methods
	//
	
	/** @see ObjectifyFactory#createQuery() */
	public static <T> OQuery<T> createQuery() { return factory().createQuery(); }
	
	/** @see ObjectifyFactory#createQuery(Class) */
	public static <T> OQuery<T> createQuery(Class<T> entityClazz) { return factory().createQuery(entityClazz); }
}