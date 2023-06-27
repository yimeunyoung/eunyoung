package day20.collection;

import java.util.ArrayList;

public class ListEx2 {

	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student(1,1,1,"홍길동"));
		list.add(new Student(1,1,2,"가길동"));
		list.add(new Student(1,1,3,"나길동"));
		list.add(new Student(1,1,4,"라길동"));
		list.add(new Student(1,1,5,"마길동"));
		System.out.println(list);
		/* remove 메서드는 Objects클래스의 equals를 호출(Objects.equals(A,B))해서 true인 경우만 삭제
		 * => A가 자기자신, B가 삭제하려는 객체
		 * => A와 B의 클래스가 다르면 false를 리턴
		 * => A와 B의 클래스가 같으면 A.equals(B)를 호출해서 결과를 리턴
		 * Student 클래스에 equals를 오버라이딩 하지 않으면 Student 클래스의 equals는 주소를 비교
		 * => 학년, 반, 번호, 이름은 같지만 새로 객체를 만들었기 때문에 주소가 다름
		 * => 다른 객체를 판별해서 삭제가 안됨 -> Student 클래스에서 @Data 추가하면 객체 삭제 가능
		 * */
		list.remove(new Student(1,1,1,"홍길동"));
		System.out.println(list);
		//contains, indexOf도 Objects.equals를 호출해서 같은 객체를 찾음 -> Student 클래스에서 @Data 추가하면 객체 찾을 수 있음
		System.out.println(list.contains(new Student(1,1,1,"홍길동")));
		System.out.println(list.indexOf(new Student(1,1,1,"홍길동")));

	}

}
