package com.richuff.rcclient.core.network.retrofit

import com.richuff.rcclient.core.design.model.Sheet
import com.richuff.rcclient.core.design.model.Song
import com.richuff.rcclient.core.design.model.response.NetWorkResponse
import com.richuff.rcclient.core.design.model.response.PageListResponse
import com.richuff.rcclient.core.design.model.response.ViewData
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface NetworkApiService {

    @GET("v1/songs/page")
    suspend fun songs(): NetWorkResponse<PageListResponse<Song>>

    @GET("v1/songs/info")
    suspend fun songDetail(@Query(value = "id") id:String): NetWorkResponse<Song>

    @GET("v1/indexes")
    suspend fun indexes(@Query(value = "app") app: Int): NetWorkResponse<PageListResponse<ViewData>>

    @GET("v1/sheets/info")
    suspend fun sheetDetail(@Query(value = "id")id: String): NetWorkResponse<Sheet>
}