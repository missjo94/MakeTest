/**
 * Created by Milan on 22/11/2016.
 */
var app = angular.module('app.profile', ['ngCookies']);

app.controller('profile.controller', ['$scope', '$http', '$cookies', 'userService', function ($scope, $http, $cookies, userService) {
    var vm = this;

    vm.showProfileAlert = false;
    vm.showUser = function () {

        userService.showUser().then(function (response) {
            vm.user = response.data;
        }, function () {
            console.log("Error");
        });
    };

    vm.update = function () {
        userService.update(vm.user).then(function (response) {
            vm.user = response.data;
            vm.showProfileAlert = true;
        }, function () {
            console.log("Error");
        });
    };


}]);



