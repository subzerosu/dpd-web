(function(angular) {
	'use strict';

	angular.module('dpdApp')
		.controller('CalcCtrl', DpdCalcController);

	function DpdCalcController($scope, $log, $mdToast, $mdDialog, $location, $anchorScroll, DpdCalc) {
		var self = this;

        self.form = {};       

		self.update = function(form) {
			self.facilityList = [];
			self.showFacilities = false;
			
			if(isCitiesSelected(form)) {			
				self.showWhile();
	            form.$update({}, function success(resp) {
	            	$log.info(resp.$status + ": " + resp.$statusText);
		            self.facilityList = DpdCalc.query({}, function success() {
		                self.closeWhile(true);
		                goTo('table');
		            }, function err(){
		                self.closeWhile(false);
		            });
	            }, function error(resp) {
	            	self.closeWhile(false);
	            	showNotification(resp.data.code + ": " + resp.data.message);
	            });
			}
		};
		
		self.loadForm = function() {
			DpdCalc.get({id: 0}, function(response) {
				self.form = response;
				$log.info('Empty form is loaded');
			});
		};
		
		self.clearTable = function() {
			// обнуляем список
			self.facilityList = [];
			// прячем таблицу
	        self.showFacilities = false;
		};
		
		self.clearForm = function() {
	        self.clearTable();
			// загружаем пустую форму
			self.loadForm();
            // прячем таблицу
            self.showFacilities = false;
            // опускаем вниз
    		$scope.$broadcast('clearForm', {});
		};

		// init
        self.clearForm();
        
        function isCitiesSelected(form) {
        	if(!form.cityPickupId) {
				showNotification("Не выбран пункт отправления");
				return false;
			}
			
			if(!form.cityDeliveryId) {
				showNotification("Не выбран пункт назначения");
				return false;
			}
			
            return true;
        }
        
        function showNotification (message) {
            $mdToast.show(
                $mdToast.simple()
                    .textContent(message)
                    .position("top right")
                    .hideDelay(3000)
            );
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
        
        self.closeWhile = function(showTable) {
        	$mdDialog.cancel();
        	self.showFacilities = showTable;
            $log.info('show facilities table');
        };
        

        function goTo(loc) {
            // set the location.hash to the id of
            // the element you wish to scroll to.
            $location.hash(loc);

            // call $anchorScroll()
            $anchorScroll();
        };
	};

}(angular));