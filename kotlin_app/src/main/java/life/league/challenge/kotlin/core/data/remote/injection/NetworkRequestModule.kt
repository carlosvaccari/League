package life.league.challenge.kotlin.core.data.remote.injection

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import life.league.challenge.kotlin.core.data.remote.RemoteDataSource
import life.league.challenge.kotlin.core.data.remote.RemoteDataSourceImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkRequestModule {

    @Binds
    abstract fun provideRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource
}