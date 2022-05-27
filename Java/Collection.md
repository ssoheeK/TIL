## Collection
### **컬렉션 인터페이스 특징**
> *List*
* *ArrayList* : 순서가 있는 집합, 크기를 동적으로 늘릴 수 있다.
```java
class ArrayList{
  public static void main(String[] args){
      
      // ArrayList 선언
      ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
  
      // 리스트 값 변경 - set method
      arrayList.set(0, 4);
  
      // 리스트 값 삭제 - remove method
      arrayList.remove("1");  //object를 인자로 받아서 삭제
      arrayList.remove(1);    //index를 인자로 받아서 삭제
      arrayList.clear();  //모두 삭제
  
      // 리스트 값 검색 - contains, indexOf(object를 인자로 받아서 검색)
      arrayList.contains(1);
      arrayList.indexOf(3);
      
      // 배열로 변환
      Object[] arr = arrayList.toArray();


      // LinkedList 선언
      LinkedList<Integer> linkedList = new LinkedList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
  
      // 새로운 노드 추가 - add method
      linkedList.add(6);
      linkedList.add(6, 7);
      linkedList.addFirst(15);
      linkedList.addLast(20);
      linkedList.addAll(Arrays.asList(17, 18, 19));
  }
}
```

* *LinkedList* - 
  * ArrayList와 달리 List 인터페이스를 구현한 AbstractList를 상속하지 않고 **AbstractSequentialList를 상속** 받는다.
  * ArrayList는 순차적으로 늘어선 배열의 형식이며, **LinkedList는 자료의 주소 값으로 연결되어 있는 구조**이다.
```java
class ArrayList{
  public static void main(String[] args){

      // LinkedList 선언
      LinkedList<Integer> linkedList = new LinkedList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
  
      // add method
      linkedList.add(6);
      linkedList.add(6, 7);
      linkedList.addFirst(15);
      linkedList.addLast(20);
      linkedList.addAll(Arrays.asList(17, 18, 19));
      
      // 
  }
}
```
* *Stack*
* *Set*
  * *HashSet*
  * *TreeSet*
  * *LinkedHashSet*
* *Queue*
* *Map*
  * *HashMap*
  * *TreeMap*
  * *LinkedHashMap*