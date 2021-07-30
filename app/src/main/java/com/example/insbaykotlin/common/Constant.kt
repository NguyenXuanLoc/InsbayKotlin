package com.example.insbaykotlin.common

object Constant {
    const val PAGE_SIZE = 10;
    const val SHARED_NAME = "SHARED_NAME";

}

object PrefCode {
    const val PREF_TOKEN = "PREF_TOKEN"
}

object ErrorCode {
    const val API_ERROR = 1 // Api call error (response code is different 200)
}

object ResponseCode {
    const val SUCCESS = "1"
    const val NOT_FOUND = "4"
}

object Api {
    const val GET_ANONYMOUS_TOKEN = "users/api/v2/users/anonymous_token"
    const val SEARCH_LOOK = "clothes/api/v2/outfits/list"
}
object Param{
    const val USER_TYPE = "user_type"
    const val LIMIT = "limit"
    const val PAGE = "page"
    const val ACCESS_TOKEN = "access_token"

}
object Env {
    const val BASE_URL_PUBLIC = "http://insbay.sigma-solutions.vn/pub/"
    const val BASE_URL_ANO = "http://insbay.sigma-solutions.vn/ano/"
}



