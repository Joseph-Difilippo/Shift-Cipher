package hw1;

public class ShiftKey
{
	private int shift;

	public ShiftKey()
	{
		shift = 0;
	}
	public ShiftKey(int shift)
	{
		this.shift = shift;
	}

	public String encrypt(String plainText)
	{
		char[] textToEncrypt = new char[plainText.length()];
		int[] textToNum = new int[plainText.length()];
		int[] encryptedNum = new int[plainText.length()];
		char[] encryptedText = new char[plainText.length()];
		int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
				17, 18, 19, 20, 21, 22, 23, 24, 25};
		char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
				'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
				'y', 'z'};

		textToEncrypt = plainText.toCharArray();

		for (int i = 0; i < textToEncrypt.length; i++)
		{
			for (int j = 0; j < chars.length; j++)
			{
				if (textToEncrypt[i] == chars[j])
				{
					textToNum[i] = nums[j];
					break;
				}
			}
		}

		for (int i = 0; i < textToNum.length; i++)
		{
			encryptedNum[i] = (textToNum[i] + shift) % 26;
		}

		for (int i = 0; i < encryptedNum.length; i++)
		{
			for (int j = 0; j < chars.length; j++)
			{
				if (encryptedNum[i] == nums[j])
				{
					encryptedText[i] = chars[j];
					break;
				}
			}
		}
		encryptedText[encryptedText.length - 1] = '.';
		String encryptedString = new String(encryptedText);
		return encryptedString;
	}

	public String decrypt(String encryptedText)
	{
		char[] textToDecrypt = new char[encryptedText.length()];
		int[] textToNum = new int[encryptedText.length()];
		int[] decryptedNum = new int[encryptedText.length()];
		char[] decryptedText = new char[encryptedText.length()];
		int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
				17, 18, 19, 20, 21, 22, 23, 24, 25};
		char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
				'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
				'y', 'z'};

		textToDecrypt = encryptedText.toCharArray();

		for (int i = 0; i < textToDecrypt.length; i++)
		{
			for (int j = 0; j < chars.length; j++)
			{
				if (textToDecrypt[i] == chars[j])
				{
					textToNum[i] = nums[j];
					break;
				}
			}
		}

		for (int i = 0; i < textToNum.length; i++)
		{
			decryptedNum[i] = ((textToNum[i] - shift) + 26) % 26;
		}

		for (int i = 0; i < decryptedNum.length; i++)
		{
			for (int j = 0; j < chars.length; j++)
			{
				if (decryptedNum[i] == nums[j])
				{
					decryptedText[i] = chars[j];
					break;
				}
			}
		}
		decryptedText[decryptedText.length - 1] = '.';

		String decryptedString = new String(decryptedText);
		return decryptedString;
	}

}
