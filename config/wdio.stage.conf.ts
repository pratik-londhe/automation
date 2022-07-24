import {config as baseConfig} from "../wdio.conf"
export const config = Object.assign(baseConfig, {
    // All STAGE environment specific key value pairs
    Environment: "STAGING",
    Greenroom_Ui_Host: "https://greenroom.brandlive-staging.com",
    Greenroom_Api_Host: "https://greenroom-api.brandlive-staging.com",
    Greenroom_Sync_Host: "https://greenroom-sync.brandlive-staging.com",
    Streams_Ui_Host: "https://admin.brandlive-staging.com",
    Streams_Api_Host: "https://events-api.brandlive-staging.com",
    Streams_Api_Uploads: "https://uploads.brandlive-staging.com",
    Streams_Live_Api_Host: "https://api-hv.brandlive-staging.com",
    Username: "brandlive.automation1@gmail.com",
    Password: "Brandlive123!",
    ChannelName: "Brandlive QA Automation I",
    Channel_Live_Host: "qauto1.brand.live",
    Channel_Host: "qauto1.brandlive-staging.com",
    MySql_DB_Server: "165.22.144.60",
    MySql_DB_Port: "3306",
    MySql_DB_Name: "ybl",
    MySql_DB_User: "bldashdev",
    MySql_DB_Password: "pitch-twitter-flipper",
    PG_DB_Server: "postgresql-qa-serverless-cluster.cluster-cqrxncnqudqa.us-west-2.rds.amazonaws.com",
    PG_DB_Port: "5432",
    PG_DB_Name: "bl",
    PG_DB_User: "bldashdev",
    PG_DB_Password: "teZRexoGAvJraZ4L0Nx1"
})