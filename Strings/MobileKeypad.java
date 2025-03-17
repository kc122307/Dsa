package com.kunal.Dsa.Strings;

public class MobileKeypad {
//    static String printSequence(String arr[], String input)
//    {
//        String output="";
//        int n = input.length();
//        for (int i = 0; i < n; i++) {
//            if(input.charAt(i)==' '){
//                output=output+'0';
//            }
//            else{
//                int position = input.charAt(i)-'A';
//                output=output+arr[position];
//            }
//        }
//        return output;
//    }
    
    static String convertToKeypadSequence(String input){
       String [] keymap = {
               "2", "22", "222",    // A, B, C
               "3", "33", "333",    // D, E, F
               "4", "44", "444",    // G, H, I
               "5", "55", "555",    // J, K, L
               "6", "66", "666",    // M, N, O
               "7", "77", "777", "7777",  // P, Q, R, S
               "8", "88", "888",    // T, U, V
               "9", "99", "999", "9999"   // W, X, Y, Z
       };
       input = input.toUpperCase();
       StringBuilder output = new StringBuilder();
        for (char ch:input.toCharArray()) {
            if(ch==' '){
                output.append('0');
            } else if (ch>='A'&&ch<='Z') {
                output.append(keymap[ch-'A']);
            }
        }
        return output.toString();
    }
    public static void main(String[] args) {
        String input = "Hello World";
        System.out.println("Keypad Sequence: " + convertToKeypadSequence(input));
    }
}
