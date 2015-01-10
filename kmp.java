import java.util.Scanner;
class main
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		String text = input.nextLine();
		int n = text.length();
		char T[] = new char[n];
		String pattern = input.nextLine();
		int m = pattern.length();
		char P[] = new char[m];
		for(int i=0;i<n;i++)
		{
			T[i] = text.charAt(i);
		}
		for(int i=0;i<m;i++)
		{
			P[i] = pattern.charAt(i);
		}
		int F[] = new int[m];
		int i = 1;
		int j = 0;
		// F is the prefix array
		while(i<m)
		{
			if(P[i] == P[j])
			{
				F[i] = j+1;
				j++;
				i++;
			}
			else
			{
				if(j == 0)
				{
					i++;
				}
				else
				{
					j = F[j-1];
				}
			}
		}
		/*for(i=0;i<m;i++)
		{
			System.out.println(F[i]);
		}*/


		// Knuth Morris Pratt Algorithm
		j = 0;
		int index = 0;
		i = 0;
		while(i<m)
		{
//			System.out.println("Hello");
			if(P[i] == T[j])
			{
				index = j;
				i++;
				j++;
			}
			else
			{
				if(i == 0)
				{
					j++;
				}
				else
				{
					i = F[i-1];
				}
			}
		}
		System.out.println(index-m+1);
	}
}
