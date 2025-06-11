package com.kunal.Dsa.HeapsandHashing;

public class OnlinePalindromeStream {
    static final int BASE=256;
    static final int MOD = 1000000007;

    public static void checkPalindromeStream(String s) {
        long forwardHash = 0;
        long reverseHash = 0;
        long power =1;

        StringBuilder current = new StringBuilder();
        for (int i = 0; i <s.length() ; i++) {
            char ch = s.charAt(i);
            current.append(ch);

            forwardHash=(forwardHash*BASE+ch)%MOD;
            reverseHash=(reverseHash+ch*power)%MOD;

            if(forwardHash==reverseHash){
                if(isPalindrome(current)){
                    System.out.println(ch+" :YES");
                }
                else {
                    System.out.println(ch+" :NO");
                }
            }
            else {
                System.out.println(ch+" :NO");
            }
            power=(power*BASE)%MOD;
        }
    }
    private static boolean isPalindrome(StringBuilder sb) {
        int l=0,r=sb.length()-1;
        while(l<r){
            if(sb.charAt(l++)!=sb.charAt(r--)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String str = "abcba";
        checkPalindromeStream(str);

        System.out.println();

        String str2 = "aabaacaabaa";
        checkPalindromeStream(str2);
    }
}
