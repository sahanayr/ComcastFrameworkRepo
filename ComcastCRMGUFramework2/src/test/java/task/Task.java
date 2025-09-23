package task;

import org.testng.annotations.Test;

import task_baseclass.Task_BaseClass;

public class Task extends Task_BaseClass{

	@Test
	public void test1() {
		System.out.println("Test1 Executed");
	}
	
	@Test
	public void test2() {
		System.out.println("Test2 Executed");
	}
	
	@Test
	public void test3() {
		System.out.println("Test3 Executed");
	}
	
	@Test
	public void test4() {
		System.out.println("Test4 Executed");
	}
}
