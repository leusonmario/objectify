/*
 * $Id$
 * $URL$
 */

package com.googlecode.objectify.test.entity;

import javax.persistence.Id;

/**
 * A fruit.
 * 
 * @author Scott Hernandez
 */
public abstract class Fruit
{
	@Id Long id;
	String color;
	String taste;
	
	/** Default constructor must always exist */
	protected Fruit() {}
	
	/** Constructor*/
	protected Fruit(String color, String taste)
	{
		this.color = color;
		this.taste = taste;
	}
	
	public String getColor()
	{
		return this.color;
	}
	
	public String getTaste()
	{
		return this.taste;
	}
}