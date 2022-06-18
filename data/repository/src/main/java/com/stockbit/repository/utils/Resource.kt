package com.stockbit.repository.utils

data class Resource<out T>(val status: Status, val data: T?, val error: String?) {
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(
                Status.SUCCESS,
                data,
                null
            )
        }

        fun <T> error(error: String?, data: T?): Resource<T> {
            return Resource(
                Status.ERROR,
                data,
                error
            )
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(
                Status.LOADING,
                data,
                null
            )
        }

        fun <T> empty(data: T?): Resource<T> {
            return Resource(
                Status.EMPTY,
                null,
                null
            )
        }
    }

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING,
        EMPTY
    }
}