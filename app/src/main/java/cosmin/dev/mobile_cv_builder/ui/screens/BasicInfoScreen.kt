package cosmin.dev.mobile_cv_builder.ui.screens

import android.widget.GridLayout
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
fun BasicInfoScreen(navController: NavController, scaffoldState: ScaffoldState) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val dataStored = StoreData(context)
//    val savedEmail = dataStored.getEmail.collectAsState(initial = "")
//    val savedName = dataStored.getName.collectAsState(initial = "")
//    this is how to get the values when creating the cv at the end

    var email by remember {
        mutableStateOf("")
    }
    var name by remember {
        mutableStateOf("")
    }
    var phone by remember {
        mutableStateOf("")
    }
    // implement something to be able to upload photo

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row() {
            Text(text = "Contact Info", style = MaterialTheme.typography.h4)

            Spacer(modifier = Modifier.width(16.dp))
            
            Text(text = "1 out of 5", style = MaterialTheme.typography.h6)
        }
        
        Card(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .fillMaxWidth(),
            elevation = 2.dp,
            backgroundColor = Color.DarkGray,
            shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        ) {
            // surname field
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Full Name", style = MaterialTheme.typography.h5)

                Spacer(modifier = Modifier.height(4.dp))

                // !!! make the textfields required to be completed
                OutlinedTextField(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp)
                        .fillMaxWidth(),
                    value = name,
                    onValueChange = { name = it },
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
            // email field
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Email", style = MaterialTheme.typography.h5)

                Spacer(modifier = Modifier.height(4.dp))

                // !!! make the textfields required to be completed
                OutlinedTextField(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp)
                        .fillMaxWidth(),
                    value = email,
                    onValueChange = { email = it },
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
                Text(text = "Mobile Number", style = MaterialTheme.typography.h5)

                Spacer(modifier = Modifier.height(4.dp))

                // !!! make the textfields required to be completed
                OutlinedTextField(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp)
                        .fillMaxWidth(),
                    value = phone,
                    onValueChange = { phone = it },
                )
            }

        }


        Spacer(modifier = Modifier.height(120.dp))

        // save button
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(start = 16.dp, end = 16.dp),
            onClick = {
                if (phone != "" && email != "" && name != "") {
                    //launch the class in a coroutine scope
                    scope.launch {
                        // store the data put into the fields
                        dataStored.saveEmail(email)
                        dataStored.saveName(name)
                        dataStored.savePhone(phone)

                        // navigate to the next screen
                        navController.navigate(Screen.EducationScreen.route)
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
                text = "Education ->",
                color = Color.White,
                fontSize = 18.sp
            )
        }

    }
}