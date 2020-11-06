package bagooni;

import java.util.Random;
import java.util.Scanner;

public class GBBGame {
	public static void main(String[] args) {
		int n = 1; // 게임 횟수
		int a = 0; // 철수 이긴 판
		int b = 0; // 명희 이긴 판
		int c = 0; // 무승부
		int suma = 0;
		int sumb = 0;

		Scanner scanner = new Scanner(System.in);
		Random rand = new Random();
		System.out.println("*********가위바위보 하고 돈따먹기!*********");
		System.out.println("");
		System.out.println("");
		while (n <= 10) {
			System.out.println(n + "번째 가위바위보 게임입니다. 가위, 바위, 보 중에서 입력하세요.");
			System.out.print("철수 >> ");
			String ch = scanner.next();
			System.out.print("명희 >> ");
			String my = scanner.next();
			if (ch.equals("가위")) {
				if (my.equals("가위")) {
					System.out.println("비겼습니다.");
					c++;
				} else if (my.equals("바위")) {
					System.out.println("명희가 이겼습니다.");
					b++;
				} else {
					System.out.println("철수가 이겼습니다.");
					a++;
				}
			} else if (ch.equals("바위")) {
				if (my.equals("바위")) {
					System.out.println("비겼습니다.");
					c++;
				} else if (my.equals("보")) {
					System.out.println("명희가 이겼습니다.");
					b++;
				} else {
					System.out.println("철수가 이겼습니다.");
					a++;
				}
			} else {
				if (my.equals("보")) {
					System.out.println("비겼습니다.");
					c++;
				} else if (my.equals("가위")) {
					System.out.println("명희가 이겼습니다.");
					b++;
				} else {
					System.out.println("철수가 이겼습니다.");
					a++;
				}
			}
			n++;
		}
		System.out.println("");
		System.out.println("10판 중 무승부 : " + c + "번, 철수 : " + a + "번, 명희 : " + b + "번 이겼습니다.");
		System.out.println("");
		System.out.println("철수의 룰렛 횟수 : " + a + ", 명희의 룰렛 횟수 : " + b);
		for (int i = 0; i < a; i++) {
			int iValue = rand.nextInt(11) * 100;
			suma += iValue;
			System.out.println("철수의 " + (i+1) + "번째 금액 : " + iValue + "원");
		}
		System.out.println("");
		System.out.println("");
		for (int i = 0; i < b; i++) {
			int iValue = rand.nextInt(11) * 100;
			sumb += iValue;
			System.out.println("명희의 " + (i+1) + "번째 금액 : " + iValue + "원");
		}
		System.out.println("");
		System.out.println("");
		System.out.println("*********************************");
		System.out.println("철수는 총 " + suma + "원 얻었습니다!");
		System.out.println("명희는 총 " + sumb + "원 얻었습니다!");
		System.out.println("*********************************");
	}

}
