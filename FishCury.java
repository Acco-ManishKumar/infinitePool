import java.util.concurrent.CopyOnWriteArrayList;
import java.util.List;
import java.util.Random;


class activity{
    synchronized static void activity(List<String> fish) {
        Random rand = new Random();
        String [] fi = {"M","F"};
        int rnd = new Random().nextInt(fish.size());
        int rnd2 = new Random().nextInt(fish.size());
        for (int i = 0; i >= 0; i++) {
            if (rnd != rnd2) {
                break;
            } else {
                rnd2 = new Random().nextInt(fish.size());
            }
        }
        System.out.println("Number of fish before : "+fish.size());
        System.out.println(fish.get(rnd) + " " + rnd);
        System.out.println(fish.get(rnd2) + " " + rnd2);
        if(fish.get(rnd).equals("M") && fish.get(rnd2).equals("F")) {
            fish.add(fi[rand.nextInt(fi.length)]);
            fish.add(fi[rand.nextInt(fi.length)]);
        }
        else if(fish.get(rnd).equals("F") && fish.get(rnd2).equals("M")) {
            fish.add(fi[rand.nextInt(fi.length)]);
            fish.add(fi[rand.nextInt(fi.length)]);
        }
        else if(fish.get(rnd).equals("F") && fish.get(rnd2).equals("F")) {
            fish.remove("F");
        }
        else if(fish.get(rnd).equals("M") && fish.get(rnd2).equals("M")) {
            fish.remove("M");
            fish.remove("M");
        }
        System.out.println("Number of fish after : "+fish.size());
        System.out.println(fish);

    }
}
class multipleThread extends Thread{
    List<String> fish = new CopyOnWriteArrayList<String>();
    public void run() {
        try {
            while(fish.size()>1) {
                activity a = new activity();
                a.activity(fish);
                System.out.println("Thread performed this meeting : "+Thread.currentThread().getName());
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
    multipleThread(List<String> fish){
        this.fish = fish;
    }
}
public class FishCury{
    static List<String> fish = new CopyOnWriteArrayList<String>();
    public static void main(String[] args) {
        for(int i=0;i<10;i++) {
            fish.add("M");
            fish.add("F");
        }
        System.out.println(fish);
        System.out.println(fish.size());
        multipleThread thread1 = new multipleThread(fish);
        multipleThread thread2 = new multipleThread(fish);
        multipleThread thread3 = new multipleThread(fish);
        multipleThread thread4 = new multipleThread(fish);
        multipleThread thread5 = new multipleThread(fish);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
