package repo

import com.etisalattask.movies.core.FlowResult


interface MoviesRepository {

    fun fetchMovies(currentPage: Int?,pageType:String?): FlowResult<dto.MoviesResponse, String>

}