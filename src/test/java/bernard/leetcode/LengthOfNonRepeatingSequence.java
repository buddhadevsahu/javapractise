package bernard.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class LengthOfNonRepeatingSequence {
    /*   Sliding Window Problem

        Given a string s, find the length of the longest substring without repeating characters.

        Example 1:

        Input: s = "abcabcbb"
        Output: 3
        Explanation: The answer is "abc", with the length of 3.

        Example 2:

        Input: s = "bbbbb"
        Output: 1
        Explanation: The answer is "b", with the length of 1.

        Example 3:

        Input: s = "pwwkew"
        Output: 3
        Explanation: The answer is "wke", with the length of 3.
        Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

        Example 4:

        Input: s = ""
        Output: 0



        Constraints:

            0 <= s.length <= 5 * 104
            s consists of English letters, digits, symbols and spaces.
*/




    @Test
    public void test() {
        Assert.assertEquals("wrong value", 3, lengthOfLongestSubstring("abcabcbb"));
        Assert.assertEquals("wrong value", 1, lengthOfLongestSubstring("bbbbb"));
        Assert.assertEquals("wrong value", 3, lengthOfLongestSubstring("pwwkew"));
        Assert.assertEquals("wrong value", 1, lengthOfLongestSubstring(" "));
        Assert.assertEquals("wrong value", 3, lengthOfLongestSubstring("dvdf"));

    }
    //2 ms, faster than 99.84% of Java online submissions for Longest Substring Without Repeating Characters.
    // Memory Usage: 38.9 MB, less than 83.60% of Java online submissions for Longest Substring Without Repeating Characters.
    public int lengthOfLongestSubstring3(String s) {
        if (s.length() == 0) return 0;

        int[] count = new int[256];
        for (int i = 0; i < 256; i++) count[i] = -1;
        count[s.charAt(0)] = 0;

        int start = 0;
        int max = 1;

        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (count[ch] != -1) {
                start = Math.max(start, count[ch]+1); // Math.max because for abba input;
            }

            max = Math.max(max, i-start+1);
            count[(int) ch] = i;
        }

        return max;

    }


    //Runtime: 94 ms, faster than 13.21% of Java online submissions for Longest Substring Without Repeating Characters.
    //Memory Usage: 39 MB, less than 74.70% of Java online submissions for Longest Substring Without Repeating Characters.
    public int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        int result = 0;

        for (int i = 0; i < charArray.length; ) { //first index of matching sequence
            int j = i + 1;
            while (j < charArray.length) { // target item to be checked in sequence

                char targetChar = charArray[j];
                boolean isMatched = false;

                for (int k = i; k < j; k++) { // all item in sequence to be checked with target char
                    char curChar = charArray[k];
                    if (curChar == targetChar) {
                        isMatched = true;
                        break;
                    }

                }

                int curSeqLen = j - i;
                if (curSeqLen > result)
                    result = curSeqLen;

                if (isMatched) {
                    i = j = i + 1;
                }
                j++; //increment j
            }
            result = (j - i) > result ? j - i : result;
            i = j;
        }


        return result;
    }


    //Runtime: 205 ms, faster than 7.09% of Java online submissions for Longest Substring Without Repeating Characters.
    public int lengthOfLongestSubstring2(String s) {
        int len = s.length();
        int result = 0;
        for (int i = 0; i < len; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < len; j++) {
                char ch = s.charAt(j);
                if (sb.toString().contains(String.valueOf(ch))) break;
                sb.append(ch);

            }
            int curLen = sb.length();
            if (curLen > result) {
                result = curLen;
            }
        }
        return result;
    }

    //Runtime: 84 ms, faster than 16.09% of Java online submissions for Longest Substring Without Repeating Characters.
    public int lengthOfLongestSubstring1(String s) {
        int len = s.length();
        int result = 0;
        Set<Character> charSet = null;
        for (int i = 0; i < len; i++) {
            if (len - i + 1 <= result) {
                System.out.println("already found longest nonrepeating sequence");
                break;
            }
            charSet = new HashSet<Character>();
            for (int j = i; j < len; j++) {

                char ch = s.charAt(j);
                boolean isAdded = charSet.add(ch);
                int curLen = charSet.size();
                System.out.println("i " + i + " j " + j + " ch " + ch + " curlen :" + curLen + " result " + result + " isadded " + isAdded);
                if (!isAdded) {
                    System.out.println(" repeate found ->");
                    if (curLen > result) {
                        result = curLen;
                        System.out.println("updated length to curLen" + curLen);
                    } else {
                        System.out.println("repeated but not updated" + curLen);
                    }

                    break;
                }
            }

        }
        System.out.println("final result " + result);
        return result;
    }


}
