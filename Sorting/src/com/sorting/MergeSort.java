package com.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//Faster than Selection,Insertion,Bubble Sort
//Divide and Conquer approach
//TimeComplexity : O(n log n) -worstCase & best case
//Algo : Divide the array into 2 half and make 2 new arrays(let left and right)
// Nor again divide the left and right arrays into half recursively  till we have only 1 element left in sub arrays
// That array with 1 element is sorted so return when we have only 1 element left in array
//Once 1 element is left merge the left and right arrays as follows (Note :  at this point left and right array's are sorted)
//Compare 1st element of both the arrays and add the smaller one to new list and increment the index of that array and new array
//At the end add the check if some elements left in either of the array and add them to the new list
public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sobj = new Scanner(System.in);
		int n = sobj.nextInt();
		sobj.nextLine();
		String s[] = sobj.nextLine().split(" ");
		sobj.close();
		List<Integer> list = Arrays.stream(s).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
		sortUsingMergeSort(list, n);
		System.out.println(list);
	}

	private static void sortUsingMergeSort(List<Integer> list, int n) {
		// TODO Auto-generated method stub
		if (n < 2) {
			return;
		}
		int mid = n / 2;
		int leftSize = mid;
		int rightSize = n - mid;
		List<Integer> left = new ArrayList<>(list.subList(0, mid));
		List<Integer> right = new ArrayList<>(list.subList(mid, n));
		sortUsingMergeSort(left, leftSize);
		sortUsingMergeSort(right, rightSize);
		merge(list, left, right);
	}

	private static void merge(List<Integer> list, List<Integer> left, List<Integer> right) {
		// TODO Auto-generated method stub
		int leftSize = left.size();
		int rightSize = right.size();
		int leftIterator = 0, rightIterator = 0, i = 0;
		while (leftIterator < leftSize && rightIterator < rightSize) {
			if (left.get(leftIterator) < right.get(rightIterator)) {
				list.set(i, left.get(leftIterator));
				leftIterator++;
				i++;
			} else {
				list.set(i, right.get(rightIterator));
				rightIterator++;
				i++;
			}
		}
		while (leftIterator < leftSize) {
			list.set(i, left.get(leftIterator));
			leftIterator++;
			i++;
		}
		while (rightIterator < rightSize) {
			list.set(i, right.get(rightIterator));
			rightIterator++;
			i++;
		}
	}
}
