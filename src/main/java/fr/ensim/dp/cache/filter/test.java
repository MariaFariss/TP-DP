package fr.ensim.dp.cache.filter;

public class test {
    public static void main(String[] args) {
        Runnable thread = new Runnable() {

            @Override
            public void run() {
                System.out.println("jhg");
            }
            
        };

        thread.run();
    }
}
