package com.mrshashankbisht.assignmenteka.presentation.ui.screen.form.view

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.mrshashankbisht.assignmenteka.presentation.ui.screen.form.event.FormEvent
import com.mrshashankbisht.assignmenteka.presentation.ui.screen.form.state.FormState
import kotlinx.coroutines.flow.StateFlow

/**
 * Created by Shashank on 24-05-2024
 */

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FormScreen(modifier: Modifier = Modifier, stateFlow: StateFlow<FormState>, formScreenEvent: FormEvent) {
    val state by stateFlow.collectAsState()
    var showDatePicker by remember { mutableStateOf(false) }

    Scaffold( modifier = Modifier.fillMaxSize() ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            TextField(
                value = state.name,
                onValueChange = { formScreenEvent.saveName(it) },
                label = { Text("Name") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = state.age.toString(),
                onValueChange = {
                                formScreenEvent.saveAge(it.toInt())
                },
                label = { Text("Age") },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                ),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = state.dob,
                onValueChange = { },
                label = { Text("Date of Birth") },
                readOnly = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { showDatePicker = true }
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = state.address,
                onValueChange = { formScreenEvent.saveAddress(it) },
                label = { Text("Address") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    // Handle form submission
                    Toast.makeText(LocalContext.current, "Form Submitted", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(text = "Submit")
            }
        }

        if (showDatePicker) {
            DatePickerDialog(
                onDateSelected = { date ->
                    state.dob = date
                    showDatePicker = false
                },
                onDismissRequest = { showDatePicker = false }
            )
        }
    }
}