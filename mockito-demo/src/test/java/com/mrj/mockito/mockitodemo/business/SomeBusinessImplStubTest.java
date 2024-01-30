package com.mrj.mockito.mockitodemo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SomeBusinessImplStubTest {

	@Test
	void findTheGreatestFromAllData_basicScenario() {
		DataServiceStub dataServiceStub = new DataServiceStub();
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceStub);
		int result = businessImpl.findTheGreatestFromAllData();	
		assertEquals(25,result);
	}

}

class DataServiceStub implements DataService
{

	@Override
	public int[] retreiveAllData() {
		return new int[] {25,15,5};
	}
	
}