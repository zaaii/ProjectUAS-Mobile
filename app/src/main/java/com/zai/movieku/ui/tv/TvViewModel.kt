package com.zai.movieku.ui.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zai.movieku.network.Tv
import com.zai.movieku.network.TvApi
import kotlinx.coroutines.launch

enum class TvApiStatus { LOADING, ERROR, DONE }

class TvViewModel: ViewModel(){

    private val _status = MutableLiveData<TvApiStatus>()
    val status: LiveData<TvApiStatus> = _status

    private val _tvs = MutableLiveData<List<Tv>>()
    val tvs: LiveData<List<Tv>> = _tvs

    private val _tv = MutableLiveData<Tv>()
    val tv: LiveData<Tv> = _tv

    fun listToString(list: List<String>): String {
        return list.joinToString("\n")
    }

    fun getTvList() {
        viewModelScope.launch {
            _status.value = TvApiStatus.LOADING
            try {
                _tvs.value = TvApi.retrofitService.getTv().await().results
                _status.value = TvApiStatus.DONE
            } catch (e: Exception) {
                _tvs.value = listOf()
                _status.value = TvApiStatus.ERROR
            }
        }
    }

    fun onMovieClicked(tv: Tv) {
        _tv.value = tv
    }
}