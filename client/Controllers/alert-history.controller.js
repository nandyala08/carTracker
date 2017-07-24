




(function(){
    'use strict';
    angular.module('tracker')
        .controller('alertController',alertController);
    alertController.$inject=['trackerService'];

    function alertController(trackerService){
        
          
   
    
        var alertVm = this;
        trackerService.get().then(function(alerts){
            alertVm.alerts=alerts;
        }, function(error){
            console.log(error);
        });
        
     
    }
})();
