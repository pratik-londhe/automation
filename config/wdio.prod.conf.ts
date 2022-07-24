import {config as baseConfig} from "../wdio.conf"
export const config = Object.assign(baseConfig, {
    // All PRODUCTION environment specific key value pairs
    Environment: "PRODUCTION",
    Greenroom_Ui_Host: "https://greenroom.brand.live",
    Greenroom_Api_Host: "https://api-greenroom.brand.live",
    Greenroom_Sync_Host: "https://greenroom-sync.brandlive.com",
    Streams_Ui_Host: "https://admin.brandlive.com",
    Streams_Api_Host: "https://events-api.brandlive.com",
    Streams_Api_Uploads: "https://uploads.brandlive.com",
    Streams_Live_Api_Host: "https://api-hv.brandlive.com",
    Username: "brandlive.automation1@gmail.com",
    Password: "Brandlive123!",
    ChannelName: "Brandlive QA Automation I",
    Channel_Live_Host: "qauto1.brand.live",
    Channel_Host: "qauto1.brandlive.com",
    MySql_DB_Server: "165.22.144.60",
    MySql_DB_Port: 3306,
    MySql_DB_Name: "ybl",
    MySql_DB_User: "bldashdev",
    MySql_DB_Password: "pitch-twitter-flipper",
    PG_DB_Server: "postgresql-qa-serverless-cluster.cluster-cqrxncnqudqa.us-west-2.rds.amazonaws.com",
    PG_DB_Port: 5432,
    PG_DB_Name: "bl",
    PG_DB_User: "bldashdev",
    PG_DB_Password: "teZRexoGAvJraZ4L0Nx1"
})