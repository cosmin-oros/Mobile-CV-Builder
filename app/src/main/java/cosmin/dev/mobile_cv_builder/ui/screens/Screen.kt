package cosmin.dev.mobile_cv_builder.ui.screens

const val MACROS_ARGUMENT_KEY = "id"

sealed class Screen(val route: String){
    object SplashScreen: Screen("splash_screen")
    object BasicInfoScreen: Screen("basic_info_screen")
    object EducationScreen: Screen("education_screen")
    object ExperienceScreen: Screen("experience_screen")
    object ProjectsScreen: Screen("projects_screen")
    object SkillsScreen: Screen("skills_screen")

    /*  display final CV Screen and have a choice of changing the design  */
    object FinalCVScreen: Screen("final_cv_screen")

    /*  Use this when you have to pass arguments between screens    */
    fun withArgs(vararg args: String): String{
        return buildString {
            append(route)
            args.forEach { arg->
                append("/$arg")
            }
        }
    }
}