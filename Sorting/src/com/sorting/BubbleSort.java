package com.sorting;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//compare i& i+1 elements and swap for n times
//after every loop the biggest element is at the end
//Optimizing rules:
//If 2nd loop swap condition does not execute at least 1 time... list is sorted so terminate and return list
//As after every iteration of outer loop largest element is at end we can decrease 2nd loop end position by 1
//best case is O(n) and worst case is O(n^2)
public class BubbleSort {

	public static void main(String args[]) {
		Scanner sobj = new Scanner(System.in);
		int n = sobj.nextInt();
		sobj.nextLine();
		String input = sobj.nextLine();
		sobj.close();
		List<Integer> list = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).boxed()
				.collect(Collectors.toList());

		sortUsingBubbleSort(list, n);
		System.out.println(list.toString());

	}

	private static List<Integer> sortUsingBubbleSort(List<Integer> list, int n) {
		// TODO Auto-generated method stub
		for (int i = 0; i < n; i++) {
			int flag = 0;
			for (int j = 0; j < n - i - 1; j++) {
				if (list.get(j) > list.get(j + 1)) {
					swap(list, j);
					flag = 1;
				}

			}
			if (flag == 0)
				break;
		}
		return list;
	}

	private static void swap(List<Integer> list, int j) {
		int temp = 0;
		temp = list.get(j);
		list.set(j, list.get(j + 1));
		list.set(j + 1, temp);

	}
}
