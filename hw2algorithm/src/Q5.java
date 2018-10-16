import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Asus on 10/15/2018.
 */
public class Q5 {
   public static ArrayList<Integer>[] edges;
   public static int distance[];
   public static int min;
   public static int minindex;
   public static boolean[] visited;
    public static void main(String[] args) {
        int n;
        int m;
        Scanner s=new Scanner (System.in);
        n=s.nextInt();
        m=s.nextInt();
         edges=new ArrayList[n];
         distance=new int[n];
         visited=new boolean[n];
         for(int i=0;i<n;i++){
             edges[i]=new ArrayList<>();
             distance[i]=1000000000;
             visited[i]=false;
         }
        for(int i=0;i<m;i++){
            int u=s.nextInt()-1;
            int v=s.nextInt()-1;
            //System.out.println("u = " + u);
            //System.out.println("v = " + v);
            edges[u].add(v);
            edges[v].add(u);

        }
         min=1000000000;
         minindex=-1;
        for(int i=0;i<n;i++){
            BFS(i);
            distance=new int[n];
            visited=new boolean[n];
        }
//        for(int i=0;i<n;i++){
//            BFS(i);
//            int sum=0;
//            for(int j=0;j<n;j++){
//                sum+=distance[j];
//            }
//            System.out.println("sum = " + sum);
//            System.out.println("i = " + i);
//            if(sum<min){
//                min=sum;
//                minindex=i;
//            }
//
//        }
        System.out.println(minindex+1);

    }
    public static int BFS(int start){
        int total=0;
        Queue<Integer> q= new LinkedList<>();
        distance[start]=0;
        visited[start]=true;
        q.add(start);
        while(!(q.isEmpty())){
            int u=q.poll();
            for(int i=0;i<edges[u].size();i++){
                int v=edges[u].get(i);
                if(!visited[v]){
                    distance[v]=distance[u]+1;
                    total+=distance[v];
                    visited[v]=true;
                    q.add(v);
                    
                }
            }
        }
        if(total<min){
            minindex=start;
            min=total;;
        }
        return total;
    }

}

