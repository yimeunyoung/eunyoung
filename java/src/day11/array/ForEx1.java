package day11.array;

public class ForEx1 {

	public static void main(String[] args) {
		int arr[] = new int[] {4,5,2,1,9};
		
		for(int i = 0 ; i<arr.length ; i++) {
			arr[i] = 0;
			int tmp = arr[i];
			System.out.println(tmp);
		}
		arr = new int[] {4,5,2,1,9};
		System.out.println("===========");
		for(int tmp : arr) { // 향상된 for문 사용하여 위의 식 다시 작성 => 훨씬 간단함
			tmp = 0;
			System.out.println(tmp);
		}
		for(int tmp : arr) {
			System.out.println(tmp);
		}
	}
}
