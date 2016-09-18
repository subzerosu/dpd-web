(function(angular) {
	'use strict';

	// Dpd resource
	var DpdGeoFactory = function($resource) {
		return $resource('/dpd/rest/geo', {query:'@query'}, {});
	};

	angular.module('dpdApp').factory("DpdGeo", DpdGeoFactory);
}(angular));