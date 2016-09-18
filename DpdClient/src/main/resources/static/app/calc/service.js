(function(angular) {
	'use strict';
	
	// Dpd resource
	var DpdCalcFactory = function($resource) {
		return $resource('/dpd/rest/calc', {}, {
			update : {
				method : 'PUT',
                // TODO
                isArray: true,
                transformResponse: function(data, headers){
                    // transform to array of objects
                    return data;
                }
			}
		});
	};
    
	angular.module("dpdApp").factory("DpdCalc", DpdCalcFactory);
}(angular));