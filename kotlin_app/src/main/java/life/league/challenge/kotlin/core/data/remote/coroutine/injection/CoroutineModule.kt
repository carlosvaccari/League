package life.league.challenge.kotlin.core.data.remote.coroutine.injection

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import life.league.challenge.kotlin.core.data.remote.coroutine.CoroutineDispatchProvider
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class CoroutineModule {

    @Singleton
    @Provides
    fun provideCoroutineContextProvider(): CoroutineDispatchProvider {
        return CoroutineDispatchProvider.CoroutineDispatchers()
    }
}