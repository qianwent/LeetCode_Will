package com.algorithm.test;

/**
 * Created by Wentao Qian on 11/27/2017.
 */
public class InterviewTest3 {

    /*
    https://stackoverflow.com/questions/40002762/how-to-do-object-getclass-getname-in-java
    无语了，居然有完整解答。。。
    当时看题的时候真的懵逼了，这显然和平时看到的工厂模式不一样，
     */
    public static void main(String[] args) {
        FoodFactory myFoods = new FoodFactory();
        Food food1 = myFoods.getFood("FastFood");
        Food food2 = myFoods.getFood("Fruit");
        //2.根据搜索，发现getClass().getName()一定是返回这个类的类名
        //如果返回类似FoodFactory$1，说明我们new出来的是一个anonymous class
        //而题意要求必须是传入的string作为这个类名。。。当时的确是想不到，思维还是局限啊
        //现在能够明确的是要得到这个确切的类名，我们必须要用这个string来作为类名
        //那么就强制要求这个类必须被创建出来
        System.out.println(food1.getClass().getName());//FastFood
        System.out.println(food2.getClass().getName());//Fruit
        System.out.println(food1.getClass().getSuperclass().getName());
        food1.serveFood();//为了使得编译通过，Food类里还必须保留这个方法
        //如果保留constructor，那么各个类看起来比较奇怪，虽然答案正确了
        //之后移除constructor，在Food类的serveFood方法里添加这个getClass().getSimpleName()
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
        //TODO：这个倒是帮助我又一次复习了Java里面继承的特性
        //FastFood extends Food，因为Food不是一个abstract class，
        // 所以即使子类不override这个方法，子类依然可以使用这个方法
        /*TODO：不过现在这个代码虽然能通过了，但是依个人之见，这也只能算是考试用的无聊题目了，
        I don't think this is a good practice, let's see if someday I can see such code in real world...
         */
        System.out.println("I'm serving " + getClass().getSimpleName());
    }

//    @Override
//    public String toString() {
//        return foodName;
//    }
}

//1.这个感觉像是迷惑用的，因为显然这里工厂继承食物是不合理的，但是当时被紧张控制之后，就没有敢这么想下去
//没有这么想下去也是对的。。。题目中居然有food1.getClass().getSuperclass().getName()，打印必须是Food。。。那没办法了
//既然它想extend就让它extend吧。。。
class FoodFactory extends Food {
    public Food getFood(String foodName) {
        switch (foodName) {
            case "FastFood" : return new FastFood();
            case "Fruit" : return new Fruit();
//            case "FastFood" : return new FastFood("FastFood");//这个写法是用来匹配相应的constructor的
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

    //TODO：toString还需总结
//    @Override
//    public String toString() {
//        return this.getFoodName();
//    }

}

//补充内容，笔试结束后看了答案才写下的
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
