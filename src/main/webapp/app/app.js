var app = angular.module('app', ['ui.router', 'restangular']);

app.config(['$stateProvider', 'RestangularProvider', function ($stateProvider, RestangularProvider) {
    // ui-router config
    $stateProvider
        .state('index', {url: "", views: {"body": {template: "Home Page"}}})
        .state('user', {
            url: "/user",
            views: {"body": {templateUrl: "app/user/user.tpl.html", controller: "userCtrl"}}
        });

    // restangular configuration
    RestangularProvider.setBaseUrl('/api/');
}]);

app.controller('appCtrl', [function () {
}]);