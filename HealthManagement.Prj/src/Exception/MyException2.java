package Exception;

import java.util.regex.Pattern;

public class MyException2 {

	// ���̵� �ڸ��� �׽�Ʈ
	public void idCheck(String mngId) throws MyException {
		if (mngId.length() < 4 || mngId.length() > 8) {
			throw new MyException(" ���̵�� 4~8�� ���̷� �Է����ּ���.");
		}

	}

	// �̸� Ȯ��
	public void nameCheck(String name) throws MyException {

		boolean check = Pattern.matches("^[��-����-�R]*$", name);

		if (!check)

			throw new MyException("���̸��� �ѱ۷� �Է����ּ���");

	}

	// ��ȭ��ȣ Ȯ��
	public void phoneCheck(String phone) throws MyException {

		boolean check = Pattern.matches("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$", phone);

		if (!check)

			throw new MyException("��ȭ ��ȣ ������ : [010 6-9] - xxxx - xxxx");

	}

	public void numberException() throws MyException {
		throw new MyException("���� ���ڰ� �Է� �Ǿ����ϴ�. �ٽ� �Է����ּ���. ");
	}
}
