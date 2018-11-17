package com.samples.code.utils;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

/**
 * References:
 * <br/> - https://stackoverflow.com/questions/35331327/does-java-8-have-cached-support-for-suppliers
 * <br/> - http://javathink.blogspot.com/2008/09/what-is-memoizer-and-why-should-you.html
 * <br/> - https://opencredo.com/lambda-memoization-in-java-8/
 */
public class Memoizer {

    public static <T> Supplier<T> memoize(Supplier<T> delegate) {
        AtomicReference<T> cachedValue = new AtomicReference<>();
        return () -> {
            T value = cachedValue.get();
            if (value == null) {
                value = cachedValue.updateAndGet(cur -> cur == null ? Objects.requireNonNull(delegate.get()) : cur);
            }
            return value;
        };
    }

}
