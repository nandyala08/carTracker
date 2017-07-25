











(function(){
    'use strict';
    angular.module('tracker')
        .controller('plotController',plotController);
    plotController.$inject=['trackerService','$routeParams','$scope'];

    function plotController(trackerService, $routeParams, $scope){
        console.log("Came here to controller gfcgfcgcjjhbhjb");
         var plotVm = this;
      
       
        
         $scope.type =["engineRpm", "engineHp", "speed","fuelVolume","checkEngineLightOn","engineCoolantLow","cruiseControlOn"];
           $scope.time =["5","10","20", "30", "40","60","80","100", "120"];
      
        $scope.setSelected = function(){
          
         trackService($scope.selectedName,$scope.selectedTime);
        }
        
        function getValues(plots,selected,time) {
          var st=time*60*1000;
          var d = new Date();
           var n = d.getTime();
           var t= n-st;
           
          
           var tempArr=[];
           var timeArr = [];
          for(var obj in plots){
            
            if(plots[obj].timestamp>=t ){
              
            
            tempArr.push(plots[obj][selected]);
            
            }
           
            
          }
          console.log('tempArr value is:',tempArr);
         
           $scope.myJson = {
          type : 'line',
          series : [
                    { values : tempArr } 
         
          ]
        };
        }
       
        
    function trackService(selected,time){
   
        trackerService.getRead($routeParams.vin)
        .then(function(plots){
          plotVm.plots=plots;
         
          
             getValues(plots,selected,time);
          
          
         
          
        },function(error){
          console.log(error);
        });
    }
       
       
        
     
    }
})();