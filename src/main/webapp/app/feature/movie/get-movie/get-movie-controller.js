(function() {

    var GetMovieController =  function(cdDal)
    {
        var vm = this;
        vm.test = "test";

        function init() {
            cdDal.getMovies().then(function (results) {
                vm.cds  = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        }
        init();
    };
    angular.module('cinema').controller('getMovieController', ['cdDal', GetMovieController]);
}());