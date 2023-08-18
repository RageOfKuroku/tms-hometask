public class ThreadName extends Thread{
    public String threadName;

    ThreadName(String threadName){
        this.threadName = threadName;
    }

    public void run(){
        System.out.println("Поток " + threadName + " запущен");
    }
}
