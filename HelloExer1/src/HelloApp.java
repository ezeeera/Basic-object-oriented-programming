//=============================================================
//	Simple Hello Application in Java
//	콘솔 입출력
//=============================================================


import java.util.Scanner;

public class HelloApp {

 public static void main(String[] args) {
  Scanner s = new Scanner(System.in);

  System.out.print("반지름을 입력하세요: ");
  double radius = s.nextDouble();

  double area = Math.PI * radius * radius;
  System.out.println("원의 면적: " + area);

  s.close();
 }
}
