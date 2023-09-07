package github.preeti5sharon.jokesapp

import retrofit2.Response
import retrofit2.http.GET

interface JokeService {
    @GET("/random_ten")
    suspend fun getJokes(): Response<List<JokeResponseItem>>
}