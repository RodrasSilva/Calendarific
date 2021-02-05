package util.observables;

import io.reactivex.Observable;

import java.util.concurrent.CompletableFuture;

public class ObservableUtils {
    public static <T> Observable<T> toObservable(CompletableFuture<T> future) {
        return Observable.create(subscriber ->
                future.whenComplete((result, error) -> {
                    if (error != null) {
                        subscriber.onError(error);
                    } else {
                        subscriber.onNext(result);
                        subscriber.onComplete();
                    }
                }));
    }

}
