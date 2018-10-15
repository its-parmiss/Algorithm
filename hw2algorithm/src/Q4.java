import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by Asus on 10/11/2018.
 */
public class Q4 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<String> a = new ArrayList<>();
        int n;
        ArrayList<Runner> runners = new ArrayList<>();

        PriorityQueue<Runner> pq = new PriorityQueue<>();
        while (true) {
            String k = s.next();
            if (k.equals("#")) {
                break;
            }
            String name=k;
            int time=s.nextInt();
            int addingTime=s.nextInt();
           Runner runner = new Runner(name, time, addingTime);
            runners.add(runner);
            pq.add(runner);

        }
        n = s.nextInt();




        for (int i = 1; i < n; i++) {
            Runner r = pq.remove();
           // r.round++;
            System.out.println(r.name);
           // System.out.println("r.totaltime = " + r.totaltime);
            //System.out.println(r.totaltime);
            r.totalTime();
            pq.add(r);
        }
        System.out.print(pq.remove().name);
       // System.out.println("pq.remove()totaltime = " + pq.remove().totaltime);
        //System.out.println(pq.remove().totaltime);

    }

    static class Runner implements Comparable<Runner> {
        String name;
        int time;
        int addingtime;
        int round = 0;
        int totaltime = 0;

        public Runner(String name, int time, int addingtime) {
            this.name = name;
            this.time = time;
            this.addingtime = addingtime;
            totaltime=time;
        }

        public int totalTime() {
            time+=addingtime;
            totaltime+=time;
            return totaltime;
        }

        @Override
        public int compareTo(Runner o) {
            if (this.totaltime < o.totaltime)
                return -1;
            if (this.totaltime == o.totaltime){
                if(this.name.compareTo(o.name)<0)
                  return -1;
                else
                    return 1;

            }

            else
                return 1;
        }


    }
}

