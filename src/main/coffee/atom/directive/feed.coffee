###*
 * feed.coffee - AngularJS directive for the Atom feed element.
 *
###


'use strict'


class AtomFeed
  constructor: ->
    @replace = true
    @restrict = 'EA'
    @scope = {}

    # The transclude property must be set to `true` so that the
    # nested elements are retained.
    @transclude = true

    @template = """
      <div class='atom-feed' ng-transclude>
      </div>
      """


define [
  'app/atom.angular'
  'app/modules'
  ],
  (bundled) ->
    bundled.angular
      .module('AtomReader.directives')
      .directive('feed', -> new AtomFeed())

