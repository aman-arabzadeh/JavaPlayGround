package org.example;

import java.util.ArrayList;
import java.util.List;

public class LeakMemory {
    private static final int LIMIT = 7;

    public static class Big100MB {
        private final byte[] data = new byte[100 * 1024 * 1024];
        public byte[] getData() {
            return data;
        }
    }

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        System.gc();
        List<Big100MB> list = new ArrayList<>();

        for (int i = 1; i <= LIMIT; i++) {
            list.add(new Big100MB());
            System.out.println("Allocated object #" + (i));
        }
        System.gc();
        long totalMemoryAfter = runtime.totalMemory();
        long freeMemoryAfter = runtime.freeMemory();

        System.out.println("--- Memory After Allocation (7 objects) ---");
        System.out.printf("Total Heap Used (Approx): %.2f MB%n", (double) (totalMemoryAfter - freeMemoryAfter) / (1024 * 1024));
    }
}