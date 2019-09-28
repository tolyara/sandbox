
public class Main {
    public static void main(String[] args) {
        DeMorganLaws dm = new DeMorganLaws();
        dm.checkDeMorganLaws();
        try {
			throw new Throwable();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
