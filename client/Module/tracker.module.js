






(function() {
  'use strict';
  var tracker = angular.module('tracker', ['ngRoute', 'zingchart-angularjs']);
  
  angular.module('tracker')
  .config(moduleConfig);
  
   tracker.config(function($httpProvider) {
      //Enable cross domain calls
      $httpProvider.defaults.useXDomain = true;

      //Remove the header used to identify ajax call  that would prevent CORS from working
      delete $httpProvider.defaults.headers.common['X-Requested-With'];
  });
 
 angular.module('tracker')
  .config(module2Config);
  module2Config.$inject=['$routeProvider'];
   function module2Config($routeProvider){
    $routeProvider
    
    .when('/high-alerts',{
      templateUrl: 'Html/vehicle-highalert.tmpl.html',
      controller: 'highAlertController',
      controllerAs: 'hAlertVm'
    })
    
    
    
    .otherwise({redirectTo:'/vehicles'});
    
    
    
  }
  
  angular.module('tracker')
  .config(module3Config);
  module3Config.$inject=['$routeProvider'];
   function module3Config($routeProvider){
    $routeProvider
    

    
     .when('/alerts-history',{
      templateUrl: 'Html/alert-history.tmpl.html',
      controller: 'alertController',
      controllerAs: 'alertVm'
    })
     .when('/vehicles/alerts/:vin',{ 
      templateUrl: 'Html/alert-history-details.tmpl.html',
      controller: 'VehicleHistoryController',
      controllerAs: 'VhAlertVm'
    })
    
    .otherwise({redirectTo:'/vehicles'});
    
    
    
  }
  
  angular.module('tracker')
  .config(module4Config);
  module4Config.$inject=['$routeProvider'];
   function module4Config($routeProvider){
    $routeProvider
    

    
     .when('/location',{
      templateUrl: 'Html/vehicle-location.tmpl.html',
      controller: 'locationController',
      controllerAs: 'locateVm'
      
     
    })
    
    
    .otherwise({redirectTo:'/vehicles'});
    
    
    
  }
  
  angular.module('tracker')
  .config(module5Config);
  module5Config.$inject=['$routeProvider'];
   function module5Config($routeProvider){
    $routeProvider
    

    
     .when('/location/:vin',{
      templateUrl: 'Html/location-map.tmpl.html',
      controller: 'mapController',
      controllerAs: 'mapVm'
     
    })
    
    
    .otherwise({redirectTo:'/vehicles'});
    
    
    
  }
  
  angular.module('tracker')
  .config(module6Config);
  module6Config.$inject=['$routeProvider'];
   function module6Config($routeProvider){
    $routeProvider
  
     .when('/plots',{
      templateUrl: 'Html/plots-vin.tmpl.html',
      controller: 'plotVinController',
      controllerAs: 'plotVinVm'
    })
    .otherwise({redirectTo:'/vehicles'});
    
  }
  
  angular.module('tracker')
  .config(module7Config);
  module7Config.$inject=['$routeProvider'];
   function module7Config($routeProvider){
    $routeProvider
  
     .when('/plots/:vin',{
      templateUrl: 'Html/plots-read.tmpl.html',
      
    })
    .otherwise({redirectTo:'/vehicles'});
    
  }
  
  
 
  moduleConfig.$inject=['$routeProvider'];
  
  function moduleConfig($routeProvider){
    $routeProvider
    
    .when('/vehicles',{
      templateUrl: 'Html/vehicle-list.tmpl.html',
      controller: 'trackerController',
      controllerAs: 'trackVm'
    })
    .when('/vehicles/:vin',{ 
      templateUrl: 'Html/vehicle-details.tmpl.html',
      controller: 'VehicleDetailController',
      controllerAs: 'vehicleDetailVm'
    })
    
    .otherwise({redirectTo:'/vehicles'});
    
    
    
  }

})();