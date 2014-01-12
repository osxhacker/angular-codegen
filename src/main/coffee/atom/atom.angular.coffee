###*
 * atom.angular.coffee - Defines the RequireJS modules related to
 * using AngularJS.
 *
###


'use strict'


define (require) ->
  console.log 'defining atom.angular'

  angular: require 'angular'
  animate: require 'angular.animate'
  resource: require 'angular.resource'
  route: require 'angular.route'

