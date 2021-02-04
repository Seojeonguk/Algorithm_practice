import java.io.*;
import java.util.*;
  
class Solution {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
    static int n;
    static int arr[];
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        //tc = Integer.valueOf(st.nextToken());
         
        for (int test_case = 1; test_case <= 10; test_case++) {
            n = Integer.valueOf(br.readLine());
                     
            StringTokenizer st = new StringTokenizer(br.readLine());
             
            arr = new int[100];
             
            for(int i=0;i<100;i++)
                arr[i] = Integer.valueOf(st.nextToken());
             
            for(int i=0;i<n;i++) {
                Arrays.sort(arr);
                if(arr[99]-arr[0]<=1) break;
                arr[0]++;
                arr[99]--;
            }
             
            Arrays.sort(arr);
             
            bw.write("#" + String.valueOf(test_case)+ " " + String.valueOf(arr[99]-arr[0]) + "\n");
        }
         
        bw.flush();
        bw.close();
    }
}