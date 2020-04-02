import java.util.Scanner;


public class TestLab10 {

    public static void main(String[] args) {
		
	new TestLab10().go();
    }

	private void go() {
		DateFactoryLab10 df = new DateFactoryLab10();
		try {
			GregorianDateLab10 gd = df.createDate("January",31,2010);
			System.out.println(gd);
			gd = df.createDate("January",32,2010);
			System.out.println(gd);
			System.out.println("finishing go");
		}
		catch(CS112DateException e) {
			System.out.println("Thrown exception "+e);
			e.printStackTrace();
		}
	}
	
}

