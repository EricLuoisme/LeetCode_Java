package Ex1_300.Ex1_to_30.Ex7_ReverseInteger;

/*
Method from LeetCode cop., %10 then *10 add it to simulate "push & pop" for a digit
 */

public class Reverse_Fast {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        Reverse_Fast use = new Reverse_Fast();
        System.out.println(use.reverse(-123));
    }
}
