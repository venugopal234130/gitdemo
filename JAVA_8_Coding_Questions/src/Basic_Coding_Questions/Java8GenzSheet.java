package Basic_Coding_Questions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8GenzSheet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Filter even numbers
		List<Integer> list=Arrays.asList(180,135,30,10,120,21,22,23,24,26,24,25,30,35);
		List<String> namesList=Arrays.asList("venu","gopal","syam");
		list.stream().filter(value->value%2==0).forEach(System.out::println);
		
		//Find the maximum value in a list
		Optional<Integer> max=list.stream().max(Comparator.comparing(Integer::intValue));
		System.out.println(max.get());
		
		//calculate the sum of elements in a list
		int sum=list.stream().mapToInt(Integer::intValue).sum();
		System.out.println(sum);
		
		//List of names to UpperCase
		List<String> upperCase=namesList.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(upperCase);
		
		//sort a list of integers in ascending order
		list.stream().sorted().forEach(System.out::print);
		System.out.println();
		
		//sort a list of integers in decending order
		list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::print);
		
		System.out.println();
		
		//Count the number of elements in a list that are greater than 25
		long count=list.stream().filter(n->n>25).count();
		System.out.println(count);
		
		//Get a list of distinct elements from a list of integers
		list.stream().distinct().forEach(System.out::print);
		
		System.out.println();
		
		//Reduce a list of integers to their sum.
		int sum1=list.stream().reduce(0,Integer::sum);
		System.out.println(sum1);
		
		//Return any element from a list of integers.
		Optional<Integer> any=list.stream().findAny();
		System.out.println(any);
		
		//Extract first names from a list of full names.
		List<String> fullNames = Arrays.asList("Alice Johnson", "Bob Harris",
				"Charlie Lou");
		List<String> firstNames=fullNames.stream().map(name->name.split(" ")[0]).collect(Collectors.toList());
		System.out.println(firstNames);
		
		//Check if all numbers in a list are positive.
		boolean positive=list.stream().allMatch(n->n>0);
		System.out.println(positive);
		
		//Check if there are no negative numbers in a list.
		
		boolean nonegative=list.stream().allMatch(n->n>0);
		System.out.println(nonegative);
		
		//Find the first element in a list of integers.
		
		Optional<Integer> first=list.stream().findFirst();
		System.out.println(first.get());
		
		//Flatten a nested list structure.
		List<List<Integer>> nestedNumbers = Arrays.asList(Arrays.asList(1, 2),
				Arrays.asList(3, 4, 5));
		List<Integer> flatmap=nestedNumbers.stream().flatMap(List::stream).collect(Collectors.toList());
		System.out.println(flatmap);
		
		//Group users by age.
		//Map<Integer,List<User>> groupByAge=users.stream().collect(Collectors.groupingBy(User::getAge));
		
		//Get summary statistics for a list of integers.
		IntSummaryStatistics stats=list.stream().mapToInt(Integer::intValue).summaryStatistics();
		System.out.println(stats);
		
		//Given a list of integers, find out all the numbers starting with 1 using Stream functions?
		List<String> startsWithOne=list.stream().map(s->s+" ").filter(s->s.startsWith("1")).collect(Collectors.toList());
		System.out.println(startsWithOne);
		//How to find duplicate elements in a given integers list in java using Stream functions?
		Map<Integer, Long>duplicates=list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		Map<Integer,Long> values=duplicates.entrySet().stream().filter(entry->entry.getValue()>1).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
		System.out.println(values);
		
		//Write a program to print the count of each character in a String?
		String s = "string data to count each character";
		Map<String,Long> counting=Arrays.stream(s.split("")).map(String::toLowerCase).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(counting);
		
		//Given a String, find the first repeated character in it using Stream functions?
		String str="venugopalvenugopal";
		Character firstNon=str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting())).entrySet().stream().filter(entry->entry.getValue()>1).map(Map.Entry::getKey).findFirst().get();
		System.out.println(firstNon);
	}

}
