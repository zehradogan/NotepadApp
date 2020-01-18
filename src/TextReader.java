import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextReader {
	
	private String filename;
	
	public TextReader(String filename) {
		this.filename = filename;
	}
	
	public String readFile() {
		
		String text = "";
		
		try(BufferedReader fr = new BufferedReader(new FileReader(filename))){
		String line;
		
		while((line = fr.readLine()) != null) {
			text += line;
		}
		}
		
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return text;
		
	}

}
