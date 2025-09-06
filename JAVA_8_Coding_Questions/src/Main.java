import java.util.Stack;
public class Main
{
	public static void main(String[] args) {
	    String s="([])";
	    Stack<Character> st=new Stack<>();
	    
	    for(char ch:s.toCharArray())
	    {
	        if(ch=='('|| ch=='{' || ch=='[')
	        {
	            st.push(ch);
	        }
	        else
	        {
	            if(st.isEmpty())
	            {
	                System.out.println("not balanced ");
	                break;
	            }
	            if((st.peek()=='{' && ch=='}')|| (st.peek()=='[' && ch==']') || (st.peek()=='(' && ch==']'))
	            {
	                st.pop();
	            }
	            else
	            {
	                System.out.println("Not balanced");
	                break;
	            }
	        }
	    }
	    if(st.isEmpty())
	    {
	        System.out.println("Balanced");
	    }
	}
}