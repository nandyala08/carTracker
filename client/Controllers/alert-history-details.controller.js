(function(){
    'use strict';
    angular.module('tracker')
        .controller('VehicleHistoryController',VehicleHistoryController);
    VehicleHistoryController.$inject=['trackerService','$routeParams'];

    function VehicleHistoryController(trackerService, $routeParams){
       
          
        
    
        var VhAlertVm = this;
        trackerService.getAH($routeParams.vin)
        .then(function(alert){
          VhAlertVm.alert=alert;
        
        },function(error){
          console.log(error);
        });
       
       
        
     
    }
})();