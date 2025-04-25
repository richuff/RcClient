package com.richuff.rcclient.core.design.model.response

import kotlinx.serialization.Serializable

@Serializable
data class NetWorkResponse<T> (
    val data:T? = null,
    val status:Int,
    val message:String? = null
)