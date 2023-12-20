import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int totalStudent = Integer.parseInt(br.readLine());
        int[] interestingSubjects = new int[3];
        String interestingSubject = br.readLine();
        for (int i = 0; i < totalStudent; i++) {
            char c = interestingSubject.charAt(i);
            if (c == 'B') {
                interestingSubjects[0]++;
            } else if (c == 'S') {
                interestingSubjects[1]++;
            } else if (c == 'A') {
                interestingSubjects[2]++;
            }
        }

        int max = Arrays.stream(interestingSubjects).max().getAsInt();
        ArrayList<Integer> mostInterestingSubjects = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (interestingSubjects[i] == max) {
                mostInterestingSubjects.add(i);
            }
        }

        if (mostInterestingSubjects.size() == 3) {
            sb.append("SCU");
        } else {
            for (int i : mostInterestingSubjects) {
                if (i == 0) {
                    sb.append("B");
                } else if (i == 1) {
                    sb.append("S");
                } else if (i == 2) {
                    sb.append("A");
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
