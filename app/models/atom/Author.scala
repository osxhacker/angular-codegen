/**
 * Created on: Dec 7, 2013
 */
package models.atom


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
