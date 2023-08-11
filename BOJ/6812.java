import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static String[] cities = {"Ottawa", "Victoria", "Edmonton", "Winnipeg", "Toronto", "Halifax", "St. John's"};
    static int[] diff = {0, -180, -120, -60, 0, 60, 90};

    public static void main(String[] args) throws Exception {
        String ottawaTime = br.readLine();
        String formatOttawaTime = String.format("%0" + 4 + "d", Integer.parseInt(ottawaTime));

        int ottawaHour = Integer.parseInt(formatOttawaTime.substring(0, 2));
        int ottawaMinute = Integer.parseInt(formatOttawaTime.substring((2)));

        int ottawaAllMinute = ottawaHour * 60 + ottawaMinute;

        for (int i = 0; i < cities.length; i++) {
            int timeInCity = (ottawaAllMinute + diff[i] + 60 * 60 * 24) % (60 * 60 * 24);
            int hourInCity = (timeInCity / 60) % 24;
            int minuteInCity = timeInCity % 60;

            sb.append(hourInCity * 100 + minuteInCity)
                    .append(" in ")
                    .append(cities[i])
                    .append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
