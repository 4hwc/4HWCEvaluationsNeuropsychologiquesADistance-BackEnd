package enad.trainings;

import java.io.File;

public class Delete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			File file = new File("C:\\fichiers\\imagestdoi\\SAM_1124.JPG");

			if (file.delete()) {
				System.out.println(file.getName() + " is deleted!");
			} else {
				System.out.println("Delete operation is failed.");
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
