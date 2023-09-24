package com.example.androidassignment.utilities

sealed class ResultType<out T> {
    data class Success<out T>(val data: T) : ResultType<T>()
    data class Error(val message: String) : ResultType<Nothing>()
    object Loading : ResultType<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success -> "Success[data=$data]"
            is Error -> "Error[message=$message]"
            Loading -> "Loading"
        }
    }
}
