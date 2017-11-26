package com.leetcode.String.easy;

/**
 * You are given a string representing an attendance record for a student. The record only contains the following
 * three characters:

 'A' : Absent.
 'L' : Late.
 'P' : Present.
 A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent)
 or more than two continuous 'L' (late).

 You need to return whether the student could be rewarded according to his attendance record.

 Example 1:
 Input: "PPALLP"
 Output: True
 Example 2:
 Input: "PPALLL"
 Output: False
 */
public class StudentAttendanceRecordI {
    //看看，这就是经验的积累，如果要查某个文档里是否含有特殊规则的字符串，用regex再合适不过了
    //TODO:虽然写法简单，但是效率不一定最好，当然一般情况下，有这种字符串匹配需求的东西可能效率上并不是太关注
    public boolean checkRecord(String s) {
        return !s.matches(".*LLL.*|.*A.*A.*");
    }
}
