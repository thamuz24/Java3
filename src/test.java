import java.util.regex.Pattern;

public class test {
    public static void main(String[] args) {
        String check0_225 = "([1-9]|[1-9][1-9]|1[0-9][0-9]|2[1-4][0-9]|25[0-5])";
        String IP = "256.225";
        System.out.println(Pattern.matches(check0_225+"\\."+check0_225,IP));
    }
}
