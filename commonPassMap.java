import com.sun.org.apache.xerces.internal.impl.xpath.regex.CaseInsensitiveMap;

import java.io.*;
import java.util.*;

public class commonPassMap {
	public static void checkPassword() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter your password: ");
		String userPassword = keyboard.next();
		boolean commonPassFail = false;

		int passStrength = 0;
		//common password test
		try {
			FileInputStream in = new FileInputStream("src/CommonPasswords.txt");
			BufferedReader scanInput = new BufferedReader(new InputStreamReader(in));
			HashMap<String, String> map = new HashMap<String, String>();
			String next = scanInput.readLine();
			while (next != null) {
				map.put(next, "Weak");
				next = scanInput.readLine();
			}
			if (map.containsKey(userPassword)) {
				System.out.println("Your password failed the common password test.");
				commonPassFail = true;
			} else {
				System.out.println("Your password passed the common password test.");
				passStrength = passStrength + 1;
			}

			scanInput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		while (commonPassFail == false) {
			//common last name test
			try {
				FileInputStream in = new FileInputStream("src/LastNamesOnly.txt");
				BufferedReader scanInput = new BufferedReader(new InputStreamReader(in));
				HashMap<String, String> map = new HashMap<String, String>();
				String next = scanInput.readLine();
				while (next != null) {
					map.put(next, "Weak");
					next = scanInput.readLine();
				}
				if (map.containsKey(userPassword)) {
					System.out.println("Your password failed the common last name test.");
				} else {
					System.out.println("Your password passed the common last name test.");
					passStrength = passStrength + 1;
				}

				scanInput.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			//dictionary test
			try {
				FileInputStream in = new FileInputStream("src/wordList.txt");
				BufferedReader scanInput = new BufferedReader(new InputStreamReader(in));
				HashMap<String, String> map = new HashMap<String, String>();
				String next = scanInput.readLine();
				while (next != null) {
					map.put(next, "Weak");
					next = scanInput.readLine();
				}
				if (map.containsKey(userPassword)) {
					System.out.println("Your password failed the dictionary test.");
				} else {
					System.out.println("Your password passed the dictionary test.");
					passStrength = passStrength + 1;
				}

				scanInput.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			//more names?
			try {
				FileInputStream in = new FileInputStream("src/yob2016.txt");
				BufferedReader scanInput = new BufferedReader(new InputStreamReader(in));
				HashMap<String, String> map = new HashMap<String, String>();
				String next = scanInput.readLine();
				while (next != null) {
					map.put(next, "Weak");
					next = scanInput.readLine();
				}
				if (map.containsKey(userPassword)) {
					System.out.println("Your password failed the baby name test.");
					commonPassFail = true;
				} else {
					System.out.println("Your password passed the baby name test.");
					passStrength = passStrength + 1;
					commonPassFail = true;
				}

				scanInput.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

			System.out.println("Your password has scored a " + passStrength + " out of 5 in terms of strength.");

			if (passStrength <= 1) {
				System.out.println("It is very weak. You should change it immediately");
				return;
			} else if (passStrength <= 3) {
				System.out.println("It is okay, but could be better.");
				return;
			} else if (passStrength >= 4) {
				System.out.println("It is strong.");
			}
		}

}