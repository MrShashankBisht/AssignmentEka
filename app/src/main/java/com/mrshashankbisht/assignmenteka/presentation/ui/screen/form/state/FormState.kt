package com.mrshashankbisht.assignmenteka.presentation.ui.screen.form.state

import com.mrshashankbisht.assignmenteka.data.Model.FormDataModel
import java.util.Date

/**
 * Created by Shashank on 24-05-2024
 */
data class FormState(
    var name: String = "",
    var age: Int = 0,
    var dob: String? = null,
    var address: String? = null,
    var users: MutableList<FormDataModel> = mutableListOf()
) {
    fun toFormDataModel(): FormDataModel {
        return FormDataModel(
            name = name,
            age = age,
            dob = dob?: "",
            address = address?: "")
    }
}
