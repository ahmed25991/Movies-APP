package repository

import com.etisalattask.movies.core.Result
import dto.AppConfigModel
import kotlinx.coroutines.flow.Flow

interface SplashRepository {
    fun getAppConfigurations(): Flow<Result<AppConfigModel, String>>
}