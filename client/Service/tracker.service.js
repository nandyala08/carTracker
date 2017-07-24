



(function(){
    'use strict';
    var tracker = angular.module('tracker')
        .service('trackerService', trackerService);

    trackerService.$inject = ['$q', '$http'];

    function trackerService($q,$http){
        var self=this;
        self.get=getVehicles;
        self.getByVin=getVehicleByVin;
        self.getAlert= getAlerts;
        self.getHalerts = getHighAlerts;
        self.getAH=getAlertByVin;
        self.getM = getMap;
        self.getRead = getReadingsByVin;
        console.log("Came here");
        
        
        
        function getVehicles(){
            return $http.get('http://localhost:8080/api/vehicles')
                .then(successFn, errorFn);
        }
        
        function getVehicleByVin(vin) {
        return $http.get('http://localhost:8080/api/vehicles/' + vin)
        .then(successFn, errorFn);
    }
    
            function getAlertByVin(vin) {
        return $http.get('http://localhost:8080/api/vehicles/alerts/'+vin)
        .then(successFn, errorFn);
    }
        
        function getAlerts(){
            return $http.get('http://localhost:8080/api/vehicles/alerts')
                .then(successFn, errorFn);
        }
        
        function getHighAlerts(){
          return $http.get('http://localhost:8080/api/highalerts')
                .then(successFn, errorFn);
          
        }
        
        function getMap(vin){
          return $http.get('http://localhost:8080/api/vehicles/geo/'+ vin)
                .then(successFn, errorFn);
          
        }
        function getReadingsByVin(vin){
          return $http.get('http://localhost:8080/api/readings/'+ vin)
                .then(successFn, errorFn);
          
        }
        
        
        function successFn(response){
          console.log("sucess!!");
            return response.data;
        }
        function errorFn(error) {
            return $q.reject(error);
        }
    }
})();