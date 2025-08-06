package org.example.string;

public class AddBianary {
    public static void main(String[] args) {

        String a2 = "1010";
        String b2 = "1011";
        System.out.println("Input: a = \"" + a2 + "\", b = \"" + b2 + "\"");
        System.out.println("Output: \"" + addBinary(a2, b2) + "\"");
        System.out.println();

    }

    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        // Process both strings from right to left
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            // Add digit from string a if available
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }

            // Add digit from string b if available
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            // Append the current bit (sum % 2) to result
            result.append(sum % 2);

            // Update carry for next iteration
            carry = sum / 2;
        }

        // Reverse the result since we built it backwards
        return result.reverse().toString();
    }
}
