import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution {
	public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
 
        for(int test_case = 1; test_case <= T; test_case++) {
            String k = sc.next();
            for (int i = 1; i <= k.length(); i++) {
                if(k.substring(0, i).equals(k.substring(i, i+i)) ) {
                    System.out.printf("#%d %d\n",test_case, i);
                    break;
                }
            }
 
        }
        sc.close();
    }
}