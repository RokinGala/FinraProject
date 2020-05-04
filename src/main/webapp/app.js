/**
 * 
 */

'use strict';

var app = angular.module('app', [ 'ngResource', 'smart-table', 'ngTable',
		'angular.filter' ]);

app.controller('TableCtrl', [
		'$scope',
		'$http',
		'$log',
		'ngTableParams',
		function($scope, $http, $log, ngTableParams) {

			$scope.phoneNo = "9876543210";
			$scope.ORDERNUMBER = {};
			$scope.count = "0";
			$scope.validateNumber = function() {

				var phonenoTen = /^\d{10}$/;
				var phonenoSeven = /^\d{7}$/;
				if ($scope.phoneNo!=undefined &&(($scope.phoneNo.match(phonenoTen))
						|| ($scope.phoneNo.match(phonenoSeven)))) {

					// getAllMapping
					var restURL = '/getAllMapping?phoneNumber='
							+ $scope.phoneNo;
					//console.log($scope.phoneNo);

					// $.ajax(
					// {
					// type : "GET",
					// url : restURL + '?phoneNumber='+$scope.phoneNo,
					// dataType : "text",
					// contentType : "application/json; charset=utf-8",
					// data :'',
					// async : false,
					// success: function(data) {
					// console.log(data);
					// $scope.ORDERNUMBER = data.data;
					// $log.debug("order number:", $scope.ORDERNUMBER);
					// }
					// });
					$http.get(restURL).then(
							function(response) {
								$scope.ORDERNUMBER = response.data;
								if ($scope.ORDERNUMBER != null
										|| $scope.ORDERNUMBER != undefined) {
									$scope.count = $scope.ORDERNUMBER.count;
									var data = $scope.ORDERNUMBER.output;
									if (data.length > 0 && data != null) {
										$scope.showData = true;
									}
									$scope.tableParams = new ngTableParams({
										page : 1,
										count : 25
									}, {
										counts : [],
										total : 1,
										getData : function($defer, params) {
											var orderedData = data;
											$scope.page = orderedData.slice(
													(params.page() - 1)
															* params.count(),
													params.page()
															* params.count());
											params.total(orderedData.length); // set
																				// total
																				// for
																				// recalc
																				// pagination
											$defer.resolve($scope.page);
										}
									});
								}
							});
				}// end Phone number validation
				else {
					alert("Enter Valid Phone number");
					return false;
				}
			};

			$scope.itemsByPage = 10;

		} ]);