package party;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class UpdateList {
	
	private void update(List<Integer> nums) {
		int initialSize = nums.size();
		LinkedList<Integer> removeList = new LinkedList<>();
		for(int i=0;i<nums.size();i++) {
			Integer currentVal = nums.get(i);
			if(i>0 && i<(nums.size()-1)) {
				Integer previousVal = nums.get(i-1);
				Integer nextVal = nums.get(i+1);
				if(currentVal < previousVal && currentVal < nextVal) {
					removeList.add(currentVal);
				}
			}
		}
		nums.removeAll(removeList);
		if(nums.size() != initialSize) {
			update(nums);
		}
	}
	
	public static void main(String[] args) {
		UpdateList app = new UpdateList();
		List<Integer> list = new ArrayList<>(Arrays.asList(20,30,3,2,40,6));
		app.update(list);
		System.out.println(list);
	}
}
