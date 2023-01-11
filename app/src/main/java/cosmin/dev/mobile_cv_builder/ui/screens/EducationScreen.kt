package cosmin.dev.mobile_cv_builder.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
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
fun EducationScreen(navController: NavController, scaffoldState: ScaffoldState) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val dataStored = StoreData(context)

    var university by remember {
        mutableStateOf("")
    }
    var fieldOfStudy by remember {
        mutableStateOf("")
    }
    var specialization by remember {
        mutableStateOf("")
    }
    var graduationDate by remember {
        mutableStateOf("")
    }
    // implement something to be able to upload photo

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // make a button here <- Contact Info

        Row() {
            Text(text = "Education", style = MaterialTheme.typography.h4)

            Spacer(modifier = Modifier.width(16.dp))

            Text(text = "2 out of 5", style = MaterialTheme.typography.h6)
        }

        Card(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .fillMaxWidth(),
            elevation = 2.dp,
            backgroundColor = Color.DarkGray,
            shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        ) {
            // university field
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Name of the university", style = MaterialTheme.typography.h5)

                Spacer(modifier = Modifier.height(4.dp))

                // !!! make the textfields required to be completed
                OutlinedTextField(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp)
                        .fillMaxWidth(),
                    value = university,
                    onValueChange = { university = it },
                )
            }

        }

        Card(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .fillMaxWidth(),
            elevation = 2.dp,
            backgroundColor = Color.DarkGray,
            shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        ) {
            // field of study field
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Field of study", style = MaterialTheme.typography.h5)

                Spacer(modifier = Modifier.height(4.dp))

                // !!! make the textfields required to be completed
                OutlinedTextField(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp)
                        .fillMaxWidth(),
                    value = fieldOfStudy,
                    onValueChange = { fieldOfStudy = it },
                )
            }

        }

        Card(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .fillMaxWidth(),
            elevation = 2.dp,
            backgroundColor = Color.DarkGray,
            shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        ) {
            // phone nr field
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Specialization", style = MaterialTheme.typography.h5)

                Spacer(modifier = Modifier.height(4.dp))

                // !!! make the textfields required to be completed
                OutlinedTextField(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp)
                        .fillMaxWidth(),
                    value = specialization,
                    onValueChange = { specialization = it },
                )
            }

        }

        Card(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .fillMaxWidth(),
            elevation = 2.dp,
            backgroundColor = Color.DarkGray,
            shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        ) {
            // phone nr field
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Graduation date", style = MaterialTheme.typography.h5)

                Spacer(modifier = Modifier.height(4.dp))

                // !!! make the textfields required to be completed
                OutlinedTextField(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp)
                        .fillMaxWidth(),
                    value = graduationDate,
                    onValueChange = { graduationDate = it },
                )
            }

        }

        // !!! button to add another university

        Spacer(modifier = Modifier.height(120.dp))

        // save button
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(start = 16.dp, end = 16.dp),
            onClick = {
                if (university != "" && fieldOfStudy != "" && specialization != "" && graduationDate != "") {
                    //launch the class in a coroutine scope
                    scope.launch {
                        // store the data put into the fields
                        dataStored.saveUniversity(university)
                        dataStored.saveFieldOfStudy(fieldOfStudy)
                        dataStored.saveSpecialization(specialization)
                        dataStored.saveGraduation(graduationDate)

                        // navigate to the next screen
                        navController.navigate(Screen.ExperienceScreen.route)
                    }
                } else {
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar("Complete all the fields")
                    }
                }
            },
        ) {
            // button text
            Text(
                text = "Experience ->",
                color = Color.White,
                fontSize = 18.sp
            )
        }

    }
}