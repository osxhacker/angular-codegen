/**
 * Created on: Jan 4, 2014
 */
package com.iteamsolutions.angular.spray

import scala.concurrent.duration._
import scala.language.postfixOps

import akka.actor.ActorSystem
import akka.io.IO
import akka.pattern._
import akka.util.Timeout

import spray.can.Http


/**
 * The '''CommandLineServer''' type is an `object` which starts the Spray
 * HTTP server by way of command line invocation.
 *
 * @author svickers
 *
 */
object CommandLineServer
	extends App
{
	/// Instance Properties
	implicit val system = ActorSystem ("angular-codegen");
	implicit val timeout = Timeout (5 seconds);
	
	val router = system.actorOf (ApplicationHttpService (), "request-router");
	
	
	/// Constructor Body
	IO (Http) ? Http.Bind (
		router,
		interface = "localhost",
		port = 9000
		);
}
