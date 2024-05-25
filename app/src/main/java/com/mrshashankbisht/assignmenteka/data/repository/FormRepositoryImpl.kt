package com.mrshashankbisht.assignmenteka.data.repository

import com.mrshashankbisht.assignmenteka.data.Model.FormDataModel
import com.mrshashankbisht.assignmenteka.data.source.local.AppDatabase
import com.mrshashankbisht.assignmenteka.domain.FormRepository
import javax.inject.Inject

/**
 * Created by Shashank on 24-05-2024
 */
class FormRepositoryImpl @Inject constructor(val db: AppDatabase): FormRepository {
    override suspend fun saveForm(form: FormDataModel): Long {
        return db.userDao().insertAllOne(form.toEntity())
    }

    override suspend fun getAllForm(): List<FormDataModel> {
        return db.userDao().getAll().map { it.toForm() }
    }
}