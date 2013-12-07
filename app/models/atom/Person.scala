/**
 * Created on: Dec 7, 2013
 */
package models.atom


/**
 * The '''Person''' type is the Domain Object Model reification of the
 * [[http://www.ietf.org/rfc/rfc4287.txt Person]] concept.
 *
 * @author svickers
 *
 */
trait Person
{
	/// Instance Properties
	def name : String;
	def uri : Option[URI];
	def email : Option[URI];
}
