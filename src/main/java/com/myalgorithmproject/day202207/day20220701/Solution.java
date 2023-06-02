package com.myalgorithmproject.day202207.day20220701;

import org.junit.jupiter.api.Test;

import java.util.*;

class Solution1 {

    public static void main(String[] args) {
        //[0,  0, 0,  0, null, null,  0, 0, 0, 0, 0]
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.left.left = new TreeNode(0);
        root.left.left.right = new TreeNode(0);
        root.right.right = new TreeNode(0);
        root.right.right.left = new TreeNode(0);
        root.right.right.right = new TreeNode(0);
        findDuplicateSubtrees(root);

    }

    private static Map<String, Integer> map = new HashMap<>();
    private static List<TreeNode> reslut = new ArrayList<>();

    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return reslut;
    }

    public static String dfs(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append("(");
        sb.append(dfs(root.left));
        sb.append(")(");
        sb.append(dfs(root.right));
        sb.append(")");
        String s = sb.toString();
        if (map.containsKey(s) && map.get(s) == 1) {
            reslut.add(root);
            map.put(s, map.get(s) + 1);
        } else {
            map.put(s, 1);
        }
        return s;
    }

}

class Solution2 {
    public String reorderSpaces(String text) {
        char[] chars = text.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                sb.append(chars[i]);
            }
        }
        char[] chars1 = sb.toString().toCharArray();
        String[] s = text.trim().split(" ");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            if (!s[i].equals("")) {
                list.add(s[i]);
            }
        }
        int num_2 = 0;
        int num_3 = 0;
        if (list.size() != 1) {
            num_2 = chars1.length % (list.size() - 1);
            num_3 = chars1.length / (list.size() - 1);
        } else {
            num_2 = chars1.length;
        }

        StringBuilder result = new StringBuilder();
        char[] chars3 = new char[num_3];
        Arrays.fill(chars3, ' ');
        String s3 = new String(chars3);

        char[] chars2 = new char[num_2];
        Arrays.fill(chars2, ' ');
        String s2 = new String(chars2);
        for (int i = 0; i < list.size(); i++) {
            result.append(list.get(i));
            if (i != list.size() - 1) {
                result.append(s3);
            }
        }
        return result.append(s2).toString();
    }

    @Test
    public void test() {
        String s = "  this   is  a sentence ";
        reorderSpaces(s);
    }
}

class Solution8 {
    // 45321
    public int maximumSwap(int num) {
        String str = String.valueOf(num);
        char[] chars = str.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
//            char tempMax = chars[i];
            int indexMax = i;
            for (int j = i + 1; j < length; j++) {

                if (chars[indexMax] < chars[j]) {
//                    tempMax = chars[j];
                    indexMax = j;
                }
            }
            if (indexMax != i) {
                char temp = chars[i];
                chars[i] = chars[indexMax];
                chars[indexMax] = temp;
                return (int) Integer.valueOf(new String(chars));
            }

        }
        return num;
    }

    @Test
    public void test() {
        int i = maximumSwap(98368);
        System.out.println(i);

    }
}

class Solution9 {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int v = (int) ((int) arr.length * 0.02);
        int sum = 0;
        for (int i = v; i < arr.length - v; i++) {
            sum += arr[i];
        }
        return sum / (arr.length - 2 * v);

    }
}

class Solution10 {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return new String(chars1).equals(new String(chars2));
    }

    @Test
    public void test() {
        boolean i = CheckPermutation("abc", "bca");
        System.out.println(i);

    }
}

class Solution11 {
    public int minAddToMakeValid(String s) {
        while (s.contains("()")) {
            s.replace("()", "");
        }
        return s.length();

    }
}

class Solution12 {
    public boolean areAlmostEqual(String s1, String s2) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                list.add(i);
            }
        }
        if (list.size() == 0) {
            return true;
        }
        if (list.size() == 1 || list.size() > 2) {
            return false;
        }
        char c1 = s2.charAt(list.get(0));
        char c2 = s2.charAt(list.get(1));
        char[] chars = s2.toCharArray();
        chars[list.get(0)] = c2;
        chars[list.get(1)] = c1;
        return s1.equals(new String(chars));


    }


    class Solution13 {
        public List<String> buildArray(int[] target, int n) {
            List<String> list = new ArrayList<>();
            int index = 1;
            int leng = target.length;
            for (int i = 1; i <= target[leng - 1]; i++) {
                if (target[i - 1] == index) {
                    list.add("Push");
                    index++;
                } else {
                    list.add("Push");
                    list.add("Pop");
                    index++;
                }
            }
            return list;
        }
    }


}

class Solution14 {
    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }
        int lenght = (int) Math.pow(2, n - 1);
        char[] result = new char[lenght];
        result[0] = '0';
        for (int i = 2; i <= n; i++) {
            String s = new String(result);
            char[] chars = s.substring(0, (int) Math.pow(2, i - 2)).toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '0') {
                    result[2 * j] = '0';
                    result[2 * j + 1] = '1';
                } else {
                    result[2 * j] = '1';
                    result[2 * j + 1] = '0';
                }
            }
        }
        return Integer.parseInt("" + result[k - 1]);

    }

    @Test
    public void test14() {
        kthGrammar(2, 1);

    }
}

class Solution23 {
    public String mergeAlternately(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        StringBuilder sb = new StringBuilder();
        if (length1 >= length2) {
            for (int i = 0; i < length2; i++) {
                sb.append(word1.charAt(i));
                sb.append(word2.charAt(i));
            }
            sb.append(word1.substring(length2, length1));
        } else {
            for (int i = 0; i < length1; i++) {
                sb.append(word1.charAt(i));
                sb.append(word2.charAt(i));
            }
            sb.append(word1.substring(length1, length2));
        }
        return sb.toString();
    }
}

class Solution16 {
    public int partitionDisjoint(int[] nums) {
        int max = nums[0];
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            boolean flag = true;
            for (int j = i + 1; j < nums.length; j++) {
                if (max >= nums[j]) {
                    flag = false;
                    index = j;
                }
            }
            if (!flag) {
                break;
            }
            max = Math.max(max, nums[i]);
        }
        return index + 1;

    }
}

class Solution24 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int index = -1;
        if ("type".equals(ruleKey)) {
            index = 0;
        } else if ("color".equals(ruleKey)) {
            index = 1;
        } else if ("name".equals(ruleKey)) {
            index = 2;
        } else {
            index = -1;
        }
        if (index == -1) {
            return 0;
        }
        int num = 0;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).get(index).equals(ruleValue)) {
                num++;
            }

        }
        return num;

    }
}

class Solution29 {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        char[] chars = s.toCharArray();
        dfs(chars, res, 0);
        return res;
    }

    public void dfs(char[] chars, List<String> res, int index) {
        res.add(String.valueOf(chars));
        for (int i = index; i < chars.length; i++) {
            char c = chars[i];
            if (c >= '0' && c <= '9') {
                continue;
            } else if (c >= 'A' && c <= 'Z') {
                chars[i] = (char) (c + 32);
                dfs(chars, res, i + 1);
                chars[i] = c;
            } else {
                chars[i] = (char) (c - 32);
                dfs(chars, res, i + 1);
                chars[i] = c;
            }
        }

    }
}

class Solution43 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        Arrays.sort(word1);
        Arrays.sort(word2);
        String s1 = String.valueOf(word1);
        String s2 = String.valueOf(word2);
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }

        }
        return true;


    }
}

class Solution44 {
    public int countConsistentStrings(String allowed, String[] words) {
        int num = 0;
        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            boolean flag = true;
            for (int j = 0; j < chars.length; j++) {
                if (!allowed.contains(String.valueOf(chars[j]))) {
                    flag = false;
                    break;
                }
            }
            if (flag) num++;
        }
        return num;

    }
}

//class Solution45 {
//    public void countConsistentStrings(String allowed, String[] words) {
//        Apple allpe1 = new Apple(12, "apple1");
//        Apple allpe2 = new Apple(8, "apple2");
//        Apple allpe3 = new Apple(20, "apple3");
//        List<Apple> list = Arrays.asList(allpe1, allpe2, allpe3);
//        list.sort(new Comparator<Apple>() {
//            @Override
//            public int compare(Apple o1, Apple o2) {
//                return o1.getWeight() - o2.getWeight();
//            }
//        });
//        list.sort(comparing(Apple::getWeight));
//    }
//}

//class Apple {
//
//    public Apple(int weight, String name) {
//        this.weight = weight;
//        this.name = name;
//    }
//
//    private int weight;
//    private String name;
//
//    public int getWeight() {
//        return weight;
//    }
//
//    public void setWeight(int weight) {
//        this.weight = weight;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//}

/**
 * 剑指002
 * 我想的和题解大致思路差不多，也是模拟加法运算的过程，不过看起来题解对char的应用在时间、空间上都要高效一些
 */
class Solution46 {
    public static String addBinary(String a, String b) {
        int alenght = a.length();
        int blenght = b.length();
        if (alenght >= blenght) {
            char[] tem = new char[alenght - blenght];
            Arrays.fill(tem, '0');
            String s = new String(tem);
            b = s + b;
        } else {
            char[] tem = new char[blenght - alenght];
            Arrays.fill(tem, '0');
            String s = new String(tem);
            a = s + a;
        }
        int lenght = Math.max(alenght, blenght);
        StringBuilder sb = new StringBuilder();
        int ch = 0;
        for (int i = 0; i < lenght; i++) {
            int ach = Integer.parseInt(String.valueOf(a.charAt(lenght - 1 - i)));
            int bch = Integer.parseInt(String.valueOf(b.charAt(lenght - 1 - i)));
            if (ach + bch + ch > 1) {
                int res = (ach + bch + ch) % 2;
                sb.append(res);
                ch = 1;
            } else {
                sb.append(ach + bch + ch);
                ch = 0;
            }
        }
        if (ch == 1) {
            sb.append('1');
        }
        return sb.reverse().toString();

    }

    public static void main(String[] args) {
        String s = addBinary("11", "10");

        String s2 = addBinary2("11", "10");
    }

    /**
     * 官方题解
     *
     * @param a
     * @param b
     * @return
     */
    public static String addBinary2(String a, String b) {
        StringBuilder ans = new StringBuilder();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();

    }
}


class Solution47 {
    public static int[] countBits(int n) {
        int[] ins = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ins[i] = Integer.bitCount(i);
        }
        return ins;
    }

    public static void main(String[] args) {
        int[] ints = countBits(7);
        System.out.println(ints);
    }

    public static int[] countBits_2(int n) {
        int[] ins = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ins[i] = getBitCount(i);
        }
        return ins;
    }

    public static int getBitCount(int n) {
        int res = 0;
        while (n > 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }
}

class Solution48 {
    public static int singleNumber(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        Arrays.sort(nums);
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            return nums[nums.length - 1];
        }

        int res = nums[0];
        // 边界条件
        for (int i = 1; i < nums.length-1; i++) {
            if(nums[i-1] != nums[i] && nums[i] != nums[i+1]){
                return nums[i];
            }
        }

        return res;

    }

    public static void main(String[] args) {
        int[] nums = {30000,500,100,30000,100,30000,100};
        int singleNumber = singleNumber(nums);
        System.out.println(singleNumber);
    }
}

class Solution49 {
    public int maxProduct(String[] words) {
        // 看了题解，纯纯布隆过滤器的思路
        int res = 0;
        int[] nums = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                nums[i] |= (1 << words[i].charAt(j) - 'a');
            }
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if((nums[i] & nums[j]) ==0){
                    res = Math.max(res,words[i].length()*words[j].length());
                }

            }

        }
        return res;

    }
}
