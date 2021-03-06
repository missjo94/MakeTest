<<<<<<< HEAD
/**
 * Created by Jovana Micic on 02-Nov-16.
 */
angular.module('makeTest.controllers').controller('UserController', UserController);

UserController.$inject = ['userService','$routeParams', '$cookies', '$location', '$scope'];

//$location, $routeParams
function UserController(userService,$routeParams, $cookies, $location, $scope) {
    var vm = this;
    vm.user = {};

    vm.init = function () {
        var loc = location.search.substring(1);
        loc = loc.split('=').pop();
        $cookies.put('mtt', loc);  // -> Ne vidi $cookies
        console.log("cookie->"+loc);
    };


    vm.logout = function () {
        userService.logout().then(function (response) {
            setTimeout(function () {
                window.location.href = "login";
            }, 2000);
        }, function () {
            console.log("Error");
        });
    };

    vm.showUser = function () {

        userService.showUser().then(function (response) {
            vm.data = response.data;
        }, function () {
            console.log("Error");
        });
    };

    vm.update = function () {
            userService.update(vm.data).then(function(response){
                vm.data = response.data;
                vm.data.password = "";
                vm.data.repeatPassword = "";
                toastr.success("Your profile is successfully updated.");
            },function () {
                console.log("Error");
            });
    };
=======
/**
 * Created by Jovana Micic on 02-Nov-16.
 */
angular.module('makeTest.controllers').controller('UserController', ['$scope', '$cookies', '$location', 'userService', UserController]);

function UserController($scope, $cookies, $location, userService) {
    var vm = this;
    vm.user = {};

    vm.init = function () {
        var loc = location.search.substring(1);
        loc = loc.split('=').pop();
        $cookies.put('mtt', loc);  // -> Ne vidi $cookies
        console.log("cookie->"+loc);
    };


    vm.logout = function () {
        userService.logout().then(function (response) {
            setTimeout(function () {
                window.location.href = "login";
            }, 2000);
        }, function () {
            console.log("Error");
        });
    };
>>>>>>> 3e8b4f6b46df55a25ab9a29a2fa68ddb13b105a5
}