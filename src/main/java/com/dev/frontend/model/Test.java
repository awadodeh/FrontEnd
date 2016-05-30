package com.dev.frontend.model;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {

		// --------------------------
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(new Integer(2));
		list1.add(new Integer(7));
		list1.add(new Integer(2));
		list1.add(new Integer(2));

		findTargetIndex(list1, 9);
	}

	public static void findTargetIndex(List<Integer> list, int target) {

		for (int i = 0; i < (list.size() - 1); i++) {
			
			for (int j = i + 1; j < list.size(); j++) {
			
				if ((list.get(i) + list.get(j)) == target)
					System.out.println("Index 1=" + (i + 1) + " , Index 2=" + (j + 1));
			}
		}
	}

}