var app = angular.module('app', ['restangular']);

app.config(['RestangularProvider', function (RestangularProvider) {
    RestangularProvider.setBaseUrl('/api/');
}]);

app.controller('appCtrl', ['$scope', 'Restangular', function ($scope, Restangular) {
    $scope.message = 'Users';

    var usersBase = Restangular.all('user');

    $scope.users = usersBase.getList().$object;

    $scope.deleteUser = function (id) {
        if (!confirm('Are you sure you want to delete?')) return;

        $scope.users[id - 1].remove(id);
        $scope.users = usersBase.getList().$object;
    }
}]);