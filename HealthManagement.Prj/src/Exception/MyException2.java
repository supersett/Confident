package Exception;

import java.util.regex.Pattern;

public class MyException2 {

	// ¾ÆÀÌµğ ÀÚ¸®¼ö Å×½ºÆ®
	public void idCheck(String mngId) throws MyException {
		if (mngId.length() < 4 || mngId.length() > 8) {
			throw new MyException(" ¾ÆÀÌµğ´Â 4~8ÀÚ »çÀÌ·Î ÀÔ·ÂÇØÁÖ¼¼¿ä.");
		}

	}

	// ÀÌ¸§ È®ÀÎ
	public void nameCheck(String name) throws MyException {

		boolean check = Pattern.matches("^[¤¡-¤¾°¡-ÆR]*$", name);

		if (!check)

			throw new MyException("¡ØÀÌ¸§Àº ÇÑ±Û·Î ÀÔ·ÂÇØÁÖ¼¼¿ä");

	}

	// ÀüÈ­¹øÈ£ È®ÀÎ
	public void phoneCheck(String phone) throws MyException {

		boolean check = Pattern.matches("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$", phone);

		if (!check)

			throw new MyException("ÀüÈ­ ¹øÈ£ Çü½ÄÀº : [010 6-9] - xxxx - xxxx");

	}

	public void numberException() throws MyException {
		throw new MyException("°ø¹é ¹®ÀÚ°¡ ÀÔ·Â µÇ¾ú½À´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇØÁÖ¼¼¿ä. ");
	}
}
