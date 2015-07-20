/**
 * Created by user on 22.06.2015.
 */
angular.module('clientApp', [])
    .config(
    function () {
    }
)
    .run(
    function () {
        console.log('run')
    }
).controller('ClientController', ['$scope', '$http', function ($scope, $http) {



        $http.get('client/').success(function (data) {
            $scope.clients = data.clients
            $scope.clients = data;
        });

    }]).directive('clientCard', function () {
        return {
            restrict: 'E',
            templateUrl: 'directive/client-card.html'
        };
    }).directive('appMenu', function () {
        return {
            restrict: 'E',
            templateUrl: 'directive/menu.html'
        };
    })


;