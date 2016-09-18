(function(angular) {
	'use strict';
	
	// Dpd resource
	var DpdCalcFactory = function($resource) {
		return $resource('/dpd/rest/calc/:id', {id: '@id'}, {
			update : {
				method : 'PUT'
			}
		});
	};
    
	angular.module("dpdApp").factory("DpdCalc", DpdCalcFactory);
}(angular));