package controllers

import play.api._
import play.api.mvc._

import services.atom.FeedOperations


/**
 * The '''Application''' type defines the entry point for the system.
 * 
 * @author svickers
 * 
 */
object Application
	extends Controller
		with FeedOperations
{
	/// Class Imports
	import views.html.partials


	def available = Action {
		availableFeeds () fold (
			_ => InternalServerError,
			feeds => Ok (partials.available (feeds))
			)
		}
	
	
	def summary = Action {
        /// TODO: serve up a summary
		Ok (partials.summary ());
		}


	def detail = Action {
        /// TODO: serve up a detail Atom
		Ok (partials.detail ());
		}
}
