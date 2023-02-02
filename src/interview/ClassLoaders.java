package interview;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassLoaders {
	
	public static void main(String[] args) throws MalformedURLException, ClassNotFoundException {
		
		URLClassLoader pluginClassLoader = new URLClassLoader(new URL[] {(new URL("D:\\"))});
		Class class1 = pluginClassLoader.loadClass("SomeClass");
		
	}

}

//class MyLoader extends ClassLoader {
//
//	@Override
//	protected Class<?> findClass(String moduleName, String name) {
//		return super.findClass(moduleName, name);
//	}
//
//}