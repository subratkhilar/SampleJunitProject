app.controller("uigridCtrl", function ($scope,$rootScope,$window,$http) {


	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth()+1; //January is 0!

	var yyyy = today.getFullYear();
	if(dd<10){
		dd='0'+dd;
	} 
	if(mm<10){
		mm='0'+mm;
	} 
	var todays = dd+'/'+mm+'/'+yyyy;
	var cstId=$window.localStorage.getItem("customerId");
	var userId=$window.localStorage.getItem("userID");
	$http.get("http://codex-iot.apps.eu01.cf.canopy-cloud.com/service_crud_workflow/getWorkflowByUserID/"+userId).then(function(response){
		$rootScope.WorkflowDetails=response.data;
		});
	
	$scope.currentDate=todays;
	$rootScope.Workflows = [];
	


	
	$scope.edit_button=function(edit){
		$rootScope.workFLowIdforEdit=edit.workflowId;
		$rootScope.editMaxTemp=edit.upperLimit;
		$rootScope.editMinTemp=edit.lowerLimit;
		$rootScope.editNo=edit.noOfOccurrences;
				$rootScope.editStatus=edit.active;

			$http.get("http://codex-iot.apps.eu01.cf.canopy-cloud.com/project/getbyid/"+edit.projectId).then(function(response){
			var editProject=response.data;
			$rootScope.projectForEdit=editProject.projectName;
			
		});
		$http.get("http://codex-iot.apps.eu01.cf.canopy-cloud.com/Asset/getAssetbyId/"+edit.assetId).then(function(response){
			var editAsset=response.data.data;
			$rootScope.assetForEdit=editAsset.assetName;

			
		});
		$http.get("http://codex-iot.apps.eu01.cf.canopy-cloud.com/sensor/getbyid/"+edit.sensorId).then(function(response){
			var editsensor=response.data;
			$rootScope.sensorForEdit=editsensor.sensorsName;

			
		});
		
		

		
	}
	
	$scope.delete_button=function(deleteW){
		$rootScope.toggleDelete=deleteW.active;
		$rootScope.workflowIdforDelete=deleteW.workflowId;
		
	}
	
$scope.deleteWorkflow=function(){
	if($rootScope.toggleDelete==true){
		$scope.status=false;
		$scope.message="Workflow Deactivated Successfully"
	}
	else{
		$scope.status=true;
		$scope.message="Workflow Activated Successfully"

	}
		var deleteWorkflowData={
				active:$scope.status,
				workflowId:$rootScope.workflowIdforDelete
			
		}
		
		var myJSONDelete=angular.toJson(deleteWorkflowData);
		$http(
				{
					method : 'POST',
					url : 'http://codex-iot.apps.eu01.cf.canopy-cloud.com/service_crud_workflow/updateWorkflowData',

					data : myJSONDelete,

					headers : {
						'Content-Type' : 'application/json;charset=utf-8',
						'Accept' : 'application/json;charset=utf-8'
					}
				}).success(
						function(deleteWorkflowData, status, headers, config) {
						    $('#centralModalSuccess_for_Delete').modal('show'); 
							$scope.PostDataResponse = deleteWorkflowData;
						}).error(function() {

							
						});
		
		
	}

	$scope.reloadPage = function() {
		   $window.location.reload();
		}

});


