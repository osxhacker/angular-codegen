###*
 * title.coffee - AngularJS directive for an Atom "title" element.
 *
###


'use strict'


class AtomTitle
  constructor: ($compile) ->
    @restrict = 'E'


    ###*
     * @name compile
     *
     * @description For this Code-on-Demand directive, we have to
     * retain the originalElement's text and determine whether or
     * not to produce a div dynamically based on the parent of
     * the title element.  This is due to the element of the same
     * name in HTML.
    ###
    @compile = (originalElement, templateAttrs) ->
      content = originalElement.text()

      return (scope, element, attrs) ->
        unless element[0].parentElement.localName is 'head'
          element.replaceWith """
            <div class='atom-title'>
              #{content}
            </div>
            """


define [
  'app/atom.angular'
  'app/modules'
  ],
  (bundled) ->
    bundled.angular
      .module('AtomReader.directives')
      .directive('title', ($compile) -> new AtomTitle $compile)

