
public class DateFactoryLab10 {

    public GregorianDateLab10 createDate(String month, int day, int year) throws CS112DateException {
	
    	GregorianDateLab10 newD = new GregorianDateLab10();
	newD.setDate(month, day, year);
	return newD;
    }
	
	
}