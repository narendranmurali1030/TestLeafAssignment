package week1.day1;

public class Mobile {
	
	boolean isMobileOn = true;
	int mobileAge = 2;
	String brandName = "Samsung";
	
	public static void main(String[] args) {
		
		System.out.println("I am ready");
		
		Mobile classObj = new Mobile();
		boolean isMobileOn2 = classObj.isMobileOn;
		int mobileAge2 = classObj.mobileAge;
		String brandName2 = classObj.brandName;
		
		System.out.println(isMobileOn2);
		System.out.println(mobileAge2);
		System.out.println(brandName2);
	}

}
