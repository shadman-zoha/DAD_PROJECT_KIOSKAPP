package WriteFile;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class WriteFile {

	private String path;
	private boolean append_to_file = false;
	
	public WriteFile(String file_path) {// when create the object. define the path.
		path = file_path;
		
	}
	
	public WriteFile(String file_path, boolean append_value) {// overiden fx. a
		path = file_path;
		append_to_file = append_value;// if we want to append the text if the name of file is same. set it to true.
	}
	
	public void writeToFile(String textLine) throws IOException{
		
		FileWriter write = new FileWriter(path, append_to_file);
		PrintWriter print_line = new PrintWriter(write);
		
		print_line.printf("%s" + "%n", textLine);
	
		print_line.close();
	}
}
