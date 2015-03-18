import java.util.*;
import java.io.*;

public class Time {
    public static void main(String[] args) {
        Random r = new Random();
        long myStart, myEnd, start, end;

        LList<Integer> myL = new LList<Integer>();
        List<Integer> L = new LinkedList<Integer>();

        for (int i = 0; i < 1000; i++) {
            myL.add(r.nextInt(1000));
            L.add(r.nextInt(1000));
        }

        myStart = System.currentTimeMillis();

        int mySum = 0;
        for (int i = 0; i < 1000; i++) {
            mySum += myL.get(i);
        }

        myEnd = System.currentTimeMillis();
        
        start = System.currentTimeMillis();

        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            sum += L.get(i);
        }

        end = System.currentTimeMillis();

        System.out.println("myList: " + (myEnd - myStart));
        System.out.println("javaList: " + (end - start));
    }
}
