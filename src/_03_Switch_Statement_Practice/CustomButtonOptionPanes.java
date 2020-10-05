package _03_Switch_Statement_Practice;

import javax.swing.JOptionPane;

public class CustomButtonOptionPanes {
	public static void main(String[] args) {
		String[] options = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

		int input = JOptionPane.showOptionDialog(null, "Choose a day of the week", "Custom Buttons", 0, -1, null,
				options, 0);

		String choice = options[input];
		
		//use a switch statement to do something cool for each option
		switch(choice) {
		case "Sunday":
			System.out.println("I'd rather not do this right now");
		case "Monday":
			System.out.println("This is Satan's favorite day");
		case "Tuesday":
			System.out.println("Another day");
		case "Wednesday":
			System.out.println("HALF WAY!!!");
		case "Thursday":
			System.out.println("Getting closer!");
		case "Friday":
			System.out.println("It's Friday!");
		case "Saturday":
			System.out.println("Another day of relaxation. Can't wait to start the cycle over again");
		}
		
	}
}
