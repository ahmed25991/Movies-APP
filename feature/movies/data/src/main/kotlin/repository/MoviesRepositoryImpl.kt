package repository

import com.etisalattask.movies.common.data.remote.di.IoDispatcher
import com.etisalattask.movies.common.data.remote.dto.ErrorResponse
import dto.MoviesResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import com.etisalattask.movies.core.Result
import com.google.gson.Gson
import kotlinx.coroutines.flow.onStart
import repo.MoviesRepository
import service.MoviesService
import javax.inject.Inject


class MoviesRepositoryImpl  @Inject constructor(
    private val moviesService: MoviesService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : MoviesRepository {

    override fun fetchMovies(currentPage: Int?,pageType:String?) =
        flow<Result<MoviesResponse, String>> {
            val response = moviesService.fetchMovies(
                page = currentPage,
                pageType = pageType
            )
            val body = response.body()
            if (response.isSuccessful) {
                if (body != null ) {
                    emit(Result.Success(body))
                }
            } else {
                val errorResponse = Gson().fromJson(response.errorBody()?.string(), ErrorResponse::class.java)
                emit(Result.Fail(message = errorResponse.status_message))
            }
        }.onStart {
            emit(Result.Loading())
        }.catch {
            emit(Result.Fail(message = it.localizedMessage?:"Internal Server Error"))
        }.flowOn(ioDispatcher)




    }

