package _50to100;

import se.embuc.Task;

import java.math.BigInteger;

//Square root convergents
public class JTask57 implements Task {
	@Override
	public Object solve() {
		var big2 = BigInteger.valueOf(2);
		var n= BigInteger.valueOf(3);
		var d= BigInteger.valueOf(2);
		var count = 0;

		for(int i = 2; i<1000;i++) {
			var n2 = n.add(d.multiply(big2));
			var d2 = n.add(d);
			if(n2.toString().length() > d2.toString().length()) {
				count++;
			}
			n = n2;
			d = d2;
		}
		return count;
	}
}
