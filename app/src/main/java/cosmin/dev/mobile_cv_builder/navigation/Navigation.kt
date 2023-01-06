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

        composable(Screen.BasicInfoScreen.route) {
             BasicInfoScreen(navController = navController)
        }

        composable(Screen.EducationScreen.route) {
             EducationScreen(navController = navController)
        }

        composable(Screen.ExperienceScreen.route) {
             ExperienceScreen(navController = navController)
        }

        composable(Screen.ProjectsScreen.route) {
             ProjectsScreen(navController = navController)
        }

        composable(Screen.SkillsScreen.route) {
             SkillsScreen(navController = navController)
        }

        composable(Screen.FinalCVScreen.route) {
             FinalCVScreen(navController = navController)
        }
    }
}