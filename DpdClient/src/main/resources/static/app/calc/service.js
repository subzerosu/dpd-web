(function(angular) {
	'use strict';
	
	// Dpd resource
	var DpdCalcFactory = function($resource) {
		return $resource('/dpd/rest/calc/:id', {id: '@id'}, {
			update : {
				method : 'PUT',
				interceptor: {
			        response: function(response) {      
			            var result = response.resource;        
			            result.$status = response.status;
			            result.$statusText = response.statusText;
			            return result;
			        }
			    }
			}
		});
	};
    
	angular.module("dpdApp").factory("DpdCalc", DpdCalcFactory);
}(angular));