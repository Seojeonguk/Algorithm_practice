import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int startVolunteer = Integer.parseInt(st.nextToken());
        int returnVolunteer = Integer.parseInt(st.nextToken());

        boolean[] isReturn = new boolean[startVolunteer + 1];
        StringTokenizer returnToken = new StringTokenizer(br.readLine());
        for (int i = 0; i < returnVolunteer; i++) {
            int returnVolunteerNum = Integer.parseInt(returnToken.nextToken());
            isReturn[returnVolunteerNum] = true;
        }

        if (startVolunteer == returnVolunteer) {
            sb.append("*");
        } else {
            for (int volunteerNum = 1; volunteerNum <= startVolunteer; volunteerNum++) {
                if (!isReturn[volunteerNum]) {
                    sb.append(volunteerNum).append(" ");
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
