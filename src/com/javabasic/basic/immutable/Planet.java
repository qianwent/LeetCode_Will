package com.javabasic.basic.immutable;

import java.util.Date;

/**
 * Created by Wentao Qian on 2/13/2018.
 *
 * https://softwareengineering.stackexchange.com/questions/151733/if-immutable-objects-are-good-why-do-people-keep-creating-mutable-objects
 * �ȿ�������Ļش𣬿��Կ���immutable object�����϶��Ǵ�ģ������ܱ�����̴߳���������
 * ����һ��web APP���û��ʲô���̵߳Ļ�����Ȼ��û��Ҫ��immutable�ģ�����spring�����ﶼ�ǵ���һ��
 * ÿ��objectһ��û��ʲô˽������(������Щautowire������)��ͨ��web������Ķ���߳̿���ͬһ��object��ʱ��
 * ���������ķ�������copy�����������������object��Ҫһ�δε�copy���ǿ����ö��
 * Ŀǰ��������û������ʲô��Ҫ��immutable�ĳ��������Ļ��ǲ����డ������
 *
 * https://my.oschina.net/jackieyeah/blog/205198?fromerr=yJ78hGIV
 *
 * Planet��һ�����ɱ��࣬��Ϊ�����������֮��û�а취�ı�����״̬
 */
public class Planet {

    /**
     * ����Ϊfinal�Ļ��������������ǲ��ɱ��
     */
    private final double fMass;
    /**
     * ���ɱ�Ķ������� (String���󲻿ɱ�)
     */
    private final String fName;
    /**
     * �ɱ�Ķ�������. �����������, ����ɱ�����ֻ�ܱ������ı䡣
     * (�����������, ������ԭ�����ⲿ�ı�һ�������Ǻ��������;
     * ����������ǵ�������Ϊ�����ط�������һ����������)
     */
    private final Date fDateOfDiscovery;
    public Planet(double aMass, String aName, Date aDateOfDiscovery) {
        fMass = aMass;
        fName = aName;
        //����aDateOfDiscovery��һ��˽�п���
        //���Ǳ���fDateOfDiscovery����Ϊprivate��Ψһ��ʽ, ���ұ������
        //�಻�ܵ����߶���ԭʼaDateOfDiscovery���������κθı��Ӱ��
        fDateOfDiscovery = new Date(aDateOfDiscovery.getTime());
    }
    /**
     * ����һ����������ֵ.
     *
     * �����߿�������ı䷵��ֵ,���ǲ���Ӱ�����ڲ���
     */
    public double getMass() {
        return fMass;
    }
    /**
     * ����һ�����ɱ����
     *
     * �����ߵõ��ڲ����Ե�һ��ֱ������. ����String�ǲ��ɱ������ûʲôӰ��
     */
    public String getName() {
        return fName;
    }
// /**
// * ����һ���ɱ���� - ����һ���õķ�ʽ.
// *
// * �����ߵõ��ڲ����Ե�һ��ֱ������. ��ͨ����Σ��,��ΪDate����ȿ���
// * �������ı�Ҳ���Ա����ĵ����߸ı�.��,�಻�ٶ�fDateӵ�о��ԵĿ��ơ�
// */
// public Date getDateOfDiscovery() {
// return fDateOfDiscovery;
// }
    /**
     * ����һ���ɱ���� - �õķ�ʽ.
     *
     * �������Ե�һ�������Կ���.�����߿�������ı䷵�ص�Date����,���ǲ���
     * Ӱ������ڲ�.Ϊʲô? ��Ϊ����û��fDate��һ������. ��׼ȷ��˵, ����
     * ʹ�õ��Ǻ�fDate������ͬ���ݵ���һ��Date����
     */
    public Date getDateOfDiscovery() {
        return new Date(fDateOfDiscovery.getTime());
    }
    /**
     * ���Է���
     * @param args
     */
    public static void main(String[] args) {
        Planet planet = new Planet(1.0D, "earth", new Date());
        Date date = planet.getDateOfDiscovery();
        date.setTime(111111111L);
        System.out.println("the value of fDateOfDiscovery of internal class : " + planet.fDateOfDiscovery.getTime());
        System.out.println("the value of date after change its value : " + date.getTime());
    }

}
