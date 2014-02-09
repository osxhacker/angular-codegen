/**
 * Created on: Feb 2, 2014
 */
package com.iteamsolutions.angular.services

import scala.reflect.ClassTag

import scalaz.{
	Failure => _,
	Success => _,
	_
	}
import scalaz.contrib.std._
	
import akka.actor._
import akka.pattern.ask
import akka.util.Timeout


/**
 * The '''MessagingExtensionLike''' generic `trait` defines the contract for
 * ''all'' Akka extensions which define `Actor` request/response protocols
 * categorized by the `ResponseT` and `RequestT` parameters.
 * 
 * By providing this contract here, we regain type safety as quick as possible
 * and leverage the compiler's type checking ability to help catch `Actor`
 * collaborations which will never have a chance to succeed.  Specifically, if
 * a client sends a message to some actor expecting only a particular category
 * of messages, and that message doesn't "belong" to that type hierarchy, the
 * compiler will reject it immediately.
 *
 * @author svickers
 *
 */
trait MessagingExtensionLike[
	ResponseT[X <: ResponseT[X]] <: Response[X],
	RequestT[X <: ResponseT[X]] <: Request[X]
	]
{
	def ![R <: ResponseT[R]] (request : RequestT[R])
		(implicit T : Timeout, CT : ClassTag[R])
		: Unit;


	def ?[R <: ResponseT[R]] (request : RequestT[R])
		(implicit T : Timeout, CT : ClassTag[R])
		: FutureEither[R];
}


/**
 * The '''MessagingExtension''' type defines the common behaviours of Akka
 * `Extension`s which define messaging protocols for system actors.
 *
 * @author svickers
 *
 */
class MessagingExtension[
	ResponseT[X <: ResponseT[X]] <: Response[X],
	RequestT[X <: ResponseT[X]] <: Request[X]
	] (protected val actor : ActorRef)
	(implicit protected val system : ActorSystem)
	extends Extension
		with MessagingExtensionLike[ResponseT, RequestT]
{
	/// Class Imports
	import EitherT.fromTryCatch
	import system.dispatcher


	override def ![R <: ResponseT[R]] (request : RequestT[R])
		(implicit T : Timeout, CT : ClassTag[R])
		: Unit =
		actor ! request;
	
	
	override def ?[R <: ResponseT[R]] (request : RequestT[R])
		(implicit T : Timeout, CT : ClassTag[R])
		: FutureEither[R] =
		fromTryCatch (ask (actor, request).mapTo[R]);
}

