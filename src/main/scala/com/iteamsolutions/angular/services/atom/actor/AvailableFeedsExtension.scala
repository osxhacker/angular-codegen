/**
 * Created on: Feb 2, 2014
 */
package com.iteamsolutions.angular.services
package atom.actor

import scala.concurrent.Future
import scala.concurrent.duration.Deadline
import scala.reflect.ClassTag

import scalaz.{
	Failure => _,
	Success => _,
	_
	}
import scalaz.contrib.std._
	
import akka.actor.{
	IO => _,
	_
	}
import akka.pattern._
import akka.util._


/**
 * The '''AvailableFeedsExtension''' type provides the system with the ability
 * to interact with the `Actor`s involved in determining what atom feeds are
 * available for consumption.
 *
 * @author svickers
 *
 */
trait AvailableFeedsExtension
	extends Extension
		with MessagingExtensionLike[
			AvailableFeedsResponse,
			AvailableFeedsRequest
			]


object AvailableFeedsExtension
	extends ExtensionId[AvailableFeedsExtension]
		with ExtensionIdProvider
{
	/// Class Types
	private class DefaultAvailableFeedsExtension (
		override val actor : ActorRef,
		override val system : ActorSystem
		)
		extends MessagingExtension [
			AvailableFeedsResponse,
			AvailableFeedsRequest
			] (actor) (system)
			with AvailableFeedsExtension
	
	
	override def createExtension (system : ExtendedActorSystem)
		: AvailableFeedsExtension =
	{
		val actor = AvailableFeeds ("available-feeds") (system);

		new DefaultAvailableFeedsExtension (actor, system);
	}
	
	
	override def lookup = this;
}