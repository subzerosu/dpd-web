(function(angular) {
	// Dpd controller
	var DpdGeoController = function($scope, DpdGeo) {
		var vm = this;

		vm.cities = [
			// {
			//     cityId: 48951627,
			//     countryCode: "RU",
			//     countryName: "Россия",
			//     regionCode: 42,
			//     regionName: "Кемеровская",
			//     cityCode: "42000009000",
			//     cityName: "Кемерово",
			//     abbreviation: "г",
			//     indexMin: "650000",
			//     indexMax: "650999"
			// }
		];

		vm.allCities = DpdGeo.query({query:""});

		vm.city = {};
		vm.city.selected = {};

		$scope.funcAsync = function (query) {
            vm.cities = [];
			vm.cities = vm.allCities.filter(function(c) {
                return ( contains(c.cityName, query) || contains(c.regionName, query));
            });
		};

        contains = function(a, b) {
            return a.toLowerCase().indexOf(b.toLowerCase()) !== -1;
        };
	};


	DpdGeoController.$inject = ['$scope', 'DpdGeo'];
	angular.module("dpdApp.controllers").controller("DpdGeoController",
        DpdGeoController);

}(angular));