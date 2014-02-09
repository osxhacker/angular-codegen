/**
 * Created on: Feb 2, 2014
 */
package com.iteamsolutions.angular.services.atom


/**
 * The '''actor''' `package` defines Akka `Actor`-related abstractions used
 * in fulfilling the `atom` services.
 *
 * @author svickers
 *
 */
package object actor
{
	/// Class Imports
	import com.iteamsolutions.angular
	
	
	/// Class Types
	type FutureEither[+T] = angular.services.FutureEither[T]
	type URI = angular.services.URI
	type URISyntaxException = angular.services.URISyntaxException
}
