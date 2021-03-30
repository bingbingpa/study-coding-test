# study-coding-test-basic

### 문제 풀이 과정
- 1. 문제를 명확이 이해했는지 확인 한다.
- 2. 가정하고 있거나 가정할 수 있는 것들을 확인한다.
- 3. 실제 예를 들어가며 다시 확인한다.(나중에 테스트 케이스로 활용할 수 있다.)
- 4. 문제 해결책을 고민한다.
- 5. 해결책을 설명하고 해당 시간과 공간 알고리듬 복잡도를 설명한다.
- 6. 코드를 작성한다.
- 7. 앞서 예시로 사용했던 입력값을 케이스로 삼아 코드를 테스트 한다.

### 배열 
- 배열은 연속된 메모리 영역에 저장된 데이터로, 조회가 O(1), 추가 및 삭제가 O(n) 복잡도를 가지고 있다. 즉, 조회는 빠르고 추가 및 삭제는 느리다.
- 자바에서 배열은 만들 때 크기를 정해야 하며, 추가 및 삭제 기능은 없다.
- 다른 자료구조를 구현하는데 사용하는 가장 기본적인 데이터 구조다.

### 리스트 
- 중복을 허용하며 순서가 있는 연속된 데이터를 표현하는 자료구죠.
- 배열과 달리 사용하는 중에 크기가 자동으로 조절된다.
- 자바가 제공하는 대표적인 리스트
  - Vector
  - ArrayList
  - LinkedList
- ArrayList
  - 추가 및 삭제 O(1) 하지만 최악의 경우에는 O(N)
  - 조회 O(1)
- LinkedList 
  - 추가 및 삭제 O(1)
  - 조회 O(N)

### 스택 
- 데이터 삽입과 삭제가 한쪽 끝에서 이루어지는 순서가 있는 특별한 형태의 리스트. 
- 제일 먼저 추가된 데이터가 제일 마지막에 나간다.(**FILO**)
- 제일 마지막에 추가된 데이터가 제일 먼저 나간다.(**LIFO**)
- 스택 오퍼레이션
  - push: 데이터 추가
  - pop: 데이터를 꺼낸다
  - peek 또는 top: 맨 위에 있는 데이터를 조회한다.(**스택에서 빼지는 않는다.**)
- 스택 구현 방법
  - 배열 또는 연결 리스트를 사용
- 오퍼레이션 별 시간 복잡도 
  - push: O(1)
  - pop: O(1)
  - top: O(1)
  
### 큐
- 스택과 비슷한 데이터 구조이지만, 데이터 삽입과 삭제가 각기 다른 쪽에서 이루어지는 정렬된 리스트이다.
- 가장 처음에 삽입된 데이터가 제일 먼저 삭제된다.(**FIFO**)
- 가장 마지막에 삽입된 데이터가 제일 마지막에 삭제된다.(**LILO**)
- 큐 오퍼레이션
  - EnQueue: 큐에 데이터 넣기
  - DeQueue: 큐에서 데이터 빼기 
- 큐 구현
  - (동적) 원형 배열
  - 연결 리스트
- 오퍼레이션 별 시간 복잡도
  - EnQueue: O(1)
  - DeQueue: O(1)
- 자바의 Queue 인터페이스 
  - add(E e): 넣을 수 있으면 넣고 true 리턴, 더이상 큐에 넣을 수 없을 때는 IllegalStateException 을 던진다.
  - offer(E e): 넣을 수 있으면 넣고 true 리턴, 넣을 수 없는 경우에는 false 리턴.
  - E remove(): 꺼낼 수 있으면 꺼내주고 꺼낼 것이 없으면 NoSuchElementException 을 던진다.
  - E poll(): 꺼낼 수 있으면 꺼내주고 꺼낼 것이 없으면 null 리턴. 
  - E element(): 큐의 head 에 들어 있는 값을 리턴하지만 큐에서 빼지는 않는다. 큐에 데이터가 없으면 NoSuchElementException 을 던진다.
  - E peek(): 큐의 head 에 들어있는 값을 리턴하지만 큐에서 빼지는 않는다. 큐에 데이터가 없으면 null 리턴.
  
### 트리
- 연결 리스트와 비슷하지만 노드 한개가 다른 여러 노드를 가리킨다. 
- 트리 용어 
  - 루트(root): 부모가 없는 노드. 트리에는 최대 한개의 루트가 있다. 
  - 엣지(edge): 부모에서 자식으로 이어지는 연결 선
  - 리프(leaf): 자식이 없는 노드
  - 형제(siblings): 부모가 같은 노드들
  - 노드의 깊이: 뿌리에서 해당 노드까지의 길이
  - 노드의 높이: 해당 노드에서 가장 깊은 리프까지의 길이
  - 트리의 깊이: 모든 노드의 깊이 값 중에서 최대 값
  - 노드의 크기: 자기 자신을 포함한 그 노드가 가진 자손의 수
- 이진 트리
  - 각 노드가 자식이 없거나, 한 개 혹은 두개의 자식을 가진다.
  - 엄격한 이진 트리: 모든 노드가 두 개의 자식을 가지거나 자식이 없는 트리.
  - 포화 이진 트리: 모든 노드가 두 개의 자식을 가지고, 모든 리프 노드가 같은 레벨에 있는 트리.
  - 완전 이진 트리: 트리의 높이가 h 일 때, 레벨 h-1까지 모든 노드가 채워져 있고 레벨 h 에 있는 노드는 가능한 왼쪽으로 채워져 있는 트리.
  - 트리 높이로 각 이진 트리의 노드 개수를 추측할 수 있다. 
- 이진 검색 트리(BST)
  - 검색용 이진 트리
  - 어떤 노드 왼쪽 서브 트리의 모든 값들은 해당 노드의 값보다 작아야 한다.
  - 어떤 노드 오른쪽 서브 트리의 모든 값들은 해당 노드의 값보다 커야 한다. 
  - 왼쪽, 오른쪽 서브 트리 모두 각각이 이진 검색 트리여야 한다. 
- 트리 순회 
  - 전위탐색(노드,왼쪽,오른쪽 또는 노드,오른쪽,왼쪽)
  - 중위탐색(왼쪽,노드,오른쪽 또는 오른쪽,노드,왼쪽)
  - 후위탐색(왼쪽,오른쪽,노드 또는 오른쪽 왼쪽 노드)
  - 레벨탐색(BFS)

### String
- charAt(), int num = str.charAt(i) - '0';
- substring()
    - substring(beginIndex, endIndex)  시작인덱스 부터 마지막 인덱스 -1 까지
    - substring(index) 시작 인텍스부터 모두
- indexOf()
    - indexOf(String str) 문자의 위치를 리턴, 없으면 -1
    - indexOf(String str, int fromIndex) fromIndex 번째의 str 위치를 리턴
  
### Array
- Math.max()
- map.getOrDefault(Object key, V defaultValue) 찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환한다.

### 2dArray
  - 2차원 배열 정의
    ~~~ java
    // 방법 1
    int[][] grid = new int[3][4];
    // 방법 2
    int[][] grid2 = new int[3][];
    grid2[0] = new int[1];
    grid2[1] = new int[2];
    grid2[2] = new int[7];
    // 방법 3
    int[][] grid3 = {{1,2},
                     {2,3},
                     {3,5}};
    ~~~
    
### map
- **keySet 방법**
  ~~~ java
  for (String key : map.keySet()) {
      System.out.println("key : " + key + ", value : " + map.get(key));
  }
  ~~~
- **entrySet 방법**
  ~~~ java
  for (Map.Entry<string, string> elem : map.entrySet()) {
      System.out.println("key : " + elem.getKey() + ", value : " + elem.getValue());
  }
  ~~~
- Iterator 방법
  ~~~ java
  Iterator<string> keys = map.keySet().iterator();
  while (keys.hasNext()) {
      String key = keys.next();
      System.out.println("key : " + key + ", value : " + map.get(key));
  }
  ~~~
  
### sort
- compareTo
  - A = B 이면 0
  - A > B 이면 1
  - A < B 이면 -1 
  ~~~ java
  public int compareTo() {
      return A.compareTo(B);
  }
  ~~~
- 오름차순 
  ~~~ java
  Collections.sort(List<T> list, (a, b) -> a.start - b.start);
  ~~~
  
