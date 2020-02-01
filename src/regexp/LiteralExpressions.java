package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LiteralExpressions {
	
	//]\^.
	
	public static void main(String[] args) {
		
//		Pattern pattern = Pattern.compile("\\Q1+1=2\\E");
		Pattern pattern = Pattern.compile("1\\+1=2");
		Matcher matcher = pattern.matcher("1+1=2");
		while (matcher.find()) {
			System.out.println(matcher.start() + " " + matcher.group() + " ");
		}
		System.out.println("");
		
	}
	
	private static void doMagic() {
		
//		Pattern pattern = Pattern.compile("b");
//		Matcher matcher = pattern.matcher("Jack is a boy");
//		while (matcher.find()) {
//			System.out.println(matcher.start() + " " + matcher.group() + " ");
//		}
//		System.out.println("");
		
//		Pattern pattern = Pattern.compile("1\\+1=2");
		Pattern pattern = Pattern.compile("\\Q1+1=2\\E");
		Matcher matcher = pattern.matcher("1+1=2");
		while (matcher.find()) {
			System.out.println(matcher.start() + " " + matcher.group() + " ");
		}
		System.out.println("");
		
	}

}
