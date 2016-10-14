package pratamawijaya.moviesinfokotlin.app;

import android.app.Application;
import pratamawijaya.moviesinfokotlin.data.network.ServiceDependencies;
import pratamawijaya.moviesinfokotlin.domain.executor.PostExecutionThread;
import pratamawijaya.moviesinfokotlin.domain.executor.ThreadExecutor;

/**
 * Created by pratama on 9/30/16.
 */

public interface AppDependencies extends ServiceDependencies {
  Application application();

  ThreadExecutor threadExecutor();

  PostExecutionThread postExecutionThread();
}
