package com.rnd.app.ui.album

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rnd.domain.core.ResultModel
import com.rnd.domain.interactor.Interactor
import com.rnd.domain.model.Album
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

class AlbumViewModel : ViewModel(), KoinComponent {

    private val interactor: Interactor by inject()

    private val _items = MutableLiveData<ResultModel<List<Album>>>()
    val items = _items

    fun getAlbums() {
        viewModelScope.launch {
            interactor.getAlbums().collect {
                items.value = it
            }
        }
    }
}
