# Programmers.Level3_Java_DoublePriorityQueue

## 프로그래머스 힙(Heap) > 이중우선순위큐

### 1. 문제설명
input으로 Commands들이 String[]으로 들어온다. I로 시작하는 명령은 큐에 값을 넣는 명령어 이며 D로 시작하는 명령어는 뒤에 1이오면 큐에 최대값을, -1이오면 큐의 최소값을 제거하는 명령어이다. 명령어대로 수행을 마쳤을 때 마지막 큐에서의 최대값과 최소값을 int[]으로 return하는 문제. 큐에 아무원소도 존재하지 않는다면 [0,0]을 return한다.

### 2. 풀이
PriorityQueue를 이용한다. I명령어가 오면 큐에 값을 넣는다. 최소값을 제거할 때는 poll명령어를 이용하여 쉽게 제거한다. 최대값을 제거할때는 마지막 요소까지 찾아 그 요소를 제외한 값들로 새로 우선순위 큐에 담아 다음 명령을 진행한다.

### 3. 다른 방법
PriorityQueue를 이용했어서 max와 min을 제거하는 과정에 코드작성이 크게 달랐다. 이를 TreeSet을 이용하여 간결히 작성한 예시를 보았다.
```java
TreeSet<Integer> set = new TreeSet<>();
  ...
  // remove max and min
 set.pollFirst();
 set.pollLast();
  
```
