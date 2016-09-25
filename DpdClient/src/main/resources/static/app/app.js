(function () {
  'use strict';

  var app = angular.module('dpdApp', ['ngMaterial', 'ngMessages', 'mdDataTable', 'ngclipboard', 'ngResource']);
  
  app.config(function($mdIconProvider) {
	  $mdIconProvider
	    .defaultIconSet('assets/mdi/mdi.svg')
	});
})();