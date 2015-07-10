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

        $scope.find = function () {
            $http.post('tender/search', {search: $scope.findText}).success(function (data) {
                $scope.tenders = data.tenders
                $scope.tenders = data;
            });

        };
        $scope.edit = function (people) {
            $scope.activeTender = angular.copy(people);
            $scope.action='EDIT';
        };
        $scope.delete = function (people) {
                $http.delete('tender/' + tender.id).success(function () {
                $scope.find();
            });
        };
        $scope.save = function () {
            var request = $scope.activeTender;
            $http.put('tender/', request).success(function () {
                $scope.find();
            });
        };

        $http.get('client/').success(function (data) {
            $scope.tenders = data.tenders
            $scope.tenders = data;
        });

    }]).directive('tenderCard', function () {
        return {
            restrict: 'E',
            templateUrl: 'directive/tender-card.html'
        };
    }).directive('tenderFind', function () {
        return {
            restrict: 'E',
            templateUrl: 'directive/tender-find.html'
        };
    }).directive('tenderModal', function () {
        return {
            restrict: 'E',
            templateUrl: 'directive/tender-modal.html'
        };
    })


;