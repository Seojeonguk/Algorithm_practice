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

        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= testCase; tc++) {
            StringTokenizer sequenceInfo = new StringTokenizer(br.readLine());
            int sequenceLength = Integer.parseInt(sequenceInfo.nextToken());
            int[] sequences = new int[sequenceLength];
            for (int idx = 0; idx < sequenceLength; idx++) {
                sequences[idx] = Integer.parseInt(sequenceInfo.nextToken());
            }

            int[] nextSequences = calSequence(sequences);
            if (nextSequences.length != 5) {
                sb.append(String.format("The sequence %s is not an arithmetic sequence.\n", print(sequences)));
            } else {
                sb.append(String.format("The next 5 numbers after %s are: %s\n", print(sequences), print(nextSequences)));
            }
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static String print(int[] arr) {
        String result = "";
        result = result.concat("[");
        for (int idx = 0; idx < arr.length; idx++) {
            result = result.concat(String.valueOf(arr[idx]));
            if (idx != arr.length - 1) {
                result = result.concat(", ");
            }
        }
        result = result.concat("]");

        return result;
    }

    public static int[] calSequence(int[] arr) {
        int diff = arr[1] - arr[0];
        for (int idx = 2; idx < arr.length; idx++) {
            if (arr[idx] - arr[idx - 1] != diff) {
                return new int[]{-1};
            }
        }

        int[] nextSequences = new int[5];
        for (int idx = 0; idx < nextSequences.length; idx++) {
            nextSequences[idx] = arr[arr.length - 1] + diff * (idx + 1);
        }
        return nextSequences;
    }
}
