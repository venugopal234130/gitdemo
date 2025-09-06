package Advancedquestions;

import java.util.HashMap;
import java.util.Map;

public class Anagrams {
	
	
	public static boolean checkAnagrams(String s1,String s2)
	{
		char ch1[]=s1.toCharArray();
		char ch2[]=s2.toCharArray();
		if(s1.length()!=s2.length())
		{
			return false;
		}
		Map<Character,Integer> map=new HashMap<>();
		for(char ch:ch1)
		{
			map.put(ch, map.getOrDefault(ch,0)+1);
		}
		
		for(char ch : ch2)
		{
			if(!map.containsKey(ch))
			{
				return false;
			}
			map.put(ch, map.getOrDefault(ch,0)-1);
			
			if(map.get(ch)==0)
			{
				map.remove(ch);
			}
		}
		
		return map.isEmpty();
	}

	public static void main(String[] args) {
		
		System.out.println("Program execution starts");
		String s1="listend";
		String s2="silent";
		boolean flag=checkAnagrams(s1,s2);
		if(flag)
			System.out.println("Anagrams");
		else
			System.out.println("Not Anagrams");
		System.out.println("program execution ends");

	}

}
