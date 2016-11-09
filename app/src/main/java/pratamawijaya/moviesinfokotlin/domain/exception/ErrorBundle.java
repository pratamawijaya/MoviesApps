package pratamawijaya.moviesinfokotlin.domain.exception;

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/18/16
 * Project Name : MoviesInfoKotlin
 */

public interface ErrorBundle {
  Throwable getException();

  String getErrorMessage();
}
