###*
 * tbd.coffee - Defines the AngularJS "tbd" directive.
 *
###


'use strict'


###*
 * @name ToBeDelivered
 *
 * @description The ToBeDelivered class defines an AngularJS
 * directive which is used during development to indicate that
 * a portion of the system is not yet available.
###
class ToBeDelivered
  constructor: ->
    @replace = true
    @restrict = 'EA'
    @scope = {}

    # NOTE: Without transclude == true, the compile method has
    # no access to the original template element!  This is true
    # at least for AngularJS v1.2.4.
    @transclude = true


    @compile = (templateElement, templateAttrs, transcludeFn) ->
      return (scope, element, attrs) ->
        scope.tbd =
          message: templateElement.text()


    @template = """
      <div class='tbd' ng-transclude>
        {{ tbd.message }}
      </div>
      """


define [
  'app/atom.angular'
  'app/modules'
  ],
  (bundled) ->
    bundled.angular
      .module('AtomReader.directives')
      .directive('tbd', -> new ToBeDelivered())

