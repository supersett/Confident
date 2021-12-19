package xyz.itwill.student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

//���� ǥ����(Regular Expression) : Meta ����, Escape ���ڵ��� �̿��Ͽ� ������ ��Ģ(����)��
//���ڿ��� ǥ���ϴ� ���
/*
^���� : ����(��)�� ���۵��� �ǹ�
����$ : ����(��)�� ������� �ǹ�
. : ������ ���� �ϳ��� �ǹ�(\ ���� ǥ�� �Ұ���)
[����1����2����3] : ������ ���ڵ� �� �ϳ��� �ǹ�
[^����1����2����3] : ������ ���ڵ��� �ƴ� ���� �� �ϳ��� �ǹ�
[����1-����2] : ����1���� ����2 ������ ���� �� �ϳ��� �ǹ�
���ڿ�? : ���ڿ��� 0�� �Ǵ� 1�� �������� �ǹ�
���ڿ�+ : ���ڿ��� 1���̻� �ݺ����� �ǹ�
���ڿ�* : ���ڿ��� 0���̻� �ݺ����� �ǹ�
���ڿ�{����} : ���ڿ��� ���ڸ�ŭ �ݺ����� �ǹ�
���ڿ�{����1,����2} : ���ڿ��� ����1���� ����2 ������ŭ �ݺ����� �ǹ�
(���ڿ�1|���ڿ�2|���ڿ�3) : ������ ���ڿ� �� �ϳ��� �ǹ�
(?!)���ڿ� : ���ڿ����� ��ҹ��ڸ� �������� ������ �ǹ�
(?=���ڿ�) : ���ڿ��� �ݵ�� �����ϰ� ������ �ǹ�
(?!���ڿ�) : ���ڿ��� �ݵ�� �����ϰ� ���� ������ �ǹ�

\s : ������ �����ϴ� ���ڿ��� �ǹ�
\S : ������ �������� �ʴ� ���ڿ��� �ǹ�
\w : ������,����,Ư������(_)�� ���ڷθ� ������ ���ڿ��� �ǹ�
\W : ������,����,Ư������(_)�� ���ڸ� ������ ���ڵ�� ������ ���ڿ��� �ǹ�
\d : ���� ������ ���ڷθ� ������ ���ڿ��� �ǹ�
\D : ���� ������ ���ڸ� ������ ���ڵ�� ������ ���ڿ��� �ǹ�
\��Ÿ���� : ��Ÿ���ڸ� �Ϲݹ��ڷ� ǥ������ �ǹ�
*/

//Ű����� �Էµ� ���ڿ��� ���� ���� ���α׷� - �Է°� ��ȿ�� ����(Data Validation)
// => ���Ŀ� ���� �ʴ� ���ڿ��� �Է��� ��� ���α׷� ����
public class DataValidationApp {
	public static void main(String[] args) throws IOException {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		/*
		System.out.print("���̵� �Է� >> ");
		String id=in.readLine();
		
		//�Է°� ������ ���� ���� : ������ �Ǵ� String Ŭ������ �޼ҵ带 �̿��� �Է°� ����
		if(id==null || id.equals("")) {
			System.out.println("[����]���̵� �ݵ�� �Է��� �ּ���.");
			System.exit(0);
		}
		
		//�Է°� ���Ŀ� ���� ���� - ���� ǥ���ĸ� �̿��� ��ȿ�� ����
		//���̵� ���� - �����ڷ� ���۵Ǹ� ������,����,Ư������(_)�� �������� 6~20 ������ ���ڷ� ǥ��
		
		//���̵� ���� ������ ���� ǥ�������� �����Ͽ� ����
		//String idReg="^[a-zA-Z][a-zA-Z0-9_]{5,19}$";
		String idReg="^[a-zA-Z]\\w{5,19}$";
		
		//java.util.regex.Pattern : ���� ǥ������ �����ϱ� ���� Ŭ����
		//Pattern.matches(String regex, CharSequence input) : ���� ǥ���İ� �Է°��� ���޹޾�
		//�Է°��� ���� ��Ģ�� ���Ͽ� ���(boolean)�� ��ȯ�ϴ� �޼ҵ�
		// => false : ���� ǥ������ ���İ� ����ġ, true : ���� ǥ������ ���İ� ��ġ 
		//�Է°��� ���� ǥ������ ���Ͽ� ���Ŀ� ���� ���� ��� ���α׷� ����
		//if(!Pattern.matches(idReg, id)) {
		//	System.out.println("[����]�Է��� ���̵�� ���Ŀ� ���� �ʽ��ϴ�.");
		//	System.exit(0);
		//}
		
		//Pattern.compile(String regex) : ���� ǥ������ ���޹޾� Pattern �ν��Ͻ��� �����Ͽ�
		//��ȯ�ϴ� �޼ҵ�
		Pattern idPattern=Pattern.compile(idReg);
		
		//java.util.regex.Matcher : ���� ǥ���İ� �� ���ڿ��� �����ϱ� ���� Ŭ���� 
		// => ���� ǥ���İ� ���ڿ� ���ϴ� ��ɿܿ� �˻� �Ǵ� ����,���� ó���ϴ� �޼ҵ� ����
		//Pattern.matcher(CharSequence input) : Pattern �ν��Ͻ��� ����� ���� ǥ���İ�
		//�� ���ڿ��� �����޾� ������ Matcher �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		Matcher idMatcher=idPattern.matcher(id);
		
		//Matcher.matches() : Matcher �ν��Ͻ��� ����� ���� ǥ���İ� ���ڿ��� ���� ��Ģ�� 
		//���Ͽ� ���(boolean)�� ��ȯ�ϴ� �޼ҵ�
		// => false : ���� ǥ������ ���İ� ����ġ, true : ���� ǥ������ ���İ� ��ġ
		if(!idMatcher.matches()) {
			System.out.println("[����]�Է��� ���̵�� ���Ŀ� ���� �ʽ��ϴ�.");
			System.exit(0);
		}
		
		System.out.println("[�޼���]���Ŀ� �´� ���̵� �Է� �Ͽ����ϴ�.");
		*/

		/*
		System.out.print("��й�ȣ �Է� >> ");
		String password=in.readLine();

		if(password==null || password.equals("")) {
			System.out.println("[����]��й�ȣ�� �ݵ�� �Է��� �ּ���.");
			System.exit(0);
		}
		
		//��й�ȣ ���� : ������,����,Ư�����ڸ� �ݵ�� 1���̻� �����Ͽ� 8~30 ������ ���ڷ� ǥ��
		String passwordReg="^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*_-]).{8,30}$";
		
		if(!Pattern.matches(passwordReg, password)) {
			System.out.println("[����]�Է��� ��й�ȣ�� ���Ŀ� ���� �ʽ��ϴ�.");
			System.exit(0);
		}

		System.out.println("[�޼���]���Ŀ� �´� ��й�ȣ�� �Է� �Ͽ����ϴ�.");
		*/
		System.exit();
		System.out.print("�̸��� �Է� >> ");
		String email=in.readLine();

		if(email==null || email.equals("")) {
			System.out.println("[����]�̸����� �ݵ�� �Է��� �ּ���.");
			System.exit(0);
		}
		
		//�̸��� ���� : [����ڸ�@�����θ�] ������ ���ڿ��� ǥ��
		String emailReg="^([a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+)*$";
		if(!Pattern.matches(emailReg, email)) {
			System.out.println("[����]�Է��� �̸����� ���Ŀ� ���� �ʽ��ϴ�.");
			System.exit(0);
		}
		
		System.out.println("[�޼���]���Ŀ� �´� �̸����� �Է� �Ͽ����ϴ�.");

	}
}



















