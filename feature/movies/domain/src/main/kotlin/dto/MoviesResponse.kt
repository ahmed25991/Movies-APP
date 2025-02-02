package dto

data class MoviesResponse(
    val dates :DatesModel?,
    val page :Int?,
    val total_pages :Int?,
    val total_results :Int?,
    val results :List<MovieModel>?
)

data class DatesModel(
    val maximum :String?,
    val minimum :String?,
)


data class MovieModel(
    val adult: Boolean?= null,
    val backdrop_path: String?=null,
    val genre_ids: List<Int>?=null,
    val id: Int?=null,
    val original_language: String?=null,
    val original_title: String?=null,
    val overview: String?=null,
    val popularity: Double?=null,
    val poster_path: String?=null,
    val release_date: String?=null,
    val title: String?=null,
    val video: Boolean?=null,
    val vote_average: Double?=null,
    val vote_count: Int?=null
)