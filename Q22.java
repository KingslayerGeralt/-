/*
  上机题Q22

  写出一个满足Singleton模式地类出来

  更新于2019.06.04

  Author：黄亮亮

 */

package TheExam1_2;

public class Q22 {
    //创建自己的对象
    private static Q22 instance = new Q22();

    //用private修饰构造方法，此类就不会被实例化
    private Q22(){}

    public static Q22 getInstance(){
        return instance;
    }
    //写一个show方法，可以调用
    public void show(){
        System.out.println("Here is Singleton Message");
    }
}
