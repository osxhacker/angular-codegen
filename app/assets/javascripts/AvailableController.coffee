###*
 * AvailableController.coffee - AngularJS CoffeeScript controller types
 * responsible for the top-level "available" atom feeds.
###

'use strict'


class Controller.AvailableController
  constructor: (@$scope) ->
    console.log 'made AvailableController'


angular
  .module('AtomReader.controllers')
  .controller('AvailableController', Controller.AvailableController)

