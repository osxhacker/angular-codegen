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
 * The '''Entry''' type defines the Domain Object Model type for an individual
 * [[http://www.ietf.org/rfc/rfc4287.txt Atom Entry Document]].
 *
 * @author svickers
 *
 */
final case class Entry (
	val id : URI,
	val author : NonEmptyList[Author],
	val title : String,
	val updated : Date,
	val summary : Option[String],
	val link : List[Link],
	val content : Option[String]
	)
{

}


object Entry
{
}

