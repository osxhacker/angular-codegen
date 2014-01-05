/**
 * Created on: Jan 2, 2014
 */
package com.iteamsolutions.angular

import org.scalatest.{
	FunSpec,
	GivenWhenThen,
	Matchers
	}


/**
 * The '''ProjectSpec''' type defines the common configuration for
 * [[http://www.scalatest.org/user_guide ScalaTest]] based unit tests.
 *
 * @author svickers
 *
 */
trait ProjectSpec
	extends FunSpec
		with GivenWhenThen
		with Matchers
{

}
