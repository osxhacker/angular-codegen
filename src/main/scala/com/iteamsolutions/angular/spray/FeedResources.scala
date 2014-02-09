/**
 * Created on: Jan 12, 2014
 */
package com.iteamsolutions.angular.spray

import scala.concurrent.duration._
import scala.language.{
	higherKinds,
	implicitConversions,
	postfixOps
	}
import scala.util.{
	Failure,
	Success,
	Try
	}

import scalaz.{
	Failure => _,
	Success => _,
	_
	}
import scalaz.contrib.std._

import akka.util.Timeout
import spray.http.{
	MediaTypes,
	StatusCode,
	StatusCodes
	}
import spray.httpx.marshalling.Marshaller
import spray.routing.{
	HttpService,
	Route
    }

import shapeless._
import spray.routing._

import com.iteamsolutions.angular.models.atom.Feed
import com.iteamsolutions.angular.services._

import atom.FeedOperations
import scalate.DynamicContentGenerator


/**
 * The '''FeedResources''' type uses functional programming techniques to
 * define Spray.io routes related to Atom feeds.
 *
 * @author svickers
 *
 */
trait FeedResources
	extends FeedOperations
{
	/// Self Type Constraints
	this : HttpServiceActor =>
	
	
	/// Class Imports
	import functional.directives._
	import functional.syntax.directives._
	import MediaTypes._
	import StatusCodes.{
		Success => _,
		_
		}
	import Scalaz._
	
	
	/// Instance Properties
	val atomResult = respondWithMediaType (`application/atom+xml`).lift[String];
	val partial = pathPrefix ("partials");
	val availableRequest = get & partial & path ("available" ~ """\.\w+$""".r);
	val validateExtension : String => Directive[String :: HNil] = {
		case ".html" =>
			provide ("html");
			
		case other =>
			reject (ValidationRejection ("Unsupported extension"));
		}
	
	private implicit val system = context.system;
	private implicit val dispatcher = system.dispatcher;
	private implicit val timeout = Timeout (10 seconds);
	
	
	
	def feedRoutes : Route =
		(
			availableRequest >>=
			validateExtension >>=
			atomResult >>=
			load >>=
			render
		) (completeAs[String] (OK));
	
	
	def completeAs[T : Marshaller] (code : StatusCode)
		(response : FutureEither[T])
		: RequestContext => Unit =
		onComplete (
			response.fold (
			e => complete (InternalServerError, e.getMessage),
			good => complete (code, good)
			)) {
			case Success (sr) =>
				sr;
				
			case Failure (e) =>
				complete (InternalServerError, e.getMessage);
			}
		

	private def load (s : String)
		: Directive[FutureEither[List[Feed]] :: HNil] =
		availableFeeds ().point[Directive1];
	
	
	private def render (result : FutureEither[List[Feed]])
		: Directive[FutureEither[String] :: HNil] =
		(result >>= {
			feeds =>
			
			val generator = DynamicContentGenerator (
				"com/iteamsolutions/angular/partials/available.scaml"
				);
			
			generator (Map ('availableFeeds -> feeds)).toFutureEither;
			}
		).point[Directive1];
}

