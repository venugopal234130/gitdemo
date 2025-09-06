import java.util.Arrays;
import java.util.List;

public class MoveZerostoEnd {

	public static void main(String[] args) {
		
		List<Integer> list=Arrays.asList(10,0,2,0,3,4,0,5,6);
		Integer[] arr=list.toArray(new Integer[0]);
		int index=0;
		for(int num:arr)
		{
			if(num!=0)
			{
				arr[index++]=num;
			}
		}
		while(index<arr.length)
		{
			arr[index++]=0;
		}
		System.out.println(Arrays.toString(arr));
	}

}
