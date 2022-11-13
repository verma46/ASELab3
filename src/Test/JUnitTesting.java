package Test;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import Functions.TrigoFunctions;

@RunWith (Parameterized.class)
public class JUnitTesting {

	private TrigoFunctions ManualFunctions;
	private int rad;
	private int deg;
	
	
	@Before
	public void initializeValues() {
		ManualFunctions = new TrigoFunctions();
	}
	
	public JUnitTesting(int rad, int deg) {
	this.rad = rad;
	this.deg = deg;
     }

	@Parameterized.Parameters
	public static Collection<Object[]> values() {
	
		
		Object[][] data = { { 0, 0 },{ 30, 30 },{ 60, 60 },{ 120, 120 },{ 180, 180 },{ 360, 360 },
				{ -1, -1 },{ -30, -30 },{ -60, -60 },{ -120, -120 },{ -180, -180 },{ -360, -360 }};
		
		return Arrays.asList(data);
	}
	
	@Test
	public void testGetRadianValue() {
		assertEquals(Math.toRadians(deg), ManualFunctions.toRad(deg), 0.001);
	}

	@Test
	public void testGetDegreeValue() {
		assertEquals(Math.toDegrees(rad), ManualFunctions.toDeg(rad), 0.001);
	}

	@Test
	public void testSineValue() {
		assertEquals(Math.sin(rad), ManualFunctions.sin(rad), 0.001);
	}

	@Test
	public void testSineValueInDegree() {
		assertEquals(Math.toDegrees(Math.sin(Math.toRadians(deg))), ManualFunctions.sinDeg(deg), 0.001);
	}

	@Test
	public void testCosineValue() {
		assertEquals(Math.cos(rad), ManualFunctions.cos(rad), 0.001);
	}

	@Test
	public void testCosineValueInDegree() {
		assertEquals(Math.toDegrees(Math.cos(Math.toRadians(deg))), ManualFunctions.cosDeg(deg), 0.001);
	}
	
	@Test
	public void testTanValue() {
		assertEquals(Math.tan(rad), ManualFunctions.tan(rad), 0.001);
	}

	@Test
	public void testTanValueInDegree() {
		assertEquals(Math.toDegrees(Math.tan(Math.toRadians(deg))), ManualFunctions.tanDeg(deg), 0.001);
	}
	
	
}
