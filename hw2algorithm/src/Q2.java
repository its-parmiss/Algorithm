import java.util.*;

/**
 * Created by Asus on 10/7/2018.
 */
public class Q2 {
    public static long gcd(long a,long b){
            if (a == 0)
                return b;

            return gcd(b%a, a);

    }
    public static void main(String[] args) {

        int n;
        int counter=0;

        Scanner scanner=new Scanner(System.in);
        n= scanner.nextInt();
        long[] x=new long[n];
        for(int i=0;i<n;i++){
            x[i]=scanner.nextLong();
        }
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(gcd(x[i],x[j])==1)
                    counter++;
            }
        }
        System.out.println(counter);
    }
}
