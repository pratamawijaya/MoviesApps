package pratamawijaya.moviesinfokotlin.data.feature.movie

import pratamawijaya.moviesinfokotlin.data.model.response.NowPlayingResponse
import retrofit2.http.GET
import rx.Observable

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/11/16
 * Project Name : MoviesInfoKotlin
 */

interface MovieServices {
  @GET("movie/now_playing")
  fun getNowPlaying(): Observable<NowPlayingResponse>
}