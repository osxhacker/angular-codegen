###*
 * directives.coffee - Defines a RequireJS module which includes
 * all Atom directives as dependencies.
 *
###


'use strict'


define (require) ->
  feed: require 'app/directive/feed'
  feeds: require 'app/directive/feeds'
  tbd: require 'app/directive/tbd'

