package cosmin.dev.mobile_cv_builder.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cosmin.dev.mobile_cv_builder.datastore.StoreData
import cosmin.dev.mobile_cv_builder.navigation.Screen
import kotlinx.coroutines.launch

@Composable
fun ExperienceScreen(navController: NavController, scaffoldState: ScaffoldState) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val dataStored = StoreData(context)

    // !!! make it possible to store multiple jobs
    var company by remember {
        mutableStateOf("")
    }
    var jobTitle by remember {
        mutableStateOf("")
    }
    var startDate by remember {
        mutableStateOf("")
    }
    var endDate by remember {
        mutableStateOf("")
    }
    // implement something to be able to upload photo

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 10.dp)
    ) {
        // make a button here <- Education
        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Transparent,
                contentColor = Color.LightGray
            ),
            modifier = Modifier
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Transparent
                        ),
                        startX = 150f
                    )

                ),
            onClick = {
                navController.navigate(Screen.EducationScreen.route)
            }
        ) {
            Text(text = "<- Education")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Experience", fontFamily = FontFamily.Monospace, fontSize = 20.sp)

            Text(text = "3 out of 5", fontFamily = FontFamily.Monospace, fontSize = 12.sp)
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
                Text(text = "Name of the company", style = MaterialTheme.typography.h5)

                Spacer(modifier = Modifier.height(4.dp))

                // !!! make the textfields required to be completed
                OutlinedTextField(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp)
                        .fillMaxWidth(),
                    value = company,
                    onValueChange = { company = it },
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
                Text(text = "Job title", style = MaterialTheme.typography.h5)

                Spacer(modifier = Modifier.height(4.dp))

                // !!! make the textfields required to be completed
                OutlinedTextField(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp)
                        .fillMaxWidth(),
                    value = jobTitle,
                    onValueChange = { jobTitle = it },
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
                Text(text = "Start date", style = MaterialTheme.typography.h5)

                Spacer(modifier = Modifier.height(4.dp))

                // !!! make the textfields required to be completed
                OutlinedTextField(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp)
                        .fillMaxWidth(),
                    value = startDate,
                    onValueChange = { startDate = it },
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
                Text(text = "End date", style = MaterialTheme.typography.h5)

                Spacer(modifier = Modifier.height(4.dp))

                // !!! make the textfields required to be completed
                OutlinedTextField(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp)
                        .fillMaxWidth(),
                    value = endDate,
                    onValueChange = { endDate = it },
                )
            }

        }

        // !!! button to add another job

        Spacer(modifier = Modifier.height(120.dp))

        // save button
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Transparent,
                    contentColor = Color.LightGray
                ),
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(60.dp)
                    .border(
                        width = 5.dp,
                        brush = Brush.horizontalGradient(
                            listOf(
                                Color.LightGray,
                                Color.DarkGray
                            )
                        ),
                        shape = RoundedCornerShape(15.dp)
                    )
                    .padding(start = 16.dp, end = 16.dp)
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Transparent
                            ),
                            startX = 150f
                        )
                    ),
                onClick = {
                    if (company != "" && jobTitle != "" && startDate != "" && endDate != "") {
                        //launch the class in a coroutine scope
                        scope.launch {
                            // store the data put into the fields
                            dataStored.saveCompany(company)
                            dataStored.saveJob(jobTitle)
                            dataStored.saveStartDate(startDate)
                            dataStored.saveEndDate(endDate)

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
                    text = "Projects ->",
                    color = Color.White,
                    fontSize = 18.sp
                )
            }

        }

    }
}