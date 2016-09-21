(function(angular) {
	'use strict';

	// Dpd resource
	var DpdGeoFactory = function($resource) {
		return $resource('/dpd/rest/geo', {query:'@query'}, {
			query: {
				method: 'GET',
				isArray: true,
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

	angular.module('dpdApp').factory("DpdGeo", DpdGeoFactory);
}(angular));