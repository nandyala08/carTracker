





(function(){
    'use strict';
    angular.module('tracker')
        .controller('plotVinController',plotVinController);
    plotVinController.$inject=['trackerService'];

    function plotVinController(trackerService){
      
          
   
    
        var plotVinVm = this;
        trackerService.get().then(function(plot){
            plotVinVm.plot=plot;
            
            
        }, function(error){
            console.log(error);
        });
        
     
    }
})();
