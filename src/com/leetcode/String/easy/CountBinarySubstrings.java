package com.leetcode.String.easy;

/**
 * Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's,
 * and all the 0's and all the 1's in these substrings are grouped consecutively.

 Substrings that occur multiple times are counted the number of times they occur.

 Example 1:
 Input: "00110011"
 Output: 6
 Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's:
 "0011", "01", "1100", "10", "0011", and "01".

 Notice that some of these substrings repeat and are counted the number of times they occur.

 Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
 Example 2:
 Input: "10101"
 Output: 4
 Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
 Note:

 s.length will be between 1 and 50,000.
 s will only consist of "0" or "1" characters.
 */
public class CountBinarySubstrings {

    /*
    碰到这种题目，一开始是没有思路的，看过解答后，有这么一种感觉，如果一个算法题要计算类似这种子集个数
    或者说看起来似乎要进行一些数学计算的，那么最好先从sample中提取一些规律，把规律再转换成code
    同时这种规律也可以帮助判断是否和题意相符
    比如：s = "110001111000000"， 看成是groups = [2, 3, 4, 6]
    那么满足条件的就是形如'0' * k + '1' * k or '1' * k + '0' * k的binary string
    子集显然就是[2,3], [3,4], [4,6]
    每个子集中满足条件的substring个数就是小的那个数
     */
    public static int countBinarySubstrings_v0(String s) {
        int[] arr = new int[s.length()];
        int count = 0;
        arr[count] = 1;
        int prev = s.charAt(0);
        for(int i=1; i<s.length(); i++) {
            if(s.charAt(i) == prev) {
                arr[count]++;
            } else {
                prev = s.charAt(i);
                count++;
                arr[count]++;
//                arr[count++]++;//这么写count还没自增就arr[count]++了，显然不对
            }
        }
        int subStringCount = 0;
        /*
        TODO:这里注意一下s.length()，不是s.length()-1
        为什么？这是长久以来会搞混的第一感觉，必须纠正，因为每次去验证，就有点浪费时间了，这应该是可以形成肌肉记忆的
        在for loop中，这个边界条件是要小于string的总长度的，-1显然不合理
        那么什么时候会用到-1？目前为止，用得较多的是在左右指针夹逼的时候，右指针的index是s.length()-1
        注意：这两个场景区别还是非常明显的！
         */
        for(int i=1; i<s.length(); i++) {
            subStringCount += Math.min(arr[i-1], arr[i]);
        }
        return subStringCount;
    }

    //这个版本简化了一些代码，如：++count
    public int countBinarySubstrings_v1(String s) {
        int[] arr = new int[s.length()];
        int count = 0;
        arr[count] = 1;
        for(int i=1; i<s.length(); i++) {
            if(s.charAt(i) == s.charAt(i-1)) {
                arr[count]++;
            } else {
                arr[++count]++;
            }
        }
        int subStringCount = 0;
        for(int i=1; i<s.length(); i++) {
            subStringCount += Math.min(arr[i-1], arr[i]);
        }
        return subStringCount;
    }

    public static int countBinarySubstrings_v2_linear_scan_wrong(String s) {
        int count=0, prev=1, curr=0;
        for(int i=1; i<s.length(); i++) {
            if(s.charAt(i) == s.charAt(i-1)) {
                prev++;
//                count += Math.min(++prev, curr);
            } else {
                count += Math.min(prev, ++curr);
                prev = curr;
                curr = 0;
            }
        }
        return count;
    }

    public static int countBinarySubstrings_v2_linear_scan(String s) {
        //这个算法一开始比较难以理解，但是一旦理解了，还是比较顺畅的
        //比如这个string：000111000，数0的时候，是curr，当数到1的时候，先把000group，发现没有prev
        //那自然没有count，再从1数，数到又是0的时候，这个时候111就有prev了，正是比较000111，显然需要做min运算
        //最后，数完最后一个数，后面没法再进入else了，必须再做一次count += Math.min(prev, curr)运算
        int count=0, prev=0, curr=1;
        for(int i=1; i<s.length(); i++) {
            if(s.charAt(i) == s.charAt(i-1)) {
                curr++;
            } else {
                count += Math.min(prev, curr);
                prev = curr;
                curr = 1;
            }
        }
        return count += Math.min(prev, curr);
    }

    public static void main(String[] args) {
        int count = countBinarySubstrings_v2_linear_scan("000111000");
        System.out.println(count);
    }

}
