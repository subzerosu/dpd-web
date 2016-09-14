(function(angular) {
	// Dpd resource
	var DpdGeoFactory = function($resource) {
		return $resource('/dpd/rest/geo', {}, {});
	};

	DpdGeoFactory.$inject = [ '$resource' ];
	angular.module("dpdApp.services").factory("DpdGeo", DpdGeoFactory);
}(angular));