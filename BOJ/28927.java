import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        Hobby Max = new Hobby(st);
        int maxTotalTime = Max.getTotalViewingTime();

        st = new StringTokenizer(br.readLine());
        Hobby Mel = new Hobby(st);
        int melTotalTime = Mel.getTotalViewingTime();

        if (maxTotalTime < melTotalTime) {
            sb.append("Mel");
        } else if (maxTotalTime > melTotalTime) {
            sb.append("Max");
        } else {
            sb.append("Draw");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Hobby {
        Hobby(StringTokenizer s) {
            this.trailer = Integer.parseInt(s.nextToken());
            this.series = Integer.parseInt(s.nextToken());
            this.movie = Integer.parseInt(s.nextToken());
        }

        final int TRAILER_TIME = 3;
        final int SERIES_TIME = 20;
        final int MOVIE_TIME = 120;

        int trailer;
        int series;
        int movie;

        public int getTotalViewingTime() {
            int totalTrailerTime = this.trailer * this.TRAILER_TIME;
            int totalSeriesTime = this.series * this.SERIES_TIME;
            int totalMovieTime = this.movie * this.MOVIE_TIME;

            int totalViewingTime = totalTrailerTime + totalSeriesTime + totalMovieTime;

            return totalViewingTime;
        }
    }
}