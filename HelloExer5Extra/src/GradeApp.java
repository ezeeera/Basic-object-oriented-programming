//=============================================================
//	Grade Application in Java
//  5명의 국어와 수학 점수 입력, 각 과목의 최고점, 최저점, 총점, 평균 구함
//=============================================================

import java.util.Scanner;

public class GradeApp {
	
	public static void main(String[] args) {
		final int COUNT = 5;
		int scores[] = {-1, -1, -1, -1, -1};
		String names[] = {null, null, null, null, null};
		Scanner scan = new Scanner(System.in);
		
		for(int i = 0; i < COUNT; i++) {
			System.out.print((i+1) + "번째 응시자의 이름과 점수: ");
			names[i] = scan.next();
			scores[i] = scan.nextInt();
		}
		
		int total = 0;
		for(int i = 0; i < COUNT; i++) {
			total = total + scores[i];
		}
		double avg = total / COUNT;
		System.out.println("평균: " + avg);
		
		
		int choice;
		System.out.println();
		System.out.print("\n합격 기준을 선택하세요: (1)60점 이상 (2)평균 이상: ");
		choice = scan.nextInt();
		
		scan.close();
		
		int count = 0;
		System.out.println();
		System.out.println("합격자 명단");
		System.out.println("---------------");
		if(choice == 1) {
			for(int i = 0; i < COUNT; i++) {
                if(scores[i] >= 60) {
                    System.out.println(names[i] + " " + scores[i] + "합격");
                    count = count + 1;
                }
                else {
                    System.out.println(names[i] + " " + scores[i] + "불합격");
                }
			}
		} else {
                for(int i = 0; i < COUNT; i++) {
                    if(scores[i] >= avg) {
                        System.out.println(names[i] + " " + scores[i] + "합격");
                        count = count + 1;
                    }
                    else {
                        System.out.println(names[i] + " " + scores[i] + "불합격");
                    }
                }
		}
               System.out.println();
               System.out.println("합격자 수: " + count);
		}
	}