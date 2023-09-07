package github.preeti5sharon.jokesapp

class JokeRepository(private val service: JokeService) {
    suspend fun getJokes() = service.getJokes()
}
