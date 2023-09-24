package com.example.androidassignment.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.androidassignment.R
import com.example.androidassignment.api.ViewModel.FileInfoViewModel
import com.example.androidassignment.utilities.ResultType
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private  val viewModel:FileInfoViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchAndObserve()
    }

    private fun fetchAndObserve() {
        // Observe the LiveData from the ViewModel
        viewModel.dataResult.observe(this) { result ->
            when (result) {
                is ResultType.Success -> {
                    // Data loaded successfully, update the adapter
//                    adapter.submitList(result.data)
                    Log.d("MainActivity", "fetchAndObserve: ${result.data}")
                }

                is ResultType.Loading -> {
                    // Show loading indicator or perform other UI updates
                }

                is ResultType.Error -> {
                    // Handle the error, e.g., show an error message
                    val errorMessage = result.message ?: "Unknown error"
                    // Display the error message to the user
                    Log.d("MainActivity", "fetchAndObserve:${result.message} ")
                }
            }
        }

        // Trigger the data loading operation
        viewModel.fetchData()
    }
}