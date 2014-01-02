/**
 * Created on: Dec 7, 2013
 */
package com.iteamsolutions.angular.models.atom


/**
 * The '''Author''' type is the Domain Object Model reification of the
 * [[http://www.ietf.org/rfc/rfc4287.txt atom:author]] element.
 *
 * @author svickers
 *
 */
final case class Author (
	override val name : String,
	override val uri : Option[URI],
	override val email : Option[URI]
	)
	extends Person
{

}


object Author
{
	def apply (name : String) : Author =
		new Author (name, None, None);
}

