package com.mrshashankbisht.assignmenteka.presentation.ui.screen.form.event

import com.mrshashankbisht.assignmenteka.presentation.ui.screen.form.state.FormState

/**
 * Created by Shashank on 24-05-2024
 */
interface FormEvent {
    fun saveData(formState: FormState) : Boolean
    fun saveName(name: String)
    fun saveAge(age: Int)
    fun saveAddress(address: String)
    fun saveDob(dob: String)
}