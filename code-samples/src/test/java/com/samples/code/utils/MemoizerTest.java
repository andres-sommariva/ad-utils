package com.samples.code.utils;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import java.util.function.Supplier;

import org.testng.annotations.Test;

public class MemoizerTest {

    @Test
    public void testMemoizeString() {
        String value = "String Value";
        Supplier delegate = mock(Supplier.class);
        when(delegate.get()).thenReturn(value);

        Supplier memoized = Memoizer.memoize(() -> delegate.get());

        // First call, value is produced
        assertEquals(value, memoized.get());
        verify(delegate, times(1)).get();

        // Second call, value is returned from cache
        assertEquals(value, memoized.get());
        verify(delegate, times(1)).get();
    }

    @Test(expectedExceptions = {NullPointerException.class})
    public void testMemoizeNull() {
        Supplier delegate = mock(Supplier.class);

        Supplier memoized = Memoizer.memoize(() -> delegate.get());

        // Will throw NPE
        memoized.get();
    }
}
