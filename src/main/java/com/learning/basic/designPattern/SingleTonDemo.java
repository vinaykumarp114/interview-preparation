/**
 * 
 */
package com.learning.basic.designPattern;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @author VINAY
 * 
 */
public class SingleTonDemo {

	public static void main(String[] aregs) {
		SingleTon st = SingleTon.getInstance();
		serializeMe(st);
		System.out.println("Serialized successfully : " + st);

		st = (SingleTon) deSerializeMe();
		System.out.println("Deserialized successfully : " + st);
	}

	public static void serializeMe(SingleTon st) {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("./data.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			oos.writeObject(st);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Object deSerializeMe() {
		ObjectInputStream oin = null;
		Object obj = null;
		try {
			oin = new ObjectInputStream(new FileInputStream("./data.txt"));
			obj = oin.readObject();

			oin.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return obj;
	}

}

class SingleTon implements Serializable, Cloneable {
	private static final long serialVersionUID = 100L;
	private static SingleTon singleton = null;

	private SingleTon() {
	}

	public static SingleTon getInstance() {
		if (singleton == null) {
			synchronized (SingleTon.class) {
				if (singleton == null) {
					singleton = new SingleTon();
				}
			}
		}
		return singleton;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	private Object readResolve() throws ObjectStreamException {
		return getInstance();
	}
}
