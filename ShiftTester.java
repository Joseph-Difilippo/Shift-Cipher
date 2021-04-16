package hw1;

import java.io.*;

public class ShiftTester
{
	public static void main(String[] args) throws IOException
	{
		InputStreamReader inStream = new InputStreamReader(System.in);
		BufferedReader userInput = new BufferedReader(inStream);
		String inputText;
		System.out.print("Enter the text you wish to encrypt: ");
		inputText = userInput.readLine();
		while (inputText != null && !inputText.contains("."))
		{
			inputText = userInput.readLine();
		}

		int key = 3;
		ShiftKey Sk = new ShiftKey(key);
		String encryptedText = Sk.encrypt(inputText);
		String decryptedText = Sk.decrypt(encryptedText);
		System.out.print("Encrypted text: " + encryptedText);
		System.out.println();
		System.out.print("Decrypted text: " + decryptedText);
		System.out.println();

		String cipherText = "xultpaajcxitltlxaarpjhtiwtgxktghidhipxciwtvgtpilpitghlxiwiwtxgqadds.";
		key = 15;
		ShiftKey Sk2 = new ShiftKey(key);
		decryptedText = Sk2.decrypt(cipherText);
		System.out.println();
		System.out.println("Cipher text: xultpaajcxitltlxaarpjhtiwtgxktghidhipxciwtvgtpilpitghlxiwiwtxgqadds.");
		System.out.print("Decrypted text: " + decryptedText);

		inStream.close();
		userInput.close();
	}
}
