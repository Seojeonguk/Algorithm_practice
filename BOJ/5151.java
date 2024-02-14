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
            StringTokenizer healthIndustryInfo = new StringTokenizer(br.readLine());
            int lawmakerCnt = Integer.parseInt(healthIndustryInfo.nextToken());
            int donationCnt = Integer.parseInt(healthIndustryInfo.nextToken());
            int voteTime = Integer.parseInt(healthIndustryInfo.nextToken());

            double[] moneys = new double[lawmakerCnt + 1];
            for (int donationNum = 0; donationNum < donationCnt; donationNum++) {
                StringTokenizer donationInfo = new StringTokenizer(br.readLine());
                int lawmakerNum = Integer.parseInt(donationInfo.nextToken());
                int day = Integer.parseInt(donationInfo.nextToken());
                double money = Double.parseDouble(donationInfo.nextToken());


                if (voteTime - 1000 < day && day <= voteTime) {
                    moneys[lawmakerNum] += money;
                }
            }

            double agreeVoteCount = 0, againstVoteCount = 0;
            for (int lawmakerNum = 1; lawmakerNum <= lawmakerCnt; lawmakerNum++) {
                char lawmakerVote = br.readLine().charAt(0);
                if (lawmakerVote == 'N') {
                    againstVoteCount += 1.0d / (1.0d + (moneys[lawmakerNum] / 10000.d));
                } else {
                    agreeVoteCount += 1.0d;
                }
            }

            sb.append("Data Set ").append(tc).append(":\n").append(String.format("%.2f %.2f", agreeVoteCount, againstVoteCount)).append("\n\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
