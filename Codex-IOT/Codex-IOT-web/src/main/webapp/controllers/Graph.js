app.controller("GraphController",function($scope,$http,$rootScope,$filter)
{ 	
	
	$scope.display= function(siteid,btnname)
	{	
	//DISPLAYING GRAPH
		$http.get("http://remote-data-dashboard-app.apps.eu01.cf.canopy-cloud.com/graph_type/getGrphWaterLevelAndWaterPressure" + "/" + siteid + "/" + "waterlevel")
        .then(function(response) 
             {
                console.log("in API");
                console.log(response);
                $rootScope.data3 = response.data;
                console.log(angular.toJson($rootScope.data3));

                var temp4 = [];
                var temp3 = [];
                var waterlevelarray = [];
                var obj3 = $rootScope.data3;
                console.log(obj3);

                for (var i in obj3) 
                {
                	console.log("in foreach" + i);
                    var datearray = [];
                    

                    /*$scope.data=waterlevelarray;
 						$scope.labels=datearray;
*/
					var date = $filter('date')(new Date(obj3[i].date), "dd/MMM");
                    datearray.push(date);
                    temp4.push(datearray);
                    console.log("date" +temp4);

                    waterlevelarray.push(obj3[i].waterLevel)
                    console.log("waterrrrrrrrrrr"+waterlevelarray);
                    temp3.push(waterlevelarray);
                    console.log("water level"+temp3);
                }

                $http.get("https://remote-data-dashboard-app.apps.eu01.cf.canopy-cloud.com/graph_type/getMaximumWaterLevel"+"/"+ siteid +"/"+"waterlevel").then(function(response){
                  console.log(response)
                  $rootScope.value=response.data;
                  $scope.callAnomaly();
                  console.log("before calling gridview controller");
                  $scope.gridView(siteid);
                  })

                console.log("waterrrrrrrrrrr22222222"+waterlevelarray);
                var ctx = document.getElementById('myChart').getContext('2d');
                var pointBackgroundColors = [];
                var myChart = new Chart(ctx, {
                    type: 'line',
                    data: {
                        labels: temp4,
                        datasets: [{
                            label: 'Temparature',
                            fill: true,
                            data: waterlevelarray,
                            backgroundColor: "rgba(255,255,255,0.6)",
                            pointBorderColor: "rgba(75,192,192,1)",
                            pointBackgroundColor: pointBackgroundColors,
                            borderColor: "rgba(0,102,161,1)",


                        }]
                    },

                    options: {
                        scales: {
                            yAxes: [{
                                scaleLabel: {
                                    display: true,
                                    labelString: 'Temparature',
                                },
                                gridLines: {
                                    display: true
                                }
                            }],
                            xAxes: [{
                                    scaleLabel: {
                                        display: true,
                                        labelString: 'Date'
                                    },
                                    gridLines: {
                                        display: false
                                    },
                                    ticks: {
                                        autoSkip: true,
                                        maxTicksLimit: 5
                                    }
                                },
                             ]
                        },
                        responsive: true,
                        showXLabels: 1
                    }
                });



                console.log(myChart);
                $scope.callAnomaly = function() 
                {

                    for (i = 0; i < myChart.data.datasets[0].data.length; i++) 
                    {
                    	console.log(myChart.data.datasets[0].data[i]);
                    	console.log("in for");
                        if (myChart.data.datasets[0].data[i] == $rootScope.value) 
                        {
                            console.log(myChart.data.datasets[0].data[i])
                            pointBackgroundColors.push("#FF0000");
                            console.log(pointBackgroundColors)


                        } else 
                        {
                        	pointBackgroundColors.push("rgba(0,0,0,1)");
                        }

                        myChart.update();




                    }

                }

                 



                

             })
         }
	$scope.gridView = function(siteid) 
    {

           


       $scope.data1 = [ ];

         
//     $http.post("http://10.87.196.240:9999/Codex-IOT-rest-api/temperature/data")
         $http.get("http://remote-data-dashboard-app.apps.eu01.cf.canopy-cloud.com/WATERLEVEL/getWaterLevel/"+siteid)
         .then(function(response) {
           $scope.data1 =response.data;
           console.log($scope.data1);

       },

       function(response) {
       
        }

         );
      

    }


  
	
});





