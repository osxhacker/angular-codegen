package controllers

import play.api._
import play.api.mvc._


/**
 * The '''Application''' type defines the entry point for the system.
 * 
 * @author svickers
 * 
 */
object Application
	extends Controller
{
	/// Class Imports
	import views.html.partials


	def summary = Action {
        /// TODO: serve up a summary
		Ok (partials.summary ());
		}


	def detail = Action {
        /// TODO: serve up a detail Atom
		Ok (partials.detail ());
		}
}
