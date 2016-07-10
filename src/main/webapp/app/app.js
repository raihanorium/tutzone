var app = angular.module('app', ['restangular']);

app.config(['RestangularProvider', function (RestangularProvider) {
    RestangularProvider.setBaseUrl('/api/');
}]);

app.controller('appCtrl', ['$scope', 'Restangular', function ($scope, Restangular) {
    $scope.message = 'Users';

    var usersBase = Restangular.all('user');

    $scope.users = usersBase.getList().$object;

    $scope.deleteUser = function (user) {
        if (!confirm('Are you sure you want to delete?')) return;

        user.remove().then(function () {
            var index = $scope.users.indexOf(user);
            if (index > -1) $scope.users.splice(index, 1);
        });
    }

    $scope.createUser = function () {
        usersBase.post($scope.userName).then(function () {
            $scope.users = usersBase.getList().$object;
            $scope.userName = null;
        });
    }
}]);