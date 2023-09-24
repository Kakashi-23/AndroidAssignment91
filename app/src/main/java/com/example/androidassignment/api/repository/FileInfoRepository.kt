package com.example.androidassignment.api.repository

import com.example.androidassignment.api.ApiService
import com.example.androidassignment.api.model.FileInfo
import com.example.androidassignment.utilities.ResultType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FileInfoRepository (private val apiService: ApiService) {
    suspend fun fetchData():ResultType<FileInfo?>{
        return try {
            val response = withContext(Dispatchers.IO) {
                apiService.fetchData()
            }
            if (response.isSuccessful) {
                ResultType.Success(response.body())
            } else {
                ResultType.Error("Failed to fetch data")
            }
        } catch (e: Exception) {
            ResultType.Error(e.localizedMessage ?: "Unknown error")
        }
    }
}