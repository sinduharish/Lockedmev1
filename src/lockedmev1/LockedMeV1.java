package lockedmev1;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class LockedMeV1 {

	public static String WORKING_DIR = System.getProperty("user.dir");


	public void menu() {
		try {
			
			System.out.println("\n\n*******************************************************");
			System.out.println("|------------------------------|");
			System.out.println("|          LOCKEDME            |");
			System.out.println("|                              |");
			System.out.println("|                Created by    |");
			System.out.println("|                    Sindhu K  |");
			System.out.println("|------------------------------|");

			Scanner sc = new Scanner(System.in);
			System.out.println();
			System.out.println("*****MAIN MENU*****");
			System.out.println();
			System.out.println("\t1. Display files in ascending order");
			System.out.println("\t2. User Interface ");
			System.out.println("\t3. Close application");
			System.out.println("\n Enter your choice : ");
			int n = sc.nextInt();

			switch (n) {
			case 1:
				sort();
				break;
			case 2:
				userinterface();
				break;
			case 3:
				exit();
				break;
			default:
				System.out.println("Enter the correct option");
				menu();
				break;
			}
		} catch (Exception e) {
			System.out.println("Invalid imput");
			menu();
		}
	}

	////////////////////////////////////////////

	public void sort() {
		String path = WORKING_DIR;
		File obj = new File(path);

		File files[] = obj.listFiles();

		Arrays.sort(files);
		for (File e : files) {
			if (e.isFile()) {

				System.out.println("Files  : " + e.getName());
			}
			
			  else if(e.isDirectory()) {
			 
			  System.out.println("Folder : "+ e.getName()); }
			 
			else {
				System.out.println("Unknown : " + e.getName());
			}
		}

		menu();
	}

	/////////////////////////////////////////////////

	public void userinterface() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("\n\n");
			System.out.println("*****User Interface*****");
			System.out.println("\t1. Create file");
			System.out.println("\t2. Delete file");
			System.out.println("\t3. Search file");
			System.out.println("\t4. Main menu");
			System.out.println("\n Enter your choice : ");
			int n = sc.nextInt();

			switch (n) {
			case 1:
				createFile();
				break;
			case 2:
				delete();
				break;
			case 3:
				search();
				break;
			case 4:
				menu();
				break;
			default:
				System.out.println("Enter the correct option");
				userinterface();
				break;
			}
		} catch (Exception e) {
			System.out.println("Invalid input");
			userinterface();
		}
	}

/////////////////////////////////////////////////////////////

	public void createFile() {
		String str;
		System.out.println("Enter the file name");

		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
		File obj = new File(str + ".txt");

		try {
			if (obj.createNewFile()) {
				System.out.println("\nFile created successfuly");
				System.out.println();
			}

			else {
				System.out.println("\nFile creation failed");
			}
		} catch (IOException e) {
			System.out.println("\nError occured");
		}
		userinterface();
	}

////////////////////////////////////////////////////////////

	public void delete() {

		String path = WORKING_DIR;

		Scanner sc = new Scanner(System.in);
		System.out.println("\tEnter the file to be delete");
		String str = sc.nextLine();
		File obj = new File(str + ".txt");

		if (obj.delete()) {
			System.out.println("\nFile Successfully deleted");
		}

		else {
			System.out.println("\nFile name does not exist");
		}
		userinterface();

	}

///////////////////////////////////////////////////////////

	public void search() {

		System.out.println("Enter the file to be searched :");
		Scanner sc1 = new Scanner(System.in);
		String str = sc1.next();

		String path = WORKING_DIR;
		File obj = new File(path);
		boolean found = false;

		String files[] = obj.list();
		for (int i = 0; i < files.length; i++) {
			String str1 = files[i];

			if ((str + ".txt").equals(str1)) {
				System.out.println("\nFile found");
				found = true;
				break;
			}

		}

		if (!found) {
			System.out.println("\nFile does not exist");
		}
		userinterface();
	}

///////////////////////////////////////////////////////////	  

	public void exit() {
		System.out.println("\tThanks for using our application");
	}

/////////////////////////////////////////////////////////////

	public static void main(String[] args) {

		LockedMeV1 lm = new LockedMeV1();
		
		lm.menu();

	}

}
