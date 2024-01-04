import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final String ARIES = "Aries";
    static final String TAURUS = "Taurus";
    static final String GEMINI = "Gemini";
    static final String CANCER = "Cancer";
    static final String LEO = "Leo";
    static final String VIRGO = "Virgo";
    static final String LIBRA = "Libra";
    static final String SCORPIO = "Scorpio";
    static final String SAGITTARIUS = "Sagittarius";
    static final String CAPRICORN = "Capricorn";
    static final String AQUARIUS = "Aquarius";
    static final String PISCES = "Pisces";

    public static void main(String[] args) throws Exception {
        String[] strDates = br.readLine().split("-");
        int month = Integer.parseInt(strDates[1]);
        int day = Integer.parseInt(strDates[2]);
        
        sb.append(calZodiacSign(month,day));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static String calZodiacSign(int m, int d) {
        if (m == 1) {
            return (d <= 19 ? CAPRICORN : AQUARIUS);
        } else if (m == 2) {
            return (d <= 18 ? AQUARIUS : PISCES);
        } else if (m == 3) {
            return (d <= 20 ? PISCES : ARIES);
        } else if (m == 4) {
            return (d <= 19 ? ARIES : TAURUS);
        } else if (m == 5) {
            return (d <= 20 ? TAURUS : GEMINI);
        } else if (m == 6) {
            return (d <= 20 ? GEMINI : CANCER);
        } else if (m == 7) {
            return (d <= 22 ? CANCER : LEO);
        } else if (m == 8) {
            return (d <= 22 ? LEO : VIRGO);
        } else if (m == 9) {
            return (d <= 22 ? VIRGO : LIBRA);
        } else if (m == 10) {
            return (d <= 22 ? LIBRA : SCORPIO);
        } else if (m == 11) {
            return (d <= 22 ? SCORPIO : SAGITTARIUS);
        } else if (m == 12) {
            return (d <= 21 ? SAGITTARIUS : CAPRICORN);
        }
        return null;
    }
}
