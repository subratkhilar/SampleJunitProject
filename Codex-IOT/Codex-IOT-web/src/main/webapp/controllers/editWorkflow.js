app.controller("EditWorkflowCtrls",function($scope,$rootScope,$http,$window)
		{   
	
	
	var cstId=$window.localStorage.getItem("customerId");
$scope.helpMessage="You can edit Minimum and Maximum threshold value."
	$scope.helpMessageAlert="You can edit Minimum , Maximum threshold value and Number of occurences."
		
		
	$scope.editWorkflow=function(){
	
if($scope.tempMinEdit>=$scope.tempMaxEdit ){
		
		$scope.showErrorEdit=true;
		$scope.editErrorMessage="Maximum threshold limit should be greater than Minimum."
	}
	else{
		$scope.showErrorEdit=false;

    var mybody = angular.element(document).find('button');

    mybody.addClass('waiting');
		var editedData={
				
							
				assetId: $scope.assetIDEdit,
				createdDate: "2017-09-19T05:40:09.143Z",
				customerId:cstId,
				active:$rootScope.editStatus,
				lowerLimit:$scope.tempMinEdit,
				meadiaType: "push notification",
				mediaValue: "Push notification",
				noOfOccurrences:$scope.noofOccEdit,
				projectId: $scope.projectIDEdit,
				sensorId:$scope.sensorIDEdit,
				updatedDate: "2017-09-19T05:40:09.143Z",
				upperLimit:$scope.tempMaxEdit,
				workflowId:$rootScope.workFLowIdforEdit,
				userId: 220
				
		}
		var myJSONEdit=angular.toJson(editedData);
		$http(
				{
					method : 'POST',
					url : 'http://codex-iot.apps.eu01.cf.canopy-cloud.com/service_crud_workflow/updateWorkflowData',

					data : myJSONEdit,

					headers : {
						'Content-Type' : 'application/json;charset=utf-8',
						'Accept' : 'application/json;charset=utf-8'
					}
				}).success(
						function(editedData, status, headers, config) {
					          mybody.removeClass('waiting');
							$('#myModalEdit').modal('hide'); 
							$('#myModalEditNotificationWorkflow').modal('hide'); 

						    $('#centralModalSuccess_for_Edit').modal('show'); 

							$scope.PostDataResponse = editedData;
						}).error(function() {
							console.log("update going into error");
						});
								
		
	}
		
	}
	
		});