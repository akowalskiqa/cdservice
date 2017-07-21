"use strict";

(function () {

    angular.module('cinema').config(function ($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise("/dashboard");

        $stateProvider.state("dashboard", {
            url: "/dashboard",
            templateUrl: "app/feature/dashboard/dashboard.html"
        }).state("getcd", {
            url: "/getcd",
            templateUrl: "app/feature/cd/get-cd/get-cd.html"
        }).state("addcd", {
            url: "/addcd",
            templateUrl: "app/feature/cd/add-cd/add-cd.html"
        })
    });
}());