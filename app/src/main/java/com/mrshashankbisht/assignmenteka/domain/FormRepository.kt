package com.mrshashankbisht.assignmenteka.domain

import com.mrshashankbisht.assignmenteka.data.Model.FormDataModel

/**
 * Created by Shashank on 24-05-2024
 */
interface FormRepository {
    suspend fun saveForm(form: FormDataModel) : Long
    suspend fun getAllForm() : List<FormDataModel>
}