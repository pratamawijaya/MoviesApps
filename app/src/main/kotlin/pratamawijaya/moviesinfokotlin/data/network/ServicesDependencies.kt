package pratamawijaya.moviesinfokotlin.data.network

import pratamawijaya.moviesinfokotlin.data.feature.movie.MovieServices

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/11/16
 * Project Name : MoviesInfoKotlin
 */

interface ServicesDependencies {
  fun movieServices(): MovieServices
}