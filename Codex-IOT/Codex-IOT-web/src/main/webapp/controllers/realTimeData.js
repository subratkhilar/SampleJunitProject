/**
 * 
 */

var app = angular.module('Myapp', []).controller('dataController', function ($scope, $rootScope, $http,$filter) {
	var final_temperature;
	
	function requestData() 
	        {
	          console.log("in fun");
	            $http.get("http://10.87.195.125:8032/save")
	             .then(function(response) 
	             {
	                var data1=response.data;
	                //console.log(response.data);

	                for(var i in data1)
	                {
	                    temp=data1[i].temperature;
	                    id=data1[i].id;
	                    //console.log(temp);

	                    chart.series[0].addPoint(temp);
	                    shift = series.temp.length > 20; 


	                }
	                 var series = chart.series[0];
	                 console.log("length" +series.data.length);
	          if (series.data.length) 
	          {
	            chart.series[0].data[0].remove();
	          }

	                  


	             })

	  setTimeout(requestData, 2000);    
	        } 

	
	
	 $scope.GetDataVar=function getData(){
		 console.log("in fun");
	$http.get("http://10.87.195.125:8032/save")
    .then(function(response) 
    {
          // console.log(response.data);
           $rootScope.data1=response.data;
           var temp4 = [];
           var temp3 = [];
         final_temperature = [];
           var final_id= [];
           
           var wholedata = $rootScope.data1; 
           console.log(wholedata);

           for (var i in wholedata) 
           {
	
           console.log("in foreach" + i);
           temp3.push(wholedata[i].id);
           final_id.push(temp3);
           //console.log("final id"+final_id);
           
           temp4.push(wholedata[i].temperature);
           //console.log(temp4);
            
          final_temperature.push(temp4);
           console.log("temperature"+final_temperature[i]+wholedata.length);
           return final_temperature[i];
	
       }  });
           
    }


var chart=	 Highcharts.chart('container', {
	        chart: {
	            type: 'spline',
	            animation: Highcharts.svg, // don't animate in old IE
	            marginRight: 10,
	          events: {
	              load: requestData() /* function () {

	                     //set up the updating of the chart each second
	                    var series = this.series[0];
	                    setInterval(function () {
	                        var x = (new Date()).getTime(), // current time
	                        
	                            y = final_temperature[i];
	                        series.addPoint([x, y], true, true);
	                    }, 10000);
	                }*/
	            }
	        },
	        title: {
	            text: 'Live random data'
	        },
	        xAxis: {
	            type: 'datetime',
	            tickPixelInterval: 150
	        },
	        yAxis: {
	            title: {
	                text: 'Value'
	            },
	            plotLines: [{
	                value: 0,
	                width: 1,
	                color: '#808080'
	            }]
	        },
	      /*  tooltip: {
	            formatter: function () {
	                return '<b>' + this.series.name + '</b><br/>' +
	                    Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
	                    Highcharts.numberFormat(this.y, 2);
	            }
	        }*/
	        legend: {
	            enabled: false
	        },
	        exporting: {
	            enabled: false
	        },
	        series: [{
	            name: 'Random data',
	            data:[]
	             /*data: (function () {
	                // generate an array of random data
	                var data = [],
	                    time = (new Date()).getTime(),
	                    i;

	                for (i = -1; i <= 0; i += 1) {
	                    data.push({
	                      //  x: time + i * 1000,
	                        y: final_temperature[i]
	                    });
	                }
	                return data;
	            }())*/
	            
	            
	        }]
	    });
   
});