package app.di_v.myvie.service

import app.di_v.myvie.util.TheMovieDbUrl
import app.di_v.myvie.util.tmdbApiKey
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiFactory {

    private val authInterceptor = Interceptor { chain ->
        val newUrl = chain.request().url
            .newBuilder()
            .addQueryParameter("api_key", tmdbApiKey)
            .build()

        val newRequest = chain.request()
            .newBuilder()
            .url(newUrl)
            .build()

        chain.proceed(newRequest)
    }

    private val loggingInterceptor =  HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val tmdbClient = OkHttpClient().newBuilder()
        .addInterceptor(authInterceptor)
        .addInterceptor(loggingInterceptor)
        .build()

    fun retrofit(): Retrofit = Retrofit.Builder()
        .client(tmdbClient)
        .baseUrl(TheMovieDbUrl)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val tmdbApi = retrofit().create(MovieService::class.java)
}
