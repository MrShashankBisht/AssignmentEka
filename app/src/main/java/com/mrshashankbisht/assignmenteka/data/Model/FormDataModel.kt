package com.mrshashankbisht.assignmenteka.data.Model

import com.mrshashankbisht.assignmenteka.data.source.local.FormEntity
import com.mrshashankbisht.assignmenteka.presentation.ui.screen.form.state.FormState

/**
 * Created by Shashank on 24-05-2024
 */
data class FormDataModel(
    val name: String,
    var age: Int,
    var dob: String,
    var address: String,
) {
    fun toEntity(): FormEntity {
        return FormEntity(name = this.name, age = this.age, dob = this.dob, address = this.address)
    }

    fun toFormState(): FormState {
        return FormState(name = this.name, age = this.age, dob = this.dob, address = this.address)
    }
}
