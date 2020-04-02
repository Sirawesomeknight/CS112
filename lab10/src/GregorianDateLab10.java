
public class GregorianDateLab10 {

    private int month;
    private int day;
    private int year;
	
    private static String[] months = {"skip","January","February","March","April",
				      "May","June","July","August","September","October","November","December"};

    public GregorianDateLab10() {
    }

    public void setDate(String month, int day, int year) throws CS112DateException {

	if (day > 31)
	    throw new CS112DateException();

	for(int i=1; i!=13;i++) {
	    if (months[i].equals(month)) 
		this.month = i;
	}
	this.day = day;
	this.year = year;
    }

    public String toString() {
	return months[month]+"/"+day+"/"+year;
    }

		
}
