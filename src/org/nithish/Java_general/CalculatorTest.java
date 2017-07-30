package org.nithish.Java_general;

import org.easymock.EasyMock;
import org.junit.Test;


public class CalculatorTest {

	
	@Test
	public void calTest() {
		CalculatorService obj = (CalculatorService) EasyMock.createNiceMock(CalculatorService.class);
		EasyMock.expect(obj.AddMethod(10, 30)).andReturn(45);
		EasyMock.replay(obj);
		ActualCalculator realObj = new ActualCalculator();
		realObj.SumMultiply(10, 30);
	}

}
