package main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import Exception.MyException;
import Exception.MyException2;
import dao.ManagerDAO;
import dto.ManagerDTO;

public class MainLogin {
	Scanner scan = new Scanner(System.in); // ���δ��� �Է� ��ĳ��

	// �׳� �α��θ� (����Ʈ �ø�)
	public void LoginAction() {
		try {
			HashMap<String, String> map = new HashMap<String, String>(); // ���̵� ��� ��ġ��
			HashMap<String, String> map2 = new HashMap<String, String>(); // �̸� ��¿�

			ManagerDAO dao = new ManagerDAO();
			ArrayList<ManagerDTO> members = new ArrayList<ManagerDTO>();
			members = dao.getManagers();

			for (int i = 0; i < members.size(); i++) {
				map.put(members.get(i).getM_Id(), members.get(i).getM_Pwd());
				map2.put(members.get(i).getM_Id(), members.get(i).getM_Name());
			}

			int count = 0; // ī��Ʈ ����
			while (true) {

				System.out.println("[ �α��� ȭ�� ] ");
				System.out.println("���̵�� ��й�ȣ�� �Է��ϼ���.");
				System.out.print("ID: ");
				String id = scan.nextLine().trim();

				System.out.print("PASSWORD: ");
				String password = scan.nextLine().trim();
				System.out.println();

				if (!map.containsKey(id)) { // �Է��� ���̵� �ؽ��� Ű�� �� ���� �ʴٸ�
					System.out.println("[���] �Է��Ͻ� ID�� �������� �ʽ��ϴ�!  �ٽ� �Է� ���ּ���. ");
					count++;
					System.out.println(" [�Է� ���� Ƚ��] = " + (5 - count) + "[ȸ]");
					if (count == 5) {
						System.out.println("[ �Է� Ƚ�� �ʰ��� ���������մϴ�.]");
						System.exit(0); // ���� ����
					}
					// continue; // �̰� ��� ���ص� �� �� ����
				} else {
					if (!(map.get(id).equals(password))) {
						System.out.println("[���] �Է��Ͻ� ��й�ȣ�� ��ġ���� �ʽ��ϴ�. �ٽ� �Է����ּ���.. ");

					} else {
						System.out.println(" ���̵�� ��й�ȣ�� ��ġ�մϴ�.");
						System.out.printf(" ��ȯ���մϴ� [%s] �����ڴԡ� \n", map2.get(id));
						break;
					}
				}

			} // while
		} catch (Exception e) {
			System.out.println("����ó�� :" + e.getMessage());
			e.printStackTrace();
		}

	}

	public void LoginAction2() throws SQLException {
		try {
			HashMap<String, String> map = new HashMap<String, String>(); // ���̵� ��� ��ġ��
			HashMap<String, String> map2 = new HashMap<String, String>(); // �̸� ��¿�

			ManagerDAO dao = new ManagerDAO();
			List<ManagerDTO> members = new ArrayList<ManagerDTO>();
			members = dao.getManagers();

			for (int i = 0; i < members.size(); i++) {
				map.put(members.get(i).getM_Id(), members.get(i).getM_Pwd());
				map2.put(members.get(i).getM_Id(), members.get(i).getM_Name());
			}
			Scanner scan = new Scanner(System.in); // ���δ��� �Է� ��ĳ��

			int count = 0; // ī��Ʈ ����
			while (true) {
				System.out.println("[ �α��� ȭ�� ] ");
				System.out.println("���̵�� ��й�ȣ�� �Է��ϼ���.");
				System.out.print("ID: ");
				String id = scan.nextLine().trim();

				System.out.print("PASSWORD: ");
				String password = scan.nextLine().trim();
				System.out.println();

				if (!map.containsKey(id)) { // �Է��� ���̵� �ؽ��� Ű�� �� ���� �ʴٸ�
					System.out.println("[���] �Է��Ͻ� ID�� �������� �ʽ��ϴ�!  �ٽ� �Է� ���ּ���. ");
					count++;
					System.out.println("[���] [�Է� ���� Ƚ��] = " + (5 - count) + "[ȸ]");
					if (count == 5) {
						System.out.println("[ �Է� Ƚ�� �ʰ��� ���������մϴ�.]");
						System.exit(0);
					}
					// continue; // �̰� ��� ���ص� �� �� ����
				} else {
					if (!(map.get(id).equals(password))) {
						System.out.println("[���] ��й�ȣ ��ġ���� �ʽ��ϴ�. �ٽ� �Է����ּ���.");

					} else {
						System.out.println(" ���̵�� ��й�ȣ�� ��ġ�մϴ�.");
						System.out.printf(" ��ȯ���մϴ� [%s] �����ڴԡ� \n", map2.get(id));
						executeProgram(); // �ٷ� ���α׷� ���� �޼ҵ� ȣ��
					}
				}

			} // while
		} catch (Exception e) {
			System.out.println("����ó�� :" + e.getMessage());
			e.printStackTrace();
		}

	}
//��ü ���� ���踦 ���� �޼����� �ְ�޾� ���α׷��� �ۼ��ϴ� ���
	// (������ ���α׷� ����)�α��� ���� �� -> 1�� : ������ ȸ������ / 2�� : ��� ���� ���α׷� / 3�� : �α׾ƿ�
	public void executeProgram() {
		ClientEx ce = new ClientEx();
		int select = 0;
		while (true) {
			System.out.println("[ ���α׷� ����.. ]");
			System.out.print("[1. ������ ���� ���α׷�]\n[2. ��� ���� ���α׷�]\n[3. �α׾ƿ�]\n��ȣ �Է�: ");

			// int select = scan.nextInt(); nextline�̶� �������� ����ó�� ���ؼ� ������
			try {
				select = Integer.parseInt(scan.nextLine().trim());
			} catch (NumberFormatException e) {
			}
			switch (select) {
			case 1:
				System.out.println("[������ ���α׷��� �����մϴ�..]");
				new ManagerEx().managerManage();// ������ ���� ���α׷� ���� ���� �޼ҵ�
			case 2:
				System.out.println("[�ｺ ȸ�� ���� ���α׷��� �����մϴ�..]");
				ce.start();
			case 3:
				System.out.println("[�α׾ƿ��� �Ϸ�Ǿ����ϴ�..]");
				MainProgram.main(null);// �ٽ� �α��� â���� ���θ޼ҵ� �θ�

			default:
				System.out.println("[���] : 1 ~ 3 �� �Է��ϼ���.. ");
				System.out.println("===============================================");

			}
		}
	}

	public void selectMenu() {
		int select = 0;
		while (true) {
			System.out.println("[1. �α���] | [2.���̵� ã��] | [3.��й�ȣ ã��(����)] | [4.����]\n�Է�:");
			try {
				select = Integer.parseInt(scan.nextLine().trim());
			} catch (NumberFormatException e) {
			}
			switch (select) {
			case 1:
				try {
					LoginAction2();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			case 2:
				idFindAction();
				break;
			case 3:
				pwdChange();
				break;
			case 4:
				System.out.println("[����] ���α׷��� �����մϴ�..");
				System.exit(0); // ���� ����
			default:
				System.out.println("[���] : 0 ~ 3 �� �Է��ϼ���.. ");
			}
		}
	}

	// ���̵� ã�� �޼ҵ� ���̵� ������
	public void idFindAction() {
		HashMap<String, String> map = new HashMap<String, String>(); // ���̵� ��� ��ġ��
		HashMap<String, String> map2 = new HashMap<String, String>(); // �̸� ��¿�

		ManagerDAO dao = new ManagerDAO();
		List<ManagerDTO> members = new ArrayList<ManagerDTO>(); // member ������ ������ ���� �� �ֱ�
		members = dao.getManagers();

		for (int i = 0; i < members.size(); i++) {
			map.put(members.get(i).getM_Name(), members.get(i).getM_PhoneNum()); // �̸� ��
			map2.put(members.get(i).getM_Name(), members.get(i).getM_Id()); // �̸� ���̵�
		}
		while (true) {
			System.out.println("�̸��� ��ȭ��ȣ�� �Է��ϼ���.");
			System.out.print("�̸�: ");
			String name = scan.nextLine().trim();

			System.out.print("��ȭ��ȣ: ");
			String phone = scan.nextLine().trim();

			System.out.println();

			if (!map.containsKey(name)) { // �Է��� �̸��� Ű�� ���� ������
				System.out.println("[���] �Է��Ͻ� �̸��� �������� �ʽ��ϴ�. �ٽ� �Է����ּ���");

			} else {
				if (!(map.get(name).equals(phone))) {
					System.out.println("[���] ��ȭ��ȣ�� ��ġ���� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
				} else {
					System.out.println(" �̸��� ��ȭ��ȣ�� ��ġ�մϴ�.");
					System.out.println(" ����� ID: " + map2.get(name));
					selectMenu(); // �ٽ� ���ư���
				}
			}
		}
	}

	// ��й�ȣ ���� �޼ҵ�
	public void pwdChange() {
		HashMap<String, String> map = new HashMap<String, String>(); // ���̵� ��� ��ġ��
		HashMap<String, String> map2 = new HashMap<String, String>(); // �̸� ��¿�

		ManagerDAO dao = new ManagerDAO();
		List<ManagerDTO> members = new ArrayList<ManagerDTO>(); // member ������ ������ ���� �� �ֱ�
		members = dao.getManagers();

		for (int i = 0; i < members.size(); i++) {
			map.put(members.get(i).getM_Id(), members.get(i).getM_PhoneNum()); // ���̵� ��
			map2.put(members.get(i).getM_Id(), members.get(i).getM_Name()); // ���̵� �̸�
		}

		System.out.println("���̵� �̸��� ��ȭ��ȣ�� �Է��ϼ���.");
		System.out.print("���̵�: ");
		String id = scan.nextLine().trim();

		System.out.print("�̸�: ");
		String name2 = scan.nextLine().trim();

		System.out.print("��ȭ��ȣ: ");
		String phone2 = scan.nextLine().trim();
		System.out.println();

		if (!map.containsKey(id)) { // �Է��� �̸��� Ű�� ���� ������
			System.out.println("[���] �Է��Ͻ� ���̵�� �������� �ʽ��ϴ�. �ٽ� �Է����ּ���");

			// !(map2.get(name2).equals(map2.get(name2)))
		} else {
			if (!(map2.get(id).equals(name2))) {
				System.out.println("[���] �̸��� ��ġ���� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
			} else {
				if (!(map.get(id).equals(phone2))) {
					System.out.println("[���] ��ȭ��ȣ�� ��ġ���� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
				} else {
					System.out.println(" ��� ������ ��ġ�մϴ�. ");
					System.out.println(" ��й�ȣ�� ���� ���ּ���.");
					dao.updatePwd(id); // �Է� ���� ���̵� �ѱ�� ��й�ȣ�� �����ϴ� �޼ҵ�
					selectMenu(); // �ٽ� ���ư���
				}
			}
		}
	}
}
