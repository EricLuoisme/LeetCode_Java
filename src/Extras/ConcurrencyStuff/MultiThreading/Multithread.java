package Extras.ConcurrencyStuff.MultiThreading;

import java.math.BigDecimal;

public class Multithread {
    public static void main(String[] args) {
        int n = 8;
        for (int i = 0; i < n; i++) {
            Thread object = new Thread(new MultithreadingDemo());
            object.start();
        }

        try{

        } catch (Exception e) {

        } finally {

        }
        BigDecimal bigDecimal = new BigDecimal("0");
    }
}
