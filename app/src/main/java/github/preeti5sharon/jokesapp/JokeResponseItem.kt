package github.preeti5sharon.jokesapp


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class JokeResponseItem(
    val id: Int,
    val punchline: String,
    val setup: String,
    val type: String
)