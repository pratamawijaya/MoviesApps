package pratamawijaya.moviesinfokotlin.data.executor

import pratamawijaya.moviesinfokotlin.domain.executor.ThreadExecutor
import java.util.concurrent.*
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/11/16
 * Project Name : MoviesInfoKotlin
 */

/**
 * Decorated [ThreadPoolExecutor]
 */
@Singleton
class JobExecutor @Inject constructor() : ThreadExecutor {

  private val workQueue: BlockingQueue<Runnable>

  private val threadPoolExecutor: ThreadPoolExecutor

  private val threadFactory: ThreadFactory

  init {
    this.workQueue = LinkedBlockingQueue<Runnable>()
    this.threadFactory = JobThreadFactory()
    this.threadPoolExecutor = ThreadPoolExecutor(INITIAL_POOL_SIZE, MAX_POOL_SIZE,
        KEEP_ALIVE_TIME.toLong(), KEEP_ALIVE_TIME_UNIT,
        this.workQueue, this.threadFactory)
  }

  override fun execute(runnable: Runnable) {
    if (runnable == null) {
      throw IllegalArgumentException("Runnable to execute cannot be null")
    }
    this.threadPoolExecutor.execute(runnable)
  }

  private class JobThreadFactory : ThreadFactory {
    private var counter = 0

    override fun newThread(runnable: Runnable): Thread {
      return Thread(runnable, THREAD_NAME + counter++)
    }

    companion object {
      private val THREAD_NAME = "android_"
    }
  }

  companion object {

    private val INITIAL_POOL_SIZE = 3
    private val MAX_POOL_SIZE = 5

    // Sets the amount of time an idle thread waits before terminating
    private val KEEP_ALIVE_TIME = 10

    // Sets the Time Unit to seconds
    private val KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS
  }
}