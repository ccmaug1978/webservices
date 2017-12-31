package com.AdvanceReport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Test {
	
	public static void main(String[] agrs)
	{
		List<student> al=new ArrayList<student>();
		al.add(new student("Murali", 30,450));
		al.add(new student("Kavitha", 29,669));
		al.add(new student("Harshi", 18,999));
		
		Collections.sort(al,(i1,i2)->
		{return i1.Marks>i2.Marks?-1:i1.Marks>i2.Marks?1:0;}
				);
		
		for(student a:al)
			System.out.println(a);
		
		
	}
}
class student{
	
	int Age;
	int Marks;
	String Name;
	
	student(String name, int age, int marks)
	{
		this.Age=age;
		this.Marks=marks;
		this.Name=name;
	}

	@Override
	public String toString() {
		return "student [Age=" + Age + ", Marks=" + Marks + ", Name=" + Name
				+ "]";
	}
	
	
}

