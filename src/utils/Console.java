package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {

	public static Console console;
	
	private Console() {
		
	}
	
	public static Console instance() {
		if(Console.console == null) {
			Console.console = new Console();
		}
		return Console.console;
	}
	private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	
	public String readString(String title) {
		String input = "";
		boolean ok = false;
		do {
			try {
				this.write(title);
				input = this.bufferedReader.readLine();
				ok = true;
			} catch (IOException e) {
				this.writeError("string");
			}
		}while(!ok);
		return input;
	}
	

	public int readInt(String title) {
		int input = 0;
		boolean ok = false;
		do {
			try {
				input = Integer.parseInt(this.readString(title));
				ok = true;
			}
			catch(Exception ex) {
				this.writeError("entero");
			}
		} while(!ok);
		return input;
	}

	public char readChar(String title) {
		char charValue = ' ';
		boolean ok = false;
		do {
			String input = this.readString(title);
			if(input.length() != 1) {
				this.writeError("caracter");
			}
			else {
				charValue = input.charAt(0);
				ok = true;
			}
		} while(!ok);
		return charValue;
	}
	
	public double readDouble(String title) {
		double input = 0;
		boolean ok = false;
		do {
			try {
				input= Double.parseDouble(this.readString(title));
				ok = true;
			}
			catch(Exception ex){
				this.writeError("decimal");
			}
			
		} while(!ok);
		return input;
	}
	
	public String readDni(String title) {
		String dni = "";
		boolean ok = false;
		do {
			dni = Integer.toString(this.readInt(title));
			if(dni.length() != 8) {
				this.writeError("dni de 8 digitos");
			}
			else {
				ok = true;
			}
		} while(!ok);
		return dni;
	}
	
	public char readSexo(String title) {
		char sexo = ' ';
		boolean ok = false;
		do {
			sexo = Character.toUpperCase(this.readChar(title));
			if(sexo == 'M' || sexo == 'F') {
				ok = true;
			}
			else {
				this.writeError(" [m o f]");
			}
		} while(!ok);
		return sexo;
	}
	
	public void write(String string) {
		System.out.print(string);
	}
	
	public void writeln(String string) {
		System.out.println(string);
	}
	
	public void writeln() {
		System.out.println();
	}

	private void writeError(String format) {
		this.writeln("ERROR DE FORMATO!! " + "Ingrese un valor de tipo " + format);
	}
}
