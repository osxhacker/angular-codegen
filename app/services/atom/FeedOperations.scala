/**
 * Created on: Dec 7, 2013
 */
package services.atom

import scalaz.{
	Failure => _,
	Success => _,
	_
	}
	
import models.atom._


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
	
	
	/// Instance Properties
	private val feeds = 
		Feed (
			id = new URI ("urn:atom-feed:1"),
			authors = NonEmptyList (
				Author (name = "Test McAuthor")
				),
			title = "Stubbed Atom feeds",
			updated = new Date,
			link = List.empty,
			entry = List.empty
			) ::
		Nil;
	
	
	/**
	 * The availableFeeds method resolves what [[models.atom.Feed]]s are
	 * _currently_ able to be manipulated.
	 */
	def availableFeeds () : Throwable \/ List[Feed] =
	{
		feeds.right;
	}
}
