app.controller("WorkflowCtrls",function($scope,$rootScope,$http,$window)
		{  
	$scope.projectsNotification = [] ;
	$scope.sensorsNotification = [];
	$scope.assetsNotification = [];
	$scope.nottficationTypes=["email","Phone","Web"];
	$scope.notifications= [
	    {notificationID: 1, notificationName: 'Web'},
	    {notificationID: 2, notificationName: 'Push Notification'},
	    {notificationID: 3, notificationName: 'Phone'}
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
	var rollID=$window.localStorage.getItem("RollId");
	var userID=$window.localStorage.getItem("userID");
	var cstId=$window.localStorage.getItem("customerId");
	
	if(rollID==2){
		   $http.get("http://codex-iot.apps.eu01.cf.canopy-cloud.com/projectusermap/getProjectbyUser/"+userID)
	       .then(function(response) 
	       {
	          var projectDetails=response.data;
	      for(var i in projectDetails){
	    	 $scope.projectIDs=projectDetails[i].projectId;
	    	 $scope.projectName=projectDetails[i].projectName;
	    	 $scope.projectsNotification.push({projectID: $scope.projectIDs,projectName:$scope.projectName})
	    	  }
	       });
		   
		
	}
	else{
		
		   $http.get("http://codex-iot.apps.eu01.cf.canopy-cloud.com/project/getbycustomer/"+cstId)
	       .then(function(response) 
	       {
	          var projectDetails=response.data;
	      for(var i in projectDetails){
	    	 $scope.projectIDs=projectDetails[i].projectId;
	    	 $scope.projectName=projectDetails[i].projectName;
	    	 $scope.projectsNotification.push({projectID: $scope.projectIDs,projectName:$scope.projectName})
	    	  }
	       });
		   
		
	}
	   
	   
	   /*Function for arrow in help box*/
		$scope.helpMessage="Click on arrow in the box OR, Arrow in the workflow to  move to the next step.";
		$scope.helpArrow=function(){
			if($scope.count==1){
				$scope.helpMessage="Select project to proceed, Next step will be selection of asset.";
				$scope.hideProject=true;
				$scope.count=2;
			}
			else if($scope.count==2){
				if($scope.projectID==null){
					$scope.showError=true;
					$scope.errorMessageNotification="Please select project."
					//$scope.hideAsset=false;
					$scope.count=2;
				}
				else{
					$scope.helpMessage="Select Asset to proceed, Next step will be selection of sensor.";
					$scope.hideAsset=true;
					$scope.showError=false;
					$scope.count=3;

				}

			}
			else	if($scope.count==3){

				if($scope.assetID==null){
					$scope.showError=true;
					$scope.errorMessageNotification="Please select asset."

					//$scope.hideSensor=false;
					$scope.count=3;
				}
				else{
					$scope.helpMessage="Select Sensor to proceed, Next step will be selection of Minimum and Maximum threshold value.";
					$scope.hideSensor=true;
					$scope.showError=false;
					$scope.count=4;

				}
			}
			else	if($scope.count==4){
				if($scope.sensorID==null){
					$scope.showError=true;
					$scope.errorMessageNotification="Please select sensor."

					//$scope.hideDiamond=false;
					$scope.count=4;
				}
				else{
					$scope.helpMessage="Select Minimum and Maximum threshold value to proceed, Next step will selection of notification type.";
					$scope.hideDiamond=true;
					$scope.showError=false;
					$scope.count=5;
				}
			}

			else if($scope.count==5){
				if($scope.tempMax==null || $scope.tempMin==null){
					//$scope.hideNotification=false;
					$scope.showError=true;
					$scope.errorMessageNotification="Please select Minimum and Maximum threshold limit."

					$scope.count=5;



				}
				else if( $scope.tempMin>=$scope.tempMax)
				{
						$scope.showError=true;
					$scope.errorMessageNotification="Maximum threshold limit should be greater than Minimum."

				}
				
				else{
					$scope.helpMessage="Select notification type to finish the workflow.";

					$scope.hideNotification=true;
					$scope.showError=false;
					$scope.count=6;

				}
			}
		
			else if($scope.count==6){
				if($scope.notification==null){
					//$scope.hideEnd=false;
					$scope.showError=true;
					$scope.errorMessageNotification="Please select notification type.."

					$scope.count=6;

				}
				else{
					$scope.helpMessage="You have completed the workflow !";

					$scope.showError=false;
					$scope.hideEnd=true;
					$scope.count=7;
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
			$scope.helpMessage="Select project to proceed, Next step will be selection of asset.";
		}
		/*Showing Asset process*/
		$scope.toggeleAssetProcess=function(){

			if($scope.projectID==null){
				$scope.showError=true;
				$scope.errorMessageNotification="Please select project."
				//$scope.hideAsset=false;
				$scope.count=2;
			}
			else{
				$scope.helpMessage="Select Asset to proceed, Next step will be selection of sensor.";
				$scope.hideAsset=true;
				$scope.showError=false;
				$scope.count=3;

			}
		}
		/*Showing Sensor process*/
		$scope.toggleSensorProcess=function(){
			if($scope.assetID==null){
				$scope.showError=true;
				$scope.errorMessageNotification="Please select asset."
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
			if($scope.sensorID==null){
				$scope.showError=true;
				$scope.errorMessageNotification="Please select sensor."
				//$scope.hideDiamond=false;
				$scope.count=4;

			}
			else{
				$scope.helpMessage="Select Minimum and Maximum threshold value to proceed, Next step will selection of notification type.";

				$scope.hideDiamond=true;
				$scope.showError=false;
				$scope.count=5;

			}
			//}
		}
	


		$scope.toggleNotification=function(){
			if($scope.tempMax==null || $scope.tempMin==null){
				//$scope.hideNotification=false;
				$scope.showError=true;
				$scope.errorMessageNotification="Please select Minimum and Maximum threshold limit."
				$scope.count=5;



			}
			else if( $scope.tempMin>=$scope.tempMax)
			{
			$scope.showError=true;
			$scope.errorMessageNotification="Maximum threshold limit should be greater than Minimum";
			}
			else{
				$scope.helpMessage="Select notification type to finish the workflow.";

				$scope.hideNotification=true;
				$scope.showError=false;
				$scope.count=6;

			}
		}

		/*Show End process*/

		$scope.toggleEnd=function(){
			if($scope.notification==null){
				//$scope.hideEnd=false;
				$scope.showError=true;
				$scope.errorMessageNotification="Please select notification type."

				$scope.count=6;

			}
			else{
				$scope.helpMessage="You have completed the workflow !";

				$scope.showError=false;
				$scope.hideEnd=true;
				$scope.count=7;
			}}
		
		
		
$scope.onchangeAsset=function(){
	if($scope.projectID==null){
		$scope.showError=true;
		$scope.errorMessageNotification="Please select project."

		
	}
	 else{
			$scope.showError=false;
		 $scope.assetsNotification=[];
			 $http.get("http://codex-iot.apps.eu01.cf.canopy-cloud.com/Asset/getAssetbyprojId/"+$scope.projectID).then(function(response){
				   var assetData=response.data;
				   for(var i in assetData){
					   $scope.assetIds=assetData[i].assetId;
					   $scope.assetNames=assetData[i].assetName;
					   $scope.assetsNotification.push({assetID: $scope.assetIds,assetName:$scope.assetNames})
						
				   
				   }});
			
			 }
	
}


	$scope.onChangeSensor=function(){
		if($scope.assetID==null ){
				$scope.showError=true;
				$scope.errorMessageNotification="Please select asset."



		}
		else{
			$scope.showError=false;
			$scope.sensorsNotification=[];
		   $http.get("http://codex-iot.apps.eu01.cf.canopy-cloud.com/service_crud_workflow/getSensorsForWorkflowByAssetID/"+$scope.assetID+"/Notification").then(function(response){
			   var sensorData=response.data;
			   for(var i in sensorData){
				   $scope.sensorIds=sensorData[i].sensorId;
				   $scope.sensorNames=sensorData[i].sensorsName;
				   $scope.sensorsNotification.push({sensorID:$scope.sensorIds,sensorName:$scope.sensorNames})
			    }});
			

		
	}}

	$scope.onChanges=function(){
		if($scope.sensorID==null){
			$scope.showError=true;
			$scope.errorMessage="Please select Sensor."

			
		}
		else{
			$scope.showError=false;

		}
	}



	$scope.reloadPage = function() {
		   $window.location.reload();
		}

	
	$scope.getAllInformationNotification=function(){
		
		 var mybody = angular.element(document).find('button');
		 console.log(userID+"user id in save  function");

		 mybody.addClass('waiting');
	var dataObjNotification={
				
				  active: true,
				  assetId: $scope.assetID,
				  createdDate: "2017-09-19T05:40:09.143Z",
				  customerId:cstId,
				  eventType: "Notification",
				 lowerLimit:$scope.tempMin,
				  meadiaType: $scope.notification,
				  mediaValue: "Push notification",
				  noOfOccurrences:$scope.noofOcc,
				  projectId: $scope.projectID,
				  sensorId:$scope.sensorID,
				  updatedDate: "2017-09-19T05:40:09.143Z",
				  upperLimit:$scope.tempMax,
				  userId: userID
			}

		var myJSONNotification=angular.toJson(dataObjNotification);
	  $http(
            {
                method : 'POST',
                url : 'http://codex-iot.apps.eu01.cf.canopy-cloud.com/service_crud_workflow/saveWorkflowData',
               
                data : myJSONNotification,

                headers : {
                    'Content-Type' : 'application/json;charset=utf-8',
                    'Accept' : 'application/json;charset=utf-8'
                }
            }).success(
            function(dataObjNotification, status, headers, config) {
            
                $scope.PostDataResponse = dataObjNotification;
            	$('#myModal1').modal('hide'); 
			     mybody.removeClass('waiting');

				$('#centralModalSuccess_for_add_Notification').modal('show');  myModal
            }).error(function() {

        
            });}
		});