package org.nithish.Java_general;

import java.util.ArrayList;
import java.util.List;

public class EmployeeTemp {

	private static class Employee {
		private static String name;

		public static String getName() {
			return name;
		}

		public static void setName(String name) {
			Employee.name = name;
		}

		public Employee(String name) {
			this.name = name;
		}
	}

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("John"));
		employees.add(new Employee("Ron"));
		String s1=new String("abc");
		String s2=new String("abc");
		System.out.println(s1==s2);
		for (Employee e : employees) {
			if (e.getName() == "John") {
				employees.remove(e);
			}
		}
		System.out.println(employees);

	}

}
