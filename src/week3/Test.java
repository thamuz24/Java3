package week3;

public class Test {
    public static void main(String[] args) {
        boolean is = false;
        int i = 0;
        while (!is) {
            System.out.println(i);
            if (i == 5) {
                is = true;
            }
            i++;
        }
    }
}
