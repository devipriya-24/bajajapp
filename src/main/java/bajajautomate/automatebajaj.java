package bajajautomate;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.sikuli.script.Key;
import org.sikuli.script.Screen;





public class automatebajaj {
	public static void main(String[] args) {
		try {
			Screen screen=new Screen();
			
			String excelPath = "C:\\Program Files\\Microsoft Office\\root\\Office16\\EXCEL.EXE"; // Adjust if needed

			 // Step 1: Open Excel
            Runtime.getRuntime().exec(excelPath);
            Thread.sleep(5000); // Wait for Excel to open
            
            // Step 2: Type the current date in A1
            screen.type("a", Key.CTRL); // Select all (to ensure a clean start)
            Thread.sleep(500);
            screen.type(Key.BACKSPACE); // Clear existing content
            Thread.sleep(500);
			
//Generate current date string
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            String currentDate = sdf.format(new Date());
            screen.type(currentDate);
            Thread.sleep(1000);
            
   // Step 3: Save the file with a random name
            screen.type("s", Key.CTRL); // CTRL+S to save
            Thread.sleep(2000);
            
            Random rand = new Random();
            int randomNumber = rand.nextInt(1000); // Random number for uniqueness
            String fileName = "file_" + currentDate + "_" + randomNumber + ".xlsx";
           // String fullFilePath = savePath + fileName;
            Thread.sleep(1000);
            
            screen.type(fileName);
            Thread.sleep(1000);
			        
         // **Fix: Navigate to "More options..."**
            for(int i=0;i>=3;i++) {
            	
           
            screen.type(Key.TAB);
           
            }
            Thread.sleep(500);
            screen.type(Key.ENTER); // Open full Save As dialog
            Thread.sleep(3000);
            
        
				
            
         // Step 4: Close Excel safely
            screen.type(Key.F4, Key.ALT); // ALT+F4 to close Excel
            Thread.sleep(2000);
            
            
            
           System.out.println("Excel automation completed. File saved as: " + fileName);
            
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
