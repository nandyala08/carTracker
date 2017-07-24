(function(){
    'use strict';
    angular.module('tracker')
        .controller('locationController',locationController);
    locationController.$inject=['trackerService'];

    function locationController(trackerService){
      var locateVm = this;
        trackerService.get().then(function(geo){
            locateVm.geo=geo;
            
        }, function(error){
            console.log(error);
        });
  
    }
})();