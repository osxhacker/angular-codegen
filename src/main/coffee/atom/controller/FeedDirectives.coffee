###*
 * FeedDirectives.coffee - AngularJS atom:feed related directives.
###


'use strict'


feedsHtml = """
  <div class="feeds">
    <ul class="nav">
      <li ng-repeat="feed in feeds">
        <a href="" ng-click="select(feed)">{{feed.title}}</a>
      </li>
    </ul>
  </div>
  """


class FeedsController
  constructor: (@$scope) ->
    console.log 'Made a FeedsController'


  select: (feed) =>


feeds = ->
  console.log 'creating the feeds directive'
  {
    controller: FeedsController
    replace: true
    restrict: 'E'
    scope: {}
    template: feedsHtml
  }


angular
  .module('AtomReader.directives')
  .directive('feeds', feeds)

