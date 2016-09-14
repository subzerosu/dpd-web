(function(angular) {
	// Dpd controller
	var DpdCalcController = function($scope, Notification, DpdCalc) {
		$scope.form = {};

		DpdCalc.get(function(response) {
			$scope.form = response;
		});

		$scope.update = function(form) {
			form.$update();
            Notification.primary('Dpd calc form was updated successfully!')
		};

	};

	DpdCalcController.$inject = [ '$scope', 'Notification', 'DpdCalc'];
	angular.module("dpdApp.controllers").controller("DpdCalcController",
        DpdCalcController);

}(angular));