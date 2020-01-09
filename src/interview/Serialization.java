package interview;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serialization {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		User user = new User();
		user.lifelevel = 55;
		user.staticField = 40;
		Sword sword = new Sword();
		user.sword = sword;
		user.sword.level = 5;

		FileOutputStream fileOutputStream = new FileOutputStream("Tempfile");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(user);
		objectOutputStream.close();

		user.lifelevel = 50;
		user.staticField = 35;

		FileInputStream fileInputStream = new FileInputStream("Tempfile");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		User userAfterSerialization = (User) objectInputStream.readObject();
		objectInputStream.close();

		System.out.println(userAfterSerialization.lifelevel);
		System.out.println(userAfterSerialization.staticField);
		System.out.println(userAfterSerialization.sword);
//		System.out.println(user + " <-> " + userAfterSerialization);

	}

}

class User implements Serializable {

	int lifelevel;
	static int staticField;
	transient Sword sword;

}

//class Sword implements Serializable {
class Sword {

	int level;

}













