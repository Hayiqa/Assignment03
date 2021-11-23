import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class Thread4 implements Runnable {

	String[] filename;
	String word;

	public Thread4(String word, String[] filename) {
		this.word = word;
		this.filename = filename;
	}

	@Override
	public void run() {
        
		for(int i = 1 ; i < filename.length; i++)
		{

			String data = "";
			int count = 0;
			String[] store = new String[10];
	        int linenum = 0;
			
			try {
				File myObj = new File("src\\" + filename[i]);
				Scanner myReader = new Scanner(myObj);

				while (myReader.hasNextLine()) {
					data = myReader.nextLine();
					String[] words = data.split("\\n");
					count = 0;

					for (String w : words) {
						store[count] = w;
						linenum++;
						count++;
					}

					String[] words1 = store[0].split("\\ ");
					for (String w1 : words1) {
						if(w1.equals(word))
						{
							System.out.println("Word " + word + " found in file " + filename[i] + "on Line Number " + linenum);
						}
					}
	                
				}
				myReader.close();
			} catch (FileNotFoundException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
			
		}
		
	}	
	
}