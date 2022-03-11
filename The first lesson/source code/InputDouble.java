import java.util.*;
public class InputDouble{
  public static void main(String args[]){
    double a,b,c;
    Scanner reader = new Scanner(System.in);
    System.out.println("从键盘输入一个浮点数");
    a = reader.nextDouble();
    b = a*a;
    c = a*a*a;
    System.out.println("数字b的值为: "+b);
    System.out.println("数字c的值为: "+c);
  }
}
