import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Thread1 implements Runnable {

	BinarySearchTree tree = new BinarySearchTree();
	String filename;


	public Thread1(BinarySearchTree tree, String filename) {
		this.tree = tree;
		this.filename = filename;
	}

	@Override
	public void run() {
		String data = "";
		int count = 0;
		String[] store = new String[10];
		
		try {
			File myObj = new File("src\\" + filename);
			Scanner myReader = new Scanner(myObj);

			while (myReader.hasNextLine()) {
				data = myReader.nextLine();
				String[] words = data.split("\\n");
				count = 0;

				for (String w : words) {
					store[count] = w;
					count++;
				}
				tree.insert(store[0]);

			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
	}

	
}