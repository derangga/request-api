package com.requestapi.model

import com.google.gson.annotations.SerializedName

data class Tv(

	@SerializedName("poster_path")
	val posterPath: String? = "",

	@SerializedName("original_name")
	val originalName: String? = "",

	@SerializedName("popularity")
	val popularity: Double? = 0.0,

	@SerializedName("vote_average")
	val voteAverage: Double? = 0.0,

	@SerializedName("name")
	val name: String? = "",

	@SerializedName("id")
	val id: Int? = 0,

	@SerializedName("vote_count")
	val voteCount: Int? = 0
)