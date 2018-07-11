package bank_casher;

import java.util.ArrayList;
import java.util.Scanner;

public class bank_casher {
	bank_casher() {
		Scanner a = new Scanner(System.in);
		int remain = 0;
		String line = "-";
		String lines = "";
		for (int i = 0; i < 40; i++) {
			lines += line;
		}
		String menuString = "1. 예금  | 2. 출금  | 3. 잔고  | 4. 종료  |";
		String selectStr = "선택> ";
		String depositStr = "입금액> ";
		String drawStr = "출금액> ";
		String remainStr = "잔고> ";
		String nextLine = "\n";
		String menu = lines + nextLine + menuString + nextLine + lines + nextLine + selectStr;
		ArrayList<String> menuNum = new ArrayList<String>();
		menuNum.add("1");
		menuNum.add("2");
		menuNum.add("3");
		menuNum.add("4");

		while (true) {
			System.out.print(menu);
			String choice = a.next();
			if (choice.equals("4")) {
				System.out.println("\n프로그램 종료");
				break;
			}
			if (menuNum.contains(choice)) {
				switch (choice) {
				case ("1"):
					System.out.print(depositStr);
					int deposit = a.nextInt();
					remain += deposit;
					break;
				case ("2"):
					System.out.print(drawStr);
					int draw = a.nextInt();
					if (remain >= draw) {
						remain -= draw;
						break;
					} else {
						System.out.println("잔액이 부족합니다. 처음부터 다시 시작해주세요.");
						break;
					}
				case ("3"):
					System.out.println(remainStr + "  " + remain);
					break;
				}
			} else {
				System.out.println("***잘못된 키를 누르셨습니다. 다시 선택해주세요***");
			}
		}
	}

	public static void main(String[] args) {
		bank_casher one = new bank_casher();

	}

}
