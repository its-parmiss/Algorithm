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
        while (true) {
            String k = s.nextLine();
            if (k.equals("#")) {
                break;
            }
            a.add(k);
        }
        int n;
        ArrayList<Runner> runners = new ArrayList<>();
        n = s.nextInt();
        for (String k : a) {
            String[] splitedk = k.split(" ");
            String name = splitedk[0];
            // System.out.println(k);
            int time = Integer.parseInt(splitedk[1]);
            int additionalTime = Integer.parseInt(splitedk[2]);
            Runner runner = new Runner(name, time, additionalTime);
            runners.add(runner);
        }

        PriorityQueue<Runner> pq = new PriorityQueue<>();

        for (int j = 0; j < runners.size(); j++) {
            runners.get(j).totalTime();
           // runners.get(j).round++;
            pq.add(runners.get(j));
        }
        for (int i = 1; i < n; i++) {
            Runner r = pq.remove();
           // r.round++;
            System.out.println(r.name);
            //System.out.println(r.totaltime);
            r.totalTime();
            pq.add(r);
        }
        System.out.println(pq.remove().name);
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
                  return 0;
                else
                    return 1;


            }

            else
                return 1;
        }


    }
}

