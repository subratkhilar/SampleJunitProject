app.service('Loginservice',function($http,$rootScope,$q){

    this.loginUrl = function(loginData) {                         
        var d = $q.defer();
        var req = {
             method: loginData.method,
             url: LOGIN_URL,
             headers: loginData.headers,
             data: loginData.data
            }

        $http(req).then(function(response) {
            $rootScope.data= response.data;
            d.resolve(response);
        }, function(error) {
            d.reject(error);
        }); 
    return d.promise;
    }
}); 
app.service('MapLocationService', function($http, $q, $rootScope) {

    this.getAllLocations = function() {
      var d = $q.defer();
      $http.get(GET_ALL_LOCATION).success(
          function(response) {
              d.resolve(response);
          }).error(function(error) {
          d.reject(error);
      });
      return d.promise;
  };

  this.getAllalerts = function(id) {
      var d = $q.defer();
      $http.get(SELECT_NOTIFICATION+"/"+id).success(
          function(response) {
              d.resolve(response);
              $rootScope.notifications = response;
          }).error(function(error) {
          d.reject(error);
      });
      return d.promise;
  };

  this.getDamInfoById = function(id) {
      var d = $q.defer();
      $http.get(SITE_ID+"/"+id).success(
          function(response) {
              d.resolve(response);
              $rootScope.siteId = response;
          }).error(function(error) {
          d.reject(error);
      });
      return d.promise;
  };
     
 /* New weather Forecast Dynamic Service start*/

   this.weatherForecast = function(lat,lon) {
      var d = $q.defer();
      var appid='e82209f61ccc77434bd155ba91a33159';
      console.log(appid);
      $http.get(WEATHER_FORECAST+"?"+"lat="+lat+"&"+"lon="+lon+"&"+"appid="+appid).success(
          function(response) {
              d.resolve(response);
              console.log(response);
             /* $rootScope.windId = response.wind;*/
          }).error(function(error) {
          d.reject(error);
      });
      return d.promise;
  };

  /* New weather Forecast Dynamic Service end */



});