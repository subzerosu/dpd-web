(function(angular) {
	'use strict';

	angular.module('dpdApp')
		.controller('CalcCtrl', DpdCalcController);

	function DpdCalcController($log, $mdToast, $mdDialog, DpdCalc) {
		var self = this;

        self.form = {};
        self.facilityList = [];
        //self.dataReceived = false;

		DpdCalc.get({id: 0}, function(response) {
			self.form = response;
			$log.info('Form is loaded');
		});

		self.update = function(form) {
			showNotification("Запрос отравляется!");
			
			self.showWhile();
            form.$update({}, function success(resp) {
                self.facilityList = DpdCalc.query({}, function success() {
                    $mdDialog.cancel();
                }, function err(){
                    $mdDialog.cancel();
                });
            }, function error(data) {
            	$mdDialog.cancel();
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
                    .position("top right")
                    .hideDelay(3000)
            );
            //$log.info('Form updated');
        }
        
        self.showWhile = function(ev) {
            $mdDialog.show({
              controller: DpdCalcController,
              templateUrl: '/dpd/app/templates/whiledialog.tmpl.html',
              parent: angular.element(document.body),
              clickOutsideToClose: false,
              fullscreen: false
            });
        };
        

	};

}(angular));