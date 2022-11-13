package com.sorting;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//Divide & Conquer
//Recursive
//In place Algo
//Not Stable (i.e if 2 elements have same value then their positions of occurrence may get changes
//i.e {4,5},{4,3} sort eith key which is same 4 then {4,3} may come first)
//Time Complexity : O(nlongn) -best & Avg case
//					O(n^2) - worst case (can almost be avoided by randomized version of uickSort)
//Process :
//1. Create a Pivot let say last elements
//2.Write a Partition method such that all the elements greater than pivot is at right and less at left and return the Pivot index
//3.Again do a QuickSort for elements at right and left till length of subArray is >1

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sobj = new Scanner(System.in);
		int n = sobj.nextInt();
		sobj.nextLine();
		String s[] = sobj.nextLine().split(" ");
		sobj.close();
		List<Integer> list = Arrays.stream(s).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
		sortUsingQuickSort(list, 0, list.size() - 1);
		System.out.println(list);
	}

	private static void sortUsingQuickSort(List<Integer> list, int start, int end) {
		// TODO Auto-generated method stub
		
		if (start < end) {
			int pIndex = partition(list, start, end);
			//System.out.println(list + " " + start + " " + end + " " + pIndex);

			sortUsingQuickSort(list, start, pIndex - 1);
			
			sortUsingQuickSort(list, pIndex + 1, end);
			
		}

	}

	private static int partition(List<Integer> list, int start, int end) {
		// TODO Auto-generated method stub
		int pivot = list.get(end);
		int pIndex = start;
		for (int i = start; i <= end - 1; i++) {
			if (list.get(i) <= pivot) {
				swap(list, i, pIndex);
				pIndex++;
			}
		}
		swap(list, pIndex, end);
//		System.out.println("test :"+list);
//		System.out.println("test :"+pIndex);
		return pIndex;
	}

	private static void swap(List<Integer> list, int a, int b) {
		// TODO Auto-generated method stub
		int temp = list.get(b);
		list.set(b, list.get(a));
		list.set(a, temp);
	}

}
