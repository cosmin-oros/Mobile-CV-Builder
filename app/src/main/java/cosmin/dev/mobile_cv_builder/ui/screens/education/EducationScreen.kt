package cosmin.dev.mobile_cv_builder.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
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
import cosmin.dev.mobile_cv_builder.ui.screens.education.EducationData
import kotlinx.coroutines.launch

val educationList = mutableListOf<EducationData>()

@Composable
fun EducationScreen(navController: NavController, scaffoldState: ScaffoldState) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val dataStored = StoreData(context)
    var educationNr = 0

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 10.dp)
    ) {
        // make a button here <- Contact Info
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
                navController.navigate(Screen.BasicInfoScreen.route)
            }
        ) {
            Text(text = "<- Contact Info")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Education", fontFamily = FontFamily.Monospace, fontSize = 20.sp)

            Text(text = "2 out of 5", fontFamily = FontFamily.Monospace, fontSize = 12.sp)
        }

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
                if (educationNr < 5) {
                    educationList.add(EducationData(nr = educationNr))
                    educationNr++
                } else {
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar("Too many added")
                    }
                }
            },
        ) {
            // button text
            Text(
                text = "Add Education",
                color = Color.White,
                fontSize = 18.sp
            )
        }

        educationList.forEach { education ->
            EducationFields(education, navController, scaffoldState)
        }

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
                    scope.launch {
                        navController.navigate(Screen.ExperienceScreen.route)
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
}

@Composable
fun EducationFields(educationData: EducationData, navController: NavController, scaffoldState: ScaffoldState) {
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
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val dataStored = StoreData(context)

    Column(

    ) {
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
                    if (university != "" && fieldOfStudy != "" && specialization != "" && graduationDate != "") {
                        //launch the class in a coroutine scope
                        scope.launch {
                            // store the data put into the fields
                            when (educationData.nr) {
                                0 -> {
                                    dataStored.saveUniversity1(university)
                                    dataStored.saveFieldOfStudy1(fieldOfStudy)
                                    dataStored.saveSpecialization1(specialization)
                                    dataStored.saveGraduation1(graduationDate)
                                }
                                1 -> {
                                    dataStored.saveUniversity2(university)
                                    dataStored.saveFieldOfStudy2(fieldOfStudy)
                                    dataStored.saveSpecialization2(specialization)
                                    dataStored.saveGraduation2(graduationDate)
                                }
                                2 -> {
                                    dataStored.saveUniversity3(university)
                                    dataStored.saveFieldOfStudy3(fieldOfStudy)
                                    dataStored.saveSpecialization3(specialization)
                                    dataStored.saveGraduation3(graduationDate)
                                }
                                3 -> {
                                    dataStored.saveUniversity4(university)
                                    dataStored.saveFieldOfStudy4(fieldOfStudy)
                                    dataStored.saveSpecialization4(specialization)
                                    dataStored.saveGraduation4(graduationDate)
                                }
                                4 -> {
                                    dataStored.saveUniversity5(university)
                                    dataStored.saveFieldOfStudy5(fieldOfStudy)
                                    dataStored.saveSpecialization5(specialization)
                                    dataStored.saveGraduation5(graduationDate)
                                }
                            }

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
                    text = "Save",
                    color = Color.White,
                    fontSize = 18.sp
                )
            }

        }
    }
}