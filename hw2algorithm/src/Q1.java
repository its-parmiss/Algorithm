import java.util.Scanner;

/**
 * Created by Asus on 10/7/2018.
 */
public class Q1 {
    public static void main(String[] args) {
        String s;
        Scanner scanner = new Scanner(System.in);
        s=scanner.nextLine();
        String smallest=s;
        for(int i=0;i<s.length();i++){
            String s1=s.substring(0,i);
            String s2=s.substring(i,s.length());
            if(s2.concat(s1).compareTo(smallest)<0)
                smallest=s2.concat(s1);
        }
        System.out.println(smallest);
    }
}
