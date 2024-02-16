package homeworkthreadday16;



public class Main {
    public static void main(String[] args) {
        System.out.println(" >>>>>>>>>>>>>>> App >>>>>>>>>>>>>>>");
        Object lock = new Object();

        Thread thread = new Thread(() -> {
            printWithDelay("Welcome to CSTAD School", 300);
            printWithDelay("*****************************************",300);
            printWithDelay("Don't Stop because of It get hard,\nIt just the beginning", 300);
            printWithDelay("_________________________________________",300);
            printWithDelayNoNewLine("Downloading***************************", 300);

            synchronized (lock) {
                lock.notify();
            }
        });

        thread.start();

        synchronized (lock) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.print("100% Downloaded Successfully");
    }

    private static void printWithDelay(String message, int delay) {
        for (int i = 0; i < message.length(); i++) {
            System.out.print(message.charAt(i));
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println();
    }
    private static void printWithDelayNoNewLine(String message, int delay) {
        for (int i = 0; i < message.length(); i++) {
            System.out.print(message.charAt(i));
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.print("");
    }
}

