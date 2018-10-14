import org.omg.CORBA.INTERNAL;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Asus on 10/7/2018.
 */
public class Q3 {
    static int n;
    static int m;
    static int dis[][];
    static int dx[]={1,-1,0,0};
    static int dy[]={0,0,1,-1};
    static int dx2[]={1,-1,0,0,-1,-1,1,1};
    static int dy2[]={0,0,1,-1,+1,-1,1,-1};
    static String[] grid;
    static boolean visite[][];
    public static void bfs(int hx,int hy){

        Queue<Integer> qx=new LinkedList<>();
        Queue<Integer> qy=new LinkedList<>();
        qx.add(hx);
        qy.add(hy);
        dis[hx][hy]=0;
        visite[hx][hy]=true;
        while(!qx.isEmpty() && !qy.isEmpty()){
            int ux=qx.poll();
            int uy=qy.poll();
            System.out.println(grid[ux].charAt(uy));
            System.out.println(dis[ux][uy]);
            int tx;
            int ty;
            if(grid[ux].charAt(uy)=='S'){
                for(int i=0;i<8;i++){
                    tx=ux+=dx2[i];
                    ty=uy+dy2[i];
                    if(tx>=0 && tx<n && ty>=0 && ty<m) {
                        if(visite[tx][ty])
                            continue;
                        if (grid[tx].charAt(ty) == 'O' || grid[tx].charAt(ty) == 'S') {
                            visite[tx][ty]=true;
                            dis[tx][ty] = dis[ux][uy] + 1;
                            qx.add(tx);
                            qy.add(ty);
                        }
                    }
                }
            }
            else{
                for(int i=0;i<4;i++){
                    tx=ux+=dx[i];
                    ty=uy+dy[i];

                    if(tx>=0 && tx<n && ty>=0 && ty<m) {
                        if(visite[tx][ty])
                            continue;
                        if(grid[tx].charAt(ty) == 'W')
                            continue;
                        if (grid[tx].charAt(ty) == 'O' || grid[tx].charAt(ty) == 'S') {
                            visite[tx][ty]=true;
                            dis[tx][ty] = dis[ux][uy] + 1;
                            qx.add(tx);
                            qy.add(ty);
                        }
                    }
                }
            }
        }

    }
    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);
        n=s.nextInt();
        m=s.nextInt();
        int hx=-1;
        int hy=-1;
        dis=new int[n][m];
        visite=new boolean[n][m];
        grid = new String[n];
        for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    dis[i][j]=1000000000;
                }
                grid[i]=s.next();
                if(grid[i].contains("H")){
                    hx=i;

                    for(int k=0;k<grid[i].length();k++){
                        if(grid[i].charAt(k)=='H'){
                            hy=k;
                        }
                    }
                }

        }
        bfs(hx,hy);
        int min=1000000000;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.println(dis[i][j]);
            }
        }
//       for(int i=0;i<n;i++){
//           for(int j=0;j<grid[i].length();j++){
//               if(grid[i].charAt(j)=='D'){
//                   if(dis[i][j]<min)
//                       min=dis[i][j];
//                   System.out.println(i);
//                   System.out.println(j);
//                   System.out.println(dis[i][j]);
//               }
//           }
//       }
//        System.out.println(min);
    }

}
