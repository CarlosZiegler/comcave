import java.util.Scanner;

public class EntradadeDados {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String b,c,d;
		String a = sc.nextLine(); // metodo le a linha inteira e armazena em uma variavel
		System.out.println(a);
		
		b= sc.next();// metodo le a palavra e guarda dentro de uma variavel
		c= sc.next();
		d= sc.next();
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		
		
		
		String name;
		char ch,letter,gender;
		int n1,digit,age;
		double n2,height;
		
		n1=sc.nextInt();//pega um numero inteiro
		sc.nextLine();//consome o ultimo enter (aqui é o flush - limpeza de stream de entrada) 
		name = sc.nextLine();//pega algo digitado ate a quebra de pagina
		ch= sc.next().charAt(0);// pega o caracter na posicao 0 da string
		
		String s = sc.next(); // crinado uma string para guardar o valor de entrada
		letter = s.charAt(0); // buscando o char na posicao 1
		digit=Integer.parseInt(s.substring(1));// pegando a substring a partir da posicao 1 e convertendo em Inteiro 
		
		n2= sc.nextDouble();
		
		String name2;
		name2=sc.next();
		char ch2=sc.next().charAt(0);
		age=sc.nextInt();
		n2=sc.nextDouble();
		
		System.out.println(n1);
		System.out.println(name);
		System.out.println(ch);
		System.out.println(letter);
		System.out.println(digit);
		System.out.println(n2);
		
		
		
		
		
		sc.close();
		
	}

}
