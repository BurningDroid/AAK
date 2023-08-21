package dev.aaron.aak.base

import androidx.annotation.Keep
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

@Keep
abstract class BaseViewModel: ViewModel() {

    var showProgressBar: Boolean by mutableStateOf(false)
        protected set

    private val _toastMessage = MutableSharedFlow<TextWrapper>()
    val toastMessage = _toastMessage.asSharedFlow()

    private val _navTo = MutableSharedFlow<NavTo>()
    val navTo: SharedFlow<NavTo> = _navTo

    protected fun showToast(textWrapper: TextWrapper) {
        viewModelScope.launch {
            _toastMessage.emit(textWrapper)
        }
    }

    fun navigate(navTo: NavTo) {
        viewModelScope.launch {
            _navTo.emit(navTo)
        }
    }
}