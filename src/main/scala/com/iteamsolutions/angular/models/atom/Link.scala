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
 * The '''Link''' type is the Domain Object Model representation of an
 * [[http://www.ietf.org/rfc/rfc4287.txt Atom Link]].
 *
 * @author svickers
 *
 */
final case class Link (
	val href : URI,
	val rel : String \/ URI,
	val title : Option[String]
	)
{
	
}


object Link
{
}

