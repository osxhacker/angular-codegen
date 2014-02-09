/**
 * Created on: Feb 2, 2014
 */
package com.iteamsolutions.angular.services


/**
 * The '''Message''' type serves as the root `trait` for ''all'' messages
 * exchanged between system `Actor`s and their clients.
 *
 * @author svickers
 *
 */
trait Message[A <: Message[A]]
	extends Serializable
	
	
/**
 * All messages originally sent to an Akka `Actor` *should* be derived from
 * this '''Request''' type.  Doing so establishes the expected
 * [[com.iteamsolutions.angular.services.Response]] type and helps regain
 * type safety as quickly as possible.
 *
 * @author svickers
 *
 */
trait Request[A <: Response[A]]
	extends Message[Request[A]]


/**
 * The '''Response''' type reifies the message category sent to issuers of a
 * [[com.iteamsolutions.angular.services.Request]] from a system-defined
 * `Actor`.
 *
 * @author svickers
 *
 */
trait Response[A <: Response[A]]
	extends Message[Response[A]]
