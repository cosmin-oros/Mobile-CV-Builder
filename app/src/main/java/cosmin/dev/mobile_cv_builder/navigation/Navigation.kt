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
            // SplashScreen(navController = navController)
        }

        composable(
            Screen.BasicInfoScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name"){
                    type = NavType.StringType
                    //defaultValue
                    nullable = true
                }
            )
        ) { entry ->
            // BasicInfoScreen(navController = navController, name = entry.arguments?.getString("name"))
        }

        composable(
            Screen.EducationScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name"){
                    type = NavType.StringType
                    //defaultValue
                    nullable = true
                }
            )
        ) { entry ->
            // EducationScreen(navController = navController, name = entry.arguments?.getString("name"))
        }

        composable(
            Screen.ExperienceScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name"){
                    type = NavType.StringType
                    //defaultValue
                    nullable = true
                }
            )
        ) { entry ->
            // ExperienceScreen(navController = navController, name = entry.arguments?.getString("name"))
        }

        composable(
            Screen.ProjectsScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name"){
                    type = NavType.StringType
                    //defaultValue
                    nullable = true
                }
            )
        ) { entry ->
            // ProjectsScreen(navController = navController, name = entry.arguments?.getString("name"))
        }

        composable(
            Screen.SkillsScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name"){
                    type = NavType.StringType
                    //defaultValue
                    nullable = true
                }
            )
        ) { entry ->
            // SkillsScreen(navController = navController, name = entry.arguments?.getString("name"))
        }

        composable(
            Screen.FinalCVScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name"){
                    type = NavType.StringType
                    //defaultValue
                    nullable = true
                }
            )
        ) { entry ->
            // FinalCVScreen(navController = navController, name = entry.arguments?.getString("name"))
        }
    }
}