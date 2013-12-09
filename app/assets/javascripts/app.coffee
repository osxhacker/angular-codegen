
'use strict'


# Declare app level module which depends on filters, and services
angular
  .module('AtomReader', [
    'ngRoute',
    'AtomReader.controllers',
    'AtomReader.directives',
    'AtomReader.filters',
    'AtomReader.services'
  ])
  .config([ '$routeProvider', ($routeProvider) ->
    $routeProvider.when '/available',
      templateUrl: 'partials/available.html'
      controller: 'Controller.AvailableController'

    $routeProvider.when '/summary',
      templateUrl: 'partials/summary.html'
      controller: 'Controller.SummaryController'

    $routeProvider.when '/detail',
      templateUrl: 'partials/detail.html'
      controller: 'Controller.DetailController'

    $routeProvider.otherwise redirectTo: '/available'

    @
  ])

