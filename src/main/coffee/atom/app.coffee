
'use strict'


###*
 * Define app level module which depends on filters, and services.
###
define [
  'app/atom.angular'
  'app/modules'
  ],
  (bundled) ->
    bundled.angular.module 'AtomReader'

