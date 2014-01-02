/**
 * Created on: Dec 7, 2013
 */
package com.iteamsolutions.angular.models.atom

import scalaz.{
	Failure => _,
	Success => _,
	_
	}
	

/**
 * The '''Feed''' type is a container of [[models.atom.Entry]] instances and
 * is a simplified version of the
 * [[http://www.ietf.org/rfc/rfc4287.txt Atom Feed Document]] specification.
 *
 * @author svickers
 *
 */
final case class Feed (
	val id : URI,
	val authors : NonEmptyList[Author],
	val title : String,
	val updated : Date,
	val link : List[Link],
	val entry : List[Entry]
	)
{

}


object Feed
{
}

