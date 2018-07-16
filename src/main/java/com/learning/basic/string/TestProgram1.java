/**
 * 
 */
package com.learning.basic.string;

/**
 * @author VINAY
 * 
 */
public class TestProgram1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestProgram1 program = new TestProgram1();
		
		// Question 1
		program.question1();
		System.out.println("==============================");
		// Question 2
		program.question2();
		System.out.println("==============================");
		// Question 3
		program.question3();
	}

	/**
	 * Suppose we want to pre process JSON strings to strip out C style line
	 * comments. Write a function to strip line commentswithout using regular
	 * expressions
	 */
	public void question1() {
		String input = "// this is a comment\r\n" + "{ // another comment\r\n"
				+ " true, \"foo\", // 3rd comment\r\n"
				+ " \"http://www.abc.com\" // comment after URL\r\n" + "}";
		System.out.println("Input : "+input);
		String result = stripLineComment(input);
		System.out.println();
		System.out.println("Output : "+result);
	}
	
	/**
	 * @param input
	 * @return
	 */
	private String stripLineComment(String input) {
		String output = "";
		// System.out.println(input.replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|[^:]//.*|^//.*",
		// ""));
		String[] inputArray = input.split("\\r\\n");
		for (String val : inputArray) {
			int i = indexOf(val, 0);
			if(i != -1) {
				output += val.substring(0, i);
			} else {
				output += val;
			}
		}
		return output;
	}

	/**
	 * @param val
	 * @param offset
	 * @return
	 */
	private int indexOf(String val, int offset) {
		int i = val.indexOf("//", offset);
		int j = val.indexOf("\"", offset);

		if (i != -1 && j != -1) {
			i = indexOf(val, j + 1);
		}

		return i;
	}

	/**
	 * Given a string consists of different types of brackets, write a function
	 * to determine the string is balanced. For example, " ([])" and "[]{}" are
	 * balanced but "([)]" and "](){" are not. You can assume these are the only
	 * characters in the string: ()[]{}
	 */
	public void question2() {
		String input = "([{}])";
		System.out.println("Input : "+input+" : Result : "+isValid(input));
		input = "( a[b {d} e] c)";
		System.out.println("Input : "+input+" : Result : "+isValid(input));
		input = "( abcd [efgh] ijkl)";
		System.out.println("Input : "+input+" : Result : "+isValid(input));
		input = "( abcd )";
		System.out.println("Input : "+input+" : Result : "+isValid(input));
		input = "( a[b {d e] } c)";
		System.out.println("Input : "+input+" : Result : "+isValid(input));
		input = "( a[b {d e } c) x ]";
		System.out.println("Input : "+input+" : Result : "+isValid(input));
	}
	
	/**
	 * If the string only consists of ( and ), how would it affect your solution
	 * from above? For example: " (())" or " (()("
	 */
	public void question3() {
		String input = "(())";
		System.out.println("Input : "+input+" : Result : "+isValid(input));
		input = "(abc(xyz)123)";
		System.out.println("Input : "+input+" : Result : "+isValid(input));
		input = "(()(";
		System.out.println("Input : "+input+" : Result : "+isValid(input));
		input = "((abcd()";
		System.out.println("Input : "+input+" : Result : "+isValid(input));
	}
	
	/**
	 * Check whether string contains well formed bracket 
	 * 1) Filter brackets from input data 
	 * 2) Validate filtered data with bracket patterns
	 * 
	 * @param input
	 * @return
	 */
	private boolean isValid(String input) {
		boolean flag = false;

		String brackets = identifyBrackets(input);

		while ((brackets.length() > 0)
				&& (brackets.contains("[]") || brackets.contains("()") || brackets
						.contains("{}"))) {
			brackets = brackets.replace("[]", "");
			brackets = brackets.replace("()", "");
			brackets = brackets.replace("{}", "");
		}

		if (brackets.length() == 0) {
			flag = true;
		}
		return flag;
	}

	/**
	 * Identify or Filter predefined brackets () [] {} 
	 * Example : 
	 * 1) Input = "( a[b] c)"; Output = ([]) 
	 * 2) Input = ""( a[b] {c})"; Output = ([]{}) 
	 * 3) Input = "( a[b(] {c)})"; Output = ([(]{)}) 
	 * 4) Input = "( {a[b] c})"; Output = ({[]}) 
	 * 5) Input = "( {a[b] c})"; Output = ({[]})
	 * 
	 * @param val
	 * @return
	 */
	private String identifyBrackets(String val) {
		String result = "";
		if (val != null && !"".equals(val)) {
			int len = val.length();
			char arr[] = val.toCharArray();

			for (int i = 0; i < len; i++) {
				if ((arr[i] == '(') || (arr[i] == ')') || (arr[i] == '[')
						|| (arr[i] == ']') || (arr[i] == '{')
						|| (arr[i] == '}')) {
					result = result + arr[i];
				}
			}
		}
		return result;
	}
}