



(function(){
    'use strict';
    angular.module('tracker')
        .controller('mapController',mapController);
   mapController.$inject=['trackerService','$routeParams'];

    function mapController(trackerService, $routeParams){
       
            function initMap(maps){
              var myOptions = {
                     center: new google.maps.LatLng( maps[0].latitude, maps[0].longitude ),
		              	zoom:3
                };
                 var map = new google.maps.Map(document.getElementById("map"), myOptions );
                 var uluru1 = {lat: parseFloat(maps[0].latitude), lng: parseFloat(maps[0].longitude)};
            var marker1 = new google.maps.Marker({
          position: uluru1,
          map: map
        });
          for(var ma in maps){
            var uluru1 = {lat: parseFloat(maps[ma].latitude), lng: parseFloat(maps[ma].longitude)};
            var marker1 = new google.maps.Marker({
          position: uluru1,
          map: map
        });
          }
          
          
          
        }
        
    
        var mapVm = this;
        trackerService.getM($routeParams.vin)
        .then(function(map){
          mapVm.map=map;
       initMap(map);
        },function(error){
          console.log(error);
        });
       
       
        
      
        
        
      
     
    }
})();