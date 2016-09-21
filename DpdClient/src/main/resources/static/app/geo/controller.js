(function (angular) {
	'use strict';

	angular.module('dpdApp')
		.controller('CityCtrl', CityController);

	function CityController ($timeout, $q, $log, $mdToast, $scope, DpdGeo) {
		var self = this;

		self.simulateQuery = false;
		self.isDisabled    = false;
		self.destination   = "pickup";

		// list of all cities
		self.cities = [];
		loadAll();
		
		self.querySearch        = querySearch;
		self.selectedItemChange = selectedItemChange;
		self.searchTextChange   = searchTextChange;
		self.clear              = clear;

		// ******************************
		// Internal methods
		// ******************************

		/**
		 * Search for cities... use $timeout to simulate
		 * remote dataservice call.
		 */
		function querySearch (query) {
			var results = query ? self.cities.filter( createFilterFor(query) ) : self.cities,
				deferred;
			// TODO
			if (self.simulateQuery) {
				deferred = $q.defer();
				$timeout(function () { deferred.resolve( results ); }, Math.random() * 1000, false);
				return deferred.promise;
			} else {
				return results;
			}
		}

		function searchTextChange(text) {
			$log.info('Text changed to ' + text);
		}

		function selectedItemChange(item) {
			$log.info('Item changed to ' + JSON.stringify(item));
			if(item) {
				if (self.destination == 'pickup') {
					$scope.$parent.calcCtrl.form.cityPickupId = item.cityId;
				} else {
					$scope.$parent.calcCtrl.form.cityDeliveryId = item.cityId;
				}
			}
		}

		/**
		 * Build `cities` list of key/value pairs
		 */
		function loadAll() {
			self.cities = DpdGeo.query({query:""},
				function success(resp) {
					$log.info(resp.$status + ": " + resp.$statusText);
			},  function err(res) {
				showNotification(resp.data.code + ": " + resp.data.message);
			});
		}

		/**
		 * Create filter function for a query string
		 */
		function createFilterFor(query) {
			var lowercaseQuery = angular.lowercase(query);

			return function filterFn(city) {
				// 1. starts with query
				//return (city.cityName.toLowerCase().indexOf(lowercaseQuery) === 0);
				// 2. contains query
				return (city.cityName.toLowerCase().indexOf(lowercaseQuery) !== -1);
			};
		}
		
		function clear() {
			self.searchText = undefined;
			self.searchItem = undefined;
		};
		
        // подписываемся на событие
        $scope.$on('clearForm', function(event, args) {
        	self.clear();
        });
        
        function showNotification (message) {
            $mdToast.show(
                $mdToast.simple()
                    .textContent(message)
                    .position("top right")
                    .hideDelay(3000)
            );
        }
	};

})(angular);