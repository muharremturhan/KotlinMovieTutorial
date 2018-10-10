package com.kotlinmovietutorial.vo

import com.kotlinmovietutorial.vo.Status.SUCCESS
import com.kotlinmovietutorial.vo.Status.LOADING
import com.kotlinmovietutorial.vo.Status.ERROR

data class Resource<out T>(val status:Status,val data: T?,val message:String?) {
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(SUCCESS, data, null)
        }

        fun <T> error(msg: String): Resource<T> {
            return Resource(ERROR, null, msg)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(LOADING, data, null)
        }
    }
}