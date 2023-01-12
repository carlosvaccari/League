package life.league.challenge.kotlin.home.fake

import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import life.league.challenge.kotlin.features.home.data.HomeRepository
import life.league.challenge.kotlin.features.home.data.HomeRepositoryImpl
import life.league.challenge.kotlin.features.home.domain.GetPostsUseCase
import life.league.challenge.kotlin.features.home.injection.HomeModule

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [HomeModule::class]
)
abstract class FakeHomeModule {

    @Binds
    abstract fun provideGetPostsUseCase(fakeGetPostsUseCase: FakeGetPostsUseCase): GetPostsUseCase

    @Binds
    abstract fun provideHomeRepository(homeRepositoryImpl: HomeRepositoryImpl): HomeRepository

}