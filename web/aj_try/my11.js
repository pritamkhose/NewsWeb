/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
<!-- Demo at http://jsbin.com/zejuvo/1/edit?html,js,output -->
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <title>JS Bin</title>
  <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular.min.js"></script>
</head>

<body>
  <div ng-app="myApp" ng-controller="planetController"> 
    <ul>
      [name], [earth-sun=1], [light speed]
      <li ng-repeat="x in names">
        {{ x.name + ', ' + x.distance + ', ' + x.light }}
      </li>
    </ul>
  </div>

  <script>

  var app = angular.module('myApp', []);
  app.controller('planetController', function($scope, $http) {
    $http.get("http://www.bogotobogo.com/AngularJS/files/httpRequest/planet2.json")
    .success(function(response) {$scope.names = response;});
  });
  </script>

</body>
</html>

</html>

