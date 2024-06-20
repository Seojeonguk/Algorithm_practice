import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int arrSize = Integer.parseInt(st.nextToken());
            int addedValue = Integer.parseInt(st.nextToken());

            StringTokenizer arrs = new StringTokenizer(br.readLine());
            int[] arr = new int[arrSize];
            for (int idx = 0; idx < arrSize; idx++) {
                arr[idx] = Integer.parseInt(arrs.nextToken());
            }

            sb.append(isContinuousArray(arr, addedValue));

            bw.write(sb.toString());
        }
    }

    public static int isContinuousArray(int[] arr, int k) {
        boolean[] isExist = new boolean[arr.length + 1];

        Arrays.sort(arr);
        for (int a : arr) {
            if (a >= isExist.length) {
                return 0;
            }
            
            while (isExist[a]) {
                a += k;
                if (a >= isExist.length) {
                    return 0;
                }
            }

            isExist[a] = true;
        }

        return 1;
    }
}
