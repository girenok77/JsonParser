package Serialize;

import Serialize.JsonWriter;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;


/**
 * @author Girenok
 */
public class Test {
    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("file.txt");
            //BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            JsonSerializer serializer=new JsonSerializer();
            ArrayList<String>arrayList=new ArrayList<String>();
            arrayList.add("dasdgdgsd");
            arrayList.add("22222222");
            serializer.serialize(arrayList,fileWriter);

            /*Object someObject = new MyClass();
            for (Field field : someObject.getClass().getDeclaredFields()) {
                field.setAccessible(true); // You might want to set modifier to public first.
                Object value = null;
                try {
                    value = field.get(someObject);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                if (value != null) {
                    System.out.println(field.getName() + "=" + value);
                }
            }*/


        } catch (IOException e) {
            e.printStackTrace();
        }





    }

    static class MyClass implements Serializable {
        String hello = new String("Hello World");
        int asss=213321;
        Myclass2 myclass2=new Myclass2();

    }
    static class Myclass2{
        String name = new String("geka");
        long age=213321;
        long []arr=new long[5];
        boolean aBoolean=false;
    }
}
