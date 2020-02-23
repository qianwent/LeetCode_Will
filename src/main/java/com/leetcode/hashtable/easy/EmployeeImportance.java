package com.leetcode.hashtable.easy;

import java.util.*;

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

    //�ȿ�һ���ݹ��㷨 recursion ������Ҫ��������������ı�̼���
    // ƽʱ����ʵս��ʱ���Ȼ�����õ����ûع�һ�£������Ƿ�����������
    int total = 0;
    public int getImportance(List<Employee> employees, int id) {
        Employee manager = employees.stream().filter(e -> e.id == id).findFirst().get();
        total += manager.importance;
        manager.subordinates.stream().forEach(sub -> getImportance(employees, sub));//�ڴ����ݹ��ʱ��˼·������
        //������ĵݹ����getImportance����һ����������Ȼ��һ��list�������list��ʼ����û�б������һ�������������Բ�����ԥ
        return total;
    }

    //�ڿ�һ��DFS�ĵݹ��㷨
    //TODO: ��DFS�����⻹�����ƶ��Ƕ��Ľ׶Σ��ݹ�ȽϺ����⣬����˵�õ�ͼ�㷨�����ǱȽϻ�ɬ
    public int getImportance_DFS(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for(Employee employee: employees) {
            map.put(employee.id, employee);
        }
        return getImportanceHelper(map, id);
    }

    //�͵�һ�ֵĵݹ�˼·��һ�µģ�ǰ�洴��������map����һ������ı�����Ҫ�ڵݹ��в���ʹ��
    public int getImportanceHelper(Map<Integer, Employee> map, int rootId) {
        Employee rootEmployee = map.get(rootId);
        int total = rootEmployee.importance;
        for(int subordinate: rootEmployee.subordinates) {
            total += getImportanceHelper(map, subordinate);
        }
        return total;
    }

    //�����֣�BFS, Breadth First Search��Ŀǰ���������㷨����Ҫ���ö��У��Ƚ��ȳ�
    //�ɽ���Զ�������ҳ��뵱ǰ�ڵ㣨vertex����������нڵ㣬Ȼ��һ��������ٱ����µ�һ��
    //�������㷨��һ���ǳ�����⣺���ȵñ�֤���ͼ�Ľṹ�������ݴ洢ʱ�Ľṹ������һ����׮�ṹ��
    //�����ӽڵ㲻�ܺȸ��ڵ��ظ�������Ŀǰ���ݴ���ó��Ľ��� TODO
    public int getImportance_BFS(List<Employee> employees, int id) {
        int total = 0;
        Map<Integer, Employee> map = new HashMap<>();
        for(Employee employee: employees) {
            map.put(employee.id, employee);
        }
        Queue<Employee> queue = new LinkedList<>();
        queue.offer(map.get(id));
        while (!queue.isEmpty()) {
            Employee currentEmployee = queue.poll();
            total += currentEmployee.importance;
            for(int subordinate: currentEmployee.subordinates) {
                queue.offer(map.get(subordinate));
                //�����߼��ͺ������Ƕ�queue�������ȱʧ��queue�����element�������ˣ�������װ�أ���ô���к�����whileѭ����
//                total += map.get(subordinate).importance;
            }
        }
        return total;
    }

}