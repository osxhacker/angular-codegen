/**
 * Created on: Jan 5, 2014
 */
package com.iteamsolutions.angular.spray.functional

import scala.language.{
	higherKinds,
	implicitConversions,
	postfixOps
	}

import scalaz._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import shapeless._
import spray.routing._
import spray.routing.directives._

import com.iteamsolutions.angular.ProjectSpec


/**
 * The '''ScalazDirectiveSpec''' type defines the behaviour expected of the
 * `functional` Scalaz support provided by
 * [[com.iteamsolutions.angular.spray.functional.directives]].
 * 
 * @author svickers
 *
 */
@RunWith (classOf[JUnitRunner])
class ScalazDirectiveSpec
	extends ProjectSpec
		with BasicDirectives
		with PathDirectives
		with RouteDirectives
{
	/// Class Imports
	import scalaz.syntax.monad._
	import directives._


	/// Testing Collaborators
	describe ("Scalaz Monad Directive1 integration") {
		it ("should be usable in a Bind context") {
			Given ("a directive producing a string");
			val constant = "test".point[Directive1];
			
			When ("participating in a bind expression");
			val expr = constant >>= {
                s =>
                
                extract {
                    complete (s);
                    }
                }
			
			Then ("the expression should type check");
            }
        }
	
	describe ("Scalaz Bind Directive integration") {
		it ("should bind to HList-based Directive instances") {
			Given ("a path matcher");
			val matcher = path ("foo" / Segment);
			
			val route = matcher >>= {
				theSegment =>

				provide (s"matched on $theSegment");
				}
			}
		}
}
