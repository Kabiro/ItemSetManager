'use strict';

app.factory('utils', function () {

    var isNullOrUndefined = function (elem) {
        return elem === undefined || elem === null;
    };

    return {
        'isNullOrUndefined': function (elem) {
            return isNullOrUndefined(elem);
        },
        'isDefined': function (elem) {
            return !isNullOrUndefined(elem);
        },
        'isEmpty': function (elem) {
            return isNullOrUndefined(elem) || elem === '';
        }
    };
});