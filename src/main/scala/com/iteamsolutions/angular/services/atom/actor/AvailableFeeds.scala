/**
 * Created on: Feb 2, 2014
 */
package com.iteamsolutions.angular.services.atom.actor

import scala.concurrent.Future
import scala.concurrent.duration.Deadline

import scalaz.{
	Failure => _,
	Success => _,
	_
	}

import akka.actor.{
	IO => _,
	_
	}
import akka.pattern._
import akka.util._


import com.iteamsolutions.angular.models.atom._


/**
 * The '''AvailableFeeds''' type is an Akka `Actor` responsible for resolving
 * the currently available Atom feeds.
 *
 * @author svickers
 *
 */
class AvailableFeeds ()
	extends Actor
{
	/// Class Imports
	import Scalaz._
	
	
	/// Instance Properties
	private val feeds = 
		Feed (
			id = new URI ("urn:atom-feed:1"),
			authors = NonEmptyList (
				Author (name = "Test McAuthor")
				),
			title = "Stubbed Atom feeds",
			updated = new Date,
			link = List.empty,
			entry = List.empty
			) ::
		Nil;
	
	
	override def receive =
	{
		case CurrentlyAvailableFeedsRequest =>
			sender ! CurrentlyAvailableFeedsResponse (feeds.right);
	}
}


object AvailableFeeds
{
	/**
	 * The apply method is provided so that the details of how to instantiate
	 * an '''AvailableFeeds''' instance is insulated from clients.
	 */
	def apply (name : String)
		(implicit factory : ActorRefFactory)
		: ActorRef =
		factory.actorOf (Props[AvailableFeeds], name);
}

