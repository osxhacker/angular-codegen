
'use strict'


###*
 * Define app level module which depends on filters, and services.
###
define [
  'app/atom.angular'
  'app/modules'
  ],
  (bundled) ->
    console.log 'angular bundled: ', bundled

    bundled.angular.module 'AtomReader'

