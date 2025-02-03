package repository

import com.etisalattask.movies.common.data.remote.BaseRepository
import com.etisalattask.movies.common.data.remote.di.IoDispatcher
import com.etisalattask.movies.core.Result
import dto.MovieDetailsResponse
import dto.MoviesResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import repo.MoviesRepository
import service.MoviesService
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val moviesService: MoviesService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : MoviesRepository, BaseRepository() {

    override fun fetchMovies(currentPage: Int?, pageType: String?): Flow<Result<MoviesResponse, String>> {
        return safeApiCall {
            moviesService.fetchMovies(page = currentPage, pageType = pageType)
        }.flowOn(ioDispatcher)
    }

    override fun fetchMovieDetails(movieId: Int?): Flow<Result<MovieDetailsResponse, String>> {
        return safeApiCall {
            moviesService.fetchMovieDetails(movieId = movieId)
        }.flowOn(ioDispatcher)
    }
}
