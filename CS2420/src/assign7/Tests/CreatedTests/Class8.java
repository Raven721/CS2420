/* \'\'\'\'\'\' \"\"\"\"\" /* */
package assign7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class containing the checkFile method for checking if the (, [, and { symbols
 * in an input file are correctly matched.
 * 
 * @author Tim Ellenberger, ellenber
 * @author Jay Mendez, jaym
 * @author Erin Parker
 * @version 10/22/2015
 */
public class BalancedSymbolChecker {

	/**
	 * Returns a message indicating whether the input file has unmatched
	 * symbols. (Use the methods below for constructing messages.) Throws
	 * FileNotFoundException if the file does not exist.
	 * 
	 * @return Message confirming the results of the symbol matching analysis on
	 *         the input file.
	 */
	public static String checkFile(String filename) throws FileNotFoundException {

		File f = new File(filename);

		@SuppressWarnings("resource")
		Scanner in = new Scanner(f);
		MyStack<Character> stack = new MyStack<Character>();
		char poppedSymbol;

		int line = 0;

		// Cycle through each separate word in the file
		while (in.hasNextLine()) {
			int column = 0;

			// increment line on each iteration
			line++;

			String currentLine = in.nextLine();
			char[] charArray = currentLine.toCharArray();

			// Cycle through the current line's characters
			for (int i = 0; i < charArray.length; i++) {
				char c = charArray[i];

				// Skip to the next character if the current space is empty
				if (c == ' ') {
					column++;
					continue;
				}
				if (c == '\t') {
					column++;
					continue;
				}
				column++;

				// Find cases where characters must be overlooked i.e. Comments and String/Character literals
				if (stack.isEmpty()) {
					if (c == '/') {
						if (i + 1 < charArray.length) {
							if (charArray[i + 1] == '/') {
								System.out.println("// found at line " + line + " column " + column);
								break;
							} else if (charArray[i + 1] == '*') {
								System.out.println("/* begins at line " + line + " column " + column);
								stack.push('/');
							}
						}
					} else if (c == '"') {
						System.out.println("\" begins at line " + line + " column " + column);
						stack.push('"');
					} else if (c == '\'') {
						System.out.println("\' begins at line " + line + " column " + column);
						stack.push('\'');
					}
				} else if (!stack.isEmpty()) {
					// If the current character is inside of a comment or literal, keep iterating
					if (stack.peek() == '"' && c != '"') {
						continue;
					} else if (stack.peek() == '/' && c != '/') {
						continue;
					} else if (stack.peek() == '\'' && c != '\'') {
						continue;
					}

					// Evaluate the current character based on the last item pushed to the stack
					if (c == '/') {
						if (stack.peek() == '/') {
							if (charArray[i - 1] == '*') {
								System.out.println("*/ ends at line " + line + " column " + column);
								stack.pop();
							}
						} else {
							if (i + 1 < charArray.length) {
								if (charArray[i + 1] == '/') {
									System.out.println("// found at line " + line + " column " + column);
									break;
								} else if (charArray[i + 1] == '*') {
									System.out.println("/* begins at line " + line + " column " + column);
									stack.push('/');
								}
							}
						}
					} else if (c == '"') {
						if (stack.peek() == '"') {
							// Before making any stack operation, make sure that the current character isn't part of a String/character literal escape sequence
							if (charArray[i - 1] != '\\') {
								System.out.println("\" ends at line " + line + " column " + column);
								stack.pop();
							} else {
								continue;
							}
						} else {
							System.out.println("\" begins at line " + line + " column " + column);
							stack.push('"');
						}
					} else if (c == '\'') {
						if (stack.peek() == '\'') {
							// Before making any stack operation, make sure that the current character isn't part of a String/character literal escape sequence
							if (charArray[i - 1] != '\\') {
								System.out.println("\' ends at line " + line + " column " + column);
								stack.pop();
							} else {
								continue;
							}
						} else {
							System.out.println("\' begins at line " + line + " column " + column);
							stack.push('\'');
						}
					}
				}

				// Keep iterating if inside a comment or string/character literal
				if (!stack.isEmpty()) {
					if (stack.peek() == '\'' || stack.peek() == '"' || stack.peek() == '/') {
						continue;
					}
				}

				// Push opening symbol to stack
				if (c == '(' || c == '{' || c == '[') {
					stack.push(c);
				}
				// Pop closing symbol from stack
				else if (c == ')' || c == '}' || c == ']') {
					if (stack.isEmpty()) {
						return BalancedSymbolChecker.unmatchedSymbol(line, column, c, ' ');
					}

					poppedSymbol = stack.pop();

					if (poppedSymbol == '(' && c != ')') {
						return BalancedSymbolChecker.unmatchedSymbol(line, column, c, ')');
					}
					if (poppedSymbol == '{' && c != '}') {
						return BalancedSymbolChecker.unmatchedSymbol(line, column, c, '}');
					}
					if (poppedSymbol == '[' && c != ']') {
						return BalancedSymbolChecker.unmatchedSymbol(line, column, c, ']');
					}
				}
			}
		}

		// Close the input stream
		in.close();

		// Check if the stack is empty after scanning through the file
		if (!stack.isEmpty()) {
			poppedSymbol = stack.pop();

			// If an item is left in the stack after iterating through the entire file, return the corresponding error message  
			if (poppedSymbol == '(')
				return BalancedSymbolChecker.unmatchedSymbolAtEOF(')');
			if (poppedSymbol == '{')
				return BalancedSymbolChecker.unmatchedSymbolAtEOF('}');
			if (poppedSymbol == '[')
				return BalancedSymbolChecker.unmatchedSymbolAtEOF(']');
			if (poppedSymbol == '\'')
				return BalancedSymbolChecker.unmatchedSymbolAtEOF('\'');
			if (poppedSymbol == '"')
				return BalancedSymbolChecker.unmatchedSymbolAtEOF('"');
			if (poppedSymbol == '/')
				return BalancedSymbolChecker.unfinishedComment();

		}

		// If the input file has made it this far, return all symbols match
		return BalancedSymbolChecker.allSymbolsMatch();
	}

	/**
	 * Returns an error message for unmatched symbol at the input line and
	 * column numbers. Indicates the symbol match that was expected and the
	 * symbol that was read.
	 * 
	 * @return Message confirming an unmatched symbol at the input line and
	 *         column numbers.
	 */
	private static String unmatchedSymbol(int lineNumber, int colNumber, char symbolRead, char symbolExpected) {
		return "ERROR: Unmatched symbol at line " + lineNumber + " and column " + colNumber + ". Expected "
				+ symbolExpected + ", but read " + symbolRead + " instead.";
	}

	/**
	 * Returns an error message for unmatched symbol at the end of file.
	 * Indicates the symbol match that was expected.
	 * 
	 * @return Message confirming an unmatched symbol at the end of the file and
	 *         indicates the expected symbol.
	 */
	private static String unmatchedSymbolAtEOF(char symbolExpected) {
		return "ERROR: Unmatched symbol at the end of file. Expected " + symbolExpected + ".";
	}

	/**
	 * Returns an error message for a file that ends with an open /* comment.
	 * 
	 * @return Message confirming that that the file ended with an open /*
	 */
	private static String unfinishedComment() {
		return "ERROR: File ended before closing comment.";
	}

	/**
	 * Returns a message for a file in which all symbols match.
	 * 
	 * @return Message confirming that all symbols match.
	 */
	private static String allSymbolsMatch() {
		return "No errors found. All symbols match.";
	}
}
