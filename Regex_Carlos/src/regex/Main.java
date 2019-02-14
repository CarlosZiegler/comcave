package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		boolean a = "carlos".matches("carlos");
		System.out.println(a);

		String regex = "aba";
		String texto = "abababa";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(texto);
		System.out.println("texto:   "+texto);
		System.out.println("indice:  0123456789");
		System.out.println("expressao:" + matcher.pattern());
		System.out.println("posicoes encontradas:");
		
		
		
		while (matcher.find()) {
			System.out.print(matcher.start());
				
			
		}
		
		Pattern pattern1 = Pattern.compile("(\\d\\d)(\\w)");
		Matcher matcher2 = pattern1.matcher("11a22b33c");
		
		while (matcher2.find()) {
			String match = matcher2.group();
			String group1 = matcher2.group(1);
			String group2 = matcher2.group(2);
			int start = matcher2.start();
			int end = matcher2.end();
			
			System.out.printf("\n %s | %s |%s [%d,%d] \n", match, group1, group2, start, end);
			
			
			
		}
		
		
		

		final String reges = "^\\w+";
		final String string = "Palme Ulme Kiefer";

		final Pattern pattern3 = Pattern.compile(reges, Pattern.MULTILINE);
		final Matcher matcher3 = pattern3.matcher(string);

		while (matcher3.find()) {
		    System.out.println("match: " + matcher3.group(0));
		   
		}
		
	}

}
