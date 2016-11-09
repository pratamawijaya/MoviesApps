package pratamawijaya.moviesinfokotlin.presentation.exception;

import android.app.Application;
import java.net.UnknownHostException;
import javax.inject.Inject;
import pratamawijaya.moviesinfokotlin.R;
import pratamawijaya.moviesinfokotlin.data.exception.NetworkConnectionException;
import pratamawijaya.moviesinfokotlin.presentation.di.scope.ActivityScope;

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/18/16
 * Project Name : MoviesInfoKotlin
 */

@ActivityScope public class ErrorMessageFactory {
  private final Application application;

  @Inject public ErrorMessageFactory(Application application) {
    this.application = application;
  }

  public String create(Throwable exception) {
    String message = application.getString(R.string.app_name);

    if (exception instanceof NetworkConnectionException
        || exception instanceof UnknownHostException) {
      message = application.getString(R.string.network_error_message);
    }

    return message;
  }
}
