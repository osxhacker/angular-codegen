/**
 * Created on: Jan 2, 2014
 */
package com.iteamsolutions.angular.services.scalate

import scalaz._

import org.fusesource.scalate._


/**
 * The '''DynamicContentGenerator''' type provides the ability to use
 * [[http://scalate.fusesource.org/documentation/user-guide.html Scalate]] in
 * order to generate arbitrary textual content.
 *
 * @author svickers
 *
 */
case class DynamicContentGenerator (
	val name : String
	)
{
	/// Class Imports
	import \/._
	import DynamicContentGenerator._
	import Scalaz._
	
	
	/**
	 * The apply method uses the optional `bindings` to produce content from
	 * the template resolved at run-time.
	 */
	def apply (bindings : Map[Symbol, Any] = Map.empty) : Throwable \/ String =
		fromTryCatch (engine layout (name, bindings mapKeys (_.name)));
}


object DynamicContentGenerator
{
	/// Instance Properties
	private val engine =
	{
		/// According to one of the Scalate developers here:
		///
		/// https://groups.google.com/d/msg/scalate/ma0WLsc7waI/b8qmopQALXUJ
		///
		/// setting the allowReload property to "false" forces the engine
		/// to use the precompiled templates.
		System.setProperty ("scalate.allowReload", "false");

		val e = new TemplateEngine;

		e.boot;

		e;
	}
}
