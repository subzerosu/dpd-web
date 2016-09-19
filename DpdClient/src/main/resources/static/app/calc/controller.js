(function(angular) {
	'use strict';

	angular.module('dpdApp')
		.controller('CalcCtrl', DpdCalcController);

	function DpdCalcController($scope, $log, $mdToast, $mdDialog, DpdCalc) {
		var self = this;

        self.form = {};
        self.facilityList = [];
        self.showFacilities = false;

		self.update = function(form) {
			showNotification("Запрос отравляется!");
			
			self.showWhile();
            form.$update({}, function success(resp) {
                self.facilityList = DpdCalc.query({}, function success() {
                	self.closeWhile();
                }, function err(){
                	self.closeWhile();
                });
            }, function error(data) {
            	self.closeWhile();
            });
		};
		
		self.loadForm = function() {
			DpdCalc.get({id: 0}, function(response) {
				self.form = response;
				$log.info('Empty form is loaded');
			});
		};
		
        //self.loadForm();

		self.clearForm = function() {
			// загружаем пустую форму
			self.loadForm();
            // прячем таблицу
            self.showFacilities = false;
            // опускаем вниз
    		$scope.$broadcast('clearForm', {});
		};

        self.clearForm();

        function showNotification (message) {
            $mdToast.show(
                $mdToast.simple()
                    .textContent(message)
                    .position("top right")
                    .hideDelay(3000)
            );
            //$log.info('Form updated');
        }
        
        self.showWhile = function() {
            $mdDialog.show({
              controller: DpdCalcController,
              templateUrl: '/dpd/app/templates/whiledialog.tmpl.html',
              parent: angular.element(document.body),
              clickOutsideToClose: false,
              fullscreen: false
            });
        };
        
        self.closeWhile = function() {
        	$mdDialog.cancel();
        	self.showFacilities = true;
            $log.info('show facilities table');
        };
	};

}(angular));