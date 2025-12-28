import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static final String HANYANG = "Hanyang Univ.";
    private static final String YONGDAP = "Yongdap";
    private static final String EITHER = "Either";

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int startToHanyang = Integer.parseInt(st1.nextToken());
            int startToYongdap = Integer.parseInt(st1.nextToken());

            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int hanyangToITBT = Integer.parseInt(st2.nextToken());
            int yongdapToITBT = Integer.parseInt(st2.nextToken());

            int totalHanyang = startToHanyang + hanyangToITBT;
            int totalYongdap = startToYongdap + yongdapToITBT;

            bw.write(getResult(totalHanyang, totalYongdap));
            bw.flush();
        }
    }

    private static String getResult(int hanyangTime, int yongdapTime) {
        if (hanyangTime < yongdapTime) {
            return HANYANG;
        } else if (yongdapTime < hanyangTime) {
            return YONGDAP;
        }
        return EITHER;
    }
}
