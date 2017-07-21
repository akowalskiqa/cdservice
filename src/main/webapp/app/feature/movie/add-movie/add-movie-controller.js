(function() {

    var AddMovieController =  function($state, cdDal) {
        var vm = this;

        vm.addMovie = function(cdToAdd) {
            console.log("This is the value of cd to add " + cdToAdd);
            console.log(cdToAdd);
            var cdToJson = JSON.stringify(cdToAdd);
            console.log(cdToJson);
            cdDal.saveMovie(cdToAdd).then(function (results) {
                vm.cdAddMessage  = results;
                $state.go('getcd');
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        };
    };

    angular.module('cinema').controller('addMovieController', ['$state','cdDal',AddMovieController]);
}());