package com.sorting;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//Consider left part to be sorted and right part to be unsorted
//let take 1st element to be sorted, and remaining elements unsorted
//now we need to pick elements from right and (i.e from 2nd element) and place it in appropriate position in right 
//Do this for till last element in right unsorted list
//best case time complexity O(n)
//best case time complexity O(n^2)
public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sobj=new Scanner(System.in);
			int n=sobj.nextInt();sobj.nextLine();
			String s[]=sobj.nextLine().split(" ");
			List<Integer> list=Arrays.stream(s).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList()); 
			
			sortUsingInsertionSort(list,n);
			System.out.println(list);
	}

	private static void sortUsingInsertionSort(List<Integer> list, int n) {
		// Consider 1st element in Left sorted set
		for(int i=1;i<n;i++)
		{
			int hole=i;
			int value=list.get(i);
			while(hole>0 && value<list.get(hole-1))
			{
				list.set(hole, list.get(hole-1));
				hole--;
			}
			list.set(hole, value);
		}
		
	}

}
