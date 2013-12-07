
'use strict'


# Declare app level module which depends on filters, and services
angular
  .module('AtomReader', [
    'ngRoute',
    'AtomReader.filters',
    'AtomReader.services',
    'AtomReader.directives',
    'AtomReader.controllers'
    ]).
  config([ '$routeProvider', ($routeProvider) ->
    $routeProvider.when('/summary',
      templateUrl: 'partials/summary.html'
      controller: 'SummaryController'
    )
    $routeProvider.when('/detail',
      templateUrl: 'partials/detail.html'
      controller: 'DetailController'
    )
    $routeProvider.otherwise(
      redirectTo: '/summary'
    )
  ])

