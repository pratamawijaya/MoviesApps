package pratamawijaya.moviesinfokotlin.domain.exception;

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/18/16
 * Project Name : MoviesInfoKotlin
 */

public class DefaultErrorBundle implements ErrorBundle {

  private static final String DEFAULT_ERROR_MSG = "Unknown error";

  private final Throwable exception;

  public DefaultErrorBundle(Throwable exception) {
    this.exception = exception;
  }

  @Override public Throwable getException() {
    return exception;
  }

  @Override public String getErrorMessage() {
    return (exception == null) ? DEFAULT_ERROR_MSG : this.exception.getMessage();
  }
}
