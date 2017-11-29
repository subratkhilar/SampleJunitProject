app.service('Loginservice', function ($http, $rootScope, $q) {

    this.loginUrl = function (loginData) {
        var d = $q.defer();
        var req = {
            method: "POST",
            url: LOGIN_URL,
            headers: loginData.headers,
            data: loginData.data
        }

        $http(req).then(function (response) {
            $rootScope.customer_data = response.data.customer.customerId;

            $rootScope.data = response.data;
            d.resolve(response);
        }, function (error) {
            d.reject(error);
        });
        return d.promise;
    }
})

app.service('Eventservice', function ($http, $rootScope, $q) {

    this.eventUrl = function (cstId) {

        var d = $q.defer();
        var req = {
            method: "GET",
            url: EVENT_URL + cstId,
            headers: cstId.headers,

        }

        $http(req).then(function (response) {

            $rootScope.data = response.data;
            d.resolve(response);
        }, function (error) {
            d.reject(error);
        });
        return d.promise;
    }
})

app.service('GetAllProjectservice', function ($http, $rootScope, $q) {

    this.allprojecturl = function (cstId) {

        var d = $q.defer();
        var req = {
            method: "GET",
            url: GET_ALL_PROJECT_URL + cstId,
            headers: cstId.headers,

        }

        $http(req).then(function (response) {

            $rootScope.data = response.data;
            d.resolve(response);
        }, function (error) {
            d.reject(error);
        });
        return d.promise;
    }
})

app.service('GetAllAssetByProjservice', function ($http, $rootScope, $q) {

    this.allasseturl = function (projectId) {

        var d = $q.defer();
        var req = {
            method: "GET",
            url: GET_ALL_ASSET_BY_PROJECT_ID_URL + projectId,

        }

        $http(req).then(function (response) {

            $rootScope.data = response.data;
            d.resolve(response);
        }, function (error) {
            d.reject(error);
        });
        return d.promise;
    }
})

app.service('GetAllSensorByAssetservice', function ($http, $rootScope, $q) {

    this.allsensorurl = function (assetId) {

        var d = $q.defer();
        var req = {
            method: "GET",
            url: GET_ALL_SENSOR_URL + assetId,

        }

        $http(req).then(function (response) {

            $rootScope.data = response.data;
            d.resolve(response);
        }, function (error) {
            d.reject(error);
        });
        return d.promise;
    }
})

app.service('CountProjectservice', function ($http, $rootScope, $q) {

    this.countprojecturl = function (cstId) {

        var d = $q.defer();
        var req = {
            method: "GET",
            url: COUNT_PROJECT_URL + cstId,

        }

        $http(req).then(function (response) {

            $rootScope.data = response.data;
            d.resolve(response);
        }, function (error) {
            d.reject(error);
        });
        return d.promise;
    }
})

app.service('CountAssetservice', function ($http, $rootScope, $q) {

    this.countasseturl = function (cstId) {

        var d = $q.defer();
        var req = {
            method: "GET",
            url: COUNT_ASSET_URL + cstId,

        }

        $http(req).then(function (response) {

            $rootScope.data = response.data;
            d.resolve(response);
        }, function (error) {
            d.reject(error);
        });
        return d.promise;
    }
})

app.service('CountSensorservice', function ($http, $rootScope, $q) {

    this.countsensorurl = function (cstId) {

        var d = $q.defer();
        var req = {
            method: "GET",
            url: COUNT_SENSOR_URL + cstId,

        }

        $http(req).then(function (response) {

            $rootScope.data = response.data;
            d.resolve(response);
        }, function (error) {
            d.reject(error);
        });
        return d.promise;
    }
})

app.service('GetAllProjectLocationByCustIdservice', function ($http, $rootScope, $q) {

    this.projectlocationurl = function (cstId) {

        var d = $q.defer();
        var req = {
            method: "GET",
            url: GET_ALL_PROJECT_URL + cstId,

        }

        $http(req).then(function (response) {

            $rootScope.data = response.data;
            d.resolve(response);
        }, function (error) {
            d.reject(error);
        });
        return d.promise;
    }
})

app.service('GetProjectDetailsByProjectIdservice', function ($http, $rootScope, $q) {

    this.projectdetailsurl = function (projectId) {

        var d = $q.defer();
        var req = {
            method: "GET",
            url: PROJECT_DETAILS_URL + projectId,

        }

        $http(req).then(function (response) {

            $rootScope.data = response.data;
            d.resolve(response);
        }, function (error) {
            d.reject(error);
        });
        return d.promise;
    }
})

app.service('GridDataByCustIdservice', function ($http, $rootScope, $q) {

    this.gridurl = function (cstId) {

        var d = $q.defer();
        var req = {
            method: "GET",
            url: GRID_URL_pre + cstId + cassandra_post_URL,

        }

        $http(req).then(function (response) {

            $rootScope.data = response.data;
            d.resolve(response);
        }, function (error) {
            d.reject(error);
        });
        return d.promise;
    }
})

app.service('LiveGraphservice', function ($http, $rootScope, $q) {

    this.livegraphurl = function (sendorid, cstId) {

        var d = $q.defer();
        var req = {
            method: "GET",
            url: LIVE_GRAPH_URL + sendorid + "/" + cstId + cassandra_post_URL,

        }

        $http(req).then(function (response) {

            $rootScope.data = response.data;
            d.resolve(response);
        }, function (error) {
            d.reject(error);
        });
        return d.promise;
    }
})

app.service('ColdGraphservice', function ($http, $rootScope, $q) {

    this.coldgraphurl = function (cstId, sensorId, date) {

        var d = $q.defer();
        var req = {
            method: "GET",
            url: COLD_GRAPH_URL + cstId + "/" + sensorId + "/" + date + cassandra_post_URL,

        }

        $http(req).then(function (response) {

            $rootScope.data = response.data;
            d.resolve(response);
        }, function (error) {
            d.reject(error);
        });
        return d.promise;
    }
});

// services for project_configuration page

// service to activate project
app.service('Activate_project_service', function ($http, $rootScope, $q) {

    this.active_project_url = function (project_id) {

        var d = $q.defer();
        var req = {
            method: "GET",
            url: ACTIVATE_PROJECT + project_id,
            headers: {
                'Accept': "application/json"
            },
            data: ""

        }

        $http(req).then(function (response) {
            // $rootScope.data= response.data;
            console.log("records updated in Active state");
            $('#centralModalSuccess_for_delete_false').modal('show');

            d.resolve(response);
        }, function (error) {
            d.reject(error);
        });
    }
});


// service to Inactivate project

app.service('Inactivate_project_service', function ($http, $rootScope, $q) {

    this.inactive_project_url = function (project_id) {

        var d = $q.defer();


        var req = {
            method: "DELETE",
            url: INACTIVE_PROJECT + $rootScope.project_id_for_delete,
            headers: {
                'Accept': "application/json"
            },
            data: ""
        }

        $http(req).then(function (response) {
            // $rootScope.data= response.data;
            console.log("record has been deleted1");
            $('#centralModalSuccess_for_delete_true').modal('show');

            d.resolve(response);
        }, function (error) {
            d.reject(error);
        });

    }
});

// edit project service

app.service('Edit_project_service', function ($http, $rootScope, $q) {

    this.edit_project_url = function (project_id, project_name, project_location, project_desc, latitude1, longitude1, latest_customer_id) {

        var d = $q.defer();
        var data = {
            projectName: project_name,
            projectLocation: project_location,
            projectId: project_id,
            projectDescription: project_desc,
            longitude: longitude1,
            latitude: latitude1,
            customerId: latest_customer_id
        };
        var myJSON = angular.toJson(data);
        var req = {
            method: 'PUT',
            url: UPDATE_PROJECT + project_id,
            data: myJSON,

            headers: {
                'Content-Type': 'application/json;charset=utf-8',
                'Accept': 'application/json;charset=utf-8'
            }
        }

        $http(req).then(function (response) {
            // $rootScope.data= response.data;
            console.log("record has been deleted1");
            $('#centralModalSm_for_editProject').hide();

            $('#centralModalSuccess_for_edit').modal('show');


            d.resolve(response);
        }, function (error) {
            d.reject(error);
        });
        return d.promise;
    }
});

// send project detail to backend
/*app.service('Add_project_service', function ($http, $rootScope, $q) {

    this.add_project_url = function (projectName, projectLocation, projectId,
        projectDescription, latitude, longitude, latest_customer_id) {

        var d = $q.defer();
        console.log(latest_customer_id);
        var data = {
            projectName: projectName,
            projectLocation: projectLocation,
            projectId: projectId,
            projectDescription: projectDescription,
            longitude: longitude,
            latitude: latitude,
            customerId: latest_customer_id
        };
        var myJSON = angular.toJson(data);
        var req = {
            method: 'POST',
            url: SAVE_PROJECT,

            data: myJSON,

            headers: {
                'Content-Type': 'application/json;charset=utf-8',
                'Accept': 'application/json;charset=utf-8'
            }
        }

        $http(req).then(function (response) {
            // $rootScope.data= response.data;
            console.log("record has success fully send.");
            $('#centralModalSm_for_addProject').hide();
            $('#centralModalSuccess_for_add').modal('show');

            d.resolve(response);
        }, function (error) {
            d.reject(error);
        });
        return d.promise;
    }
});*/

//  GET project details service

app.service('Get_project_service', function ($http, $rootScope, $q) {

    this.get_project_url = function (latest_customer_id) {
        var current_customer_id = latest_customer_id
        var d = $q.defer();

        var req = {
            method: "GET",
            url: GET_PROJECT_BY_CURRENT_ID + current_customer_id,
            headers: {
                'Accept': "application/json"
            },
            data: ""
        }

        $http(req).then(function (response) {
            // $rootScope.data= response.data;
            console.log(response.data);
            $rootScope.project_details = response.data;
            d.resolve(response);
        }, function (error) {
            d.reject(error);
        });
        return d.promise;
    }
});

// services for sensor_configuration page

// service to activate sensor
app.service('Activate_sensor_service', function ($http, $rootScope, $q) {

    this.active_sensor_url = function (sensor_id) {

        var d = $q.defer();
        var req = {
            method: "GET",
            url: ACTIVATE_SENSOR + sensor_id,
            headers: {
                'Accept': "application/json"
            },
            data: ""

        }

        $http(req).then(function (response) {
            // $rootScope.data= response.data;
            console.log("records updated in Active state");
            $('#centralModalSuccess_for_delete_active').modal('show');

            d.resolve(response);
        }, function (error) {
            d.reject(error);
        });
        return d.promise;
    }
});

// service to inactivate  sensor

app.service('Inactivate_sensor_service', function ($http, $rootScope, $q) {

    this.inactive_sensor_url = function (sensor_id) {

        var d = $q.defer();


        var req = {
            method: "DELETE",
            url: INACTIVE_SENSOR + sensor_id,
            headers: {
                'Accept': "application/json"
            },
            data: ""
        }

        $http(req).then(function (response) {
            // $rootScope.data= response.data;
            console.log("record has been deleted1");
            //   $scope.project_details = response.data;
            $('#centralModalSuccess_for_delete').modal('show');
            d.resolve(response);
        }, function (error) {
            d.reject(error);
        });
        return d.promise;
    }
});


// edit sensor service

app.service('Edit_sensor_service', function ($http, $rootScope, $q) {

    this.edit_sensor_url = function (sensor_id, sensor_name, sensor_datatype, sensor_description, sensor_serialnumber, sensor_tag, asset_id) {

        var d = $q.defer();
        var data = {

            assetId: asset_id,
            sensorDatatype: sensor_datatype,
            sensorDescription: sensor_description,
            sensorId: sensor_id,
            sensorSerialNumber: sensor_serialnumber,
            sensorTag: sensor_tag,
            sensorsName: sensor_name


        };
        var myJSON = angular.toJson(data);
        var req = {
            method: 'PUT',
            url: UPDATE_SENSOR + sensor_id,
            data: myJSON,

            headers: {
                "Accept": "application/json"
            }
        }

        $http(req).then(function (response) {
            // $rootScope.data= response.data;
            // console.log("record has been deleted1");
            $('#centralModalSuccess_for_edit').modal('show');
            $('#centralModalSm_for_editsensor').hide();


            d.resolve(response);
        }, function (error) {
            d.reject(error);
        });
        return d.promise;
    }
});


// get sensor detail service

app.service('Get_sensor_service', function ($http, $rootScope, $q) {

    this.get_sensor_url = function (latest_customer_id) {
        var current_customer_id = latest_customer_id
        var d = $q.defer();

        var req = {
            method: "GET",
            url: GET_SENSOR_BY_CURRENT_ID + current_customer_id,
            headers: {
                'Accept': "application/json"
            },
            data: ""
        }

        $http(req).then(function (response) {
            // $rootScope.data= responsse.data;
            console.log(response.data);
            $rootScope.sensor_details = response.data;
            d.resolve(response);
        }, function (error) {
            d.reject(error);
        });
        return d.promise;
    }
});

app.service('Get_sensor_project_admin_service', function ($http, $rootScope, $q) {

    this.get_sensor_project_admin_url = function (userId) {
        var userId = userId
        var d = $q.defer();

        var req = {
            method: "GET",
            url: GET_SENSOR_BY_USER_ID + userId,
            headers: {
                'Accept': "application/json"
            },
            data: ""
        }

        $http(req).then(function (response) {
            // $rootScope.data= responsse.data;
            console.log(response.data);
            $rootScope.sensor_details = response.data;
            d.resolve(response);
        }, function (error) {
            d.reject(error);
        });
        return d.promise;
    }
});

// services for Asset_configuration page

// service to activate asset
app.service('Activate_asset_service', function ($http, $rootScope, $q) {

    this.active_asset_url = function (asset_id) {

        var d = $q.defer();
        var req = {
            method: "GET",
            url: ACTIVATE_ASSET + asset_id,
            headers: {
                'Accept': "application/json"
            },
            data: ""
        }

        $http(req).then(function (response) {
            // $rootScope.data= response.data;
            console.log("asset has updated for inactive state.");
            //   $scope.project_details = response.data;
            $('#centralModalSuccess_for_asset_delete_false').modal('show');
            d.resolve(response);
        }, function (error) {
            d.reject(error);
        });
        return d.promise;
    }
});

// service to inactivate  sensor

app.service('Inactivate_asset_service', function ($http, $rootScope, $q) {

    this.inactive_asset_url = function (asset_id) {

        var d = $q.defer();


        var req = {
            method: "DELETE",
            url: INACTIVE_ASSET + asset_id,
            headers: {
                'Accept': "application/json"
            },
            data: ""
        }

        $http(req).then(function (response) {
            // $rootScope.data= response.data;
            console.log("asset has updated for active state.");
            //   $scope.project_details = response.data;
            $('#centralModalSuccess_for_asset_delete').modal('show');
            d.resolve(response);
        }, function (error) {
            d.reject(error);
        });
        return d.promise;
    }
});


// edit asset service

app.service('Edit_asset_service', function ($http, $rootScope, $q) {

    this.edit_asset_url = function (asset_edited_id, asset_edited_ip_address, asset_edited_description, asset_edited_name, asset_edited_protocol, asset_edited_serial_number, project_edited_id) {

        var d = $q.defer();
        var data = {

            assetDesc: asset_edited_description,
            assetId: asset_edited_id,
            assetIpAddress: asset_edited_ip_address,
            assetName: asset_edited_name,
            assetProtocol: asset_edited_protocol,
            assetSerialNumber: asset_edited_serial_number,

            projectId: project_edited_id,

        };

        var myJSON = angular.toJson(data);
        console.log(angular.toJson(data));

        var req = {
            method: 'POST',
            url: UPDATE_ASSET,
            data: myJSON,

            headers: {
                'Content-Type': 'application/json;charset=utf-8',
                'Accept': 'application/json;charset=utf-8'
            }
        }
        $http(req).then(function (response) {
            // $rootScope.data= response.data;
            console.log("asset has updated ");
            $('#centralModalSm_for_edit').hide();
            $('#centralModalSuccess_for_edit').modal('show');
            d.resolve(response);
        }, function (error) {
            d.reject(error);
        });
        return d.promise;
    }
});


// get asset detail service

app.service('Get_asset_service', function ($http, $rootScope, $q) {

    this.get_asset_url = function (latest_customer_id) {
        var current_customer_id = latest_customer_id
        var d = $q.defer();

        var req = {
            method: "GET",
            url: GET_ASSET_BY_CURRENT_ID + current_customer_id,
            headers: {
                'Accept': "application/json"
            },
            data: ""
        }

        $http(req).then(function (response) {
            // $rootScope.data= responsse.data;
            console.log(response.data);
            $rootScope.asset_details = response.data;
            d.resolve(response);
        }, function (error) {
            d.reject(error);
        });
        return d.promise;
    }
})

// get asset detail for project admin service 
app.service('Get_asset_project_admin_service', function ($http, $rootScope, $q) {

    this.get_asset_project_admin_url = function (userId) {
        var UserId = userId
        var d = $q.defer();

        var req = {
            method: "GET",
            url: GET_ASSET_BY_USER_ID + UserId,
            headers: {
                'Accept': "application/json"
            },
            data: ""
        }

        $http(req).then(function (response) {
            // $rootScope.data= responsse.data;
            console.log(response.data);
            $rootScope.asset_details = response.data;
            d.resolve(response);
        }, function (error) {
            d.reject(error);
        });
        return d.promise;
    }
});