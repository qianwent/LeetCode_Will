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
    //����������Ǿ���Ļ��ۣ����Ҫ��ĳ���ĵ����Ƿ������������ַ�������regex�ٺ��ʲ�����
    //TODO:��Ȼд���򵥣�����Ч�ʲ�һ����ã���Ȼһ������£��������ַ���ƥ������Ķ�������Ч���ϲ�����̫��ע
    public boolean checkRecord(String s) {
        return !s.matches(".*LLL.*|.*A.*A.*");
    }
}
