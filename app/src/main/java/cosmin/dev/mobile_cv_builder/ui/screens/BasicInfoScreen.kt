package cosmin.dev.mobile_cv_builder.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cosmin.dev.mobile_cv_builder.datastore.StoreData
import cosmin.dev.mobile_cv_builder.navigation.Screen
import kotlinx.coroutines.launch

@Composable
fun BasicInfoScreen(navController: NavController) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val dataStored = StoreData(context)
    val savedSurname = dataStored.getSurname.collectAsState(initial = "")
    val savedName = dataStored.getName.collectAsState(initial = "")

    var surname by remember {
        mutableStateOf("")
    }
    var name by remember {
        mutableStateOf("")
    }
    // implement something to be able to upload photo

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // !!! make the textfields required to be completed
        OutlinedTextField(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxWidth(),
            value = surname,
            onValueChange = { surname = it },
        )

        Spacer(modifier = Modifier.height(120.dp))

        // save button
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(start = 16.dp, end = 16.dp),
            onClick = {
                //launch the class in a coroutine scope
                scope.launch {
                    // store the data put into the fields
                    dataStored.saveSurname(surname)
                    dataStored.saveName(name)

                    // navigate to the next screen
                    navController.navigate(Screen.EducationScreen.route)
                }
            },
        ) {
            // button text
            Text(
                text = "Save",
                color = Color.White,
                fontSize = 18.sp
            )
        }

    }
}