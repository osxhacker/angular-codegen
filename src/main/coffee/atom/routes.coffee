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
    console.log 'defining routes'

    app.config [ '$routeProvider',
      ($routeProvider) ->
        $routeProvider.when '/available',
          templateUrl: 'partials/available.html'
          controller: 'Controller.AvailableController'

        $routeProvider.when '/summary',
          templateUrl: 'partials/summary.html'
          controller: 'Controller.SummaryController'

        $routeProvider.when '/detail',
          templateUrl: 'partials/detail.html'
          controller: 'Controller.DetailController'

        $routeProvider.otherwise redirectTo: '/available'
    ]

