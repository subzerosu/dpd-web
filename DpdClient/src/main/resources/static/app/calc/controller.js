(function(angular) {
	'use strict';

	angular.module('dpdApp')
		.controller('CalcCtrl', DpdCalcController);

	function DpdCalcController($log, $mdToast, DpdCalc) {
		var self = this;

        self.form = {};

        self.facilityList = [];

        self.calculations = false;

		DpdCalc.get({id: 0}, function(response) {
			self.form = response;
			$log.info('Form is loaded');
		});

		self.update = function(form) {
            self.calculations = true;
            form.$update({}, function success(resp) {
                showNotification("Запрос отравлен!");

                self.facilityList = DpdCalc.query({}, function success(data){
                    self.calculations = false;
                }, function error(data) {
                    self.calculations = false;
                });
            }, function error(data) {
                self.calculations = false;
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