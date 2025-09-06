import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DuplicateCharactersInString {

	public static void main(String[] args) {
		String input="naganjaneyulu";
		char[] ch=input.toCharArray();
		Map<Character,Integer> count=new HashMap<>();
		for(char value:ch)
		{
			count.put(value, count.getOrDefault(value,0)+1);
		}
			System.out.println(count);
			for(Map.Entry<Character,Integer> map :count.entrySet())
			{
				System.out.println(map.getKey()+ " "+map.getValue());
			}
	}

}
