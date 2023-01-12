package life.league.challenge.kotlin.features.home.injection

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import life.league.challenge.kotlin.features.home.data.HomeRepository
import life.league.challenge.kotlin.features.home.data.HomeRepositoryImpl
import life.league.challenge.kotlin.features.home.domain.GetPostsUseCase
import life.league.challenge.kotlin.features.home.domain.GetPostsUseCaseImpl

@Module
@InstallIn(ViewModelComponent::class)
abstract class HomeModule {
    @Binds
    abstract fun provideGetPostsUseCase(getPostsUseCaseImpl: GetPostsUseCaseImpl): GetPostsUseCase

    @Binds
    abstract fun provideHomeRepository(homeRepositoryImpl: HomeRepositoryImpl): HomeRepository
}