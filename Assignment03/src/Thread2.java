import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class Thread2 implements Runnable {

	String[] filename;
    
	public Thread2(String[] filename) {
		this.filename = filename;
	}

	@Override
	public void run() {

		

		for (int i = 1; i < filename.length; i++) {
			
			Vector<String> vector1 = new Vector<String>(200);

			String data = "";
			int count = 0;
			String[] store = new String[10];

			try {
				File myObj = new File("src\\" + filename[i]);
				Scanner myReader = new Scanner(myObj);

				while (myReader.hasNextLine()) {
					data = myReader.nextLine();
					String[] words = data.split("\\n");
					count = 0;

					for (String w : words) {
						store[count] = w;
						count++;
					}

					String[] words1 = store[0].split("\\ ");
					for (String w1 : words1) {
						vector1.add(w1);
					}

				}
				myReader.close();
			} catch (FileNotFoundException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
            
			System.out.println("\n");
			System.out.println("============================================");
			System.out.println("OUTPUT OF FILE " + filename[i]);
			for (int j = 0; j < vector1.size(); j++) {
				System.out.println(vector1.get(j));
			}

		}

		System.out.println("\n");

	}
}