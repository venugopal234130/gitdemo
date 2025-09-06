package Advancedquestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Advanced {

	public static void main(String[] args) {
		
		//Find All duplicate Elements in a list
		
		List<String> names=Arrays.asList("jhon","venu","syam","naga","syam","venu");
		List<String> result=names.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
		.entrySet().stream().filter(e->e.getValue()>1).map(Map.Entry::getKey).collect(Collectors.toList());
		//System.out.println(result);
		
		//Count occurrences of each word in a sentence
		
		String input="java is java and java is powerful";
		Map<String,Long> result1=Arrays.stream(input.split(" ")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(result1);
		
	// check for palindrome or not 
		String input1="madam";
		boolean ispalin=IntStream.range(0, input1.length()/2).allMatch(i->input1.charAt(i)==input1.charAt(input1.length()-i-1));
		System.out.println(ispalin);
		
	    //sort a list of employees by salary and name
		//emp.stream().sorted(Comparator.comparing(emp::getsalary).thenComparing(emp::getName)).forEach(System::out.println);
		
		//Get the longest string from the list
		Optional<String> longest=names.stream().max(Comparator.comparing(String::length));
		System.out.println(longest.get());
	}

}
