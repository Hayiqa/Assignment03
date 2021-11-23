import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class Menu {

	@SuppressWarnings("resource")
	public static void main(String[] args)
			throws InterruptedException, InvalidInput, IndexOutofBound, FileNotFoundException {

		int choice;
		BinarySearchTree tree = new BinarySearchTree();
		instance[] obj = new instance[50];
		
		if(obj.length > 50)
		{
			throw new IndexOutofBound("Index out of Bound");
		}
		for (int i = 0; i < 50; i++) {
			obj[i] = new instance();
		}

		while (true) {
			System.out.print("\n");
			System.out.println("1.Displaying BST build from Vocabulary File");
			System.out.println("2.Displaying Vectors build from Input files.");
			System.out.println("3.Viewing Match words and its frequency");
			System.out.println("4.Searching a query");
			System.out.println("5.Enter 5 for Exiting");
			System.out.println("\n");

			Scanner reader = new Scanner(System.in);
			choice = reader.nextInt();
			if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5) {
				throw new InvalidInput("Option does not exist");
			}

			if (choice == 1) {
				Runnable thread1 = new Thread1(tree, args[0]);
				new Thread(thread1).start();
				Thread.sleep(500);

				System.out.println("Total Number of Files: " + args.length);
				for (int i = 0; i < args.length; i++) {
					System.out.println("Name of File#" + i + ": " + args[i]);

					System.out.println("\n");
				}

				System.out.println("OUTPUT OF BINARY SEARCH TREE FOR VOCABULARY.TXT");
				tree.inorder();

				System.out.println("\n");
			}
			if (choice == 2) {
				Runnable thread2 = new Thread2(args);
				new Thread(thread2).start();
				Thread.sleep(500);
				int counter = 0;
				String[] array = new String[200];
				String[] array2 = new String[200];

				for (int i = 1; i < args.length; i++) {

					Scanner scanner = new Scanner(new File("src\\" + args[i]));
					while (scanner.hasNext()) {
						array[counter] = scanner.next();
						counter++;
					}
				}

				array2 = Arrays.stream(array).distinct().toArray(String[]::new);

				int size = 0;
				for (int i = 0; i < array2.length - 1; i++) {
					if (tree.Search(tree.root, array2[i]) == true) {
						obj[size].object = array2[i];
						size++;
					}
				}

			}
			
			if (choice == 3) {

				for (int i = 1; i < args.length; i++) {
					Runnable thread3 = new Thread3(obj, args[i]);
					new Thread(thread3).start();
					Thread.sleep(500);
				}

				System.out.println("Word   Frequency");
				for (int i = 0; obj[i].object != null; i++)
				{
					System.out.println(obj[i].object + " " + obj[i].counter);
				}

			}
			if (choice == 4) {
				System.out.print("Enter a Word to Search in Files: ");

				Scanner inp = new Scanner(System.in);
				String word = inp.nextLine();

				Runnable thread4 = new Thread4(word, args);
				new Thread(thread4).start();
				Thread.sleep(500);
			}
			
			if (choice == 5) {
				System.out.print("Exiting from code....");
				System.exit(0);
			}
		}
	}
}