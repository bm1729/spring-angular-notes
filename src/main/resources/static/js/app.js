var appModule = angular.module('app', ['ngRoute'])
	.config(function($routeProvider) {
		$routeProvider.when('/', {
			templateUrl : 'templates/notes.html',
			controller : 'notesController'
		}).when('/tags', {
			templateUrl : 'templates/tags.html',
			controller : 'tagsController'
		}).otherwise('/');
	}).controller('notesController', function($scope) {
		$scope.message = 'notes';
	}).controller('tagsController', function($scope) {
		$scope.message = 'tags';
	});