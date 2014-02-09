###*
 * feeds.coffee - AngularJS directive for the Atom feeds element.
 *
###


'use strict'


class AtomFeeds
  constructor: ->
    @replace = true
    @restrict = 'EA'
    @scope = {}

    # The transclude property must be set to `true` so that the
    # nested elements are retained.
    @transclude = true

    @template = """
      <div class='atom-feeds' ng-transclude>
      </div>
      """


define [
  'app/atom.angular'
  'app/modules'
  ],
  (bundled) ->
    bundled.angular
      .module('AtomReader.directives')
      .directive('feeds', -> new AtomFeeds())

