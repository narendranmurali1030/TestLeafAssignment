package week3.day4;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class AllCharacterCountHW {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int con = 1;
		Map<Character, Integer> mp = new LinkedHashMap<Character, Integer>();
		Scanner sc= new Scanner(System.in);

		System.out.println("Enter the String :");
		String varStr = sc.nextLine();

		for (int i = 0; i < varStr.length(); i++) {
			if (varStr.charAt(i)!= ' ') {
				if (mp.containsKey(varStr.charAt(i))) {
					int value= mp.get(varStr.charAt(i));
					mp.put(varStr.charAt(i), (value+1));
				}
				else {
					mp.put(varStr.charAt(i), con);
				}
			}
		}
		for (Entry<Character,Integer> each : mp.entrySet()) {
			System.out.println(each);
		}
	}

}
