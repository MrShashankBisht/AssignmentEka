package com.mrshashankbisht.assignmenteka.data.source.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mrshashankbisht.assignmenteka.data.Model.FormDataModel

@Entity
data class FormEntity(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "age") val age: Int?,
    @ColumnInfo(name = "dob") val dob: String?,
    @ColumnInfo(name = "address") val address: String?,
) {
    override fun toString(): String {
        return "FormEntity(uid=$uid, name=$name, age=$age, dob=$dob, address=$address)"
    }
    fun toForm(): FormDataModel {
        return FormDataModel(name?: "", age?: 0, dob?: "", address?:"")
    }

}