package week4.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class PracticeURL {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://wiki.warthunder.com/Main_Page");
        BufferedReader read = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;
        while ((line = read.readLine()) != null) {
            System.out.println(line);
        }
        read.close();
    }
}
