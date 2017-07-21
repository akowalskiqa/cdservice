"use strict";

(function () {

    angular.module("cinema").service("cdDal", ["dal", MovieDal]);

    function MovieDal (dal) {

        this.getMovies = function () {
            return dal.http.GET("rest/cinema/json");
        };

        this.saveMovie = function (cdToSave) {
            return dal.http.POST("rest/cinema/json", cdToSave);
        };

        this.updateMovie = function (cdToUpdate) {
            return dal.http.PUT("rest/cinema/json/", cdToUpdate);
        };

        this.deleteMovie = function (cdToDelete) {
            return dal.http.DELETE("rest/cinema/json/", cdToDelete);
        };

    }
}());
