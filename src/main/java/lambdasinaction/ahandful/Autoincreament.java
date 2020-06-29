package lambdasinaction.ahandful;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Autoincreament {
    public static void main(String[] args) {
        List<Integer> aa=new ArrayList<>(){
            {
                add(1);
                add(2);
            }
        };
        Stream<Integer> stream = aa.stream();
        stream.collect(Collectors.toList());
        stream = aa.stream();
        stream.forEach(System.out::println);
    }
}
