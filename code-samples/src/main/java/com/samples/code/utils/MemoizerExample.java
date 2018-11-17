package com.samples.code.utils;

import java.util.Date;
import java.util.function.Supplier;

public class MemoizerExample {

    private ValueProvider valueProvider = new ValueProvider();

    public static void main(String[] args) {
        MemoizerExample memoizerExample = new MemoizerExample();

        System.out.println("Without memoization");
        Supplier<ValueType> valueSupplier = () -> memoizerExample.valueProvider.getValue("Data1", new Date());
        for (int i=0; i<5; i++) {
            System.out.println(valueSupplier.get());
        }

        System.out.println("With memoization");
        Supplier<ValueType> memoizedValueSupplier = Memoizer.memoize(() -> memoizerExample.valueProvider.getValue("Data2", new Date()));
        for (int i=0; i<5; i++) {
            System.out.println(memoizedValueSupplier.get());
        }

    }

    class ValueProvider {
        public ValueType getValue(String text, Date date) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return new ValueType(text, date);
        }
    }

    class ValueType {
        private String text;
        private Date date;
        private Date createdOn = new Date();
        public ValueType(String text, Date date){
            this.text = text;
            this.date = date;
        }
        @Override
        public String toString() {
            return String.format("text: %s, date: %s, createdOn: %s", text, date, createdOn);
        }
    }

}
