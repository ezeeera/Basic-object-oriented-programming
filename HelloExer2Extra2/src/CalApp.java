//=============================================================
//	Simple Calculator Application in Java
//  콘솔 윈도우에 두 실수를 임력하고 + - * / 중 선태갛면 계산 결과를 출력
//=============================================================

import java.util.Scanner;

public class CalApp {

	public static void main(String[] args) {
		double x, y;
		int op;
		Scanner s = new Scanner(System.in);
		System.out.print("두 실수를 입력하세요: ");
		x = s.nextDouble();
		y = s.nextDouble();
		System.out.println("원하는 연산의 번호를 선택하세요");
		System.out.print("(1) +, (2) -, (3) *, (4) /, (5) exit: ");
		op = s.nextInt();
		while (op != 5) {
			switch (op) {
			case 1:
				System.out.println("덧셈 결과는 " + (x + y) + "입니다");
				break;
			case 2:
				System.out.println("뺄셈 결과는 " + (x - y) + "입니다");
				break;
			case 3:
				System.out.println("곱셈 결과는 " + (x * y) + "입니다");
				break;
			case 4:
				while (y == 0) {
					System.out.print("0.0으로 나눌 수 없습니다. 두 번째 실수를 다시 입력해 주세요: ");
					y = s.nextDouble();
				}
				System.out.println("나눗셈 결과는 " + (x / y) + "입니다");
				break;
				
			default:
				System.err.println("입력 오류!!");
			}
			System.out.print("두 실수를 입력하세요: ");
			x = s.nextDouble();
			y = s.nextDouble();
			System.out.println("원하는 연산의 번호를 선택하세요");
			System.out.print("(1) +, (2) -, (3) *, (4) /, (5) exit: ");
			op = s.nextInt();
		}
		s.close();
	}
}
