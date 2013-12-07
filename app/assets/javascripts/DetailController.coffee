###*
 * DetailController.coffee - AngularJS CoffeeScript controller types
 * responsible for the detail atom feed logic.
###

'use strict'


class DetailController
  constructor: (@$scope) ->


angular
  .module('AtomReader.controllers', [])
  .controller('DetailController', DetailController)

