(function(angular) {
	// Dpd resource
	var DpdGeoFactory = function($resource) {
		return $resource('/dpd/rest/geo', {query:'@query'}, {});
	};

	DpdGeoFactory.$inject = [ '$resource' ];
	angular.module("dpdApp.services").factory("DpdGeo", DpdGeoFactory);
}(angular));