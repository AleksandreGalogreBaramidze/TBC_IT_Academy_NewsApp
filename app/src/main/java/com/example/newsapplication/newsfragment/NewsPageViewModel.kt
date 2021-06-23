package com.example.newsapplication.newsfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapplication.model.SpaceNewsModel
import com.example.newsapplication.retrofit.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsPageViewModel : ViewModel() {
    private val newsLiveData = MutableLiveData<List<SpaceNewsModel>>().apply {
        mutableListOf<SpaceNewsModel>()
    }
    val newsLiveData_: LiveData<List<SpaceNewsModel>> = newsLiveData
    fun init() {
        CoroutineScope(Dispatchers.IO).launch {
            getImage()
        }
    }
    private suspend fun getImage() {
        val result = RetrofitInstance.Instance.getResponse()
        if (result.isSuccessful) {
            val items = result.body()
            newsLiveData.postValue(items)
        }
    }
}