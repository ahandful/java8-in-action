package lambdasinaction.chap11;

import org.apache.hadoop.hbase.shaded.org.apache.commons.collections.map.LinkedMap;
import org.apache.hbase.thirdparty.com.google.gson.internal.LinkedTreeMap;
import org.apache.hbase.thirdparty.org.apache.commons.collections4.map.UnmodifiableMap;

import java.util.*;

public class XuyuTest {
    public static void main(String[] args) {
        int a=9;
//        int b=8;
//        System.out.println(a & 1<<b);
        int b=1 << a;
        System.out.println(b);
    }
}
