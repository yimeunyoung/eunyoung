package day13.sort;

import java.util.Arrays;
import java.util.Comparator;

import array.Array;

public class ArraySortEx {

	public static void main(String[] args) {
		//버블 정렬 예제
		int arr[] = {1, 4, 7, 9, 2, 8, 3, 6};
		
		for(int i = 0; i < arr.length-1 ; i++) { //arr.length-1에서 -1을 안해줘도 되지만 하는 이유는 맨 마지막 숫자는 굳이 안해도 1개만 남아있기 때문에 비교 안하면 더 빠르게 끝날 수 있기때문 
			for(int j = 0; j < arr.length-1-i ; j++) { //-i를 해주면 반복횟수를 1번이라도 줄일 수 있다.
				if(arr[j] > arr[j+1]) { // 부등호 방향을 바꾸면 오름차순/내림차순 설정 가능
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		Array.printArray(arr);
		}
		Integer arr2[] = {1, 4, 7, 9, 2, 8, 3, 6};
		//Arrays.sort(arr2); // 오름차순
		Arrays.sort(arr2, Comparator.reverseOrder()); // 내림차순
		for(Integer tmp : arr2) {
			System.out.print(tmp + " ");
		}
	}

}
