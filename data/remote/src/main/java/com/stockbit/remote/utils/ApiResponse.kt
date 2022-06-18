package com.stockbit.remote.utils

class ApiResponse<T>(val status: StatusResponse, val body: T?, val message: String?) {
    companion object {
        fun <T> success(body: T): ApiResponse<T> = ApiResponse(StatusResponse.SUCCESS, body, null)

        fun <T> empty(): ApiResponse<T> = ApiResponse(StatusResponse.EMPTY, null, null)

        fun <T> error(msg: String): ApiResponse<T> = ApiResponse(StatusResponse.ERROR, null, msg)
    }
}

enum class StatusResponse {
    SUCCESS,
    EMPTY,
    ERROR,
}