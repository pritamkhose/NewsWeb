/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var app = angular.module("mainApp", ['ngRoute']);
 
app.config(function($routeProvider) {
    $routeProvider
        .when('/home', {
            templateUrl: 'home.html',
            controller: 'customerController'
        })
        .when('/viewCustomers', {
            templateUrl: 'viewCustomers.html',
            controller: 'customerController'
        })
        .otherwise({
            redirectTo: '/home'
        });
});
 
app.controller('customerController', function($scope) {
    $scope.customers = [
        {name: 'Jane Stewart', city:'San Francisco'},
        {name: 'Sam Jenkins', city:'Moscow'},
        {name: 'Mark Andrews', city:'New York'}
    ];
 
    $scope.message = "Click the link to view the customers list.";
});


