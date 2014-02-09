/**
 * Created on: Feb 2, 2014
 */
package com.iteamsolutions.angular

import scala.concurrent.{
	ExecutionContext,
	Future
	}

import scalaz.{
	Failure => _,
	Success => _,
	_
	}
import scalaz.contrib.std._
	
import akka.util.Timeout


/**
 * The '''services''' `package` defines behaviour transcending the Domain
 * Model's responsibilities.
 *
 * @author svickers
 *
 */
package object services
{
	/// Class Imports
	import EitherT.eitherT
	import Scalaz._
	
	
	/// Class Types
	type FutureEither[+T] = EitherT[Future, Throwable, T]
	type URI = com.iteamsolutions.angular.models.atom.URI
	type URISyntaxException =
		com.iteamsolutions.angular.models.atom.URISyntaxException
		
		
	implicit class CreateFutureEither[A] (val a : Throwable \/ A)
		extends AnyVal
	{
		def toFutureEither (implicit T : Timeout, EC : ExecutionContext)
			: FutureEither[A] = eitherT (a.point[Future]);
	}
}

