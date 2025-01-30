package usecase

import com.etisalattask.movies.core.FlowResult
import dto.AppConfigModel
import repository.SplashRepository
import javax.inject.Inject

class SplashUseCase @Inject constructor(private val splashRepository: SplashRepository) {
    operator fun invoke(): FlowResult<AppConfigModel, String> = splashRepository.getAppConfigurations()
}