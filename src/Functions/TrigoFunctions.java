package Functions;

public class TrigoFunctions {

	final double pi = 3.14159265358979323846;

	public double sin(double radValue) {

		final int precision = 60;
		int signVal = 1;
		if(radValue < 0)
			signVal = -1;
		
		double currentVal = 0;

		if (radValue == Double.NEGATIVE_INFINITY || !(radValue < Double.POSITIVE_INFINITY)) {
			return Double.NaN;
		}
		radValue %= 2 * pi;

		if (radValue > pi) {
			radValue -= pi;
			signVal = -(signVal);
		}
		if (radValue < 0) {
			radValue = 2 * pi - radValue;
		}

		for (int i = 0; i <= precision; i++) {
			currentVal += getPower(-1, i) * (getPower(radValue, 2 * i + 1) / getFact(2 * i + 1));
		}
		return currentVal * signVal;
	}

	public double cos(double radian) {
		final int PRECISION = 60;
		int sign = 1;
		double currentVal = 0;
		if (radian == Double.NEGATIVE_INFINITY || !(radian < Double.POSITIVE_INFINITY)) {
			return Double.NaN;
		}
		radian %= 2 * pi;

		if (radian < pi) {
			radian -= pi;
			sign = -1;
		}
		if (radian < 0) {
			radian = 2 * pi - radian;
		}

		for (int i = 0; i <= PRECISION; i++) {
			currentVal += getPower(-1, i) * (getPower(radian, 2 * i) / getFact(2 * i));
		}

		return currentVal * sign;
	}

	public double tan(double val) {
		
		return (sin(val) / cos(val));
	}
	
	public double sinDeg(double val) {
		double radians = toRad(val);
		return toDeg(sin(radians));
	}
	
	public double cosDeg(double val) {
		double radians = toRad(val);
		return toDeg(cos(radians));
	}

	public double tanDeg(double val) {
		double radians = toRad(val);
		return toDeg(tan(radians));
	}
	
	public double toRad(double val) {

		return (val*(pi/180));
	}

	public double toDeg(double val) {
		
		return (val*(180/pi));
	}

	public double getPower(double val, int power) {

		if (power == 0) {
			return 1;
		}
		
		if (power == 1) {
			return val;
		}

		return val * getPower(val, power - 1);
	}

	public double getFact(int val) {

		if (val == 1 || val == 0) {
			return 1;
		}

		return val * getFact(val - 1);
	}

	public double getPI() {
		return pi;
	}
	
	public static void main(String[] args) {

		
		double Values[]= {0.0,30.0,60.0,90.0,120.0,180.0,360.0,-1.0,-30.0,-60.0,-120.0,-180.0,-360.0};
		
		
		
		TrigoFunctions obj1= new TrigoFunctions();
		
		System.out.println("*************Trignometric Functions in Radian for the four quadrants *************");
	
		
		double currentValue=0.0;
		double currentDegValue=0.0;

		for(int i=0;i<Values.length;i++)
		{
			
			currentValue=obj1.toRad(Values[i]);
			currentDegValue=Values[i];
			
			System.out.println("\n"+"Operation for " + currentDegValue + " -->");
			
			System.out.println("SIN of "+currentDegValue+" = "+obj1.sin(currentValue));
			
			System.out.println("COS of "+currentDegValue+" = "+obj1.cos(currentValue));
			
			System.out.println("TAN of "+currentDegValue+" = "+obj1.tan(currentValue)+"\n");
	
			
		}
		
		System.out.println("*************Trignometric Functions in Degree for the four quadrants *************");
		
		currentValue=0.0;

		for(int i=0;i<Values.length;i++)
		{
			
			currentValue=Values[i];
			
			System.out.println("\n"+"Operation for " + currentValue + " -->");
			
			System.out.println("SIN of "+currentValue+" = "+obj1.sinDeg(currentValue));
			
			System.out.println("COS of "+currentValue+" = "+obj1.cosDeg(currentValue));
			
			System.out.println("TAN of "+currentValue+" = "+obj1.tanDeg(currentValue)+"\n");
	
			
		}
		
		
		
	}
	
}
