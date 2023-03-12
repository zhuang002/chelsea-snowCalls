import java.util.HashMap;
import java.util.Scanner;

public class Main {

	static HashMap<Character, Integer> dic = new HashMap<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		buildDictionary();
		Scanner sc = new Scanner(System.in);
		int numCases = sc.nextInt();
		sc.nextLine();
		
		for (int i=0;i<numCases;i++) {
			System.out.println(formalize(sc.nextLine()));
		}
	}

	private static void buildDictionary() {
		// TODO Auto-generated method stub
		String[] map = {"", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV","WXYZ"};
		for (int i=0;i<map.length;i++) {
			String s = map[i];
			for (int j=0;j<s.length();j++) {
				char c = s.charAt(j);
				dic.put(c, i);
			}
		}
	}

	private static String formalize(String line) {
		// TODO Auto-generated method stub
		
		line = line.replaceAll("-", "");
		line = replaceChars(line);
		line = line.substring(0,3)+"-"+line.substring(3,6)+"-" + line.substring(6);
		if (line.length()>12) {
			line = line.substring(0,12);
		}
		return line;
	}


	private static String replaceChars(String line) {
		// TODO Auto-generated method stub
		String s = "";
		for (int i=0;i<line.length();i++) {
			char c = line.charAt(i);
			if (c>='A' && c<='Z') {
				c = (char)('0'+dic.get(c));
			} 
			s += c;
		}
		return s;
	}

}
