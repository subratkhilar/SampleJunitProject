app
.controller(
		'config_controller',
		function ($scope, $http, $q, $rootScope, $window, $location, Activate_project_service, Inactivate_project_service, Edit_project_service, Get_project_service) {

			var userRole=localStorage.getItem("RoleName");
			var latest_customer_id = localStorage.getItem("customerId");
			$rootScope.loc_custmer_id = $window.localStorage.getItem("customer_ID");

		$scope.delete_button_false = function (project_data) {

			console.log("in delete method for table_button" + project_data.projectId)
			//		$rootScope.project_id_for_delete = abc.projectId;

			$rootScope.project_ID_for_delete_false = project_data.projectId;
			$rootScope.project_name_for_delete_false = project_data.projectName;



			var d = $q.defer();



			Activate_project_service.active_project_url($rootScope.project_ID_for_delete_false).then(function(response) {
				d.resolve(response);
				
			});
		
		};


			$scope.customers=[];

			$http.get("http://codex-iot.apps.eu01.cf.canopy-cloud.com/projectusermap/getprojectAdminbycustomer/"+latest_customer_id)
			.then(function(response) 
					{
				var data1=response.data;

				for(var i in data1){
					$scope.customerIDs=data1[i].userId;
					$scope.fname=data1[i].firstname;
					$scope.lname=data1[i].lastname;
					$scope.customerNames=$scope.fname+" "+$scope.lname;
					$scope.customers.push({customerID: $scope.customerIDs,customerName:$scope.customerNames})
					console.log("customer details"+$scope.customerIDs);

				}
					});



		$scope.delete_button = function (project_data) {

			$rootScope.project_id_for_delete = project_data.projectId;
			$rootScope.project_name_for_delete_true = project_data.projectName;

			var d = $q.defer();

			Inactivate_project_service.inactive_project_url($rootScope.project_id_for_delete).then(function (response) {
				d.resolve(response);

			});
			
		};


				$scope.edit_button = function (edit) {
			$scope.a = edit;
			console.log($scope.customerIDEdit + "Project id selected");
			$http.get("http://codex-iot.apps.eu01.cf.canopy-cloud.com/projectusermap/getUserbyProject/" + $scope.a.projectId)
				.then(function (response) {

					var userData = response.data;
					for (var i in userData) {
						$scope.fnameEdit = userData[i].firstname;
						$scope.lnameEdit = userData[i].lastname;
						$scope.userNameEdit = $scope.fnameEdit + " " + $scope.lnameEdit;
						console.log("username Selected for edit" + $scope.userNameEdit);

					}
				})

			$rootScope.project_name_for_delete = $scope.a.projectName;

			$rootScope.project_name_for_c_form = $scope.a.projectLocation;

			$rootScope.project_desc_for_c_form = $scope.a.projectDescription;
			$rootScope.project_longi_for_c_form = $scope.a.longitude;
			$rootScope.project_longi_for_c_form = $scope.a.longitude;
			$rootScope.project_lati_for_c_form = $scope.a.latitude;




		}
			$scope.onChangeProjectAdmin=function(){
				console.log("in on change project admin"+"customer id edit:"+$scope.customerIDEdit);
				for(var i in $scope.customers){
					if($scope.customers[i].customerID==$scope.customerIDEdit){
					$scope.userNameEdit=$scope.customers[i].customerName;
					console.log("value shoul dset to"+$scope.customerNames);
					}
				}
				
			}


			console.log("selected user id ---------"+$scope.userId);


			$scope.pass_edited_data = function (a) {
				// use $.param jQuery function to serialize data
				// from JSON
				console.log("inside edited function");

				var project_id = document.getElementById("project_detail_modal_edit1").value;
				var project_name = document.getElementById("project_detail_modal_edit2").value;
				var project_location = document.getElementById("project_detail_modal_edit3").value;
				var project_desc = document.getElementById("project_detail_modal_edit4").value;
				var latitude1 = document.getElementById("project_detail_modal_edit6").value;
				var longitude1 = document.getElementById("project_detail_modal_edit5").value;
				var user_id_Edit=$scope.customerIDEdit;



				/*Edit_project_service.edit_project_url(project_id, project_name, project_location, project_desc, latitude1, longitude1, latest_customer_id).then(function(response) {
					d.resolve(response);
				});*/



				

				if (project_id == '' || project_name == '' || project_location == ''  || latitude1 == '' || longitude1 == '') {
					console.log("if condition");
					$scope.formError = "Please fill all the fields";
					$scope.submitFailed = true;
				}
				else if (project_location.search(/^([a-zA-Z]{1,30})$/) == -1) {
					$scope.formError = "Enter Correct Location";
					$scope.submitFailed = true;
				}
				else if (latitude1.search(/^-?([0-9]{1,4})[.]([0-9]{1,5})$/) == -1) {
					$scope.formError = "Enter Correct Latitude";
					$scope.submitFailed = true;
				}

				else if (longitude1.search(/^-?([0-9]{1,4})[.]([0-9]{1,5})$/) == -1) {
					$scope.formError = "Enter Correct Longitude";
					$scope.submitFailed = true;
				}

				else {


					Edit_project_service.edit_project_url(project_id, project_name, project_location, project_desc, latitude1, longitude1, latest_customer_id).then(function (response) {
						d.resolve(response);
					});

					$scope.pid = $rootScope.project_edited_id;

					console.log("welocme to edited_pass_data function ur value coming from update button " + project_id);
					
					var editProjectAdminData={
							projectId:project_id,
							userId:$scope.customerIDEdit 
					}
					console.log("editProjectAdminData"+editProjectAdminData.projectId+editProjectAdminData.userId);
					var myJSONEdit=angular.toJson(editProjectAdminData);
					var myJSON = angular.toJson(data);
					$http(
							{
								
							}).success(
									function (data, status, headers, config) {
										$scope.submitFailed = false;
										$scope.PostDataResponse = data;
										$http(
												{
													method: 'PUT',
													url: 'http://codex-iot.apps.eu01.cf.canopy-cloud.com/projectusermap/updateProjectMap',
													data: myJSONEdit,

													headers: {
														'Content-Type': 'application/json;charset=utf-8',
														'Accept': 'application/json;charset=utf-8'
													}
												})
	
									}).error(function () {
									

									});
				}
			};



			$scope.pass_data = function (projectName, projectLocation, projectId,
					projectDescription, latitude, longitude) {
				// use $.param jQuery function to serialize data
				// from JSON
				$rootScope.projectForUserMap=$scope.projectId;

				/*Add_project_service.add_project_url(projectName, projectLocation, projectId,projectDescription, latitude, longitude, latest_customer_id).then(function (response) {
					d.resolve(response);
				});*/
				console.log("welocme to pass_data project");
				console.log("selected user id ---------"+$scope.customerID);
				
				if ($scope.projectLocation.search(/^([a-zA-Z]{1,30})$/) == -1) {
					$scope.addformError = "Enter Correct Location";
					$scope.submitFailed = true;
				}

				else if ($scope.latitude.search(/^-?([0-9]{1,4})[.]([0-9]{1,4})$/) == -1) {
					$scope.addformError = "Enter Correct Latitude";
					$scope.submitFailed = true;
				}
				else if ($scope.longitude.search(/^-?([0-9]{1,4})[.]([0-9]{1,4})$/) == -1) {
					$scope.addformError = "Enter Correct Longitude";
					$scope.submitFailed = true;
				}
				else {
					var data = {
							projectName: $scope.projectName,
							projectLocation: $scope.projectLocation,
							projectId: $scope.projectId,
							projectDescription: $scope.projectDescription,
							longitude: $scope.longitude,
							latitude: $scope.latitude,
							customerId: latest_customer_id
					};
					var dataForUserConfig={
							projectId: $rootScope.projectForUserMap,
							userId:$scope.customerID

					}
					var myJSONForUserConfig=angular.toJson(dataForUserConfig);



					var myJSON = angular.toJson(data);
					//console.log(angular.toJson(data));
					$http(
							{
								method: 'POST',
								url: ' http://codex-iot.apps.eu01.cf.canopy-cloud.com/project/save',

								data: myJSON,

								headers: {
									'Content-Type': 'application/json;charset=utf-8',
									'Accept': 'application/json;charset=utf-8'
								}
							}).success(
									function (data, status, headers, config) {
										console.log("project id in success"+$scope.projectId);

										$http(
												{
													method: 'POST',
													url: ' http://codex-iot.apps.eu01.cf.canopy-cloud.com/projectusermap/saveprojmap',

													data: myJSONForUserConfig,

													headers: {
														'Content-Type': 'application/json;charset=utf-8',
														'Accept': 'application/json;charset=utf-8'
													}
												});
										$scope.PostDataResponse = data;
										$scope.submitFailed = false;
										$('#centralModalSm_for_addProject').hide();
										$('#centralModalSuccess_for_add').modal('show');
									}).error(function (status) {

										$scope.addformError = status.error;
										$scope.submitFailed = true;

									});


				}

			};




			$scope.initProjects = function () {


				console.log("User Role:"+userRole);


				var d = $q.defer();

				Get_project_service.get_project_url(latest_customer_id).then(function (response) {
					d.resolve(response);

				});

				
			
			}

			$scope.reset_form = function () {

			console.log("welcome to reset form");
			document.getElementById("myForm").reset();
			$scope.submitFailed = false;
			

		}
		$scope.reloadPage = function () {
			$window.location.reload();

		}



		$scope.reloadPage1 = function () {
			console.log("Your C _form value" + $rootScope.project_name_for_delete);
			document.getElementById("project_detail_modal_edit2").value = $rootScope.project_name_for_delete;
			document.getElementById("project_detail_modal_edit3").value = $rootScope.project_name_for_c_form;
			document.getElementById("project_detail_modal_edit4").value = $rootScope.project_desc_for_c_form;
			document.getElementById("project_detail_modal_edit6").value = $rootScope.project_lati_for_c_form;
			document.getElementById("project_detail_modal_edit5").value = $rootScope.project_longi_for_c_form;
			$scope.submitFailed = false;
			
		}

		});