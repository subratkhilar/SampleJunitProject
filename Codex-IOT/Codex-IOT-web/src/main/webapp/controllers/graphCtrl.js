app.controller('NewGraphController', function($scope,$window,$q,$http,$rootScope,usSpinnerService,GridDataByCustIdservice,LiveGraphservice,ColdGraphservice) 
{
	
	var cstId=$window.localStorage.getItem("customerId");

	
	 $scope.initReports = function () 
	 {
		 var s1,s2,s3;
         var mybody = angular.element(document).find('body');
		 mybody.addClass('waiting');
		
		  
		 
		 
		 

			GridDataByCustIdservice.gridurl(cstId).then(function (response) 
					{
				
				
				$scope.report_details = response.data;
				 s1=$scope.report_details[0].sensorId ;
				  s2=$scope.report_details[1].sensorId;  
				  s3=$scope.report_details[2].sensorId;
				  mybody.removeClass('waiting');
				  
				  sensor3(s1,s2,s3);
				d.resolve(response);
				
			}, function (error) {
				 mybody.removeClass('waiting');
				d.reject(error);
			});
				
			
	} 
	 
	
	 sensor3=function(s3,s2,s1)
	   {
		
		  
		 
	   
	  
		
	      

		
	   
	   
		   $scope.i = 0;
		    $scope.hotdatagraph3 = {};
		    $scope.hotdatagraph2 = {};
		    $scope.hotdatagraph1 = {};
		    $scope.count=1;

		    var temp;
	    $scope.hotdatagraph3.labels = [];
	    $scope.hotdatagraph3.data = [];
	    $scope.hotdatagraph2.labels = [];
	    $scope.hotdatagraph2.data = [];
	    $scope.hotdatagraph1.labels = [];
	    $scope.hotdatagraph1.data = [];
	    
	    $scope.hotdatagraph3.options = {
	          
	          scales: {
	              xAxes: 
	              [{
	                   
	                  scaleLabel: {
	            display: true,
	            labelString: 'Time',


	                        },
	                         gridLines: {
	                        display: true
	                    }
	                  }]
	            ,
	              yAxes: [{
	                  
	                  scaleLabel: {
	            display: true,
	            labelString: 'Temperature'
	                        },
	                         gridLines: {
	                        display: true
	                    }
	                  }]
	            
	          },
	          
	          title: {
	              display: true,
	              text: ' '
	          },

	         

	          scaleShowGridLines : true,
	          scaleShowHorizontalLines: true,
	          scaleShowVerticalLines: true,
	          datasetStroke :true,
	          datasetFill : false,
	          borderColor: '#0062ff',
	          

	         
	      };
	 
	 
	     

	    $scope.onClick = function (points, evt) 
	      {
	         
	    	 

	      };

	      $scope.$on('chart-create', function (evt, chart) {
	 
	});
	      
	      $scope.update = function()
		     {
	    	  
	    	 
	    	 

		   
		      LiveGraphservice.livegraphurl(s1,cstId).then(function(response) 
		      {
		    	 
		    	 
		    		 

		         $rootScope.data1=response.data;
		        
		        
		         
		    for(var i in $rootScope.data1)
		    {
		      var value=$rootScope.data1[i].sensor_value;
		      
		      
		      var time=$scope.data1[i].current_timestamp;
	        var date_obj = UUID_to_Date.get_date_obj(time);
	        var ctime=date_obj.toLocaleString( );
	        var time = ctime.split(',');
	      var time2=time[1].split(' ');
	      var ftime=time2[1];

	      
		  		      
	       $scope.hotdatagraph1.labels.push(ftime);
	       $scope.hotdatagraph1.data.push(value);
		    		  
		        
		      if(  $scope.hotdatagraph1.labels.length>20)
		        {
		        
		    	  $scope.hotdatagraph1.labels.shift();
		    	  $scope.hotdatagraph1.data.shift();
		    	
		        }
		        		     

		    }//for
		  });// http of live graph
		  
		  
		  }//update
		 
		    
		    

		  setInterval(function () {$scope.update();},3000);
		  
	      
	      
	      $scope.update2 = function()
		     {
		    	
		    	

		  
	    	  LiveGraphservice.livegraphurl(s2,cstId).then(function(response) 
		      {
		    	 
		    		 

		         $rootScope.data1=response.data;
		       
		        
		         
		    for(var i in $rootScope.data1)
		    {
		      var value=$rootScope.data1[i].sensor_value;
		      
		      
		      var time=$scope.data1[i].current_timestamp;
	      var date_obj = UUID_to_Date.get_date_obj(time);
	      var ctime=date_obj.toLocaleString( );
	      var time = ctime.split(',');
	    var time2=time[1].split(' ');
	    var ftime=time2[1];

	    
		  		      
	     $scope.hotdatagraph2.labels.push(ftime);
	     $scope.hotdatagraph2.data.push(value);
		    		  
		        
		      if(  $scope.hotdatagraph2.labels.length>20)
		        {
		        
		    	  $scope.hotdatagraph2.labels.shift();
		    	  $scope.hotdatagraph2.data.shift();
		    	
		        }
		        		     

		    }//for
		  });// http of live graph
		  
		   
		  }//update
		 
		    
		    

		  setInterval(function () {$scope.update2();},3000);
		  
	    
	 
		
	    $scope.update3 = function()
	     {
	    	
	    	

	    	LiveGraphservice.livegraphurl(s3,cstId)
	      .then(function(response) 
	      {
	    	 
	    		 

	         $rootScope.data1=response.data;
	       
	        
	         
	    for(var i in $rootScope.data1)
	    {
	      var value=$rootScope.data1[i].sensor_value;
	   
	      
	      var time=$scope.data1[i].current_timestamp;
    var date_obj = UUID_to_Date.get_date_obj(time);
    var ctime=date_obj.toLocaleString( );
    var time = ctime.split(',');
  var time2=time[1].split(' ');
  var ftime=time2[1];

  
	  		      
   $scope.hotdatagraph3.labels.push(ftime);
   $scope.hotdatagraph3.data.push(value);
	    		  
	        
	      if(  $scope.hotdatagraph3.labels.length>20)
	        {
	        
	    	  $scope.hotdatagraph3.labels.shift();
	    	  $scope.hotdatagraph3.data.shift();
	    	
	        }
	        		     

	    }//for
	  });// http of live graph
	  
	   
	  }//update
	 
	    
	    

	  setInterval(function () {$scope.update3();},3000);
	  
	
	  

	   }//sensor3


	 
	 
		   
	 $scope.cold_data_graph = function(id)
	 {
		 $scope.colddatagraph = {};
		
		 
		 var sensorId=id;
	     
	     $scope.colddatagraph.data = [];
		
			var d=new Date();
			var year=d.getFullYear();
			var month=d.getMonth()+1;
			if (month<10){
			month="0" + month;
			};
			var day=d.getDate();
			var seconds = d.getSeconds();
			var minutes = d.getMinutes();
			var hour = d.getHours();
			$scope.from=day + "-" + month + "-" + year;
			
			 $scope.myDate = new Date();
			 $scope.$watch('myDate', function (value) 
					 {
				
				     
					    usSpinnerService.spin('spinner-1');
				 		
				 		var year = value.getFullYear();
						
				 		var month = value.getMonth() + 1;
						
						var tday = value.getDate();
						
						var fulldate = tday + "-" + month + "-" + year;
				 		
		 			    cold( sensorId,fulldate);
					 });
			
			$scope.myFunc=function(value){
		 $scope.$watch('myDate', function (value) 
				 {
			
			      
					usSpinnerService.spin('spinner-1');
			 		
			 		var year = value.getFullYear();
					
					var month = value.getMonth() + 1;
					
					var tday = value.getDate();
					
					var fulldate = tday + "-" + month + "-" + year;
			 		
	 			    cold( sensorId,fulldate);
			 		
	 			    
			 		
					
			 		});
			}
		 var cold=function(sensorId,date)
		 {
			 
			
			 $scope.colddatagraph.data=[];
			
	    	 
			
			
		 $scope.colddatagraph.labels = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24];
		 $scope.colddatagraph.options = {
		 
		 scales: {
             xAxes: 
             [{
                  
                 scaleLabel: {
           display: true,
           labelString: 'Time in Hrs',


                       },
                        gridLines: {
                       display: true
                   }
                 }]
           ,
             yAxes: [{
                 
                 scaleLabel: {
           display: true,
           labelString: 'Temperature'
                       },
                        gridLines: {
                       display: true
                   }
                 }]
           
         },
         
         title: {
             display: true,
             text: ' '
         },

        

         scaleShowGridLines : true,
         scaleShowHorizontalLines: true,
         scaleShowVerticalLines: true,
         datasetStroke :true,
         datasetFill : false,
         borderColor: '#0062ff',
         

        
     };
		
		 
		
	      ColdGraphservice.coldgraphurl(cstId,sensorId,date).then(function(response) 
	      {
	    	  $scope.colddatagraph.data=[];
	    	 
	    	  var data=response.data;
	    	  for(var i in data)
	  	    {
	    		  var temp=data[i];
	    		 
	    		  $scope.colddatagraph.data.push(temp);
	    		  
	    	}
	    	  
	    	
			 usSpinnerService.stop('spinner-1');
	    	 
	    });
			
			
			  
			 
	 } 
	 
	 }
	
		 
		 
		 
		    
	      
	     
		   
	 
	 

	 
});
	 