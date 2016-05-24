package day09;

public class Employee {
	private String num;
	private String name;
	private String date;
	public Employee(String num, String name, String date) {
		this.num = num;
		this.name = name;
		this.date = date;
	}
	
	//getter
	public String getNum() {
		return num;
	}
	public String getName() {
		return name;
	}
	public String getDate() {
		return date;
	}

}
