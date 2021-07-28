package com.example.task.common

object Constant {
    const val GPS = "gps"
    const val RESULT = "result"
    const val TOTAL_STOP = "Total STOP"
    const val GPS_STOP = "GPS STOP"
    const val PIN_STOP = "PIN STOP"
    const val WHAT_PUSH_TO_SERVER = 1
    const val WHAT_RESULT = 2
    const val WHAT_NOTIFY = 3

    const val SHARED_NAME = "sharedName"
    const val SETTING_AGENT = "setting_agent"
    const val URL_LOGIN = "http://onmobi.vn/u/login"

}

object ErrorCode {
    const val API_ERROR = 1 // Api call error (response code is different 200)
}

object ResponseCode {
    const val SUCCESS = "1"
    const val NOT_FOUND = "4"

}

object Api {
    const val DATA = "data"
    const val GET_PARTNER_CODE = "get_partner_code"
    const val GET_DATA = "get_data"
    const val LOG_ACCOUNT = "log_account"
    const val ID = "id"
    const val MSISDN = "msisdn"

    const val PARTNER_CODE = "partner_code"
    const val APP_CODE = "app_code"
    const val LOG_ACTION = "log_action"
    const val LOGIN_STATUS = "login_status"
    const val ACT_START_TIME = "act_start_time"
    const val ACT_END_TIME = "act_end_time"
    const val VIEW_TIME = "view_time"
    const val VIEW_LINK = "view_link"
    const val CHANNEL = "channel"
    const val ON_MOBI = "OnMobi"
    const val GET_SETTING = "get_setting"

    const val LOGIN_ONMOBI = "auth/authorize"


    const val GET_ANONYMOUS_TOKEN = "users/api/v2/users/anonymous_token"

}

object Key {
    const val PARTNER_CODE = "partner_code"
    const val GET_SETTING = "get_setting"
    const val DURATION = "duration"
    const val WAIT_TIME = "waitTime"
    const val ON_MOBI = "OnMobi"
}

object Env {
    const val BASE_URL_PUBLIC = "http://insbay.sigma-solutions.vn/pub/"


    const val GCM_PROJECT_ID = "417654659308"
    const val SOCKET_SERVER_URL = "https://ws.insbay.app/"
    const val BASE_URL_CLOTIFY_ANO = "http://insbay.sigma-solutions.vn/ano/clothes"
    const val BASE_URL_CLOTIFY = "http://insbay.sigma-solutions.vn/clothes"
    const val BASE_URL_CLOTIFY_NMU = "http://insbay.sigma-solutions.vn/nmu/clothes"
    const val BASE_URL_SEARCH_ANO = "http://insbay.sigma-solutions.vn/ano/search"
    const val BASE_URL_SEARCH_NMU = "http://insbay.sigma-solutions.vn/nmu/search"
    const val BASE_URL_SEARCH = "http://insbay.sigma-solutions.vn/search"
    const val BASE_URL_ACCOUNT_NMU = "http://insbay.sigma-solutions.vn/nmu/users"
    const val BASE_URL_ACCOUNT = "http://insbay.sigma-solutions.vn/users/"
    const val BASE_URL_ACCOUNT_ANO = "http://insbay.sigma-solutions.vn/ano/users"
    const val BASE_URL_FEED_ANO = "http://insbay.sigma-solutions.vn/ano/feed"
    const val BASE_URL_FEED = "http://insbay.sigma-solutions.vn/feed"
    const val BASE_URL_FEED_NMU = "http://insbay.sigma-solutions.vn/nmu/feed"
    const val BASE_URL_COMMENT = "http://insbay.sigma-solutions.vn/comments"
    const val BASE_URL_COMMENT_ANO = "http://insbay.sigma-solutions.vn/ano/comments"
    const val BASE_URL_COMMENT_NMU = "http://insbay.sigma-solutions.vn/nmu/comments"

    //url when user login
    const val BASE_URL_FILES = "http://insbay.sigma-solutions.vn/nmu/files"
    const val BASE_URL_ORDER = "http://insbay.sigma-solutions.vn/orders/api/v1/orders"
    const val BASE_URL_ORDER_RATING = "https://api.insbay.app/orders/api/v1/rating"
//    public static final String BASE_URL_ACCOUNT = "https://api.insbay.app/users"
}



