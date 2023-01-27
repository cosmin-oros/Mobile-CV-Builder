package cosmin.dev.mobile_cv_builder.ui.screens.education

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.util.*

data class EducationData (
    var universityName: String = "",
    var fieldOfStudy: String = "",
    var specialization: String = "",
    var startDate: String = "",
    var endDate: String = "",
    var nr: Int
)
