package org.nithish.Java_general;

import java.util.ArrayList;
import java.util.List;

public class FinalKeywordClass {
	
	public  void f(){
		System.out.println("hii");
	}
	 class ClassB extends FinalKeywordClass{
		 public  void f(){
				System.out.println("inner HII");
			} 
	 }
	 static class InnerClass { 
		 int x=0;
	 }
	 
	 public static void main(String[] args){
		 FinalKeywordClass out=new FinalKeywordClass();
		 FinalKeywordClass.ClassB ob=out.new ClassB();
		 ob.f();
		 out.f();
		 InnerClass k=new FinalKeywordClass.InnerClass();
		 
	 }

}
