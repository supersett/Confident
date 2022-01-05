package main;

import dao.ManagerDAO;
import dto.ManagerDTO;

public class MainProgram {
	public static void main(String[] args) {
		MainLogin ml = new MainLogin(); // �α��� �޼ҵ�� ����ϱ� ���� ��ü ����
		ManagerDAO dao = new ManagerDAO();

		// DB ������ �ο� 1���� ��?
		if (dao.selectRecord() == 1) { // ������� ���ڵ� �� Ȯ�� 1���϶�?
			try {
				ml.LoginAction();
			} catch (Exception e) {
				e.printStackTrace();
			} // ù ����Ʈ �α��� ( �ܼ� �α��θ� ������.)
			dao.insert(); // �����ڰ� 1���̹Ƿ� ������ ȸ������ ���Ѿ� ��
			main(args);
		}

		// ȸ������ �Ϸ� �Ǿ�����, ���� ���� ���α׷� 1. �α���, 2. ���̵�ã��, 3. ��й�ȣã��
		if (dao.selectRecord() >= 2) { // DB ���ڵ� �� 2���̻�?
			ml.selectMenu();
		}

	}
}
