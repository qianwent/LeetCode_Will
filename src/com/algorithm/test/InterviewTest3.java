package com.algorithm.test;

/**
 * Created by Wentao Qian on 11/27/2017.
 */
public class InterviewTest3 {

    /*
    https://stackoverflow.com/questions/40002762/how-to-do-object-getclass-getname-in-java
    �����ˣ���Ȼ��������𡣡���
    ��ʱ�����ʱ������±��ˣ�����Ȼ��ƽʱ�����Ĺ���ģʽ��һ����
     */
    public static void main(String[] args) {
        FoodFactory myFoods = new FoodFactory();
        Food food1 = myFoods.getFood("FastFood");
        Food food2 = myFoods.getFood("Fruit");
        //2.��������������getClass().getName()һ���Ƿ�������������
        //�����������FoodFactory$1��˵������new��������һ��anonymous class
        //������Ҫ������Ǵ����string��Ϊ���������������ʱ��ȷ���벻����˼ά���Ǿ��ް�
        //�����ܹ���ȷ����Ҫ�õ����ȷ�е����������Ǳ���Ҫ�����string����Ϊ����
        //��ô��ǿ��Ҫ���������뱻��������
        System.out.println(food1.getClass().getName());//FastFood
        System.out.println(food2.getClass().getName());//Fruit
        System.out.println(food1.getClass().getSuperclass().getName());
        food1.serveFood();//Ϊ��ʹ�ñ���ͨ����Food���ﻹ���뱣���������
        //�������constructor����ô�����࿴�����Ƚ���֣���Ȼ����ȷ��
        //֮���Ƴ�constructor����Food���serveFood������������getClass().getSimpleName()
        food2.serveFood();
    }

}

class Food {

//    public void setFoodName(String foodName) {
//        this.foodName = foodName;
//    }
//
//    public String getFoodName() {
//        return foodName;
//    }
//
//    private String foodName;

    public void serveFood() {
        //TODO��������ǰ�������һ�θ�ϰ��Java����̳е�����
        //FastFood extends Food����ΪFood����һ��abstract class��
        // ���Լ�ʹ���಻override���������������Ȼ����ʹ���������
        /*TODO�������������������Ȼ��ͨ���ˣ�����������֮������Ҳֻ�����ǿ����õ�������Ŀ�ˣ�
        I don't think this is a good practice, let's see if someday I can see such code in real world...
         */
        System.out.println("I'm serving " + getClass().getSimpleName());
    }

//    @Override
//    public String toString() {
//        return foodName;
//    }
}

//1.����о������Ի��õģ���Ϊ��Ȼ���﹤���̳�ʳ���ǲ�����ģ����ǵ�ʱ�����ſ���֮�󣬾�û�и���ô����ȥ
//û����ô����ȥҲ�ǶԵġ�������Ŀ�о�Ȼ��food1.getClass().getSuperclass().getName()����ӡ������Food��������û�취��
//��Ȼ����extend������extend�ɡ�����
class FoodFactory extends Food {
    public Food getFood(String foodName) {
        switch (foodName) {
            case "FastFood" : return new FastFood();
            case "Fruit" : return new Fruit();
//            case "FastFood" : return new FastFood("FastFood");//���д��������ƥ����Ӧ��constructor��
//            case "Fruit" : return new Fruit("Fruit");
//            case "FastFood" : return new FastFood(){{this.setFoodName(foodName);}};
//            case "Fruit" : return new Fruit(){{this.setFoodName(foodName);}};
        }
//        if("FastFood".equals(foodName)) {
//            return new FastFood();
//        } else if("Fruit".equals(foodName)) {
//            return new Fruit();
//        }
        throw new IllegalArgumentException("No food found with name " + foodName);
//        return new Food(){{setFoodName(food);}};
    }

    //TODO��toString�����ܽ�
//    @Override
//    public String toString() {
//        return this.getFoodName();
//    }

}

//�������ݣ����Խ������˴𰸲�д�µ�
class FastFood extends Food {
//    String name;
//    FastFood(String name) {
//        this.name = name;
//    }
//    @Override
//    public void serveFood() {
//        System.out.println("I'm serving " + name);
//    }
}

class Fruit extends Food {
//    String name;
//    Fruit(String name) {
//        this.name = name;
//    }
//    @Override
//    public void serveFood() {
//        System.out.println("I'm serving " + name);
//    }
}
