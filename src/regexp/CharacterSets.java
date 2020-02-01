package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharacterSets {
	
	//]\^.
	
	public static void main(String[] args) {
		
		Pattern pattern = Pattern.compile("[\\Q[-]\\E]");
		Matcher matcher = pattern.matcher("]]]");
		while (matcher.find()) {
			System.out.println(matcher.start() + " " + matcher.group() + " ");
		}
		System.out.println("");
		
//		Pattern pattern = Pattern.compile("[a-c]");
//		Matcher matcher = pattern.matcher("abcdc");
		
//		Pattern pattern = Pattern.compile("[0-5a-zA-z]");
//		Matcher matcher = pattern.matcher("147fF");
		
//		Pattern pattern = Pattern.compile("gr[ae]y");
//		Matcher matcher = pattern.matcher("grey");
		
//		Pattern pattern = Pattern.compile("q[^u]");
//		Matcher matcher = pattern.matcher("Iraqu is a country");
		
//		Pattern pattern = Pattern.compile("[*+]");
//		Matcher matcher = pattern.matcher("1+1=2");
		
//		Pattern pattern = Pattern.compile("[\\\\x]");
//		Matcher matcher = pattern.matcher("\\");
		
		
		
		
	}

}
