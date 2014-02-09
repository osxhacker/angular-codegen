/**
 * Created on: Dec 7, 2013
 */
package com.iteamsolutions.angular.services
package atom

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
	
import akka.actor.ActorSystem
import akka.pattern._
import akka.util._

import com.iteamsolutions.angular.models.atom._

import actor._


/**
 * The '''FeedOperations''' type defines system operations related to
 * [[models.atom]] Domain types.
 *
 * @author svickers
 *
 */
trait FeedOperations
{
	/// Class Imports
	import Scalaz._
	
	
	/**
	 * The availableFeeds method resolves what [[models.atom.Feed]]s are
	 * _currently_ able to be manipulated.
	 */
	def availableFeeds ()
		(implicit system : ActorSystem, EC : ExecutionContext, T : Timeout)
		: FutureEither[List[Feed]] =
		(AvailableFeedsExtension (system) ? CurrentlyAvailableFeedsRequest) >>= {
			_.result.toFutureEither;
			}
}

