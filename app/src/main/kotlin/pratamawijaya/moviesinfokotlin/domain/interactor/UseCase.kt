package pratamawijaya.moviesinfokotlin.domain.interactor

import pratamawijaya.moviesinfokotlin.domain.executor.PostExecutionThread
import pratamawijaya.moviesinfokotlin.domain.executor.ThreadExecutor
import rx.Observable
import rx.Subscriber
import rx.functions.Action0
import rx.functions.Action1
import rx.schedulers.Schedulers
import rx.subscriptions.Subscriptions

/**
 * Created by Pratama Nur Wijaya
 * Date : Oct - 10/11/16
 * Project Name : MoviesInfoKotlin
 */
abstract class UseCase<T> protected constructor(private val threadExecutor: ThreadExecutor,
    private val postExecutionThread: PostExecutionThread) {

  private var subscription = Subscriptions.empty()

  /**
   * Executes the current use case.

   * @param useCaseSubscriber The guy who will be listen to the observable build
   * * with [.buildObservableUseCase]
   */
  @SuppressWarnings("unchecked") fun execute(useCaseSubscriber: Subscriber<T>) {
    this.subscription = this.buildUseCaseObservable()
        .subscribeOn(Schedulers.from(threadExecutor))
        .observeOn(postExecutionThread.scheduler)
        .subscribe(useCaseSubscriber)
  }

  @SuppressWarnings("unchecked")
  fun execute(onNext: Action1<T>, onError: Action1<Throwable>) {
    this.subscription = this.buildUseCaseObservable()
        .subscribeOn(Schedulers.from(threadExecutor))
        .observeOn(postExecutionThread.scheduler)
        .subscribe(onNext, onError)
  }

  @SuppressWarnings("unchecked")
  fun execute(onNext: Action1<T>, onError: Action1<Throwable>, onCompleted: Action0) {
    this.subscription = this.buildUseCaseObservable()
        .subscribeOn(Schedulers.from(threadExecutor))
        .observeOn(postExecutionThread.scheduler)
        .subscribe(onNext, onError, onCompleted)
  }

  /**
   * Unsubscribes from current [rx.Subscription].
   */
  fun unsubscribe() {
    if (!subscription.isUnsubscribed) {
      subscription.unsubscribe()
    }
  }

  /**
   * Builds an [Observable] which will be used when executing the current [UseCase].
   */
  protected abstract fun buildUseCaseObservable(): Observable<T>
}