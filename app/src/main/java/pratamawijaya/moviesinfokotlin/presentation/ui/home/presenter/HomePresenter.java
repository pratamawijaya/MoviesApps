package pratamawijaya.moviesinfokotlin.presentation.ui.home.presenter;

import pratamawijaya.moviesinfokotlin.domain.exception.ErrorBundle;

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/15/16
 * Project Name : MoviesInfoKotlin
 */

public interface HomePresenter {
  void loadItemHome(final boolean isUpdate);

  void showError(Throwable throwable);

  void showErrorMessage(ErrorBundle errorBundle);
}
