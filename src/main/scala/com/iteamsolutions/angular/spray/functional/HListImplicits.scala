/**
 * Created on: Jan 18, 2014
 */
package com.iteamsolutions.angular.spray.functional

import scalaz.{
	Failure => _,
	Success => _,
	_
    }

import shapeless._


/**
 * The '''HListImplicits''' type defines Scalaz type classes for the shapeless
 * HList polymorphic types.
 * 
 * @author svickers
 *
 */
trait HListImplicits
{
	/// Implicit Conversions
	implicit def hlist1Monad =
		new Monad[({ type L[X] = X :: HNil })#L] {
			override def point[A] (a: => A) = a :: HNil;
			
			override def bind[A, B] (fa : A :: HNil)
				(f : A => B :: HNil)
				= f (fa.head);
		}
}
