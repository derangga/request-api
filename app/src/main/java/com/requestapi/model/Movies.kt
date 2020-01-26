package com.requestapi.model

import com.google.gson.annotations.SerializedName

data class Movies(


	@SerializedName("title")
	val title: String? = "",

	@SerializedName("poster_path")
	val posterPath: String? = "",

	@SerializedName("release_date")
	val releaseDate: String? = "",

	@SerializedName("popularity")
	val popularity: Double? = 0.0,

	@SerializedName("vote_average")
	val voteAverage: Double? = 0.0,

	@SerializedName("id")
	val id: Int? = 0,

	@SerializedName("vote_count")
	val voteCount: Int? = 0
)