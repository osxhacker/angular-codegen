/**
 * Created on: Jan 4, 2014
 */
package com.iteamsolutions.angular.spray

import akka.actor.{
	IO => _,
	_
	}
import akka.pattern._
import akka.util._
import spray.routing._


/**
 * The '''ApplicationHttpService''' type serves as the Spray route definition
 * `Actor`, bringing together the externally available REST functionality.
 *
 * @author svickers
 *
 */
class ApplicationHttpService ()
	extends HttpServiceActor
		with FeedResources
		with StaticResources
{
	override def receive = runRoute (
		feedRoutes ~
		staticResourcesRoutes
		);
}


object ApplicationHttpService
{
	/**
	 * The apply method is provided so that the details of how to instantiate
	 * an '''ApplicationHttpService''' instance is insulated from clients.
	 */
	def apply (name : String)
		(implicit factory : ActorRefFactory)
		: ActorRef =
		factory.actorOf (Props[ApplicationHttpService], name);
}
