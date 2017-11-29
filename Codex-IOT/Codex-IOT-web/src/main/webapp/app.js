var app = angular.module('codexIot', ['ui.router','datatables','chart.js','angularjs-datetime-picker','720kb.datepicker','ngMaterial','ngMessages','angularSpinner'])

.config(['ChartJsProvider', function (ChartJsProvider) {
    // Configure all charts 
    ChartJsProvider.setOptions({
     chartColors: ['#0066a1'],// change the color of datapoints
      scaleShowGridLines : true,
      responsive: true,
     
     elements: {
        line: {
               
                fill: false,
                borderColor: '#0066a1', //change the color of line 
                backgroundColor:'#0062ff',
                scaleShowGridLines : false,
            }
          },

     /*legend: {
          display: true,
          labels: {

               text: "Temperature",
               }
            },*/
          tooltips: 
      {
        callbacks: {
          label: function(label) 
          {
             console.log(label); 
              
             return (label.yLabel + " C Temp "  ); 
             
          }
        }
        
      },

       zoom: {
      enabled: true
      
           },

     /* scales: {
            xAxes: [{
            scaleLabel: {
            display: true,
            labelString: 'Time'
                        }
                  }],

            yAxes: [{
            scaleLabel: {
            display: true,
            labelString: 'Temperature'
                        }
                  }]

            },

      zoom: {
      enabled: true,
      mode: 'x'
           },*/
       
    });

    //for Specific Chart
    
    ChartJsProvider.setOptions('line', 
    {
      showLines: true,
     
    });
   
  }])