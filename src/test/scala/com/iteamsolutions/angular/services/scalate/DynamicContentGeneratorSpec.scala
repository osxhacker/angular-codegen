/**
 * Created on: Jan 2, 2014
 */
package com.iteamsolutions.angular.services.scalate

import scalaz._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import com.iteamsolutions.angular.ProjectSpec


/**
 * The '''DynamicContentGeneratorSpec''' type defines the behaviour expected of
 * the [[com.iteamsolutions.angular.services.scalate.DynamicContentGenerator]]
 * [[com.iteamsolutions.angular.services.DynamicContent]] implementation.
 *
 * @author svickers
 *
 */
@RunWith (classOf[JUnitRunner])
class DynamicContentGeneratorSpec
	extends ProjectSpec
{
	describe ("A DynamicContentGenerator") {
		describe ("Creating an instance") {
            it ("expects a symbolic template name") {
                Given ("a symbolic name");
                val arbitraryName = "/some/template.scaml";
                
                When ("an instance is created with it");
                val generator = DynamicContentGenerator (arbitraryName);
                
                Then ("the generator should know its name");
                generator.name shouldBe "/some/template.scaml";
                }
            
            it ("can have multiple instances created") {
                Given ("two different symbolic names");
                val oneName = "name 1";
                val anotherName = "name 2";
                
                When ("generators are created");
                val gen1 = DynamicContentGenerator (oneName);
                val gen2 = DynamicContentGenerator (anotherName);
                
                Then ("each should be different");
                gen1 shouldNot be theSameInstanceAs gen2;
                
                And ("should have different names");
                gen1.name shouldNot equal (gen2.name);
                }
            }
		
		describe ("Producing content") {
			it ("fails gracefully when the template is not found") {
                Given ("an unknown scaml template");
                val generator = DynamicContentGenerator ("unknown.ssp");
                
                When ("asked to generate content");
                val content = generator ();
                
                Then ("there should either be content or an error");
                content shouldBe an [Throwable \/ String];
                
                And ("this call should fail");
                content shouldBe 'left;
                }

			it ("can generate content without any parameterization") {
                Given ("a scaml template generator");
                val generator = DynamicContentGenerator (
                	"/partials/no_bindings.scaml"
                	);
                
                When ("asked to generate content based on the template");
                val result = generator ();
                
                Then ("this call should succeed");
                result shouldBe 'right;
                
                result foreach {
                	content =>
                	
                    And ("should have visible content");
                    content shouldNot be ('empty);
                    }
                }
			
			it ("can provide the template with run-time parameters") {
                Given ("a scaml template expecting a parameter");
                val generator = DynamicContentGenerator (
                	"/partials/message_binding.scaml"
                	);
                
                When ("asked to generate content based on the template");
                val result = generator (Map ('message -> "Hello, world!"));
                
                Then ("this call should succeed");
                result shouldBe 'right;
                
                result foreach {
                	content =>
                	
                    And ("should have the message provided");
                    content should include ("Hello, world!");
                    }
				}
            }
        }
}
