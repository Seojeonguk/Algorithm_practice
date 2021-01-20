import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
 
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
             
            boolean[] chk = new boolean[10];
             
            int cnt=10,i=1,temp;
             
            while(true) {
                temp = n*i;
                while(temp!=0) {
                    if(chk[temp%10] == false) {
                        chk[temp%10] = true;
                        cnt--;
                    }
                    temp/=10;
                }
                 
                if(cnt==0) break;
                i++;
            }
             
            System.out.println("#" + test_case + " " + n*i);
        }
         
        sc.close();
    }
}