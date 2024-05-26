package com.mrshashankbisht.assignmenteka.presentation.ui.screen.form.view

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.mrshashankbisht.assignmenteka.data.Model.FormDataModel
import com.mrshashankbisht.assignmenteka.presentation.ui.screen.form.event.FormEvent
import com.mrshashankbisht.assignmenteka.presentation.ui.screen.form.state.FormState
import kotlinx.coroutines.flow.StateFlow

/**
 * Created by Shashank on 24-05-2024
 */

@Composable
fun FormScreen(modifier: Modifier = Modifier, stateFlow: StateFlow<FormState>, formScreenEvent: FormEvent) {

    val state by stateFlow.collectAsState()
    var showDatePicker by remember { mutableStateOf(false) }
    val context = LocalContext.current
    formScreenEvent.getAllData()
    Scaffold( modifier = Modifier.fillMaxSize() ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            TextField(
                value = state.name,
                onValueChange = { formScreenEvent.saveName(it) },
                label = { Text(text = "Name") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = state.age.toString(),
                onValueChange = {
                                formScreenEvent.saveAge(it.toIntOrNull())
                },
                label = { Text(text = "Age") },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number
                ),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = state.dob?: "null",
                onValueChange = {
                                formScreenEvent.saveDob(it)
                },
                label = { Text("Date of Birth") },
                readOnly = true,
                enabled = false,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(true)
                    {
                        showDatePicker = true
                    }
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(value = state.address?: "null", onValueChange = { formScreenEvent.saveAddress(it) }, label = {
                    Text( text = "Address" )
                }, modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    if(state.name.isEmpty()){
                        Toast.makeText(context, "Please enter valid name", Toast.LENGTH_SHORT).show()
                        return@Button
                    }
                    if(state.dob.isNullOrEmpty()) {
                        Toast.makeText(context, "Please enter valid date of birth", Toast.LENGTH_SHORT).show()
                        return@Button
                    }
                    if(state.address.isNullOrEmpty()) {
                        Toast.makeText(context, "Please enter valid address", Toast.LENGTH_SHORT).show()
                        return@Button
                    }
                    if(state.age == 0) {
                        Toast.makeText(context, "Please enter valid age", Toast.LENGTH_SHORT).show()
                        return@Button
                    }
                    formScreenEvent.saveData(state)
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(text = "Submit")
            }
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn {
                items(state.users) { user ->
                    UserItem(user = user, onClick = {
                        Toast.makeText(context, "${it.name} clicked", Toast.LENGTH_SHORT).show()
                    })
                }
            }
        }


        if (showDatePicker) {
            DatePickerDialog(
                onDateSelected = { date ->
                    formScreenEvent.saveDob(date)
                    showDatePicker = false
                },
                onDismissRequest = { showDatePicker = false }
            )
        }
    }
}