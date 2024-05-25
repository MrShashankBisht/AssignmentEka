package com.mrshashankbisht.assignmenteka.presentation.ui.screen.form.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrshashankbisht.assignmenteka.data.Model.FormDataModel
import com.mrshashankbisht.assignmenteka.domain.FormRepository
import com.mrshashankbisht.assignmenteka.presentation.ui.screen.form.event.FormEvent
import com.mrshashankbisht.assignmenteka.presentation.ui.screen.form.state.FormState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Shashank on 24-05-2024
 */
@HiltViewModel
class FormViewModel @Inject constructor(val formRepository: FormRepository) : ViewModel(), FormEvent {

    private val _state = MutableStateFlow(FormState())
    val state = _state.asStateFlow()
    override fun saveData(formState: FormState) {
        viewModelScope.launch {
            CoroutineScope(Dispatchers.IO).launch {
                val id = formRepository.saveForm(formState.toFormDataModel())
                _state.update {
                    val list = it.users
                    list.add(FormDataModel(name = formState.name, age = formState.age, address = formState.address?: "", dob = formState.dob?: ""))
                    it.copy(name = "", age = 0, address = "", dob = "", users = list)
                }
            }
        }
    }

    override fun saveName(name: String) {
        _state.update {
            it.copy(name = name)
        }
    }

    override fun saveAge(age: Int?) {
        if(age != null) {
            _state.update {
                it.copy(age = age)
            }
        }
    }

    override fun saveAddress(address: String) {
        _state.update {
            it.copy(address = address)
        }
    }

    override fun saveDob(dob: String) {
        _state.update {
            it.copy(dob = dob)
        }
    }

    override fun getAllData() {
        viewModelScope.launch {
            CoroutineScope(Dispatchers.IO).launch {
                val data = formRepository.getAllForm()
                _state.update {
                    val list = it.users
                    list.addAll(data.toList())
                    it.copy(name = "", age = 0, address = "", dob = "", users = list)
                }
            }
        }
    }
}