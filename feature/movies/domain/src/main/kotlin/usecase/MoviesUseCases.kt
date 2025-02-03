package usecase

import com.etisalattask.movies.core.FlowResult
import repo.MoviesRepository
import javax.inject.Inject

class DisplayMoviesUseCase @Inject constructor(private val repo: MoviesRepository) {
    operator fun invoke(currentPage: Int?,pageType:String?): FlowResult<dto.MoviesResponse, String> =
        repo.fetchMovies(currentPage = currentPage,pageType =pageType)
}



class MovieDetailsUseCase @Inject constructor(private val repo: MoviesRepository) {
    operator fun invoke(movieId: Int?): FlowResult<dto.MovieDetailsResponse, String> =
        repo.fetchMovieDetails(movieId = movieId)
}