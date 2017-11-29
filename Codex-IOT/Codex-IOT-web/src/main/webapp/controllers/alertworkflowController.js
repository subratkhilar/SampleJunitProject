app.controller("AlertWorkflowCtrls",function($scope,$rootScope,$http,$window)
		{   
	$scope.projects = [];
	$rootScope.sensors= [];
	$rootScope.assets= [];
	$scope.nottficationTypes=["email","Phone","Web"];
	$scope.notifications= [
		{notificationID: 1, notificationName: 'Push Notification'}

		];

	$scope.hideProject=false;
	$scope.hideSensor=false;
	$scope.hideAsset=false;
	$scope.hideNotification=false;
	$scope.hideDiamond=false;
	$scope.error=false;
	$scope.errorAsset=false;
	$scope.hideNotificationValue=false;
	$scope.errorSensor=false;
	$scope.hideEnd=false;
	$scope.showHelp=true;
	$scope.count=1;
	/*Current customer ID */
	var rollID=$window.localStorage.getItem("RollId");
	var userID=$window.localStorage.getItem("userID");
	/*Current customer ID */
	var cstId=$window.localStorage.getItem("customerId");
	$scope.disableSave=false;

	/*Get all projects related to current customer*/
	
	if(rollID==2){
		$http.get("http://codex-iot.apps.eu01.cf.canopy-cloud.com/projectusermap/getProjectbyUser/"+userID)
		.then(function(response) 
				{
			var data1=response.data;
			for(var i in data1){

				$scope.projectIDs=data1[i].projectId;
				$scope.projectName=data1[i].projectName;
				$scope.projects.push({projectIDAlert: $scope.projectIDs,projectName:$scope.projectName})


			}
				});

		
	}
	else{
	$http.get("http://codex-iot.apps.eu01.cf.canopy-cloud.com/project/getbycustomer/"+cstId)
	.then(function(response) 
			{
		var data1=response.data;
		for(var i in data1){

			$scope.projectIDs=data1[i].projectId;
			$scope.projectName=data1[i].projectName;
			$scope.projects.push({projectIDAlert: $scope.projectIDs,projectName:$scope.projectName})


		}
			});
	}

	
	/*Function for arrow in help box*/
	$scope.helpMessage="Click on arrow in the box or Arrow in the workflow to  move to the next step.";
	$scope.helpArrow=function(){
		if($scope.count==1){
			$scope.helpMessage=" Select project to proceed, Next step will be selection of asset.";
			$scope.hideProject=true;
			$scope.count=2;
		}
		else if($scope.count==2){
			if($scope.projectIDAlert==null){
				$scope.showError=true;
				$scope.errorMessage="Please select Project."
				$scope.hideAsset=false;
				$scope.count=2;
			}
			else{
				$scope.helpMessage="Select asset to proceed, Next step will be selection of sensor.";
				$scope.hideAsset=true;
				$scope.showError=false;
				$scope.count=3;

			}

		}
		else	if($scope.count==3){

			if($scope.assetIDAlert==null){
				$scope.showError=true;
				$scope.errorMessage="Please select Asset."

				$scope.hideSensor=false;
				$scope.count=3;
			}
			
			else{
				$scope.helpMessage="Select Sensor to proceed, Next step will be selection of Minimum  and Maximum threshold value. ";
				$scope.hideSensor=true;
				$scope.showError=false;
				$scope.count=4;

			}
		}
		else	if($scope.count==4){
			if($scope.sensorIDAlert==null){
				$scope.showError=true;
				$scope.errorMessage="Please select Sensor."

				$scope.hideDiamond=false;
				$scope.count=4;
			}
			else{
				$scope.helpMessage="Select Minimum and Maximum Threshold value to proceed, Next step will be selection of No.of occurences.";
				$scope.hideDiamond=true;
				$scope.showError=false;
				$scope.count=5;
			}
		}

		else if($scope.count==5){
			if($scope.tempMaxAlert==null || $scope.tempMinAlert==null){
				$scope.hideNotification=false;
				$scope.showError=true;
				$scope.errorMessage="Please select Maximum and Minimum threshold limit."

				$scope.count=5;



			}
			else if( $scope.tempMinAlert>=$scope.tempMaxAlert)
			{

				$scope.showError=true;
				$scope.errorMessage="Maximum Threshold limt should be greater than minimum."
			}

			else{
				$scope.helpMessage="Select Number of occurences to proceed, Next step will selection of Notification type.";

				$scope.hideNotification=true;
				$scope.showError=false;
				$scope.count=6;

			}
		}
		else if($scope.count==6){
			if($scope.noofOccAlert==null){
				$scope.hideNotificationValue=false;
				$scope.showError=true;
				$scope.errorMessage="Please select Number of occurrences."

				$scope.count=6;

			}
			else{
				$scope.helpMessage="Select Notification Type to Finish the workflow.";

				$scope.hideNotificationValue=true;
				$scope.showError=false;
				$scope.count=7;


			}	

		}

		else if($scope.count==7){
			if($scope.notificationTypeAlert==null){
				$scope.hideEnd=false;
				$scope.showError=true;
				$scope.errorMessage="Please select Notification type."

				$scope.count=7;

			}
			else{
				$scope.helpMessage="You have completed the workflow !";

				$scope.showError=false;
				$scope.hideEnd=true;
				$scope.count=8;
			}
		}

	}
/*Toggle Help message box*/
	$scope.toggleHelp=function(){
		$scope.showHelp=!$scope.showHelp;

	}
	
	/*Showing Project process*/
	$scope.toggeleProjectProcess=function(){
		$scope.hideProject=true;
		$scope.count=2;
		$scope.helpMessage="Select project to proceed, Next step will be selection of asset. ";
	}
	/*Showing Asset process*/
	$scope.toggeleAssetProcess=function(){

		if($scope.projectIDAlert==null){
			$scope.showError=true;
			$scope.errorMessage="Please select Project."

		//	$scope.hideAsset=false;
			$scope.count=2;
		}
		else{
			$scope.helpMessage="Select asset to proceed, Next step will be selection of sensor.";
			$scope.hideAsset=true;
			$scope.showError=false;
			$scope.count=3;

		}
	}
	/*Showing Sensor process*/
	$scope.toggleSensorProcess=function(){
		if($scope.assetIDAlert==null){
			$scope.showError=true;
			$scope.errorMessage="Please select Asset."

			//$scope.hideSensor=false;
			$scope.count=3;
		}
		else{
			$scope.helpMessage="Select Sensor to proceed, Next step will be selection of Minimum and Maximum threshold value.";

			$scope.hideSensor=true;
			$scope.showError=false;
			$scope.count= 4;

		}
	}
	/*Showing Process for Min and max threshold*/

	$scope.toggleDiamond=function(){
		if($scope.sensorIDAlert==null){
			$scope.showError=true;
			$scope.errorMessage="Please select Sensor."

		//	$scope.hideDiamond=false;
			$scope.count=4;

		}
		else{
			$scope.helpMessage="Select Minimum and Maximum threshold to proceed, Next step will be selction of number of occurences. ";

			$scope.hideDiamond=true;
			$scope.showError=false;
			$scope.count=5;

		}
		//}
	}
	/*Showing Process for Number of occurences */


	$scope.toggleNotification=function(){
		if($scope.tempMaxAlert==null || $scope.tempMinAlert==null )
			
				{
				
		//	$scope.hideNotification=false;
			$scope.showError=true;
			$scope.errorMessage="Please select Minimum and Maximum threshold limit."

			$scope.count=5;


				}
		else if( $scope.tempMinAlert>=$scope.tempMaxAlert)
					{
			$scope.showError=true;
			$scope.errorMessage="Maximum Threshold limt should be greater than minimum."
					}

		
		else{
			$scope.helpMessage="Select Number of occurences to proceed, Next step will selection of Notification type.";

			$scope.hideNotification=true;
			$scope.showError=false;
			$scope.count=6;

		}
	}


	/* show notification value*/
	$scope.toggleNotificationValue=function(){
		if($scope.noofOccAlert==null){
		//	$scope.hideNotificationValue=false;
			$scope.showError=true;
			$scope.errorMessage="Please select Number of occurrences."
				$scope.count=6;

		}
		else{
			$scope.helpMessage="Select Notification Type to finish the workflow.";

			$scope.hideNotificationValue=true;
			$scope.showError=false;
			$scope.count=7;


		}	
	}
	/*Show End process*/

	$scope.toggleEnd=function(){
		if($scope.notificationTypeAlert==null){
		//	$scope.hideEnd=false;
			$scope.showError=true;
			$scope.errorMessage="Please select Notification Type."

			$scope.count=7;

		}
		else{
			$scope.helpMessage="You have completed the workflow !";

			$scope.showError=false;
			$scope.hideEnd=true;
			$scope.count=8;
		}}

	/* Changing Assets as per change in project name*/
	$scope.onAssetChange=function(){
		if($scope.projectIDAlert==null){
			$scope.showError=true;
			$scope.errorMessage="Please select Project."

		}else{
			$scope.showError=false;

			$rootScope.assets=[];
			$http.get("http://codex-iot.apps.eu01.cf.canopy-cloud.com/Asset/getAssetbyprojId/"+$scope.projectIDAlert).then(function(response){
				var assetData=response.data;
				for(var i in assetData){
					$scope.assetIds=assetData[i].assetId;
					$scope.assetNames=assetData[i].assetName;
					$rootScope.assets.push({assetIDAlert: $scope.assetIds,assetName:$scope.assetNames})


				}});
		}}
	/* Changing Sensors as per change in project name*/

	$scope.onSensorChange=function(){
		if($scope.assetIDAlert==null){
			$scope.showError=true;
			$scope.errorMessage="Please select Asset."

		}
		else{
			$scope.showError=false;
			$scope.sensors=[];
			$rootScope.selectedAssetName=$scope.assetIDAlert;
			$http.get("http://codex-iot.apps.eu01.cf.canopy-cloud.com/service_crud_workflow/getSensorsForWorkflowByAssetID/"+$scope.assetIDAlert+"/Alert").then(function(response){
				var sensorData=response.data;
				for(var i in sensorData){
					$scope.sensorIds=sensorData[i].sensorId;
					$scope.sensorNames=sensorData[i].sensorsName;
					$scope.sensors.push({sensorIDAlert:$scope.sensorIds,sensorName:$scope.sensorNames})


				}});
		}
		


	}
	
	$scope.onChange=function(){
		if($scope.sensorIDAlert==null){
			$scope.showError=true;
			$scope.errorMessage="Please select Sensor."

			
		}
		else{
			$scope.showError=false;

		}
	}

	
/* Saving all information and sensing it to server side api*/
	$scope.getAllInformationAlerts=function(){
		 var mybody = angular.element(document).find('button');
		 mybody.addClass('waiting');
		var dataObjalert={
				active: true,
				assetId: $scope.assetIDAlert,
				createdDate: "2017-09-19T05:40:09.143Z",
				customerId:cstId,
				eventType: "Alert",
				lowerLimit:$scope.tempMinAlert,
				meadiaType: "push notification",
				mediaValue: "Push notification",
				noOfOccurrences:$scope.noofOccAlert,
				projectId: $scope.projectIDAlert,
				sensorId:$scope.sensorIDAlert,
				updatedDate: "2017-09-19T05:40:09.143Z",
				upperLimit:$scope.tempMaxAlert,
				userId: userID
		}
		var myJSON=angular.toJson(dataObjalert);
		$http(
				{
					method : 'POST',
					url : 'http://codex-iot.apps.eu01.cf.canopy-cloud.com/service_crud_workflow/saveWorkflowData',

					data : myJSON,

					headers : {
						'Content-Type' : 'application/json;charset=utf-8',
						'Accept' : 'application/json;charset=utf-8'
					}
				}).success(
						function(dataObjalert, status, headers, config) {
							$scope.PostDataResponse = dataObjalert;
							$('#myModal').modal('hide'); 
						     mybody.removeClass('waiting');
							$('#centralModalSuccess_for_add').modal('show');  
						
							}).error(function() {


						});}
		});