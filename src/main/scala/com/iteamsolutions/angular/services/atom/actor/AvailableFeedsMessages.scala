/**
 * Created on: Feb 2, 2014
 */
package com.iteamsolutions.angular.services
package atom.actor

import scalaz.{
	Failure => _,
	Success => _,
	_
	}

import com.iteamsolutions.angular.models.atom.Feed
	

/**
 * The '''AvailableFeedsRequest''' type serves as the parent for ''all''
 * [[com.iteamsolutions.angular.services.Request]]s understood by the
 * [[com.iteamsolutions.angular.services.atom.actor.AvailableFeeds]] Akka
 * `Actor`.
 *
 * @author svickers
 *
 */
sealed trait AvailableFeedsRequest[A <: AvailableFeedsResponse[A]]
	extends Request[A]
{
}


sealed trait AvailableFeedsResponse[A <: AvailableFeedsResponse[A]]
	extends Response[A]
{
}


case object CurrentlyAvailableFeedsRequest
	extends AvailableFeedsRequest[CurrentlyAvailableFeedsResponse]


case class CurrentlyAvailableFeedsResponse (
	val result : Throwable \/ List[Feed]
	)
	extends AvailableFeedsResponse[CurrentlyAvailableFeedsResponse]

