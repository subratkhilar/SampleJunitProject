app.controller('mapController', function($scope,$window,$q,Eventservice,GetAllProjectservice,GetAllAssetByProjservice,GetAllSensorByAssetservice,CountProjectservice,CountAssetservice,CountSensorservice,GetAllProjectLocationByCustIdservice,GetProjectDetailsByProjectIdservice,$http,$rootScope) 
{
  
       
       
	
	$scope.flag=true;
	$scope.pflag=true;
	$scope.sflag=true;
	
	
	var cstId=$window.localStorage.getItem("customerId");
		var rollID=$window.localStorage.getItem("RollId");
	var userID=$window.localStorage.getItem("userID");
       var map;
	   $scope.projectData=[];
	   $scope.assetData=[];
	   $scope.sensorData=[];
	
     
	  
	   $scope.chk=[];
	   

  
  
  

  $rootScope.alertCount=0;
   $scope.event= function() {
		     var d = $q.defer();
       
       Eventservice.eventUrl(cstId).then(function(response) {
		     $rootScope.alertCount=response.data.length;
		   var count=0;
		    $scope.chk=[];
           
           $scope.alertData=response.data;
           for(var i=0;i<response.data.length;i++)
		   {
			   if(response.data[i].eventtype=='Alert')
			   {
				$scope.chk.push(response.data[i].eventdesc);   
				count++;
			   }
			   if(count==4){
				   break;
			   }
		   }
		   
		   
		   
           d.resolve(response);
       }) 
		   
	   } 
	   
	   
	   
	   
	   // Alert Api Hitting after 15 secconds
	    setInterval(function () {$scope.event();},10000); 
  
  
	    //Project Details as per customer id
  
  		var d = $q.defer();
		GetAllProjectservice.allprojecturl(cstId).then(function(response) {
			$scope.projectData=response.data;

			d.resolve(response);
		})
  
  
       // get Assets by customer Id
	   
	   $scope.initAssets= function(projectId) 
	   {
			
			$scope.proId=projectId;
		   var assetId;
		   var d = $q.defer();
      
		   $scope.sflag=true;
       GetAllAssetByProjservice.allasseturl(projectId).then(function(response)
    		   {
				   $scope.flag=true;
				   $scope.sflag=true;
				   
    	  
    	   
            
           
           $scope.assetData=response.data;
           
           $scope.assetData.createdDate;
		   for(var i=0;i<response.data.length;i++){
			   
		   if(i==0)
		   {
			    
				assetId= response.data[i].assetId;
				
				$scope.initSensors(response.data[i].assetId);
		        $scope.setSelectedAsset(response.data[i].assetId);
		  
           }
		   }
		   d.resolve(response);
       }, function(error) 
       {
           $scope.assetData=0;
    	  $scope.sensorData=0;
           $scope.sflag=false;
           $scope.flag=false;
           var asseterrormsg=error.data;
           
           $scope.initSensors(assetId);
          
       })
		   
	   }
	   
       
       
         // get Sensor by Asset Id	
		
		 $scope.initSensors= function(assetId) 
		 {
			 $scope.assetId=assetId;
			   var d = $q.defer();
			   
			GetAllSensorByAssetservice.allsensorurl(assetId).then(function(response) {
            
            $scope.sensorData=response.data;
			if($scope.sensorData.length == 0)
            {
                  $scope.sflag=false;
                  
            }

            else
            {
              $scope.sflag=true;
            }
            
          //  d.resolve(response);
        }, function(error) {
			$scope.sensorData=0;
        	 $scope.sflag=false;
        });
		return d.promise;
		
		
		
		 }
		 
      
        
         // total count of project by custId
       var d = $q.defer();
       
       

       CountProjectservice.countprojecturl(cstId).then(function(response) {
            $scope.total_no_of_project=response.data;
           
           d.resolve(response);
       })
       
       var d = $q.defer();
     

       CountAssetservice.countasseturl(cstId).then(function(response) {
           
           
           $scope.total_no_of_assets=response.data;
           
           d.resolve(response);
       })
       
       var d = $q.defer();
      
       

       CountSensorservice.countsensorurl(cstId).then(function(response) {
           
           
           $scope.total_no_of_sensor=response.data;
          
           d.resolve(response);
       })
       
	   
	   $scope.initiateProject = function(project) 
	   {
		   $scope.ProjectDetails=
		   {
				   projId:project.projectId,
				   ProjName:project.projectName,
				   ProjLocation:project.projectLocation,
				   gateways:project.noOfAssets,
				   totalSensors:project.noOfSensors,
				   projDesc:project.projectDescription
			 };
		   
	   }

				
				
 $scope.projectInitByProjectList=function(data)
 {
	       
            var d = $q.defer();
	        /*var req = {
	             method: "GET",
	             url: 'http://codex-iot.apps.eu01.cf.canopy-cloud.com/project/getallbycustomer/'+data.projectId,
	             url: 'http://codex-iot.apps.eu01.cf.canopy-cloud.com/project/getProjectDetails/'+data.x.projectId,
	             headers: { 'Content-Type': "application/json",
	                'Accept': "application/json"},
	             data: ""
	            }*/

	        GetProjectDetailsByProjectIdservice.projectdetailsurl(data.x.projectId).then(function(response) {
	            
	           
	        	
	        	
	            d.resolve(response);
	            $scope.initiateProject(response.data);

	              }, function(error) {
	            d.reject(error);
	        }); 
}
				
				
	$scope.initiateMap = function() { 
   $scope.projectData=[];
	   $scope.assetData=[];
	   $scope.sensorData=[];
  
	
			var d = $q.defer();
			

			GetAllProjectLocationByCustIdservice.projectlocationurl(cstId).then(function(response) {

				d.resolve(response);
				
				mapData=response.data;
				
				for(var i=0;i<response.data.length;i++)
				{

					$scope.createMarker(response.data[i],mymap);
					if(i==0){
						$scope.firstProjectDetails(response.data[i].projectId);


						$scope.initAssets(response.data[i].projectId);
						$scope.setSelectedProject(response.data[i].projectId);	
					}
				}

			}, function(error) {
				d.reject(error);
			}); 

		
	}

	




	
	   $scope.createMarker=function(data,mymap){
		   
		   
		  
	         	        
	        if(data.active)
			{
				  var pulsingIcon = L.icon.pulse({iconSize:[10,10],color:'green'});
	          var marker = L.marker([data.latitude, data.longitude],{icon: pulsingIcon
	        	  }).addTo(mymap).on('click',function(){
	              
	            

	              

	               var d = $q.defer();
	     /*   var req = {
	             method: "GET",
	             url: 'http://codex-iot.apps.eu01.cf.canopy-cloud.com/project/getallbycustomer/'+data.projectId,
	             url: 'http://codex-iot.apps.eu01.cf.canopy-cloud.com/project/getProjectDetails/'+data.projectId,
	             headers: { 'Content-Type': "application/json",
	                'Accept': "application/json"},
	             data: ""
	            }*/

	        GetProjectDetailsByProjectIdservice.projectdetailsurl(data.projectId).then(function(response) {
	            
	           
	            d.resolve(response);
	            $scope.initiateProject(response.data);

	              }, function(error) {
	            d.reject(error);
	        }); 




	            }).on('mouseover',function(){

	          
	                

	            });
	            
	            
			}
	            else
				{
				     var pulsingIcon = L.icon.pulse({iconSize:[10,10],color:'red'});
	          var marker = L.marker([data.latitude, data.longitude],{icon: pulsingIcon
	        	  }).addTo(mymap).on('click',function(){
	              
	                         
	                 

	              

	               var d = $q.defer();
	       

	               GetProjectDetailsByProjectIdservice.projectdetailsurl(data.projectId).then(function(response) {
	            
	            
	            d.resolve(response);
	            $scope.initiateProject(response.data);

	              }, function(error) {
	            d.reject(error);
	        }); 




	            }).on('mouseover',function(){

	          
	              

	            });
	            
	            	
				}
	            
	            
	        }

	   
	   
	   
	    $scope.initMap= function() {
	    	 var cstId=$window.localStorage.getItem("customerId");
			 
		       abc=2;
		      mymap = L.map('map',
			  {
	    zoomControl: false
	   
	}
			 ).setView([51.5074,0.1278], 2);
			 
			 L.control.zoom({
             position:'topright'
             }).addTo(mymap);  

	             L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
	                attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
	             }).addTo(mymap);
				 
				 
				 $scope.event();
				 $scope.initiateMap();
	    
		  
		
	   
    	 
       }
      
      
      

      
      
	  $scope.assetClickDetails=function(asset){
		   
		   $scope.initSensors(asset.x.assetId);
	  }
	  
	  $scope.projectClickDetails=function(project)
	  {
		  $scope.flag=true;
		    $scope.sflag=true;
		   $scope.sensorData=[];
		    $scope.assetData=[];
		   
		  $scope.projectInitByProjectList(project);
		  $scope.initAssets(project.x.projectId);
	  }
	  
	  $scope.setSelectedProject = function(projectId) {
       $scope.idSelectedVote = projectId;
     
    }
	  
	  $scope.setSelectedAsset = function(assetId) {
       $scope.idSelectedAsset = assetId;
     
    }
      
    	  $scope.firstProjectDetails=function(projectId){

    		 
    		  GetProjectDetailsByProjectIdservice.projectdetailsurl(projectId).then(function(response) {
    	               
    	                $scope.pflag=true;
    	                
    	                 d.resolve(response);
					 
	                   $scope.sensorData=[];
    	               $scope.initiateProject(response.data);

    	                 }, function(error) {
							 
							  $scope.pflag=false;
		    	                
    	               d.reject(error);
    	           }); 


    	       } 

    	  
});