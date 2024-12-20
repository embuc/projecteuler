package _50to100;

import se.embuc.Task;
import se.embuc.utils.UtilsKt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class JTask92 implements Task {

	@Override
	public Object solve() {
		Set<Integer> endIn89 = new HashSet<>();
		Set<Integer> endIn1 = new HashSet<>();
		endIn89.add(89);
		endIn1.add(1);
		for(int i=2;i< 10000000; i++){
			var chain = new ArrayList<Integer>();
			chain.add(i);
			var current = i;
			while(!endIn89.contains(current) && !endIn1.contains(current)){
				var next = Arrays.stream(UtilsKt.digits(current)).map(it -> it *it).sum();
				chain.add(next);
				current = next;
			}
			if(endIn89.contains(current)){
				endIn89.addAll(chain);
			}else{
				endIn1.addAll(chain);
			}
		}
		return endIn89.size();
	}
}
