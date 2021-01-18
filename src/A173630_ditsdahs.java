import java.util.*;

public class A173630_ditsdahs {
	private Node root;
	private class Node<E> {
		private Node left;
		private Node right;
		private E value;
		private Node(Node left, Node right, E value){
			this.left = left;
			this.right = right;
			this.value = value;
		}
	}
	
	public A173630_ditsdahs(){
		root = new Node(null, null, null);
	}
	
	public void add(String symbol, String code){
		Node current = root;
		for (int i=0; i<code.length(); i++){
			if (code.substring(i, i+1).equals(".")){
				if (current.left == null){
					current.left = new Node(null, null, null);
				}
				current = current.left;
			}
			else if (code.substring(i, i+1).equals("-")){
				if (current.right == null){
					current.right = new Node(null, null, null);
				}
				current = current.right;
			}
		}
		current.value = symbol;
	}
	
	public void inOrderTree() {
		inOrder(root);
	}
	
	public void inOrder(Node root) {
		if(root == null) 
			return;
		
		if(root != null) {
			inOrder(root.left);
			if(root.value != null) {
				System.out.print(root.value + "     \t");
				linetab++;
				if(linetab == 5 || linetab == 10 || linetab == 15 || linetab == 20 || linetab == 25 || linetab == 30 || linetab == 35 || linetab == 40 ||
				linetab == 45) {
					System.out.println();
					
				}
			}
			inOrder(root.right);
		}
	}
	
	private static ArrayList<Character> letters = new ArrayList<Character>( Arrays.asList('A', 'B','C','D','E','F','G','H','I','J','K','L','M',
	'N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
	'1','2','3','4','5','6','7','8','9','0',
	'.', ',', ':', '\"', '\'',	'!','?', '@', '-', ';', '(', ')','=')); 
	
	private static ArrayList<String> code = new ArrayList<String>( Arrays.asList(".-", "-...","-.-.","-..",".","..-.","--.","....","..",
	".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..",
	".----","..---","...--","....-",".....","-....","--...","---..","----.","-----",
	".-.-.-","--..--", "---...", ".-..-.", ".----.", "-.-.--", "..--.."	, ".--.-.", "-....-", "-.-.-."	, "-.--.", "-.--.-","-...-"));
	
	private static ArrayList<String> store1 = new ArrayList<String>();
	private static ArrayList<Character> store2 = new ArrayList<Character>();
	private static ArrayList<Integer> countEncodeNum;
	private static ArrayList<Integer> countDecodeNum;
	
	private static int linetab;
	
	private static void lettersEncode() {
		Scanner in = new Scanner(System.in);
		countEncodeNum = new ArrayList<Integer>();
		
		try {
			String[] input = in.nextLine().toUpperCase().split(" ");
			int line = 1;
			int word = 1;
			int alph = 5;
			int symb = 0;
			int num = 0;
				
			if(!input[0].equals("VV")) {
				System.out.println("Please insert VV");
				lettersEncode();
			}
			else {
				while(!input[0].equals("EOM")) {
					line++;
					for(String n: input) {
						word++;
						char c[]= n.toCharArray();
						for(int i = 0; i < c.length; i++) {
							int index = letters.indexOf(c[i]);
							String morseCode = code.get(index);
							System.out.print(morseCode + " ");
							if(c[i] == 'A' || c[i] == 'B' || c[i] == 'C' || c[i] == 'D' || c[i] == 'E' || c[i] == 'F' || c[i] == 'G' || c[i] == 'H' || 
							c[i] == 'I' || c[i] == 'J' || c[i] == 'K' || c[i] == 'L' || c[i] == 'M' || c[i] == 'N' || c[i] == 'O' || c[i] == 'P' || 
							c[i] == 'Q' || c[i] == 'R' || c[i] == 'S' || c[i] == 'T' || c[i] == 'U' || c[i] == 'V' || c[i] == 'W' || c[i] == 'X' ||
							c[i] == 'Z') {
								alph++;
							}
							else if(c[i] == '.' || c[i] == ',' || c[i] == ':' || c[i] == ';' || c[i] == '!' || c[i] == '?' || c[i] == '@' || c[i] == '-' ||
							c[i] == '(' || c[i] == ')' || c[i] == '=' || c[i] == '\'' || c[i] == '\"') {
								symb++;
							}
							else if(c[i] == '1' || c[i] == '2' || c[i] == '3' || c[i] == '4' || c[i] == '5' || c[i] == '6' || c[i] == '7' || c[i] == '8' ||
									c[i] == '9' || c[i] == '0') {
								num++;
								alph++;
							}
						}
					}
					System.out.println();
					input = in.nextLine().toUpperCase().split(" ");	
				}
			}
			// Encode EOM
			System.out.println(". --- --");
			
			// Counted number of
			//System.out.println(line);
			//System.out.println(word);
			//System.out.println(alph);
			//System.out.println(symb);
			//System.out.println(num);
			
			// Store in number list
			countEncodeNum.add(line);
			countEncodeNum.add(word);
			countEncodeNum.add(alph);
			countEncodeNum.add(symb);
			countEncodeNum.add(num);
			//System.out.println(countEncodeNum);
			
			String[] count = new String[5];
			count[0] = Integer.toString(line);
			count[1] = Integer.toString(word);
			count[2] = Integer.toString(alph);
			count[3] = Integer.toString(symb);
			count[4] = Integer.toString(num);
				
			for(int j = 0; j < count.length; j++) {
				String no = count[j];
				System.out.println();

				for(int k = 0; k < no.length(); k++) {
					char ch = no.charAt(k);
					Iterator<Character> it = letters.iterator();
					Iterator<String> it2 = code.iterator();
							
					while(it.hasNext()) {
						Character let = it.next();
						String cod = it2.next();
						if(let == ch) {
							store1.add(cod);
							System.out.print(cod + " ");
						}
					}
				}
			}
			// Encode EOT
			System.out.println("\n. --- -");
			//System.out.println(store1);
		}
		catch(Exception e) {
			lettersEncode();
		}
	}
	
	private static void morseDecode() {
		Scanner incod = new Scanner(System.in);
		countDecodeNum = new ArrayList<Integer>();
		
		try {
			String[] codeIn = incod.nextLine().split("\\s+");
			int line = -4;
			int word = -4;
			int alph = -4;
			int symb = 0;
			int num = -6;
			
			if(codeIn[0].equals("...-") && codeIn[1].equals("...-")) {
				System.out.println("VV");
				String ci[] = incod.nextLine().split(" " + " ");
				while(true) {
					if(ci[0].equals(". --- -"))
						break;
					else {
						line++;
						for(int i = 0; i < ci.length; i++) {
							String mi[] = ci[i].split("\\s+");
							word++;
							for(int j = 0; j < mi.length; j++) {
								int codIndex = code.indexOf(mi[j]);
								char letIndex = letters.get(codIndex);
								System.out.print(letIndex);
								store2.add(letIndex);
								if(mi[j].equals(".-") || mi[j].equals("-...") || mi[j].equals("-.-.") || mi[j].equals("-..") || mi[j].equals(".") || 
								mi[j].equals("..-.") || mi[j].equals("--.") || mi[j].equals("....") || mi[j].equals("..") || mi[j].equals(".---") ||
								mi[j].equals("-.-") || mi[j].equals(".-..") || mi[j].equals("--") || mi[j].equals("-.") || mi[j].equals("---") || 
								mi[j].equals(".--.") || mi[j].equals("--.-") || mi[j].equals(".-.") || mi[j].equals("...") || mi[j].equals("-") ||
								mi[j].equals("..-") || mi[j].equals("...-") || mi[j].equals(".--") || mi[j].equals("-..-") || mi[j].equals("-.--") ||
								mi[j].equals("--..")) {
									alph++;
								}
								else if(mi[j].equals(".----") || mi[j].equals("..---") || mi[j].equals("...--") || mi[j].equals("....-") || 
								mi[j].equals(".....") || mi[j].equals("-....") || mi[j].equals("--...") || mi[j].equals("---..") || 
								mi[j].equals("----.") || mi[j].equals("-----")) {
									num++;
									alph++;
								}
								else {
									symb++;
								}
							}
							System.out.print(" ");
						}
						System.out.println();
						ci = incod.nextLine().split(" " + " ");
					}
				}
				// Decode . --- -
				System.out.println("EOT");
				//System.out.println(store2);
			}
			// Counted number of
			//System.out.println(line);
			//System.out.println(words);
			//System.out.println(alphab);
			//System.out.println(symb);
			//System.out.println(num);
			
			// Store in number list
			countDecodeNum.add(line);
			countDecodeNum.add(word);
			countDecodeNum.add(alph);
			countDecodeNum.add(symb);
			countDecodeNum.add(num);
			//System.out.println(countDecodeNum);
						
			Iterator it = countEncodeNum.iterator();
			System.out.println();
			while(it.hasNext()) {
				System.out.print(it.next() + " ");
			}
			
			if(countDecodeNum.equals(countEncodeNum) ) {
				System.out.println("\nResult: Consistent Summary");
			}
			else {
				System.out.println("\nResult: Inconsistent Summary");
			}
		}
		catch(Exception e) {
			morseDecode();
		}
	}
	
	private static void morseDisplay() {
		ArrayList<String> codeDisplay = new ArrayList<String>(Arrays.asList("A .-", "B -...","C -.-.","D -..","E .","F ..-.","G --.","H ....","I ..",
		"J .---","K -.-","L .-..","M --","N -.","O ---","P .--.","Q --.-","R .-.","S ...","T -","U ..-","V ...-","W .--","X -..-","Y -.--", "Z --..",
		"1 .----","2 ..---","3 ...--","4 ....-","5 .....","6 -....","7 --...","8 ---..","9 ----.","0 -----",
		". .-.-.-",", --..--", ": ---...", "\" .-..-.", "\' .----.", "! -.-.--", "? ..--.."	, "@ .--.-.", "- -....-", "; -.-.-.", "( -.--.",
		") -.--.-","= -...-"));
		
		A173630_ditsdahs morse = new A173630_ditsdahs();
		for(int i = 0; i < codeDisplay.size(); i++) {
			morse.add(codeDisplay.get(i),code.get(i));
		}
		morse.inOrderTree();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int code;
		
		do {
			System.out.println("\nMenu:\n" + "\t1. Send Morse Message\n" + "\t2. Receive Morse Message\n" + "\t3. Print Letters and Morse Code\n"
					+ "\t4. Exit\n");
			System.out.print("Input code:\n");
			code = sc.nextInt();

			switch (code) {
			case 1:
				lettersEncode();
				break;
				
			case 2:
				morseDecode();
				break;
				
			case 3:
				morseDisplay();
				break;

			case 4:
				System.out.println("Bye dits-dahs..");
				break;

			default:
				System.out.print("Invalid code, Enter code 1-4: ");
				break;
			}
		} 
		while (code != 4);	
	}
}