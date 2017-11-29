app.controller('LoginCtrl', function ($scope, $rootScope, $http, $timeout, $location, Loginservice, $window, $interval) {
console.log("in login");
    $scope.loginData = {
        username: '',
        password: ''
        
    };
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
  
    $scope.invalid = false;
	
    $interval(function () {
        $scope.today = new Date();
    }, 1000);

    	$scope.login = function (loginData) {
   
    	if (loginData.username.search(re ) == -1) {
		 $scope.loginError = "Please enter valid username.";
         $scope.loginData.username = "";
         $scope.loginData.password = "";
         $scope.submitFailed = true;
		} 
        
     else if (loginData.password.search(/[a-zA-Z]/) == -1 ) {
       	 
       	$scope.loginError = "Please enter valid password.";
        $scope.loginData.password = "";
        $scope.submitFailed = true;
		}

		//validate capital letter
     else if(loginData.password.search(/[A-Z]/) == -1 ) {
    	 $scope.loginError = "Please enter valid password.";
    	 $scope.loginData.password = "";
         $scope.submitFailed = true;
		}

		//validate number
     else if(loginData.password.search(/\d/) == -1) {
    	   $scope.loginError = "Please enter valid password.";
    	   $scope.loginData.password = "";
           $scope.submitFailed = true;
		}
		
		//validate space
     else if ( loginData.password.search(/[^a-zA-Z0-9\-\/]/) ==-1 ) {
    	  $scope.loginError = "Please enter valid password.";
		  $scope.loginData.password = "";
          $scope.submitFailed = true;
		} 
       
     //validate the length
       else if (loginData.password.length < 8 ) {
       	 $scope.loginError = "Please enter valid password.";
       	 $scope.loginData.password = "";
         $scope.submitFailed = true;
		}
     //validation
      
      /* else if ( loginData.password.search(/[a-zA-Z]/) == -1 && loginData.password.search(/[A-Z]/) == -1 &&  loginData.password.search(/\d/) == -1
    	 && loginData.password.search(/[^a-zA-Z0-9\-\/]/) ==-1  && loginData.password.length < 8 
    	&& loginData.username.search(/[a-zA-Z]/) == -1 && loginData.username.search(/[A-Z]/) == -1 && loginData.username.search(/\d/) == -1 && loginData.username.search(re ) == -1 )   
    	{
           	 
            	$scope.loginError = "Please enter valid credentials.";
            	$scope.loginData.username = "";
                $scope.loginData.password = "";
                $scope.submitFailed = true;
     		}*/
       else
      {
       
        var options = {
            headers: {
                'Content-Type': "application/json",
                'Accept': "application/json"
            },
            data: {
                username: $scope.loginData.username,
                password: $scope.loginData.password
            },
            method: 'POST'
        }

        //console.log(options.data);
        Loginservice.loginUrl(options)
            .then(function (response) {
                //hitting the service
                //console.log(response);
                $window.localStorage.setItem("customerId",response.data.customer.customerId);
                $window.localStorage.setItem("Token",response.data.authTokenInfo.accessToken);
                         $window.localStorage.setItem("RoleName",response.data.role.rolename);
                $window.localStorage.setItem("RollId",response.data.role.roleId);
                $window.localStorage.setItem("userID",response.data.userid);
                
                $rootScope.logCreds = response.data.role.roletype;                        
            
                if (response.data.hasOwnProperty('userid') && response.data.hasOwnProperty('authTokenInfo')) {
                //    console.log("in error");
                    $window.location.href = "#/welcome";
                    $scope.submitFailed = false;
                }

                else if (response.status.hasOwnProperty('status')) {                        //need to ask from harish or tushar 
                    $scope.loginError = "Invalid credentials please try again";
                }
                else {
                    console.log('something went wrong');
                }
            },
            function (error) {
                console.log("Wrong crederntials");
                $scope.isLogin = true;
                $scope.loginData = {};
                //  $scope.invalid = true;
                if (loginData.username == "" && loginData.password == "") {
                      console.log("Wrong crederntial...........");
                    $scope.loginError = "Please enter credentials";
                    $scope.loginData.username = "";
                    $scope.loginData.password = "";
                }
                else {
                    if (loginData.username == "") {
                        $scope.loginError = "Please enter Username";
                        $scope.loginData.username = "";
                        $scope.loginData.password = "";
                    }
                   
                    
                  /* else if (loginData.username.search(/^([0-9a-zA-Z]([-_\\.]*[0-9a-zA-Z]+)*)[\\.]([0-9a-zA-Z]([-_\\.]*[0-9a-zA-Z]+)*)@([0-9a-zA-Z]([-_\\.]*[0-9a-zA-Z]+)*)[\\.]([a-zA-Z]{3,3})/)==-1){
                        $scope.loginError = "Please enter valid Username";
                        console.log("Please enter username");
                        $scope.loginData.username = "";
                        $scope.loginData.password = "";
            }*/
                    
                    else if (loginData.password == "") {
                        $scope.loginError = "Please enter Password";
                        $scope.loginData.username = "";
                        $scope.loginData.password = "";
                    }
                                
        	
    		//validate letter
            /*else if (loginData.password.search(/[a-zA-Z]/) == -1 ) {
            	 console.log();
            	$scope.loginError = "Please enter atleast one letter";
                $scope.loginData.username = "";
                $scope.loginData.password = "";
    		}

    		//validate capital letter
            else if ( loginData.password.search(/[A-Z]/) == -1 ) {
    			$scope.loginError = "Please enter atleast one capital letter in Password";
                $scope.loginData.username = "";
                $scope.loginData.password = "";
    		}

    		//validate number
            else if ( loginData.password.search(/\d/) == -1 ) {
    			$scope.loginError = "Please enter atleast one digit";
                $scope.loginData.username = "";
                $scope.loginData.password = "";
    		}
    		
    		//validate space
            else if ( loginData.password.search(/[^a-zA-Z0-9\-\/]/) ==-1 ) {
    			$scope.loginError = "Please enter atleast one special character";
                $scope.loginData.username = "";
                $scope.loginData.password = "";
    		} 
            
          //validate the length
            else if (loginData.password.length < 8 ) {
            	 $scope.loginError = "Please enter atleast 8 characters";
                 $scope.loginData.username = "";
                 $scope.loginData.password = "";
    		}*/
                    
                    else {
                        $scope.loginError = "Invalid credentials please try again";
                    }

                }

            }).finally(function () {
                clearMessages();
            });
        
    }
    }

    function clearMessages() {
        $timeout(function () {
            $scope.loginError = '';
            

        }, 100000);
    }

    $scope.logout = function () {
        console.log("in logout function");
    	$window.localStorage.clear();
        $window.location.href = "#/";
        console.log(window.location.href);  // whatever your current location href is
        window.history.replaceState({}, 'window.location.href', 'window.location.href');
        console.log(window.location.href);
		//window.location.reload();

    };

    $scope.relogin = function () {
        console.log("in logout function");
        $window.localStorage.clear();
        $window.location.href = "#/";
        console.log(window.location.href);  // whatever your current location href is
        window.history.replaceState({}, 'window.location.href', 'window.location.href');
        console.log(window.location.href);
      //  window.location.reload();

    };


    $scope.$on('$locationChangeStart', function (event) {
        if ($scope.myForm.$invalid) {
            event.preventDefault();
           
        }
    });
});
