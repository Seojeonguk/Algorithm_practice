import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arrSize = Integer.parseInt(st.nextToken());
        int queryCnt = Integer.parseInt(st.nextToken());

        long[] arr = new long[arrSize + 1];
        StringTokenizer arrInfo = new StringTokenizer(br.readLine());
        for(int i = 1; i <= arrSize; i++) {
            arr[i] = Long.parseLong(arrInfo.nextToken());
        }

        while(queryCnt-- > 0) {
            StringTokenizer queryInfo = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(queryInfo.nextToken());

            int a = Integer.parseInt(queryInfo.nextToken());
            int b = Integer.parseInt(queryInfo.nextToken());

            long queryResult = calSum(arr, a, b);
            if(query == 1) {
                long temp = arr[a];
                arr[a] = arr[b];
                arr[b] = temp;
            } else if(query == 2) {
                int c = Integer.parseInt(queryInfo.nextToken());
                int d = Integer.parseInt(queryInfo.nextToken());

                queryResult -= calSum(arr, c, d);
            }
            sb.append(queryResult).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static long calSum(long[] arr, int a,int b) {
        long sum = 0;
        for(int i = a; i <= b; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
