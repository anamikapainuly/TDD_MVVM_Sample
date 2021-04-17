package com.anupras.apl.tddmvvmsample.data

import com.anupras.apl.tddmvvmsample.BuildConfig
import com.anupras.apl.tddmvvmsample.data.remote.response.ImageResponse
import com.anupras.apl.tddmvvmsample.data.remote.response.ImageResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Anamika Painuly on 17/04/21.
 */
interface PixabayAPI  {

    @GET("/api/")
    suspend fun searchForImage(
        @Query("q") searchQuery: String,
        @Query("key") apiKey: String = BuildConfig.API_KEY
    ): Response<ImageResponse>
}