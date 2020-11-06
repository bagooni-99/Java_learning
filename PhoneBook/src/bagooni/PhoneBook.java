package bagooni;

import java.util.Scanner;

class Phone {
	String name, phone_number, gender;
	int height, weight;
	static int x = 0; // 이름 존재 확인용

	public Phone(String name, String phone_number, String gender, int height, int weight) {
		this.name = name; // 이름
		this.phone_number = phone_number; // 전화번호
		this.gender = gender;// 성별
		this.height = height;// 키
		this.weight = weight;// 몸무게
	}
}

public class PhoneBook {

	public static void main(String[] args) {
		int person;

		Scanner sc = new Scanner(System.in);
		System.out.print("인원수>>");
		person = sc.nextInt(); // 저장할 사람 수 입력

		Phone[] p = new Phone[person]; // Phone 클래스의 배열에 대한 레퍼런스 변수 p 선언, person개의 레퍼런스를 원소로 하는 배열 생

		for (int i = 0; i < person; i++) {
			System.out.print("이름과 전화번호, 성별, 키, 몸무게 입력>> ");
			String name = sc.next(); // 이름 입력
			String phone_number = sc.next(); // 전화번호 입력
			String gender = sc.next(); // 성별 입력
			int height = sc.nextInt(); // 키 입력
			int weight = sc.nextInt(); // 몸무게 입력
			p[i] = new Phone(name, phone_number, gender, height, weight); // 각각의 레퍼런스에 정보 저장
		}
		System.out.println("저장되었습니다...");

		while (true) {
			System.out.print("검색할 이름>>");
			String person_name = sc.next(); // 검색할 이름 입력

			if (person_name.equals("그만"))
				break; // 검색할 이름 == 그만이면 while문 나

			else {
				for (int i = 0; i < person; i++) {
					if (person_name.equals(p[i].name)) { // 검색한 이름이 존재하는 경우
						System.out.println("***" + p[i].name + "의 정보***");
						System.out.println("전화번호 : " + p[i].phone_number);
						System.out.println("성별 : " + p[i].gender);
						System.out.println("키 : " + p[i].height);
						Phone.x = 1; // 이름이 존재하는경우 x=1
					}
				}
				if (Phone.x == 0) // 검색한 이름이 없는 경우 x=0(그대로)
					System.out.println(person_name + " (는) 없습니다.");
				Phone.x = 0; // 검색을 위해 x를 0으로 초기화
			}
		}
	}

}
