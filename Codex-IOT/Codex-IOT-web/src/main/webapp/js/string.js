/* New String JS start */
const LOGIN_URL = 'http://codex-iot.apps.eu01.cf.canopy-cloud.com/login/';
const EVENT_URL = 'http://codex-iot.apps.eu01.cf.canopy-cloud.com/Event/getallEventbyCustomerID/';
const GET_ALL_PROJECT_URL='http://codex-iot.apps.eu01.cf.canopy-cloud.com/project/getallbycustomer/';
const GET_ALL_ASSET_BY_PROJECT_ID_URL='http://codex-iot.apps.eu01.cf.canopy-cloud.com/Asset/getallAssetbyprojId/';
const GET_ALL_SENSOR_URL='http://codex-iot.apps.eu01.cf.canopy-cloud.com/sensor/getallsensorbyassetid/';
const COUNT_PROJECT_URL='http://codex-iot.apps.eu01.cf.canopy-cloud.com/dashboard/getNoOfProjects/';
const COUNT_ASSET_URL='http://codex-iot.apps.eu01.cf.canopy-cloud.com/dashboard/getNoOfAssets/';
const COUNT_SENSOR_URL='http://codex-iot.apps.eu01.cf.canopy-cloud.com/dashboard/getNoOfSensors/';
const PROJECT_DETAILS_URL='http://codex-iot.apps.eu01.cf.canopy-cloud.com/project/getProjectDetails/';
const GRID_URL_pre='http://cassandra.apps.eu01.cf.canopy-cloud.com/service_timeseries/getByCriteria/';
const LIVE_GRAPH_URL='http://cassandra.apps.eu01.cf.canopy-cloud.com/service_timeseries/getLatestValues/';
const COLD_GRAPH_URL='http://pheonix.apps.eu01.cf.canopy-cloud.com/service_fetch_coldData/getByCriteria/';
const cassandra_post_URL='/{db_type}';

const ACTIVATE_PROJECT = 'http://codex-iot.apps.eu01.cf.canopy-cloud.com/project/updateActiveState/';
const INACTIVE_PROJECT = 'http://codex-iot.apps.eu01.cf.canopy-cloud.com/project/delete/';
const UPDATE_PROJECT = 'http://codex-iot.apps.eu01.cf.canopy-cloud.com/project/update/';
const SAVE_PROJECT = 'http://codex-iot.apps.eu01.cf.canopy-cloud.com/project/save';
const GET_PROJECT_BY_CURRENT_ID = 'http://codex-iot.apps.eu01.cf.canopy-cloud.com/project/getallbycustomer/';


const ACTIVATE_SENSOR = 'http://codex-iot.apps.eu01.cf.canopy-cloud.com/sensor/updateActiveState/';
const INACTIVE_SENSOR = 'http://codex-iot.apps.eu01.cf.canopy-cloud.com/sensor/delete/';
const UPDATE_SENSOR = 'http://codex-iot.apps.eu01.cf.canopy-cloud.com/sensor/update/';
const SAVE_SENSOR = 'http://codex-iot.apps.eu01.cf.canopy-cloud.com/sensor/save';
const GET_SENSOR_BY_CURRENT_ID = 'http://codex-iot.apps.eu01.cf.canopy-cloud.com/sensor/getallsensorbycustomerid/'
const GET_SENSOR_BY_USER_ID = 'http://codex-iot.apps.eu01.cf.canopy-cloud.com/sensorusermap/getSensorbyUser/'

const ACTIVATE_ASSET = 'http://codex-iot.apps.eu01.cf.canopy-cloud.com/Asset/updateActiveState/';
const INACTIVE_ASSET = 'http://codex-iot.apps.eu01.cf.canopy-cloud.com/Asset/deleteAssetbyId/';
const UPDATE_ASSET = 'http://codex-iot.apps.eu01.cf.canopy-cloud.com/Asset/updateAsset';
const SAVE_ASSET = 'http://codex-iot.apps.eu01.cf.canopy-cloud.com/Asset/addAsset';
const GET_ASSET_BY_CURRENT_ID = 'http://codex-iot.apps.eu01.cf.canopy-cloud.com/Asset/getallassetbycustid/'
const GET_ASSET_BY_USER_ID='http://codex-iot.apps.eu01.cf.canopy-cloud.com/assetusermap/getAssetbyUserID/' 




/* New String JS end */