package main;

import java.util.Scanner;

import dao.ManagerDAO;

public class ManagerEx {
	public void managerManage() {

		Scanner scan = new Scanner(System.in);

		ManagerDAO Md = new ManagerDAO();

		int select;

		while (true) {
			do {
				System.out.println(" [ �������� ���α׷��� ] ");
				System.out.print("========================\n");
				System.out.println(
						"[1. ������ ��ü ��ȸ]\n[2. ���� ������ ��ȸ]\n[3. ������ ȸ�� ����]\n[4. ������ ���� ����]\n[5. ������ Ż��]\n[6. ����] ");
				System.out.print("========================\n�Է�:  ");
				select = scan.nextInt();

			} while (select < 1 || select > 6);

			System.out.println();

			switch (select) {

			case 1:
				Md.searchAll(); //
				System.out.println();
				break;
			case 2:
				Md.searchOne();
				System.out.println();
				break;
			case 3:
				Md.insert();
				System.out.println();
				break;
			case 4:
				Md.update();
				System.out.println();
				break;
			case 5:
				Md.delete();
				System.out.println();
				break;
			case 6:
				System.out.println(" [ ���α׷��� ����Ǿ����ϴ�. ] ");
				new MainLogin().executeProgram();// �ٽ� ù �α��� ȭ������
			}
		}
	}
}
