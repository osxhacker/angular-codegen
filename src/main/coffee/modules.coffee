###*
 * modules.coffee - Initializes all AngularJS module definitions and their
 * dependencies.  This can only be done once in v1.2.4, so this is where
 * it is.
###


@.Controller = {}
@.Directive = {}


angular.module 'AtomReader.services', []
angular.module 'AtomReader.directives', [ 'AtomReader.services' ]
angular.module 'AtomReader.controllers', [ 'AtomReader.directives' ]

