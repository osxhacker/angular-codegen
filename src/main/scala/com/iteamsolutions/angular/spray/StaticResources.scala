/**
 * Created on: Jan 4, 2014
 */
package com.iteamsolutions.angular.spray

import spray.routing.{
	HttpService,
	Route
    }


/**
 * The '''StaticResources''' type serves up resources located in the
 * `WEB-INF` class path location.  Since it, effectively, behaves like a
 * "wild card matcher", it should be the last in any route composition
 * chain.
 *
 * @author svickers
 *
 */
trait StaticResources
{
	/// Self Type Constraints
	this : HttpService =>
	
	
	def staticResourcesRoutes : Route =
		getFromResourceDirectory ("WEB-INF");
}
