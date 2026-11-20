class NumberThread extends Thread {
    NumberThread() {
        setName("Number Thread");
        setPriority(5);
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(getName() + ": " + i);
        }
    }
}

class AlphabetThread extends Thread {
    AlphabetThread() {
        setName("Alphabet Thread");
        setPriority(5);
    }

    public void run() {
        for (char ch = 'A'; ch <= 'J'; ch++) {
            System.out.println(getName() + ": " + ch);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        NumberThread t1 = new NumberThread();
        AlphabetThread t2 = new AlphabetThread();

        t1.start();
        t2.start();
    }
}
