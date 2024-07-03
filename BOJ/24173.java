import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int change;
    static int[] ans = {-1, -1};

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int arrSize = Integer.parseInt(st.nextToken());
            int changedCnt = Integer.parseInt(st.nextToken());

            int[] arr = new int[2 * arrSize + 1];
            StringTokenizer values = new StringTokenizer(br.readLine());
            for (int i = 1; i <= arrSize; i++) {
                arr[i] = Integer.parseInt(values.nextToken());
            }

            sort(arr, arrSize, changedCnt);

            if (ans[0] == -1) {
                sb.append(-1);
            } else {
                sb.append(Math.min(ans[0], ans[1])).append(" ").append(Math.max(ans[0], ans[1]));
            }


            bw.write(sb.toString());
        }
    }

    public static void sort(int[] arr, int arrSize, int changedCnt) {
        buildMinHeap(arr, arrSize, changedCnt);
        for (int i = arrSize; i >= 2; i--) {
            int tmp = arr[1];
            arr[1] = arr[i];
            arr[i] = tmp;

            change++;
            if (change == changedCnt) {
                ans[0] = arr[1];
                ans[1] = arr[i];
                return;
            }

            heapify(arr, 1, i - 1, changedCnt);
        }
    }

    public static void buildMinHeap(int[] arr, int n, int changedCnt) {
        for (int i = n / 2; i >= 1; i--) {
            heapify(arr, i, n, changedCnt);

            if (changedCnt < change) {
                return;
            }
        }
    }

    public static void heapify(int[] arr, int k, int n, int changedCnt) {
        if (changedCnt < change) {
            return;
        }

        int left = 2 * k;
        int right = 2 * k + 1;

        int smaller = -1;

        if (right <= n) {
            if (arr[left] < arr[right]) {
                smaller = left;
            } else {
                smaller = right;
            }
        } else if (left <= n) {
            smaller = left;
        } else {
            return;
        }

        if (arr[smaller] < arr[k]) {
            int tmp = arr[k];
            arr[k] = arr[smaller];
            arr[smaller] = tmp;

            change++;
            if (change == changedCnt) {
                ans[0] = arr[k];
                ans[1] = arr[smaller];
            }

            heapify(arr, smaller, n, changedCnt);
        }
    }
}
