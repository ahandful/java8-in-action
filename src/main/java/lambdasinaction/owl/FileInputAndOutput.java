package lambdasinaction.owl;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FileInputAndOutput {
    public static void main(String[] args) {
        BufferedReader bf = null;
        try{
            while(true){ // while(true){}循环保证程序不会结束
//                bf = new BufferedReader(new InputStreamReader(System.in));
                new InputStreamReader(System.in);
                /*System.in 为标准输入，System.out为标准输出*/
                /*InputStreamReader用语将字节流到字符流的转化，这也就是处理流了
                 *在这里相当与2个管道接在System.in与程序之间。
                 *readLine()方法功能比较好用，也就通过处理流来实现更好功能。
                 **/
                String line = bf.readLine();
                System.out.println(line);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            //一定要关闭流，用完后。最好放在
            try{
                if(bf!=null){
                    bf.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
