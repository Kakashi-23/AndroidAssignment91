package com.example.androidassignment.api

import com.example.androidassignment.api.model.FileInfo
import com.example.androidassignment.utilities.Constants
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(Constants.END_POINT_FOR_FILE_DATA)
    suspend fun fetchData(): Response<FileInfo>
}
