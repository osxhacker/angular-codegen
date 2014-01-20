###*
 * routes.coffee - AngularJS route definitions.
 *
###


'use strict'


define [
  'app/app'
  'controller/AvailableController'
  ],
  (app) ->
    app.config [ '$routeProvider',
      ($routeProvider) ->
        $routeProvider.when '/available',
          templateUrl: 'partials/available.html'
          controller: 'AvailableController'

        $routeProvider.when '/summary',
          templateUrl: 'partials/summary.html'
          controller: 'SummaryController'

        $routeProvider.when '/detail',
          templateUrl: 'partials/detail.html'
          controller: 'DetailController'

        $routeProvider.otherwise redirectTo: '/available'
    ]

