/**
 * Created by user on 22.06.2015.
 */
angular.module('mainApp', [])
    .config(
    function () {
    }
)
    .run(
    function () {
        console.log('run')
    }
).controller('MainController', ['$scope', '$http', function ($scope, $http) {
        $scope.menu = [
            {
                title: "peoples",
                url: "people.jsp"
            }, {
                title: "request",
                url: "request.jsp"
            },
        ];
        $scope.find = function () {
            $http.post('client/search', {search: $scope.findText}).success(function (data) {
                $scope.peoples = data.peoples
                $scope.peoples = data;
            });

        };
        $scope.save = function () {
            var request = $scope.activePeople;
            console.log(request);

            $http.put('client/', request).success(function(){
                $scope.find();
            });
        }

        $http.get('client/').success(function (data) {
            $scope.peoples = data.peoples
            $scope.peoples = data;
        });

    }]).directive('peopleCard', function () {
        return {
            restrict: 'E',
            scope: {
                people: '=people'
            },
            templateUrl: 'directive/people-card.html'
        };
    }).directive('peopleFind', function () {
        return {
            restrict: 'E',
            templateUrl: 'directive/people-find.html'
        };
    }).directive('peopleModal', function () {
        return {
            restrict: 'E',
            templateUrl: 'directive/people-modal.html'
        };
    })


;