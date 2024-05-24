package com.mrshashankbisht.assignmenteka.presentation.ui.screen.form.viewmodel

import androidx.lifecycle.ViewModel
import com.mrshashankbisht.assignmenteka.presentation.ui.screen.form.event.FormEvent
import com.mrshashankbisht.assignmenteka.presentation.ui.screen.form.state.FormState

/**
 * Created by Shashank on 24-05-2024
 */
class FormViewModel : ViewModel(), FormEvent {

    override fun saveData(formState: FormState): Boolean {
        TODO("Not yet implemented")
    }

    override fun saveName(name: String) {
        TODO("Not yet implemented")
    }

    override fun saveAge(age: Int) {
        TODO("Not yet implemented")
    }

    override fun saveAddress(address: String) {
        TODO("Not yet implemented")
    }

    override fun saveDob(dob: String) {
        TODO("Not yet implemented")
    }
}