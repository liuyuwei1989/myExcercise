package test;

public class Test {
	public static void main(String[] args){
		String str = "utfut8098";
		String strs = "\\w*\\d+\\w*";
		System.out.println(str.matches(strs));
	}
}
