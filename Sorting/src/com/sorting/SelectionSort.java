package com.sorting;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//consider 1st element to be min and then traverse the remaining array to find the min
//swap the 1st element with the min element
//now at 1st index we have min one ... 
//proceed similarly for the next indices
//except the last element as it will max only last left
//best and worst case time complexity is Big O(n^2)
public class SelectionSort {
	
	public static void main(String args[])
	{
		Scanner sobj=new Scanner(System.in);
		int n=sobj.nextInt();
		sobj.nextLine();
		String s[]=sobj.nextLine().split(" ");
		sobj.close();
		List<Integer> list=Arrays.stream(s).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
		
		sortUsingSelectionSort(list,n);
		list.stream().forEach(System.out::println);
		
	}

	private static void sortUsingSelectionSort(List<Integer> list, int n) {
		// TODO Auto-generated method stub
		for(int i=0;i<n-1;i++)
		{
			int minIndex=i,minValue=list.get(i);
			for(int j=i+1;j<n;j++)
			{
				if(list.get(j)<minValue)
				{
					minIndex=j;
					minValue=list.get(j);
				}
			}
			swap(list,i,minIndex);
		}
	}

	private static void swap(List<Integer> list, int i, int minIndex) {
		// TODO Auto-generated method stub
		int temp=list.get(i);
		list.set(i, list.get(minIndex));
		list.set(minIndex, temp);
	}

}
