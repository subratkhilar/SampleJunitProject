app.controller('AuthCtrl', function($scope,$rootScope) {
	
	 var role=localStorage.getItem("RoleType");
	 console.log("role type",role);
	
	 if(role == 'Project Admin'){
     	$rootScope.IsProjectAdmin = function(){
     	    return  true;
     	}
     }
     
     else if(role == 'Customer Admin'){     	              	 
     	$rootScope.IsCustomerAdmin = function(){
     	    return  true;
     	}
     }
	 
     else if(role == 'Business User'){       	 
      	$rootScope.IsBusinessUser = function(){
      	    return  false;
      	}
      }
     
     else{
    	 $rootScope.IsAdmin = function(){
 	    return  false;
 	}
     	
     }


}); 
