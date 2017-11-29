app.controller('sidebarCtrl', function ($scope, $rootScope, $http, $timeout, $location, Loginservice, $window, $interval){
	console.log("in side cntrl");
	
	 $scope.isActive = function(route) 
	 {
    return route === $location.path();
     }
	
	 var role=localStorage.getItem("RoleName");
	 console.log("role type",role);
	
	 if(role == 'ProjectAdmin'){
		 $('#projectConfig').hide();
    }
    
    else if(role == 'CustomerAdmin'){

}
	 
    else if(role == 'BusinessUser'){  
    	$('#settingsId').hide();
    	$('#workflow').hide();
     } 

	
	$('ul.sidebar-nav > li').click(function(){
        $(this).children('a').toggleClass('active');
        $(this).siblings('li').children('a').removeClass('active');
    });
	
$("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
$("#wrapper").toggleClass("toggled-2");
     $("#menu-toggle-2").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled-2");
        $('#menu ul').hide();
    });
     $scope.project_id = ["0121", "0231", "0432"];
    
     function initMenu() {
      $('#menu ul').hide();
      $('#menu ul').children('.current').parent().show();
      //$('#menu ul:first').show();
      $('#menu li a').click(
        function() {
        	console.log("inside nav setting");
          var checkElement = $(this).next();
          if((checkElement.is('ul')) && (checkElement.is(':visible'))) {
        	  $('#menu ul:visible').slideUp('normal');
            return false;
            }
          if((checkElement.is('ul')) && (!checkElement.is(':visible'))) {
            $('#menu ul:visible').slideUp('normal');
            checkElement.slideDown('normal');
            return false;
            }
          }
        );
      }
    $(document).ready(function() {initMenu();});
    
    $scope.myFunction=function() {
        var popup = document.getElementById("myPopup");
        popup.classList.toggle("show");
    }
    $scope.userFunction=function() {
        var popup = document.getElementById("userPopup");
        popup.classList.toggle("show");
    }
    
   
});