## Queue
#### 특징
- 먼저 들어온 데이터가 가장 먼저 나가는 FIFO(First In First Out) 구조
- 그래프의 넓이 우선 탐색(BFS)에서 사용
- 컴퓨터 버퍼에서 주로 사용, 마구 입력이 되었으나 처리를 하지 못할 때, 버퍼(큐)를 만들어 대기 시킴
```java
class Queue{
    public static void main(String[] args){
        // 큐 선언
        Queue<Integer> queue = new LinkedList<>();
        
        // 데이터 추가
        queue.add(1);
        queue.add(2);
        
        // 데이터 삭제
        queue.remove();
        queue.clear();
        queue.poll();   // 값이 없다면 exception을 발생시키 지 않고, null반환
        
        // 가장 위의 데이터 반환
        queue.peak();
        
        queue.contains(1);  // 값 포함 확인(반환타입 boolean)
        queue.size();       // 사이즈
        queue.isEmpty();    // 값 비어있는지 체크(반환타입 boolean) 
    }
}
```
