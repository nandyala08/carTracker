




(function(){
    'use strict';
    angular.module('tracker')
        .controller('trackerController',trackerController);
    trackerController.$inject=['trackerService'];

    function trackerController(trackerService){
        var trackVm = this;
        trackerService.get().then(function(vehicles){
            trackVm.vehicles=vehicles;
        }, function(error){
            console.log(error);
        });
        
     
    }
})();
