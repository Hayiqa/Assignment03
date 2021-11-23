import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Thread3 implements Runnable {

	String filenames;
	instance[] obj1 = new instance[50];
	int size = 0;

	public Thread3(instance[] inst, String filename2) {

		filenames = filename2;
		obj1 = inst;
	}

	@Override
	public void run() {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("src\\" + filenames));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		String[] newarray = new String[100];
		int size = 0;
		while (scanner.hasNext()) {
			newarray[size++] = scanner.next();
		}

		for (int i = 0; obj1[i].object != null; i++) {
			for (int j = 0; j < newarray.length; j++) {
				if (obj1[i].object.equals(newarray[j])) {
					obj1[i].counter++;
				}
			}
		}

	}
}