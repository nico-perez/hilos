package dev.el_nico;

public class Hilo implements Runnable {

    private static int i = 0;
    private int id = ++i;

    /** Monitor que comparten todos las instancias de esta clase. */
    private static Object monitor = new Object();

    /** Número de hilos esperando en el monitor. */
    private static int esperando = 0;

    @Override
    public void run() {
        System.out.println("hola " + id);

        synchronized (monitor) {
            if (esperando == 19) {
                // Es el último despierto (los otros 19 están waiteando),
                // así que los despierta.
                monitor.notifyAll();
            } else {
                try {
                    // Como no es 
                    ++esperando;
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("adios " + id);
    }
}
