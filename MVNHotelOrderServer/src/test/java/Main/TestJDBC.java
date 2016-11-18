package Main;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestJDBC {

	@Test
	public void test() {
		 Stujdbc stu   =new  Stujdbc();
		 assertEquals(5, stu.getNUM());
	}

}
