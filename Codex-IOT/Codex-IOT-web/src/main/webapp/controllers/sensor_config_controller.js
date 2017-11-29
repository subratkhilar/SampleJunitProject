app
    .controller(
    'sensor_controller',
    function ($scope, $http, $q, $rootScope, $window, Activate_sensor_service, Inactivate_sensor_service, Edit_sensor_service, Get_sensor_service ,Get_sensor_project_admin_service) {


        console.log("global variable customerId " + $rootScope.customer_data);
        $rootScope.loc_custmer_id1 = 3;

        $rootScope.loc_custmer_id = $window.localStorage.getItem("customerId");

        console.log(" rootscope value for customer " + $rootScope.loc_custmer_id);
var userID=$window.localStorage.getItem("userID");
 var latest_customer_id=localStorage.getItem("customerId");
  var rollID = $window.localStorage.getItem("RollId");
  
  $scope.projectadminflag=false;
 $scope.otheradminflag=false;




        $scope.asset_detail = function () {

            console.log("asset_detail function is getting project_details");
           // console.log('http://codex-iot.apps.eu01.cf.canopy-cloud.com/Asset/getallassetbycustid/' + $rootScope.loc_custmer_id);

            /*  $http
                      .post(
                              "http://codex-iot.apps.eu01.cf.canopy-cloud.com/Asset/allasset")
                      .then(function(response) {
                          console.log(response.data);
                      })*/

            var d = $q.defer();
            var req = {
                method: "GET",
                url: 'http://codex-iot.apps.eu01.cf.canopy-cloud.com/Asset/getallassetbycustid/' + latest_customer_id,
                headers: {
                    'Accept': "application/json"
                },
                data: ""
            }

            $http(req).then(function (response) {
                // $rootScope.data= response.data;
                console.log(response.data);
                $scope.asset_details = response.data;
                d.resolve(response);
            }, function (error) {
                d.reject(error);
            });

            /* http://codex-iot-api.apps.eu01.cf.canopy-cloud.com/project/get
              http://codex-iot.apps.eu01.cf.canopy-cloud.com/project/get*/
        }



       $scope.delete_button_false = function (sensor_data) {
            console.log("in delete  method for modal_button ");
            $rootScope.sensor_id_for_delete_false = sensor_data.sensorId;
            $rootScope.sensor_name_for_delete_false = sensor_data.sensorsName;
            console.log("sensor id for false status" + $rootScope.sensor_id_for_delete_false);

            var d = $q.defer();
            Activate_sensor_service.active_sensor_url($rootScope.sensor_id_for_delete_false).then(function (response) {
                d.resolve(response);

            });


        };



        $scope.delete_button = function (sensor_data) {
            console.log("in delete  method for modal_button ");
            $rootScope.sensor_id_for_delete = sensor_data.sensorId;
            $rootScope.sensor_name_for_delete = sensor_data.sensorsName;

            var d = $q.defer();
            Inactivate_sensor_service.inactive_sensor_url($rootScope.sensor_id_for_delete).then(function (response) {
                d.resolve(response);

            });

        };




          $scope.edit_button = function (edit) {

            $scope.a = edit;
            $rootScope.sensor_edited_name_c = $scope.a.sensorsName;
            $rootScope.sensor_edited_description_c = $scope.a.sensorDescription;
            $rootScope.sensor_edited_sensor_tag_c = $scope.a.sensorTag;
            $rootScope.sensor_edited_sensorSerialNumber_c = $scope.a.sensorSerialNumber;
            $rootScope.sensor_edited_sensorDatatype_c = $scope.a.sensorDatatype;


        }


        $scope.pass_edited_data = function (a) {
            // use $.param jQuery function to serialize data
            // from JSON

       var sensor_id = document.getElementById("sensor_detail_modal_edit1").value;
       var sensor_name = document.getElementById("sensor_detail_modal_edit2").value;
       var sensor_datatype = document.getElementById("sensor_detail_modal_edit4").value;
       var sensor_description = document.getElementById("sensor_detail_modal_edit3").value;
       var sensor_serialnumber = document.getElementById("sensor_detail_modal_edit5").value;
       var sensor_tag = document.getElementById("sensor_detail_modal_edit6").value;
       var asset_id = document.getElementById("asset_detail_modal_edit9").value;
       
        	
     /*  Edit_sensor_service.edit_sensor_url(sensor_id, sensor_name, sensor_datatype, sensor_description, sensor_serialnumber, sensor_tag,asset_id).then(function (response) {
           d.resolve(response);
       });*/



        	console.log("Edit sensor id "+a.sensorId);

        	if(sensor_id== '' || sensor_name=='' || sensor_datatype=='' || sensor_serialnumber=='' || sensor_tag=='' || asset_id==''){
        		console.log("if sensor edit");
        		$scope.formError = "Please fill all the fields";
                $scope.submitFailed = true;
        	}
        	else{
                Edit_sensor_service.edit_sensor_url(sensor_id, sensor_name, sensor_datatype, sensor_description, sensor_serialnumber, sensor_tag, asset_id).then(function (response) {
                    d.resolve(response);
                });
        }

        };

        $scope.pass_data = function (sensorId, sensorsName,
            sensorDescription, assetId, sensorTag, sensorSerialNumber, sensorUpperlimit, sensorLowerlimit, sensorDatatype) {

            console.log("welocme to pass_data function11");
            var data = {
               
                assetId: $scope.assetId,
                sensorDatatype: $scope.sensorDatatype,
                sensorDescription: $scope.sensorDescription,
                sensorId: $scope.sensorId,
                sensorLowerlimit: 5,
                sensorSerialNumber: $scope.sensorSerialNumber,
                sensorTag: $scope.sensorTag,
                sensorUpperlimit: 10,
                sensorsName: $scope.sensorsName,
                
            };
            console.log(data.sensorName);

            console.log(data.sensorId);
            console.log(data.sensorDescription);
            var myJSON = angular.toJson(data);
            console.log(angular.toJson(data));
			var dataForUserConfig={
            		sensorId : $scope.sensorId,
					userId:userID

			}
			var myJSONForUserConfig=angular.toJson(dataForUserConfig);
            
            console.log("sensor data save" + myJSONForUserConfig);
            $http(
                {
                    method: 'POST',
                   /* url: 'http://codex-iot.apps.eu01.cf.canopy-cloud.com/sensor/save',*/
                
                    url: 'http://codex-iot.apps.eu01.cf.canopy-cloud.com/sensor/save',
                    data: myJSON,

                    headers: {
                        'Content-Type': 'application/json;charset=utf-8',
                        'Accept': 'application/json;charset=utf-8'
                    }
                }).success(
                function (data, status, headers, config) {
					 $http(
							{
								method: 'POST',
								url: ' http://codex-iot.apps.eu01.cf.canopy-cloud.com/sensorusermap/saveSensormap',

								data: myJSONForUserConfig,

								headers: {
									'Content-Type': 'application/json;charset=utf-8',
									'Accept': 'application/json;charset=utf-8'
								}
							});
                    $scope.PostDataResponse = data;
                    $('#centralModalSm_for_addsensor').hide();
                    $('#centralModalSuccess_for_addsensor').modal('show');

                  
                }).error(function (status) {

                	$scope.addformError = status.error;
                    $scope.submitFailed = true;
                    
                });

        };


        $scope.sensor_detail = function () {

            console.log("init sensor function is getting sensor_details");


            var d = $q.defer();
			
			if(rollID==2)
			{
				$scope.projectadminflag=true;
				Get_sensor_project_admin_service.get_sensor_project_admin_url(userID).then(function (response) {
                d.resolve(response);
			});
			}
			else
			{
				$scope.otheradminflag=true;
            Get_sensor_service.get_sensor_url(latest_customer_id).then(function (response) 
			{
                d.resolve(response);
			
            });
			}
        }

       $scope.reset_form = function () {
            document.getElementById("myForm").reset();
            $scope.submitFailed = false;

        }
        $scope.reloadPage = function () {
            $window.location.reload();

        }


        $scope.refresh_page = function () {

            document.getElementById("sensor_detail_modal_edit2").value = $rootScope.sensor_edited_name_c;
            document.getElementById("sensor_detail_modal_edit4").value = $rootScope.sensor_edited_sensorDatatype_c;
            document.getElementById("sensor_detail_modal_edit3").value = $rootScope.sensor_edited_description_c;
            document.getElementById("sensor_detail_modal_edit5").value = $rootScope.sensor_edited_sensorSerialNumber_c;
            document.getElementById("sensor_detail_modal_edit6").value = $rootScope.sensor_edited_sensor_tag_c;
            $scope.submitFailed = false;
        }

    });