package Controller;

import java.util.Scanner;

public class Controller {
	
	public static void main(String[] args) {
		new Controller().start();
	}
	
	private void start() {
		Scanner s = new Scanner(System.in);
		
		String choice;
		
		do {
			
			choice = s.nextLine();
			
			switch(choice){
				default:
					
				break;
			}
		} while(choice.equals("q") || choice.equals("Q"));
	}
}