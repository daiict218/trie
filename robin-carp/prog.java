import java.util.Scanner;
import java.lang.*;
class main
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Assuming the text and pattern contains the character 0-9");
		System.out.println("Enter the text: ");
		String text = input.nextLine();
		System.out.println("Enter the pattern");
		String pattern = input.nextLine();
		int patterValue = StringValue(pattern);
		//System.out.println(patterValue);
		int arr[] = new int[text.length()];
		for(int i=0;i<text.length();i++)
		{
			arr[i] = text.charAt(i)-'0';
			//System.out.println(arr[i]);
		}
		String tomatch = "";
		int t[] = new int[text.length()-pattern.length()+1];
		for(int i=0;i<pattern.length();i++)
                {
			//System.out.println(Character.toString(arr[i]));
                       	tomatch += Integer.toString(arr[i]);
                }
		//System.out.println(tomatch);
		t[0] = StringValue(tomatch);
		//System.out.println(t[0]);
		int count = 0;
		for(int i=0;i<text.length()-pattern.length();i++)
		{
			if(t[i] == patterValue)
			{
				count++;
			}
			t[i+1] = (t[i] - (int)Math.pow(10,pattern.length()-1)*(arr[i]))*10+(arr[i+pattern.length()]);
//			System.out.println(t[i+1]);
		}
		if(t[text.length()-pattern.length()] == patterValue)
		{
			count++;
		}
		System.out.println("total occurences of the pattern: "+count);
	}
	public static int StringValue(String x)
	{
		//we will calculate the string value using the horner's rule.
		char []arr = new char[x.length()];
		int value = 0;
		for(int i=0;i<x.length();i++)
		{
			arr[i] = x.charAt(i);
		}
		for(int i=0;i<arr.length;i++)
		{
			value = value + (int)Math.pow(10,i)*(arr[arr.length-i-1]-'0');
		}
		return value;
	}
}
