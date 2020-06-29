package lambdasinaction.owl;

import lambdasinaction.chap3.Sorting;
import org.apache.hadoop.hbase.shaded.com.google.gson.Gson;
import org.apache.hadoop.util.Time;

import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sort {
    public static void main(String[] args){
//        List<Sorting.Apple> inventory = new ArrayList<>();
//        inventory.addAll(Arrays.asList(new Sorting.Apple(80,"green"), new Sorting.Apple(155, "green"), new Sorting.Apple(120, "red")));
//        groupingBy(inventory);
        XuyuTest.test(new String("fdfd"));
        System.out.println(Paths.get("data.txt"));
        Stream.generate(Math::random);
//        test();
//        test2();
//        sortApple(inventory);
//        functionFuhe();
    }
    public static void sortApple(List<Sorting.Apple>  inventory){
        inventory.sort(Comparator.comparing(Sorting.Apple::getWeight).thenComparing(Sorting.Apple::getColor));
    }
    public static void functionFuhe(){
        Function<Integer,Integer> f=x->x+1;
        Function<Integer,Integer> p=x->x*9;
        Function<Integer, Integer> h=f.compose(p);
        int result =h.apply(1);
        System.out.println(result);
    }
    public static void groupingBy(List<Sorting.Apple> inventory){
        Map<Integer, List<Sorting.Apple>> collect = inventory.stream().collect(Collectors.groupingBy(Sorting.Apple::getWeight));
        Gson gson=new Gson();
        System.out.println(gson.toJson(collect));
    }

    public static void test(){
        long start = Time.now();
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i <1000000; i++) {
            list.add(new Random().nextInt());
        }
//        System.out.println(list.get(0));
//        list.forEach(a1->a1+=3);
//        System.out.println(list.get(0));

//        for(Integer i:list){
//            i+=3;
//        }
        list.forEach(a->a+=3);

//        list.sort(Integer::compareTo);
//        list=list.parallelStream().sorted(Integer::compareTo).collect(Collectors.toList());
        Gson gson=new Gson();
//        System.out.println(gson.toJson(list));
        long end = Time.now();
        System.out.println(end-start);
    }

    public static void test1(){
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i <10 ; i++) {
            set.add(i+2);
        }
        set.add(-1);
        for(Integer i:set){
            System.out.println(i);
        }
    }

    public static void test2(){
        List<String> helloWorld=new ArrayList<>();
        helloWorld.addAll(Arrays.asList("hello","world"));
        helloWorld.stream().map(str->str.split("")).forEach(System.out::println);
    }
}
class XuyuTest<T>{
    T jt;
    public static <T> void test(T t){

        System.out.println(t);
    }


}
