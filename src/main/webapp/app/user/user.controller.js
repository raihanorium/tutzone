/**
 * Created by Raihan on 7/11/2016.
 */
var app = angular.module('app');

app.controller('userCtrl', ['$scope', 'Restangular', function ($scope, Restangular) {
    $scope.message = 'Users';

    var usersBase = Restangular.all('user');

    $scope.users = usersBase.getList().$object;

    $scope.deleteUser = function (user) {
        if (!confirm('Are you sure you want to delete?')) return;

        user.remove().then(function () {
            var index = $scope.users.indexOf(user);
            if (index > -1) $scope.users.splice(index, 1);
        });
    };

    $scope.saveUser = function () {
        if (!$scope.user.id) {
            // create
            usersBase.post($scope.user.name).then(function () {
                $scope.users = usersBase.getList().$object;
                $scope.user = null;
            });
        } else {
            // update
            $scope.user.put().then(function () {
                $scope.users = usersBase.getList().$object;
                $scope.user = null;
                $('#actionButton').text('Create');
            });
        }
    };

    $scope.editUser = function (user) {
        usersBase.get(user.id).then(function (userInDb) {
            $scope.user = userInDb;
        });

        $('#actionButton').text('Save');
    };
}]);