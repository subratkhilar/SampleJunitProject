app
    .controller(
    'asset_controller',
    function ($scope, $http, $rootScope, $q, $window, Activate_asset_service, Inactivate_asset_service, Edit_asset_service, Get_asset_service,Get_asset_project_admin_service) {

        $rootScope.loc_custmer_id = $window.localStorage.getItem("customerId");
        var rollID = $window.localStorage.getItem("RollId");
        var userID = $window.localStorage.getItem("userID");
        var latest_customer_id = localStorage.getItem("customerId");
        $scope.delete_button_false = function (sensor_data) {

            // console.log("in delete method for table_button"+abc.assetName)
            $rootScope.asset_id_for_delete_false = sensor_data.assetId;
            $rootScope.asset_name_for_delete_false = sensor_data.assetName;
			
			$scope.projectadminflag=false;
 $scope.otheradminflag=false;

            var d = $q.defer();

            Activate_asset_service.active_asset_url($rootScope.asset_id_for_delete_false).then(function (response) {
                d.resolve(response);

            });


        };



        $scope.delete_button = function (asset_data) {
            console.log("in delete  method for modal_button ");

            $rootScope.asset_id_for_delete = asset_data.assetId;
            $rootScope.asset_name_for_delete = asset_data.assetName;

            var d = $q.defer();

            Inactivate_asset_service.inactive_asset_url($rootScope.asset_id_for_delete).then(function (response) {
                d.resolve(response);

            });
           
            

        };


        $scope.edit_button = function (edit) {

            $scope.a = edit;
            $rootScope.asset_edited_description = $scope.a.assetDesc;
            $rootScope.asset_edited_ip_address = $scope.a.assetIpAddress;
            $rootScope.asset_edited_name = $scope.a.assetName;
            $rootScope.asset_edited_protocol = $scope.a.assetProtocol;
            $rootScope.asset_edited_serial_number = $scope.a.assetSerialNumber;


        }

        $scope.pass_edited_data = function (a) {
            // use $.param jQuery function to serialize data
            // from JSON
            console.log("after edit");

            var asset_edited_id = document.getElementById("asset_edited_id").value;
            var project_edited_id = document.getElementById("project_edited_id").value;
            var asset_edited_description = document.getElementById("asset_edited_description").value;
            var asset_edited_ip_address = document.getElementById("asset_edited_ip_address").value;
            var asset_edited_name = document.getElementById("asset_edited_name").value;
            var asset_edited_protocol = document.getElementById("asset_edited_protocol").value;
            var asset_edited_serial_number = document.getElementById("asset_edited_serial_number").value;


            // $scope.pid=$rootScope.project_edited_id;

            if (asset_edited_id == '' || project_edited_id == '' || asset_edited_ip_address == '' || asset_edited_name == '' || asset_edited_protocol == '' || asset_edited_serial_number == '') {
                console.log("if condition");
                $scope.formError = "Please fill all the fields";
                $scope.submitFailed = true;

            }

            else if (asset_edited_ip_address.search(/^([0-9]{1,3})[.]([0-9]{1,3})[.]([0-9]{1,3})[.]([0-9]{1,3})$/) == -1) {
                $scope.formError = "Enter Correct IP Address";
                $scope.submitFailed = true;
            }

            else {
                console.log("welocme to edited_pass_data function ur value coming from update button ");

                Edit_asset_service.edit_asset_url(asset_edited_id, asset_edited_ip_address, asset_edited_description, asset_edited_name, asset_edited_protocol, asset_edited_serial_number, project_edited_id).then(function (response) {
                    d.resolve(response);
                });
             

            }



        };



        $scope.pass_data = function (assetId, assetDescription, assetIpAddress, assetName, assetProtocol, assetSerialNumber,
            projectId) {
            // use $.param jQuery function to serialize data
            // from JSON
            console.log("welocme to asset_pass_data function11");
            console.log("ProjectID : " + $scope.projectId);

            if ($scope.assetIpAddress.search(/^([0-9]{1,3})[.]([0-9]{1,3})[.]([0-9]{1,3})[.]([0-9]{1,3})$/) == -1) {
                $scope.addformError = "Enter Correct IP Address";
                $scope.submitFailed = true;
            }
            else {
                var data = {

                    assetDesc: $scope.assetDescription,
                    assetId: $scope.assetId,
                    assetIpAddress: $scope.assetIpAddress,
                    assetName: $scope.assetName,
                    assetProtocol: $scope.assetProtocol,
                    assetSerialNumber: $scope.assetSerialNumber,
                    projectId: $scope.projectId,
                };
                /* console.log(data.assetId);
                 console.log(data.assetName);
                 console.log(data.assetIpAddress);
                 console.log(data.assetDescription);*/
                var myJSON = angular.toJson(data);
                console.log(angular.toJson(data));
                var dataForUserConfig = {
                    assetId: $scope.assetId,
                    userId: userID

                }
                var myJSONForUserConfig = angular.toJson(dataForUserConfig);

                console.log("Asset data save" + myJSONForUserConfig);
                $http(
                    {
                        method: 'POST',
                        /* url : ' http://codex-iot.apps.eu01.cf.canopy-cloud.com/Asset/addAsset',*/
                        url: ' http://codex-iot.apps.eu01.cf.canopy-cloud.com/Asset/addAsset',

                        data: myJSON,

                        headers: {
                            'Content-Type': 'application/json;charset=utf-8',
                            'Accept': 'application/json;charset=utf-8'
                        }
                    }).success(
                    function (data, status, headers, config) {
                        console.log("in add asset");
						$http(
													{
														method: 'POST',
														url: 'http://codex-iot.apps.eu01.cf.canopy-cloud.com/assetusermap/saveAssetmap',

														data: myJSONForUserConfig,

														headers: {
															'Content-Type': 'application/json;charset=utf-8',
															'Accept': 'application/json;charset=utf-8'
														}
													});


                        $scope.PostDataResponse = data;
                        $scope.submitFailed = false;
                        $('#centralModalSm_for_addasset').hide();
                        $('#centralModalSuccess_for_add').modal('show');
                    }).error(function (status) {


                        $scope.addformError = status.error;
                        $scope.submitFailed = true;

                    });
            }

        };


        $scope.asset_detail = function () {

            console.log("asset_detail function");
           

            var d = $q.defer();
			
			
			if(rollID==2)
			{
			    $scope.projectadminflag=true;
				Get_asset_project_admin_service.get_asset_project_admin_url(userID).then(function (response) {
                d.resolve(response);
			});
			}
			else
			{
				$scope.otheradminflag=true;
            Get_asset_service.get_asset_url(latest_customer_id).then(function (response) {
                d.resolve(response);
			
            });
			}

            

          
        };




        $scope.project_detail = function () {

            console.log("asset_detail function is getting project_details");


            /*  $http
                      .post(
                              "http://codex-iot.apps.eu01.cf.canopy-cloud.com/Asset/allasset")
                      .then(function(response) {
                          console.log(response.data);
                      })*/

            if (rollID == 2) {
                var req1 = {
                    method: "GET",
                    url: 'http://codex-iot.apps.eu01.cf.canopy-cloud.com/projectusermap/getProjectbyUser/' + userID,
                    headers: {
                        'Content-Type': "application/json",
                        'Accept': "application/json"
                    },
                    data: ""

                }
                $http(req1).then(function (response) {
                    console.log("in project roll should be 2:::::" + userID);

                    $scope.project_details = response.data;

                    d.resolve(response);
                })

            }
            else {
                var d = $q.defer();
                var req = {
                    method: "GET",
                    url: 'http://codex-iot.apps.eu01.cf.canopy-cloud.com/project/getallbycustomer/' + $rootScope.loc_custmer_id,
                    headers: {
                        'Content-Type': "application/json",
                        'Accept': "application/json"
                    },
                    data: ""
                }


                $http(req).then(function (response) {
                    console.log("in project roll should be 1:::::" + rollID);
                    console.log(response.data);
                    $scope.project_details = response.data;
                    d.resolve(response);
                })


            }

        }



        $scope.refresh_modal = function () {
            //   $window.location.reload();
            document.getElementById("asset_edited_description").value = $rootScope.asset_edited_description;
            document.getElementById("asset_edited_ip_address").value = $rootScope.asset_edited_ip_address;
            document.getElementById("asset_edited_name").value = $rootScope.asset_edited_name;
            document.getElementById("asset_edited_protocol").value = $rootScope.asset_edited_protocol;
            document.getElementById("asset_edited_serial_number").value = $rootScope.asset_edited_serial_number;
            $scope.submitFailed = false;
        }


        $scope.reset_form = function () {
            console.log("welcome to reset form");
            document.getElementById("myForm").reset();
            $scope.submitFailed = false;

        }
        $scope.reloadPage = function () {
            $window.location.reload();

        }

    });