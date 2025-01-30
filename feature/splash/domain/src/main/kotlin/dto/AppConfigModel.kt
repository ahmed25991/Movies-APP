package dto

data class AppConfigModel(
    val status :String?,
    val id :Int?,
    val versions: AppVersion?,
    val about: String?,
    val terms: String?,
    val privacy: String?,
)


data class AppVersion(val latest :String?)