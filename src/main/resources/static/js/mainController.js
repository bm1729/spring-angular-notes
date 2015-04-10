var appModule = angular.module('app', []);

appModule.controller('mainController', function($scope) {

	$scope.message = "If you can see this, angular is working!";

});