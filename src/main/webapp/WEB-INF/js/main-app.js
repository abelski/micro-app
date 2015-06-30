/**
 * Created by user on 22.06.2015.
 */
angular.module('mainApp',[])
.config(
    function(){
        console.log('conf')
    }
)
.run(
    function(){
        console.log('run')
    }
).controller('MainController', ['$scope', '$http', function($scope, $http) {
        $scope.menu = [
            {
                title: "peoples",
                url: "people.jsp"
            }, {
                title: "request",
                url: "request.jsp"
            },
        ];
        $scope.find = function(){
            $http.get('client/' + $scope.findText).success(function(data) {
                $scope.peoples = data.peoples
                console.log(data);
                $scope.peoples = data;
            });

        };

        $http.get('client/').success(function(data) {
            $scope.peoples = data.peoples
            console.log(data);
            $scope.peoples = data;
        });

}]).directive('peopleCard', function() {
        return {
            restrict: 'E',
            scope:{
                people : '=people'
            },
            templateUrl: 'people-card.html'
        };
    })


;