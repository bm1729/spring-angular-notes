var appModule = angular.module('app', ['ngRoute'])
	.config(function($routeProvider) {
		$routeProvider.when('/', {
			templateUrl : 'templates/notes.html',
			controller : 'notesController'
		}).when('/tags', {
			templateUrl : 'templates/tags.html',
			controller : 'tagsController'
		}).when('/note/:id', {
			templateUrl : 'templates/note.html',
			controller : 'noteController',
			resolve: {
				note: function($http, $route) {
					return $http.get('/note/' + $route.current.params.id).then(function(response) {
						var datum = response.data;
						datum.createdDate = moment(datum.createdDate).format('MMMM Do YYYY, h:mm a');
						datum.modifiedDate = moment(datum.modifiedDate).format('MMMM Do YYYY, h:mm a');
						return datum;
					})
				}
			}
		}).otherwise('/');
	}).controller('notesController', function($scope, $http, $location) {
		
		$scope.notes = [];
		$scope.noteClicked = function(note) {
			$location.path('/note/' + note.id);
		};
		
		var initialise = function() {
			$http.get('/notes').success(function(data) {
				$scope.notes = _.map(data, function(datum) {
					datum.createdDate = moment(datum.createdDate).format('MMMM Do YYYY, h:mm a');
					datum.modifiedDate = moment(datum.modifiedDate).format('MMMM Do YYYY, h:mm a');
					return datum;
				});
			});
		};
		initialise();
	}).controller('tagsController', function($scope) {
		$scope.message = 'tags';
	}).controller('noteController', function($scope, note) {
		$scope.note = note;
	});