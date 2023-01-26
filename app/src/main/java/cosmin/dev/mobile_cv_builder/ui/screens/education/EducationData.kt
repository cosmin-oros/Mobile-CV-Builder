package cosmin.dev.mobile_cv_builder.ui.screens.education

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.util.*

data class EducationData @RequiresApi(Build.VERSION_CODES.O) constructor(
    var universityName: String = "",
    var fieldOfStudy: String = "",
    var specialization: String = "",
    var startDate: Date,
    var endDate: Date
)
