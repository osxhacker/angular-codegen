###*
 * main.coffee - RequireJS bootstrap.
 *
###


'use strict'


###*
 * @description Configure RequireJS base URL and module paths
###
requirejs.config
  baseUrl: 'js/lib'

  paths:
    angular: 'angular/angular'
    'angular.animate': 'angular/angular-animate'
    'angular.resource': 'angular/angular-resource'
    'angular.route': 'angular/angular-route'
    app: '../atom'
    controller: '../atom/controller'
    jquery: 'jquery-2.1.0.min'

  shim:
    angular:
      deps: [ 'jquery' ]
      exports: 'angular'

    'angular.animate': [ 'angular' ]
    'angular.resource': [ 'angular' ]
    'angular.route': [ 'angular' ]


###*
 * @description Initiate the system when the DOM is ready..
###
requirejs [
  'jquery'
  'angular'
  'app/routes'
  ],
  ($, angular, routes) ->
    $ -> angular.bootstrap document, [ 'AtomReader' ]

