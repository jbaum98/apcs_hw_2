public class Recursion {

    public static int fact(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n*fact(n-1);
        }
    }

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n <= 2) {
            return 1;
        } else {
            return fib(n-1) + fib(n-2);
        }
    }

    public static int len(String s) {
        if (s.equals("")) {
            return 0;
        } else {
            return 1+len(s.substring(1));
        }
    }

    public static int count(String s, char c) {
        if (s.equals("")) {
            return 0;
        } else {
            char first = s.charAt(0);
            int others = count(s.substring(1), c);
            if (first == c) {
                return 1 + others;
            } else {
                return others;
            }
        }
    }

    public static int bunnyEars2(int n){
        if (n==0){
            return 0;
        } else {
            if (n%2==0){
                return bunnyEars2(n-1)+3;
            } else {
                return bunnyEars2(n-1)+2;
            }
        }
    }

    public static int strCount(String str, String sub) {
        if (str.length() < sub.length()) {
            return 0;
        } else {
            if (str.substring(0, sub.length()).equals(sub)) {
                return 1 + strCount(str.substring(sub.length()), sub);
            } else {
                return strCount(str.substring(1), sub);
            }
        }
    }

    public static int sumDigits(int n) {
        if (n<10){
            return n;
        } else {
            int right = n%10;
            int left = n/10;
            return sumDigits(left)+right;
        }
    }

    public static String allStar(String str) {
        String out = new String();
        if (str.length() <= 1) {
            return str;
        } else {
            return str.charAt(0) + "*" + allStar(str.substring(1));
        }
    }

    public static void main(String[] args) {
        System.out.println("fact(4): "+fact(4));
        System.out.println("fib(6): " + fib(6));
        System.out.println("len(\"abcd\"): "+len("abcd"));
        System.out.println("count(\"abacada\", 'a'): "+count("abacada", 'a'));
        System.out.println("bunnyEars2(2): "+bunnyEars2(2));
        System.out.println("strCount(\"catcowcat\", \"cat\"): " + strCount("catcowcat", "cat"));
        System.out.println("sumDigits(126): "+sumDigits(126));
        System.out.println("allStar(\"Chocolate\"): "+allStar("Chocolate"));
    }
}
