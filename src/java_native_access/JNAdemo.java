package java_native_access;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

public class JNAdemo {

	public static void main(String[] args) throws ClassNotFoundException {

//		CLibrary.INSTANCE.printf("Hello, native World\n");
//		for (int i = 0; i < args.length; i++) {
//			CLibrary.INSTANCE.printf("Argument %d: %s\n", i, args[i]);
//		}

//		while (true) {
//			int ch = CLibrary.INSTANCE.getchar();
//			System.out.println(ch);
//			if (ch == 27) break;
//		}
		
		int ch = CLibrary.INSTANCE.getchar();
		if (ch == 10) System.out.println("Enter");
		

	}

	private interface CLibrary extends Library {

		CLibrary INSTANCE = (CLibrary) Native.loadLibrary((Platform.isWindows() ? "msvcrt" : "c"), CLibrary.class);

		void printf(String format, Object... args);

		int getchar();
//		int getch();

	}

//    public interface Kernel32 extends Library {
//        boolean Beep(int frequency, int duration);
//    }
//    
//    private static Kernel32 kernel32 = (Kernel32) Native.loadLibrary("kernel32", Kernel32.class);
//    
//    private static void toMorseCode(String letter) throws Exception {
//        for (byte b : letter.getBytes()) {
//            kernel32.Beep(1200, ((b == '.') ? 50 : 150));
//            Thread.sleep(50);
//        }
//    }
//    public static void main(String[] args) throws Exception {
//        String helloWorld[][] = {
//                {"....", ".", ".-..", ".-..", "---"}, // HELLO
//                {".--", "---", ".-.", ".-..", "-.."}  // WORLD
//        };
//        for (String word[] : helloWorld) {
//            for (String letter : word) {
//                toMorseCode(letter);
//                Thread.sleep(150);
//            }
//            Thread.sleep(350);
//        }
//    }

}