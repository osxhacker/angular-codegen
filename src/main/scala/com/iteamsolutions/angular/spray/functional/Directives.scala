/**
 * Created on: Jan 5, 2014
 */
package com.iteamsolutions.angular.spray.functional

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
	import Leibniz.refl
	import spray.routing.directives.BasicDirectives.provide


	/// Implicit Conversions
	implicit val directiveMonad
		: Monad[({ type l[a] = Directive[a :: HNil] })#l] =
		new Monad[({ type l[a] = Directive[a :: HNil] })#l] {
			override def point[A] (a : => A) : Directive[A :: HNil] =
				provide (a);
			
			override def bind[A, B] (fa : Directive[A :: HNil])
				(f : A => Directive[B :: HNil])
				: Directive[B :: HNil] =
				fa.hflatMap (ha => f (ha.head));
			}
	
	
	implicit def unapplyApplicativeDirective[A0]
		: Unapply[Applicative, Directive[A0 :: HNil]] {
			type M[X] = Directive[X :: HNil]
			type A = A0
			} =
		new Unapply[Applicative, Directive[A0 :: HNil]] { 
			type M[X] = Directive[X :: HNil]
			type A = A0

			def leibniz = refl
			def TC = directiveMonad
		}


	implicit def unapplyBindDirective[A0]
		: Unapply[Bind, Directive[A0 :: HNil]] {
			type M[X] = Directive[X :: HNil]
			type A = A0
			} =
		new Unapply[Bind, Directive[A0 :: HNil]] { 
			type M[X] = Directive[X :: HNil]
			type A = A0

			def leibniz = refl
			def TC = directiveMonad
		}


	implicit def unapplyMonadDirective[A0]
		: Unapply[Monad, Directive[A0 :: HNil]] {
			type M[X] = Directive[X :: HNil]
			type A = A0
			} =
		new Unapply[Monad, Directive[A0 :: HNil]] { 
			type M[X] = Directive[X :: HNil]
			type A = A0

			def leibniz = refl
			def TC = directiveMonad
		}


	implicit def functorToDirective[A, B] (f : A => B)
		: A => Directive[B :: HNil] =
		f andThen provide;
}


trait DirectiveSyntax
{
	/// Class Imports
	import spray.routing.directives.BasicDirectives.provide
	
	
	implicit class RichDirective0 (val d : Directive[HNil])
	{
		/**
		 * The lift method will "promote" `d` to a `Directive[A :: HNil]`
		 * functor so that `Directive[HNil]` instances can be ''chained'' with
		 * `Directive1` functors.
		 */
		def lift[A] () : A => Directive[A :: HNil] =
			a => d hflatMap (_ => provide (a));
	}
}

