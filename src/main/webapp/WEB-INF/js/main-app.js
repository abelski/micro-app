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
        $scope.edit = function (tender) {
            $scope.activeTender = angular.copy(tender);
            $scope.action='EDIT';
        };

        $scope.accept = function (tender, offer) {
            $http.get('tender/accept/' + tender.id+'/'+offer.id).success(function () {
                $scope.find();
            });
        };

        $scope.decline = function (tender, offer) {
            $http.get('tender/decline/' + tender.id+'/'+offer.id).success(function () {
                $scope.find();
            });
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
        $scope.putOffer = function (id, offer) {
            console.log(id);
            console.log(offer);
            $http.put('tender/offer/'+id, offer).success(function () {
                $scope.find();
            });
        };

        $http.get('tender/').success(function (data) {
            $scope.tenders = data.tenders
            $scope.tenders = data;

            $http.get('client/active').success(function (data) {
                $scope.activeClient = data;
            });

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
    }).directive('offerModal', function () {
        return {
            restrict: 'E',
            templateUrl: 'directive/offer-modal.html'
        };
    }).directive('appMenu', function () {
        return {
            restrict: 'E',
            templateUrl: 'directive/menu.html'
        };
    })


;