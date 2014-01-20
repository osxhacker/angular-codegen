/**
 * Created on: Jan 12, 2014
 */
package com.iteamsolutions.angular.spray

import scala.language.{
	higherKinds,
	implicitConversions,
	postfixOps
	}

import scalaz.{
	Failure => _,
	Success => _,
	_
	}

import spray.routing.{
	HttpService,
	Route
    }

import shapeless._
import spray.routing._


/**
 * The '''FeedResources''' type uses functional programming techniques to
 * define Spray.io routes related to Atom feeds.
 *
 * @author svickers
 *
 */
trait FeedResources
{
	/// Self Type Constraints
	this : HttpService =>
	
	
	/// Class Imports
	import functional.directives._
	import Scalaz._
	
	
	/// Instance Properties
	val partial = pathPrefix ("partials");
	val available = partial & path ("available" ~ """\.\w+$""".r);
	val validateExtension : String => Directive[String :: HNil] = {
		case ".html" =>
			provide ("html");
			
		case other =>
			reject (ValidationRejection ("Unsupported extension"));
		}
	
	
	
	def feedRoutes : Route =
		((get & available) >>= validateExtension) {
			ext =>

            complete ("<tbd>this is a placeholder</tbd>\n");
			}
}

