(function(angular) {
	'use strict';

	angular.module('dpdApp')
		.controller('CalcCtrl', DpdCalcController);

	function DpdCalcController($log, $mdToast, DpdCalc) {
		var self = this;

        self.form = {};

        self.facilityList = [];

		DpdCalc.get(function(response) {
			self.form = response;
			$log.info('Form is loaded');
		});

		self.update = function(form) {
            // TODO
			form.$update({}, function success(resp) {
                showNotification("Запрос отравлен!");

                self.facilityList = resp;
            });
		};

		self.clear = function() {
            self.form = {
                cityPickupType: false,
                cityDeliveryType: false,
                quantity: 1
            };
		};

        self.clear();

        function showNotification (message) {
            $mdToast.show(
                $mdToast.simple()
                    .textContent(message)
                    .hideDelay(3000)
            );
            $log.info('Form updated');
        }
	};

}(angular));