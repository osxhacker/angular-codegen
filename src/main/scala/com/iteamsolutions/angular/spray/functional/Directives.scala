/**
 * Created on: Jan 5, 2014
 */
package com.iteamsolutions.angular.spray.functional

import scalaz.{
	Failure => _,
	Success => _,
	_
    }

import shapeless._
import spray.routing._


/**
 * The '''DirectiveImplicits''' type defines Scalaz `implicit` type classes for
 * Spray `Directive` types.
 *
 * @author svickers
 *
 */
trait DirectiveImplicits
{
	/// Class Imports
	import spray.routing.directives.BasicDirectives._


	/// Implicit Conversions
	implicit val directive1Monad : Monad[Directive1] =
		new Monad[Directive1] {
            override def point[A] (a : => A) : Directive1[A] = provide (a);
                
            override def bind[A, B] (fa : Directive1[A])
                (f : A => Directive1[B])
                : Directive1[B] =
                fa flatMap (f);
            }
	
	
	implicit def functorToDirective[A, B] (f : A => B) =
		f andThen provide;
	
	
	implicit def liftDirective0 (d : Directive0) : Directive1[HNil] =
		provide (HNil);
}
