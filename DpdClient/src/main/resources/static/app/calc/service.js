(function(angular) {
	// Dpd resource
	var DpdCalcFactory = function($resource) {
		return $resource('/dpd/rest/calc', {}, {
			update : {
				method : 'PUT'
			}
		});
	};

	DpdCalcFactory.$inject = [ '$resource' ];
	angular.module("dpdApp.services").factory("DpdCalc", DpdCalcFactory);
}(angular));