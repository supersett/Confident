package main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import dao.ClientDAO;
import dto.ClientDTO;

public class ClientEx {

	static boolean run = true;

	// �ַܼ� ���ڿ� �Է¹ޱ� �޼ҵ�
	public String getStringInfo() {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		return s;
	}

	// �ַܼ� ���� �Է¹ޱ� �޼ҵ�
	public int getIntInfo() {
		Scanner sc = new Scanner(System.in);
		int i = Integer.parseInt(sc.nextLine());
		return i;
	}

	// �ַܼ� ���ڿ� �Է¹ޱ� �޼ҵ�

	public String getStringInfo(String msg) {
		Scanner scan = new Scanner(System.in);
		System.out.print(msg + " = ");
		String inData = scan.nextLine();
		return inData;
	}

	// �ַܼ� �� �Է¹ޱ� �޼ҵ�
	public int getIntInfo(String msg) {
		Scanner scan = new Scanner(System.in);
		System.out.print(msg + "=");
		int i = Integer.parseInt(scan.nextLine());
		return i;
	}

	public void InsertInfo() {
		ClientDAO clientdao = new ClientDAO();
		int ptcnt = 0;

		String name = getStringInfo("�̸�");
		String phonenum = getStringInfo("��ȭ��ȣ");
		int age = getIntInfo("����");
		String sex = getStringInfo("����");
		String address = getStringInfo("�ּ�");
		int height = getIntInfo("Ű");
		int weight = getIntInfo("������");
		int reg_months = getIntInfo("������");
		int ifpt = getIntInfo("��Ƽ����");
		if (ifpt == 1) {
			ptcnt = getIntInfo("��ƼȽ��");
		}

		clientdao.setInsert(name, phonenum, age, sex, address, height, weight, reg_months, ifpt, ptcnt);
	}

	// ������ ���
	public void showAllClientInfo() {
		ClientDAO cd = new ClientDAO();
		List<ClientDTO> list = cd.getAllInfo();
		System.out.println("  ��ȣ\t �̸�\t    ����ó\t ����\t����\t �ּ�\t   Ű\t������\t  �����     ��ϱⰣ\t  ������       PT����\tPTȽ��");

		for (ClientDTO e : list) {
			System.out.printf("%4d\t%3s\t%13s\t%4d\t%2s\t%3s\t%6d\t%4d\t%tY/%tm/%td\t%2d\t%tY/%tm/%td\t%2d\t%4d\t\n\n",
					e.getC_ClientNum(), e.getC_Name(), e.getC_PhoneNum(), e.getC_age(), e.getC_Sex(), e.getC_Address(),
					e.getC_Height(), e.getC_Weight(), e.getC_RegistrationDate(), e.getC_RegistrationDate(),
					e.getC_RegistrationDate(), e.getC_Reg_Months(), e.getC_ExpirationDate(), e.getC_ExpirationDate(),
					e.getC_ExpirationDate(), e.getC_ifPT(), e.getC_LeftPTCnt());
		}
	}

	// �������� ���
	public void showSimpleClientInfo() {
		ClientDAO cd = new ClientDAO();
		List<ClientDTO> list = cd.getSimpleInfo();
		for (ClientDTO e : list) {
			System.out.printf("%d\t%s\t%s\n", e.getC_ClientNum(), e.getC_Name(), e.getC_PhoneNum());
		}
	}

	// �˻����� ���
	public void showSearchInfo() {
		ClientDAO cd = new ClientDAO();
		List<ClientDTO> list = cd.getSearch(getStringInfo());
		for (ClientDTO e : list) {
			System.out.printf("%d\t%s\t%s\n", e.getC_ClientNum(), e.getC_Name(), e.getC_PhoneNum());
		}
	}

	// ȸ������ ��� (�̿��� ,����) > ���ڸ� ȸ����ȣ�� �޾ƿ���
	public void showClientState(int a) {

		ClientDAO c = new ClientDAO();
		List<ClientDTO> list = new ArrayList<ClientDTO>();
		list = c.getAllInfo();

		Date c_expriationDate = list.get(a - 1).getC_ExpirationDate();

		Calendar cal = Calendar.getInstance();
		Date today = new Date(cal.getTimeInMillis());

		if (today.compareTo(c_expriationDate) > 0) {
			System.out.println("����");
		} else if (today.compareTo(c_expriationDate) < 0) {
			System.out.println("�̿���");
		} else {
			System.out.println("������ ������ �̿����Դϴ�.");
		}
	}

	// ȸ������ ���� ���� �޴� ��� �޼ҵ�
	public void menu_Update() {
		System.out.println(
				"\n[�޴�] 1: �̸�, 2: ����ó, 3: ����, 4 : ����, 5 : �ּ�, 6 : Ű, 7 : ������, 8 : ������, 9 : PTȽ��, 10 : �����ܰ�� = ");
		getIntInfo();
	}

	// ���� �޼ҵ�
	public void start() {
		System.out.println("[ȸ������ ���α׷��� �����մϴ�]\n");

		while (run) {
			ClientDAO cd = new ClientDAO();
//		System.out.println("  ��ȣ\t �̸�\t    ����ó\t ����\t����\t �ּ�\t   Ű\t������\t  �����     ��ϱⰣ\t  ������       PT����\tPTȽ��");
//		System.out.println("================================================================================================================================");
//		
			System.out.println(
					"\n[�޴�] 1: ȸ��������ȸ(��), 2: ȸ��������ȸ(�⺻), 3: ȸ��������ȸ, 4 : ȸ���˻�, 5 : ȸ���߰�, 6 : ȸ������, 7 : ȸ�� ����, 8 : ���� = ");
			System.out.print("[���Ͻô� ����� ��ȣ�� �Է��ϼ���] : ");
			int a = getIntInfo();
			switch (a) {
			case 1: // ȸ��������ȸ(��)
				System.out.println(
						"\n[�޴�] 1: ȸ��������ȸ(��), 2: ȸ��������ȸ(�⺻), 3: ȸ��������ȸ, 4 : ȸ���˻�, 5 : ȸ���߰�, 6 : ȸ������, 7 : ȸ�� ����, 8 : ���� = ");
				showAllClientInfo();
				break;
			case 2: // ȸ��������ȸ(�⺻)
				showSimpleClientInfo();
				break;
			case 3: // ȸ��������ȸ
				System.out.print("ȸ����ȣ�� �Է����ּ��� = ");
				showClientState(getIntInfo());
				break;
			case 4: // ȸ���˻�
				System.out.print("�̸� �Ǵ� ����ó�� �Է����ּ��� = ");
				showSearchInfo();
				break;
			case 5: // ȸ���߰�
				System.out.print("ȸ�������� �Է����ּ��� = ");
				InsertInfo();
				break;

			case 6: // ȸ������
				System.out
						.println("\n[�޴�] 1: �̸�, 2: ����ó, 3: ����, 4 : ����, 5 : �ּ�, 6 : Ű, 7 : ������, 8 : PTȽ��, 9 : �����ܰ�� = ");
				switch (getIntInfo()) {
				case 1:
					System.out.print("ȸ����ȣ�� �̸��� ������� �Է����ּ��� = ");
					cd.setUpdateName(getIntInfo(), getStringInfo());
					System.out.println(
							"\n[�޴�] 1: ȸ��������ȸ(��), 2: ȸ��������ȸ(�⺻), 3: ȸ��������ȸ, 4 : ȸ���˻�, 5 : ȸ���߰�, 6 : ȸ������, 7 : ȸ�� ����, 8 : ���� = ");
					showAllClientInfo();
					break;
				case 2:
					System.out.print("ȸ����ȣ�� ����ó�� ������� �Է����ּ��� = ");
					cd.setUpdatePhoneNum(getIntInfo(), getStringInfo());
					System.out.println(
							"\n[�޴�] 1: ȸ��������ȸ(��), 2: ȸ��������ȸ(�⺻), 3: ȸ��������ȸ, 4 : ȸ���˻�, 5 : ȸ���߰�, 6 : ȸ������, 7 : ȸ�� ����, 8 : ���� = ");
					showAllClientInfo();
					break;
				case 3:
					System.out.print("ȸ����ȣ�� ���̸� ������� �Է����ּ��� = ");
					cd.setUpdateAge(getIntInfo(), getIntInfo());
					System.out.println(
							"\n[�޴�] 1: ȸ��������ȸ(��), 2: ȸ��������ȸ(�⺻), 3: ȸ��������ȸ, 4 : ȸ���˻�, 5 : ȸ���߰�, 6 : ȸ������, 7 : ȸ�� ����, 8 : ���� = ");
					showAllClientInfo();
					break;
				case 4:
					System.out.print("ȸ����ȣ�� ������ ������� �Է����ּ��� = ");
					cd.setUpdateSex(getIntInfo(), getStringInfo());
					System.out.println(
							"\n[�޴�] 1: ȸ��������ȸ(��), 2: ȸ��������ȸ(�⺻), 3: ȸ��������ȸ, 4 : ȸ���˻�, 5 : ȸ���߰�, 6 : ȸ������, 7 : ȸ�� ����, 8 : ���� = ");
					showAllClientInfo();
					menu_Update();
					break;
				case 5:
					System.out.print("ȸ����ȣ�� �ּҸ� ������� �Է����ּ��� = ");
					cd.setUpdateAddress(getIntInfo(), getStringInfo());
					System.out.println(
							"\n[�޴�] 1: ȸ��������ȸ(��), 2: ȸ��������ȸ(�⺻), 3: ȸ��������ȸ, 4 : ȸ���˻�, 5 : ȸ���߰�, 6 : ȸ������, 7 : ȸ�� ����, 8 : ���� = ");
					showAllClientInfo();
					break;
				case 6:
					System.out.print("ȸ����ȣ�� Ű�� ������� �Է����ּ��� = ");
					cd.setUpdateHeight(getIntInfo(), getIntInfo());
					System.out.println(
							"\n[�޴�] 1: ȸ��������ȸ(��), 2: ȸ��������ȸ(�⺻), 3: ȸ��������ȸ, 4 : ȸ���˻�, 5 : ȸ���߰�, 6 : ȸ������, 7 : ȸ�� ����, 8 : ���� = ");
					showAllClientInfo();
					break;
				case 7:
					System.out.print("ȸ����ȣ�� �����Ը� ������� �Է����ּ��� = ");
					cd.setUpdateWeight(getIntInfo(), getIntInfo());
					System.out.println(
							"\n[�޴�] 1: ȸ��������ȸ(��), 2: ȸ��������ȸ(�⺻), 3: ȸ��������ȸ, 4 : ȸ���˻�, 5 : ȸ���߰�, 6 : ȸ������, 7 : ȸ�� ����, 8 : ���� = ");
					showAllClientInfo();
					break;
				case 8:
					System.out.print("ȸ����ȣ�� PTȽ���� ������� �Է����ּ��� = ");
					cd.setUpdateLeftPTCnt(getIntInfo(), getIntInfo());
					System.out.println(
							"\n[�޴�] 1: ȸ��������ȸ(��), 2: ȸ��������ȸ(�⺻), 3: ȸ��������ȸ, 4 : ȸ���˻�, 5 : ȸ���߰�, 6 : ȸ������, 7 : ȸ�� ����, 8 : ���� = ");
					showAllClientInfo();
					break;

				}
				break;
			case 7: // ȸ������
				System.out.print("ȸ����ȣ�� �Է����ּ��� = ");
				cd.setDelete(getIntInfo());
				break;
			case 8: // ���� �Ǵ� ������ ���� �޴��� ����
				System.out.println("���α׷��� �����մϴ�.");
				run = false;
				break;

			}
		}
	}
}
