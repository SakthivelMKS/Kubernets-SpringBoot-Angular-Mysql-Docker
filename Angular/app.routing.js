app.config(function($routeProvider,$locationProvider) {
  $routeProvider
  .when("/studentCreation", {
    templateUrl : "StudentCreation.html"
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