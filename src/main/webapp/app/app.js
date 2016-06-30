var app = angular.module('app', ['restangular']);

app.config(['RestangularProvider', function(RestangularProvider){
    RestangularProvider.setBaseUrl('/api/');
}]);

app.controller('appCtrl', ['$scope', 'Restangular', function($scope, Restangular){
    $scope.message = 'Users';

    var usersBase = Restangular.all('user');

    $scope.users = usersBase.getList().$object;

    $scope.deleteUser = function(id){
        console.log(id);
    }
}]);