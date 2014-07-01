package com.andieguo.stackdemo;

import java.util.EmptyStackException;

public class StackTest {
	static boolean matchBracket( String str )
    {
        Stack stack = new Stack();
        try
        {
            for ( int i = 0; i < str.length(); i++ )
            {
                char curChar = str.charAt( i );
                switch ( curChar )
                {
                    case '[':
                    case '{':
                    case '(':
                        stack.push( curChar );
                        break;
                    case ']':
                        if ( !stack.pop().equals( '[' ) )
                        {
                            return false;
                        }
                        break;
                    case '}':
                        if ( !stack.pop().equals( '{' ) )
                        {
                            return false;
                        }
                        break;
                    case ')':
                        if ( !stack.pop().equals( '(' ) )
                        {
                            return false;
                        }
                        break;
                }
            }
        } catch (EmptyStackException e )
        {
            return false;
        }
        if ( stack.empty() )
            return true;
        else
            return false;
    }
	public static void isMatch(String str) {
		Stack<Character> myStack = new Stack<Character>();
		char[] arr = str.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			Character ch = arr[i];
			switch (ch) {
			case '{':
			case '[':
			case '(':
				myStack.push(ch);
				break;
			case '}':
			case ']':
			case ')':
				if (myStack.empty()) {
					char chx = myStack.pop();
					if ((ch == '{' && chx != '}') || (ch == '[' && chx != ']')
							|| (ch == '(' && chx != ')')) {
						System.out.println("Error: " + ch + " at" + i);
					}
				} else {
					System.out.println("Error: " + ch + " at" + i);
				}
				break;
			default:
				break;
			}
			if (!myStack.empty()) {
				System.out.println("Error:missing the right delimiter");
			}
		}
	}

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		for (String s : "My dog has fleas".split(" ")) {
			stack.push(s);// [fleas has dog My][0 1 2 3]
		}
		while (!stack.empty()) {
			System.out.println(stack.pop());
		}
		//isMatch("[(a)[b]]");
		
		System.out.println(matchBracket("{[[(a)[b]]]}"));
	}
}
