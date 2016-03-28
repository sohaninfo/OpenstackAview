'use strict';

angular.module('OpenstackAview', [
  'ngCookies',
  'ngResource',
  'ngSanitize',
  'ui.router',
  'ui.bootstrap'
 // 'ui.bootstrap.datetimepicker'
])
.config(function ($stateProvider, $urlRouterProvider, $locationProvider, $httpProvider) {
        $httpProvider.defaults.useXDomain = true;
     $stateProvider.state('index', {
         templateUrl: 'index.html',
         controller: 'MainCtrl'
     })
         .state('main', {
          url: '/main',
          templateUrl: 'client/components/main/main.html',
          controller: 'MainCtrl'
     })
      

})
.run(function ($rootScope) {

});