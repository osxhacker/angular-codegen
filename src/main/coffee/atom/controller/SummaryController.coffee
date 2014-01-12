###*
 * SummaryController.coffee - AngularJS CoffeeScript controller types
 * responsible for the summary atom feed views
###

'use strict'


class Controller.SummaryController
  constructor: (@$scope) ->


angular
  .module('AtomReader.controllers')
  .controller('SummaryController', Controller.SummaryController)

