(function(){
    'use strict';
    angular.module('tracker')
        .controller('VehicleHistoryController',VehicleHistoryController);
    VehicleHistoryController.$inject=['trackerService','$routeParams'];

    function VehicleHistoryController(trackerService, $routeParams){
        console.log("Came here to controller");
          
        
    
        var VhAlertVm = this;
        trackerService.getAH($routeParams.vin)
        .then(function(alert){
          VhAlertVm.alert=alert;
          console.log("sri"+ VhAlertVm.alert );
        },function(error){
          console.log(error);
        });
       
       
        console.log($routeParams.vin);
     
    }
})();