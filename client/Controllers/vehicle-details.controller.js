



(function(){
    'use strict';
    angular.module('tracker')
        .controller('VehicleDetailController',VehicleDetailController);
    VehicleDetailController.$inject=['trackerService','$routeParams'];

    function VehicleDetailController(trackerService, $routeParams){
       
        
    
        var vehicleDetailVm = this;
        trackerService.getByVin($routeParams.vin)
        .then(function(vehicle){
          vehicleDetailVm.vehicle=vehicle;
        },function(error){
          console.log(error);
        });
       
    
     
    }
})();