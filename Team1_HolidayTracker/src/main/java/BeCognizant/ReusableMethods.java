package BeCognizant;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReusableMethods {

	public Properties fileReader() {
		FileReader reader = null;

		//Reads the data from testdata properties file
		try {
			reader = new FileReader("./src/main/resources/TestData/testdata.properties");

		}catch (FileNotFoundException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}

		//creating the properties object to load the file
		Properties properties = new Properties();

		//loading the testdata properties file
		try {
			properties.load(reader);
		}catch (IOException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}

		return properties;
	}
}
