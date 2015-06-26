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
).controller('MainController', ['$scope', function($scope) {
    $scope.menu = [
        {
            title : "peoples",
            url: "people.jsp"
        },{
            title : "request",
            url: "request.jsp"
        },
        $scope.find = function(){
            $scope.text = '123123';
            $scope.peoples = {};
        }

    ];
}]).controller('PeopleController', ['$scope','$http', function($scope, $http) {
        $http.get('client/').success(function(data) {
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