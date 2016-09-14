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
		vm.city = {};
        vm.city.selected = {};

		//vm.city.selectedValue = vm.cities[3];

		DpdGeo.query(function(response) {
			vm.cities = response;
		});

        // $scope.funcAsync = function (query) {
         //    var reqStr;
         //    reqStr = query == 'red' ? 'data1.json' : 'data.json';
         //    console.log(query);
         //    $http.get(reqStr).then(
         //        function (response) {
         //            $scope.availableColors = response.data;
         //            console.log(response)
         //        },
         //        function () {
         //            console.log('ERROR!!!');
         //        }
         //    );
        
    };

	DpdGeoController.$inject = ['$scope', 'DpdGeo'];
	angular.module("dpdApp.controllers").controller("DpdGeoController",
        DpdGeoController);

}(angular));