







(function(){
    'use strict';
    angular.module('tracker')
        .controller('highAlertController',highAlertController);
    highAlertController.$inject=['trackerService'];

    function highAlertController(trackerService){
        
   
    
        var hAlertVm = this;
        trackerService.getHalerts().then(function(highAlerts){
            hAlertVm.highAlerts=highAlerts;
        }, function(error){
            console.log(error);
        });
        
     
    }
})();
