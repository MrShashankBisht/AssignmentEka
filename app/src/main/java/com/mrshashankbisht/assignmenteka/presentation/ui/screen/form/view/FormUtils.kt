package com.mrshashankbisht.assignmenteka.presentation.ui.screen.form.view

import android.widget.DatePicker
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.mrshashankbisht.assignmenteka.data.Model.FormDataModel
import com.mrshashankbisht.assignmenteka.presentation.ui.screen.form.state.FormState
import java.text.Normalizer.Form
import java.util.Calendar

/**
 * Created by Shashank on 24-05-2024
 */

@Composable
fun DatePickerDialog(onDateSelected: (String) -> Unit, onDismissRequest: () -> Unit) {
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(dismissOnClickOutside = false)
    ){
        AndroidView(
            { context ->
                DatePicker(context).apply {
                    init(year, month, day) { _, selectedYear, selectedMonth, selectedDay ->
                        val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                        onDateSelected(selectedDate)
                    }
                }
            },
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun UserItem(user: FormDataModel, onClick: (FormDataModel) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick(user) }
            .padding(16.dp)
    ) {
        Text(text = "Name: ${user.name}")
        Text(text = "Age: ${user.age}")
        Text(text = "Email: ${user.dob}")
    }
}