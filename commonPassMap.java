import java.io.*;
import java.util.*;

public class commonPassMap {
	
	public static void checkPassword() {
		try {
		FileInputStream in = new FileInputStream("/PasswordCracker/src/CommonPasswords.txt"); 
		BufferedReader scanner = new BufferedReader(new InputStreamReader(in));
        HashMap<String, String> map = new HashMap<String, String>();

        String next = scanner.readLine();
        while (next != null) {   
				map.put(next, "Weak");
		}
        
        System.out.println(map);
        scanner.close();
		}
        catch (IOException e) {
        	e.printStackTrace();
        }
		
	}
}