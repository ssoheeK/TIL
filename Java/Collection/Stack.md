## Stack
#### 특징
- 나중에 들어간 것이 먼저 나오는 LIFO(Last In First Out)구조
- 인터럽트 처리, 수식의 계산, 서브루틴의 복귀 번지 저장 등에 쓰임
- 그래프의 깊이 우선 탐색(DFS)에서 사용
- 시스템 해킹에서 버퍼오버플로우 취약점을 이용한 공격을 할 때 스택 메모리의 영역에서 함

```java
class Stack{
    public static void main(String[] args){
        // 선언
        Stack stack = new Stack();
        
        // 값 추가
        stack.push(1);
        stack.push(2);
        
        // 값 삭제
        stack.pop();    // 2
        stack.clear();
        
        // 스택의 가장 위에 있는 값 출력
        stack.peak();
        
        stack.size();       // 사이즈 체크
        stack.isEmpty();    // 비어있는지 체크
        stack.contains(1);  // 값이 포함되어 있는지 체크
    }
}
```