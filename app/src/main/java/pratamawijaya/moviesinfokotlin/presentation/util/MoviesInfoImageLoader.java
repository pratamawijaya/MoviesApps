package pratamawijaya.moviesinfokotlin.presentation.util;

import android.support.annotation.NonNull;
import android.widget.ImageView;

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/15/16
 * Project Name : MoviesInfoKotlin
 */

public interface MoviesInfoImageLoader {
  void downloadImageInto(@NonNull String url, @NonNull ImageView imageView);
}
