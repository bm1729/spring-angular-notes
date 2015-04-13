var appModule = angular.module('app', ['ngRoute'])
	.config(function($routeProvider) {
		$routeProvider.when('/', {
			templateUrl : 'templates/notes.html',
			controller : 'notesController'
		}).when('/tags', {
			templateUrl : 'templates/tags.html',
			controller : 'tagsController'
		}).otherwise('/');
	}).controller('notesController', function($scope, $http) {
		
		$scope.notes = [];
		
		var initialise = function() {
			$http.get('/notes').success(function(data) {
				$scope.notes = _.map(data, function(datum) {
					return {
						id: datum.id,
						title: datum.title,
						modifiedDate: moment(datum.modifiedDate).format('MMMM Do YYYY, h:mm a')
					};
				});
			});
		};
		
		initialise();
		
	}).controller('tagsController', function($scope) {
		$scope.message = 'tags';
	});