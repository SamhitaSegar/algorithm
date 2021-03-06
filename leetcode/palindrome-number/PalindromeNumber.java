public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) { return false; }
        int  k = 1;
        while (x / k >= 10) {
            k *= 10;
        }
        while (x / k == x % 10) {
            x = x - (x/k)*k; // remove the highest number
            x /= 10; // remove the lowest number
            k = k / 100;
            if (k <= 1) { return true; }
        }
        return false;
    }

    public static void main(String args[]) {
        PalindromeNumber sol = new PalindromeNumber();

        int[] nums = {
            0, 1, 9, // less than 10
            -2, -101, // negtive
            101, 1001, 121, 1221, // old and even
            10, 100, 100101 // not palindrome
        };
        boolean[] results = {
            true, true, true, // less than 10
            false, false, // negtive is not palindrom
            true, true, true, true, // old and even
            false, false, false
        };
        int count = nums.length;
        int failed = 0;
        boolean result;
        for (int i = 0; i < count; i++) {
            result = sol.isPalindrome(nums[i]);
            if (result != results[i]) {
                failed++;
                System.out.println("Test: " + nums[i] + ", expect: " + results[i] + ", while returned: " + result);
            }
        }
        System.out.println("Test " + count + " cases: " + (count - failed) + " success, " + failed + " failed.");
    }
}
