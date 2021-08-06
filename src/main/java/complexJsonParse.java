import org.testng.Assert;

import com.Files.JsonPayLoad;

import io.restassured.path.json.JsonPath;

public class complexJsonParse {

	public static void main(String[] args) {
		JsonPath jsp=new JsonPath(JsonPayLoad.coursePrice());
		int count=jsp.getInt("courses.size()");
		System.out.println(count);
		int purchaseAmount=jsp.getInt("dashboard.purchaseAmount");
		System.out.println(purchaseAmount);
		String firstCourseTitle= jsp.getString("courses[1].title");
		System.out.println(firstCourseTitle);
		int transactionAmount=0;
		for(int i=0;i<count;i++) {
			String courseTitles=jsp.get("courses["+i+"].title");
			int coursePrice=jsp.get("courses["+i+"].price");
			int copiesSold=jsp.get("courses["+i+"].copies");
			int amount=coursePrice*copiesSold;
			transactionAmount= transactionAmount+amount;
			
			System.out.println("Title of course: "+courseTitles);
			System.out.println("Price of course: "+coursePrice);
			
		}
		Assert.assertEquals(transactionAmount, purchaseAmount);

	}

}
