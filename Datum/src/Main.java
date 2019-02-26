import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

	public static void main(String[] args) throws ParseException {
		String StringDate= "30/11/1984";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date datum = sdf.parse(StringDate);
		
		
		System.out.println(sdf.format(datum));
		System.out.println(datum);

	}

}
