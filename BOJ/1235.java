import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int friendCnt = Integer.parseInt(br.readLine());
        String[] studentNums = new String[friendCnt];
        for (int friendNum = 0; friendNum < friendCnt; friendNum++) {
            studentNums[friendNum] = br.readLine();
        }

        int length = studentNums[0].length();
        for (int i = 0; i < length; i++) {
            int smallestDistinguishableK = length - 1 - i;
            HashSet<String> studentSubNums = new HashSet<>();
            for (int friendNum = 0; friendNum < friendCnt; friendNum++) {
                studentSubNums.add(studentNums[friendNum].substring(smallestDistinguishableK));
            }

            if (studentSubNums.size() == friendCnt) {
                sb.append(i + 1);
                break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
