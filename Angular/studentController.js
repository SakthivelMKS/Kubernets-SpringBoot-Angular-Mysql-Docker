app.controller('myCtrl', function($scope,$http,$location,$window,$rootScope) {


 $scope.names = ["MCA", "MBA", "ME","BE"];
	
	  $http({
    method : "GET",
    url : "http://localhost:8080/api/studentList"
  }).then(function mySuccess(response) {
  console.log(response)
      $scope.data = response.data;
    }, function myError(response) {
      $scope.myWelcome = response.statusText;
  });
  
   $scope.createStudent=function(){
	   //$location.url('/studentCreation');
	   $window.location.href = "StudentCreation.html";
   }
   
   $scope.StudentEdit={};
   
   
   $scope.updateStudent=function(edit){
	   var id=$scope.StudentEdit.student_id;
	   	     $http({
    method : "put",
	data:$scope.StudentEdit,
    url : "http://localhost:8080/api/student"+'/'+id
  }).then(function mySuccess(response) {
      $scope.data = response.data;
	  	   $window.location.href = "Student.html";

    }, function myError(response) {
      $scope.myWelcome = response.statusText;
  });
   }
   $scope.loadData=function(){
	   var queryString = new Array();
	   if ($window.location.search.split('?').length > 1) {
            var params = $window.location.search.split('?')[1].split('&');
            for (var i = 0; i < params.length; i++) {
                var key = params[i].split('=')[0];
                var value = decodeURIComponent(params[i].split('=')[1]);
                queryString[key] = value;
            }
	   }
var id=queryString["id"];
console.log(id);
	      $http({
    method : "GET",
    url : "http://localhost:8080/api/student/"+id
  }).then(function mySuccess(response) {
  console.log(response)
      $scope.StudentEdit = response.data;
    }, function myError(response) {
      $scope.myWelcome = response.statusText;
  });
   }
   var id=0;
    $scope.editUser=function(id){	
	$rootScope.id=id;
	  console.log(id);
	  	   $window.location.href = "StudentEdit.html?id="+id;

   }
   
   
   
   $scope.saveStudent = function() {
	  
	   console.log($scope.Student);
	   if($scope.Student==undefined){
		   $window.alert("Enter mandatory Details");    
	   }else{
	   
	     $http({
    method : "post",
	data:$scope.Student,
    url : "http://localhost:8080/api/student"
  }).then(function mySuccess(response) {
      $scope.data = response.data;
	  	   $window.location.href = "Student.html";

    }, function myError(response) {
      $scope.myWelcome = response.statusText;
  });
	   }
    }
  
});