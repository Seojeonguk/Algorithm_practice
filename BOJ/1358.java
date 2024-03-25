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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int personCnt = Integer.parseInt(st.nextToken());

        int peopleInsideIceRink = 0;
        for (int personNum = 1; personNum <= personCnt; personNum++) {
            StringTokenizer personInfo = new StringTokenizer(br.readLine());
            int personX = Integer.parseInt(personInfo.nextToken());
            int personY = Integer.parseInt(personInfo.nextToken());

            if (isInIceLink(width, height, x, y, personX, personY)) {
                peopleInsideIceRink++;
            }
        }

        sb.append(peopleInsideIceRink);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isInIceLink(int w, int h, int x, int y, int pX, int pY) {
        if (x <= pX && pX <= x + w && y <= pY && pY <= y + h) {
            return true;
        }

        int radius = h / 2;
        if (isInHalfCircle(x, y + radius, radius, pX, pY) || isInHalfCircle(x + w, y + radius, radius, pX, pY)) {
            return true;
        }

        return false;
    }

    public static boolean isInHalfCircle(int centerX, int centerY, int radius, int x, int y) {
        int distanceFromCenter = distance(centerX, centerY, x, y);
        return (radius * radius >= distanceFromCenter);
    }

    public static int distance(int a, int b, int x, int y) {
        int xDiff = Math.abs(a - x);
        int yDiff = Math.abs(b - y);

        return xDiff * xDiff + yDiff * yDiff;
    }
}
