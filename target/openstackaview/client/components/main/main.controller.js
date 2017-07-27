'use strict';

var app = angular.module("OpenstackAview");

app.controller("MainCtrl", ["$scope", "$http", function($scope, $http){
	$scope.msg = "Hello world!";
    $scope.data = ""
	$scope.encrypt = function() {

		alert("encrypting...");

		var obj = {
			"data": $scope.data
		}
		/*$http.post("/encrypt", "This is my data").success(function(response){
			if(response){
				console.log("The data has been encrypted:" + response)
			}
		})*/

	   $http({
            method: 'POST',
            url:"/encrypt", 
            data: obj,
            headers: {'Content-Type': 'application/json'}
        }).success(function (data, status, headers, config)
        {
            console.log("The data has been encrypted:" + data)
        })
            .error(function (data, status, headers, config) {

            });

	}


	$scope.update = function() {

		var obj = {
			"data": $scope.data
		}

	   $http({
            method: 'POST',
            url:"/settoken", 
            data: $scope.token,
            headers: {'Content-Type': 'text/plain'}
        }).success(function (data, status, headers, config)
        {
            console.log("The token has been set:" + data)
        })
            .error(function (data, status, headers, config) {

            });

	}
}]);