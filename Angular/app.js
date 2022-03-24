var app = angular.module('myApp', ["ngRoute"]);
app.config(function($routeProvider,$locationProvider) {
  $routeProvider
  .when("/studentCreation", {
    templateUrl : "/StudentCreation.html",
	controller : "myCtrl"
  })
  .when("/studentList", {
    templateUrl : "Student.html",
    controller : "myCtrl"
  })
  .when("/studentEdit", {
    templateUrl : "paris.htm",
    controller : "parisCtrl"
  });
});