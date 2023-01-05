package cosmin.dev.mobile_cv_builder.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import cosmin.dev.mobile_cv_builder.navigation.Screen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.SplashScreen.route){
        composable(Screen.SplashScreen.route) {
             SplashScreen(navController = navController)
        }

        composable(Screen.BasicInfoScreen.route + "/{name}") {
             BasicInfoScreen(navController = navController)
        }

        composable(Screen.EducationScreen.route + "/{name}") { entry ->
             EducationScreen(navController = navController)
        }

        composable(Screen.ExperienceScreen.route + "/{name}") { entry ->
             ExperienceScreen(navController = navController)
        }

        composable(Screen.ProjectsScreen.route + "/{name}") { entry ->
             ProjectsScreen(navController = navController)
        }

        composable(Screen.SkillsScreen.route + "/{name}") { entry ->
             SkillsScreen(navController = navController)
        }

        composable(Screen.FinalCVScreen.route + "/{name}") { entry ->
             FinalCVScreen(navController = navController)
        }
    }
}