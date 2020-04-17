package week3.day4;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class CharacterCountHW {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int count = 0;
		Map<Character, Integer> mp = new LinkedHashMap<Character, Integer>();
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the String :");
		String varStr = sc.nextLine();
		System.out.println("Enter the Character to search for :");
		char varChr = sc.nextLine().charAt(0);
				
		for (int i = 0; i < varStr.length(); i++) {
			if (varStr.charAt(i)==varChr) {
				count = count+1;
				mp.put(varChr, count);
			}
		}
		
		for (Entry<Character,Integer> each : mp.entrySet()) {
			System.out.println(each);
		}
		
	}

}
