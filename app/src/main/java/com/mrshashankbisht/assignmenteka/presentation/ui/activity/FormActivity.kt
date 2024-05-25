package com.mrshashankbisht.assignmenteka.presentation.ui.activity

import android.os.Bundle
import android.widget.DatePicker
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import com.mrshashankbisht.assignmenteka.presentation.ui.screen.form.view.FormScreen
import com.mrshashankbisht.assignmenteka.presentation.ui.screen.form.viewmodel.FormViewModel
import com.mrshashankbisht.assignmenteka.presentation.ui.theme.AssignmentEkaTheme
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Calendar

@AndroidEntryPoint
class FormActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: FormViewModel = hiltViewModel()
            enableEdgeToEdge()
            AssignmentEkaTheme {
                FormScreen(stateFlow = viewModel.state, formScreenEvent = viewModel)
            }
        }
    }
}

