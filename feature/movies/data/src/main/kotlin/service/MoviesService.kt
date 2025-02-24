package service


import dto.MovieDetailsResponse
import dto.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesService {

    @GET("movie/{pageType}")
    suspend fun fetchMovies(
        @Path("pageType") pageType: String?,
        @Query("language") language: String = "en-US",
        @Query("page") page: Int?,
    ): Response<MoviesResponse>



    @GET("movie/{movieId}")
    suspend fun fetchMovieDetails(
        @Path("movieId") movieId: Int?,
        @Query("language") language: String = "en-US"
    ): Response<MovieDetailsResponse>

}
