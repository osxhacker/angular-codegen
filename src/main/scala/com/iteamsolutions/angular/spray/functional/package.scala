/**
 * Created on: Jan 5, 2014
 */
package com.iteamsolutions.angular.spray


/**
 * The '''functional''' `package` defines Scalaz functional types for Spray
 * abstractions.
 *
 * @author svickers
 *
 */
package object functional
{
	object all
		extends DirectiveImplicits
			with HListImplicits

	
	object directives
		extends DirectiveImplicits
		
		
	object hlist
		extends HListImplicits
		
		
	object syntax
	{
		object directives
			extends DirectiveSyntax
	}
}
