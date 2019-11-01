

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Exercise_09 {
	public static void main(String[] args) {
		String resourceFolder = "D:\\Java_Softuni_2018\\Java_Advanced\\exercise_09_input_output\\";

		String serializableObjectPath = resourceFolder + "object.ser";

		FootballPlayer player = new FootballPlayer("Ronaldo", 32, "Juventus", 1200000);

		try (FileOutputStream fos = new FileOutputStream(serializableObjectPath);
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {

			oos.writeObject(player);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
