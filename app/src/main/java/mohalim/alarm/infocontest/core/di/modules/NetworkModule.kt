package mohalim.alarm.infocontest.core.di.modules

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import mohalim.alarm.infocontest.core.data_source.retrofit.UserInterfaceRetrofit
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideGsonBuilder() : Gson{
        return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    }

    @Singleton
    @Provides
    fun provideRetrofit (@ApplicationContext context: Context) : Retrofit.Builder {
        val client = OkHttpClient.Builder()
            .build()

        return Retrofit.Builder()
            .baseUrl("https://sheets.googleapis.com/v4/spreadsheets/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
    }

    @Provides
    fun provideUserInterfaceRetrofit(retrofit: Retrofit.Builder): UserInterfaceRetrofit{
        return retrofit.build().create(UserInterfaceRetrofit::class.java)
    }

}