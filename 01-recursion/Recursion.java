public class Recursion {
  public static int fib(int n) {
    if (n <= 2) {
      return 1;
    } else {
      return fib(n-1) + fib(n-2);
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
  
  public static String allStar(String str) {
    String out = new String();
    if (str.length() == 0) {
      return out;
    } else if (str.length() == 1) {
      return str;
    } else {
      return str.charAt(0) + '*' + allSa
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
  
  public static void main(String[] args) {
    System.out.println("F(6): " + fib(6));
    System.out.println("bunnyEars2(2): "+bunnyEars2(2));
    System.out.println("strCount(\"catcowcat\", \"cat\"): " + strCount("catcowcat", "cat"));
    System.out.println("sumDigits(126): "+sumDigits(126));
  }
}