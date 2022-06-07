package com.zai.movieku.network

import java.io.Serializable

data class Movie(val title:String,
                 val poster_path:String,
                 val release_date:String,
                 val vote_average:String,
                 val vote_count:Int,
                 val overview: String
) : Serializable {}
data class MoviesResponse(val page:Int,
                          val results:List<Movie>,
                          val total_pages:Int,
                          val total_results:Int){}

data class Tv(val original_name:String,
                 val poster_path:String,
                 val first_air_date:String,
                 val vote_average:String,
                 val vote_count:Int,
                 val overview: String
) : Serializable {}
data class TvResponse(val page:Int,
                          val results:List<Tv>,
                          val total_pages:Int,
                          val total_results:Int){}