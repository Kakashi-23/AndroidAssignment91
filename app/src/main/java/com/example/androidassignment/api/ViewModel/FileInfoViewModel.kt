package com.example.androidassignment.api.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidassignment.api.model.FileInfo
import com.example.androidassignment.api.repository.FileInfoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.example.androidassignment.utilities.ResultType
import kotlinx.coroutines.launch

@HiltViewModel
class FileInfoViewModel @Inject constructor(private val repository: FileInfoRepository) :ViewModel() {

    val dataResult = MutableLiveData<ResultType<FileInfo?>>()

    fun fetchData() {
        viewModelScope.launch {
            dataResult.value = ResultType.Loading
            val result = repository.fetchData()
            dataResult.value = result
        }
    }
}