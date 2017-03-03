package Files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyHomework {
	
	public static void main(String[] args)  {
		
		String sep = File.separator;
		File original = new File(".." + sep + "HomeworkLesson15vn");
		File copy = new File(".." + sep + "CopyHomework");
		copy.mkdir();
		
		try {
			copyFiles(original, copy);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void copyFiles(File f1, File f2) throws IOException {
		String pathHelper = f2.getPath();
		f2 = new File(pathHelper + File.separator + f1.getName());
		if (f1.isDirectory()) {
			f2.mkdir();
			pathHelper = f2.getPath();
			for(File child: f1.listFiles()) {
				copyFiles(child, f2);
			}
		}
		else {
			f2.createNewFile();
			FileInputStream originalReader = new FileInputStream(f1);
			FileOutputStream copyWriter = new FileOutputStream(f2);
			int b = originalReader.read();
			while (b != -1) {
				copyWriter.write(b);
				b= originalReader.read();
			}
			originalReader.close();
			copyWriter.close();
		}
		
		
		
	}

}
