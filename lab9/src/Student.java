import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Student {

	private String name;
	private Student next;


	// create a header
	public Student() {
		name = null;
		next = null;
	}

	public boolean odd() {
		if (getNext() == null) 
			return false;
		else 
			return getNext().oddHeaderless();
	}

	public boolean oddHeaderless() {
		if (getNext() == null)
			return true;
		else return !getNext().oddHeaderless();
	}


	public Student ith(int i) {
		if(getNext() != null){
			return ithHeaderless(i);
		}else{
			return null;
		}
	}

	private Student ithHeaderless(int i) {
		Student theStudent = this;
		for(int n = 0; n < i - 1; n++){
			if(theStudent.getNext() != null){
				theStudent = theStudent.getNext();
			}else{
				return null;
			}
		}
		return theStudent.getNext();
	}

	public Student deleteIth(int i) {
		Student theStudent = this;
		for(int n = 0; n < i - 1; n++){
			if(theStudent.getNext() != null){
				theStudent = theStudent.getNext();
			}else{
				return null;
			}
		}

		Student deletedStudent;

		if(theStudent.getNext() != null && theStudent.getNext().getNext() != null){
			deletedStudent = theStudent.getNext();
			theStudent.next = theStudent.getNext().getNext();
		}else if(theStudent.getNext() != null){
			deletedStudent = theStudent.getNext();
			theStudent.next = null;
		}else{
			return null;
		}

		return deletedStudent;
	}

	public void add(String d) {
		if (getNext()==null) {
			next = new Student();
			getNext().name = d;
		}
		else getNext().add(d);
	}

	public boolean isEmpty() {
		return getNext()==null;
	}

	public int length() {
		if (isEmpty()) return 0;
		else return getNext().lengthHeaderless();
	}

	private int lengthHeaderless() {
		if (getNext() == null) return 1;
		else return 1+getNext().lengthHeaderless();
	}




	public void print() {
		System.out.println(name);
		if (getNext() != null)
			getNext().print();
	}


	public void addFile(String fileName) {

		File f = new File(fileName);

		try {
			Scanner sc = new Scanner(f);

			while (sc.hasNext()) {
				String s = sc.next();
				add(s);
			}
			sc.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public boolean sameList(Student st) {
		if (st.getNext() == null && getNext() == null)
			return true;
		if (st.getNext() == null || st.getNext() == null)
			return false;
		else return getNext().sameListHeaderless(st.getNext());

	}

	private boolean sameListHeaderless(Student st) {

		if (!name.equals(st.name))
			return false;
		if (getNext() == null && st.getNext() == null)
			return true;
		if (getNext() == null || st.getNext() == null)
			return false;
		return getNext().sameListHeaderless(st.getNext());
	}

	public Student getNext() {
		return next;
	}

	public String toString() {
		return super.toString()+"  "+name;
	}

}
