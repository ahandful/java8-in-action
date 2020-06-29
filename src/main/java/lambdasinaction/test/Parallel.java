package lambdasinaction.test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Parallel {
    public static void main(String[] args) {
        IntStream.range(0,10000).forEach(System.out::println);
    }
}
