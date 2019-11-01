

import java.io.Serializable;

public class FootballPlayer implements Serializable{
	public String name;
	public int age;
	public String team;
	public double salary;

	public FootballPlayer(String name, int age, String team, double salary) {
		this.name = name;
		this.age = age;
		this.team = team;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "FootballPlayer [name=" + name + ", age=" + age + ", team=" + team + ", salary=" + salary + "]";
	}
	
}
