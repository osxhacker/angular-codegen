/**
 * Created on: Jan 4, 2014
 */
package com.iteamsolutions.angular.spray

import scala.concurrent.Future
import scala.concurrent.duration.Deadline

import akka.actor.{
	IO => _,
	_
	}
import akka.pattern._
import akka.util._
import spray.routing._


/**
 * The '''ApplicationHttpService''' type
 *
 * @author svickers
 *
 */
class ApplicationHttpService ()
	extends HttpServiceActor
		with StaticResources
{
	override def receive = runRoute (staticResourcesRoutes);
}


object ApplicationHttpService
{
	def apply () = Props[ApplicationHttpService];
}