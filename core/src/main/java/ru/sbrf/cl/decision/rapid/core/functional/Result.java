package ru.sbrf.cl.decision.rapid.core.functional;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 *
 *
 * @param <T>
 */
public interface Result<T> {
    static <T> Result<T> of(Supplier<T> supplier) {
        try {
            return Success.of(supplier.get());
        } catch (Exception e) {
            return Failure.of(e);
        }
    }

    T get();

    boolean isSuccess();

    default boolean isFailure() {
        return !isSuccess();
    }

    default <R> Result<R> map(Function<? super T, ? extends R> lambda) {
        return isSuccess()
                ? Success.of(lambda.apply(get()))
                : (Failure<R>) this;
    }

    default Result<T> ifSuccess(Consumer<? super T> successConsumer) {
        if (isSuccess()) {
            successConsumer.accept(this.get());
        }
        return this;
    }

    default Result<T> ifFailure(Consumer<Failure<T>> failureConsumer) {
        if (isFailure()) {
            failureConsumer.accept((Failure<T>) this);
        }
        return this;
    }
}
