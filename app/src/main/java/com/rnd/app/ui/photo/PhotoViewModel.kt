package com.rnd.app.ui.photo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rnd.domain.core.ResultModel
import com.rnd.domain.interactor.Interactor
import com.rnd.domain.model.Photo
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

class PhotoViewModel : ViewModel(), KoinComponent {

    private val interactor: Interactor by inject()

    private val _items = MutableLiveData<ResultModel<List<Photo>>>()
    val items = _items

    fun getPhotos(albumId: Int) {
        viewModelScope.launch {
            interactor.getPhotos(albumId).collect {
                items.value = it
            }
        }
    }
}
