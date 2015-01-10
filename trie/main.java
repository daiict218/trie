
// here key reprents a word entering.
import java.util.Scanner;
class Trie_Node
{
	int value; 	// it will decide whether it is the end of the key or not
	Trie_Node[] children;	//this is the pointer to the children nodes of a node.
	
	public Trie_Node()
	{
		this.value = 0;			// whenever a node is formed, it's value is assigned to 0
		this.children = new Trie_Node[26];
		for(int i=0;i<26;i++)
		{
			this.children[i] = null;
		}
	}
}
class Trie
{
	private Trie_Node root;
	int count = 0;
		
	public Trie()
	{
		root = new Trie_Node();
		count = 0;		// to count the number of nodes in the trie
	}

	public void insert(String keyy)
	{
		String key = keyy.toLowerCase();
		Trie_Node curr = this.root;
		this.count++;

		for(int i=0;i<key.length();i++)
		{
			int c = key.charAt(i)-'a';
			if(curr.children[c] == null)
			{
				curr.children[c] = new Trie_Node();
			}
			curr = curr.children[c];
		}
		curr.value = count;
	}
		
	public boolean search(String keyy)
	{
		String key = keyy.toLowerCase();
		Trie_Node curr = this.root;
		for(int i=0;i<key.length();i++)
		{
			int c = key.charAt(i)-'a';
			if(curr.children[c] == null)
			{
				return false;
			}
			curr = curr.children[c];
		}
		if(curr.value != 0)
		{
			return true;
		}
		return false;
	}
}
class main
{		
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the total number of words");
		int n = input.nextInt();
		input.nextLine();
		System.out.println("Enter all the words one by one");
		String keys[] = new String[n];
		for(int i=0;i<n;i++)
		{
			keys[i] = input.nextLine();
		}
		Trie t = new Trie();
		for(String k : keys)
		{
			t.insert(k);
		}
		System.out.println(t.search("ajay"));
	}
}
