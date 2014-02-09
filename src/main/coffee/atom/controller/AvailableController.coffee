###*
 * AvailableController.coffee - AngularJS CoffeeScript controller types
 * responsible for the top-level "available" atom feeds.
###

'use strict'


class AvailableController
  constructor: (@$scope) ->
    console.log 'made AvailableController'


define [
  'app/atom.angular'
  'app/modules'
  'app/directives'
  ],
  (bundled) ->
    bundled.angular
      .module('AtomReader.controllers')
      .controller('AvailableController', AvailableController)

