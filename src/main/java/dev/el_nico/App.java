package dev.el_nico;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App 
{
    static List<Thread> hilos = new ArrayList<>(20);

    public static void main( String[] args )
    {
        for (int i = 0; i < 20; ++i) {
            hilos.add(new Thread(new Hilo()));
        }

        for (Thread t : hilos) {
            t.start();
        }
    }
}
