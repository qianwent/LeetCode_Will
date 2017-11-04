package com.leetcode.hashtable.easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a data structure of employee information, which includes the employee's unique id, his importance value and his direct subordinates' id.

 For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3. They have importance value 15, 10 and 5, respectively. Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []]. Note that although employee 3 is also a subordinate of employee 1, the relationship is not direct.

 Now given the employee information of a company, and an employee id, you need to return the total importance value of this employee and all his subordinates.

 Example 1:
 Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 Output: 11
 Explanation:
 Employee 1 has importance value 5, and he has two direct subordinates: employee 2 and employee 3. They both have importance value 3. So the total importance value of employee 1 is 5 + 3 + 3 = 11.
 Note:
 One employee has at most one direct leader and may have several subordinates.
 The maximum number of employees won't exceed 2000.
 */
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
public class EmployeeImportance {

    //先看一个递归算法 recursion ，很重要，程序调用自身的编程技巧
    // 平时工作实战的时候居然很少用到，得回顾一下，看看是否能运用起来
    int total = 0;
    public int getImportance(List<Employee> employees, int id) {
        Employee manager = employees.stream().filter(e -> e.id == id).findFirst().get();
        total += manager.importance;
        manager.subordinates.stream().forEach(sub -> getImportance(employees, sub));//在处理递归的时候，思路得清晰
        //像这里的递归调用getImportance，第一个参数，显然是一个list，而这个list自始至终没有变过，是一个名单表，所以不用犹豫
        return total;
    }

    //在看一个DFS的递归算法
    //TODO: 对DFS的理解还处于似懂非懂的阶段，递归比较好理解，但是说用到图算法，还是比较晦涩
    public int getImportance_DFS(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for(Employee employee: employees) {
            map.put(employee.id, employee);
        }
        return getImportanceHelper(map, id);
    }

    //和第一种的递归思路是一致的，前面创建出来的map，是一个不变的表格，需要在递归中不断使用
    public int getImportanceHelper(Map<Integer, Employee> map, int rootId) {
        Employee rootEmployee = map.get(rootId);
        int total = rootEmployee.importance;
        for(int subordinate: rootEmployee.subordinates) {
            total += getImportanceHelper(map, subordinate);
        }
        return total;
    }

}
