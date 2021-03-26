# study-coding-test-basic

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
  
### 문제 풀이 과정 
- 1. 문제를 명확이 이해했는지 확인 한다.
- 2. 가정하고 있거나 가정할 수 있는 것들을 확인한다.
- 3. 실제 예를 들어가며 다시 확인한다.(나중에 테스트 케이스로 활용할 수 있다.)
- 4. 문제 해결책을 고민한다.
- 5. 해결책을 설명하고 해당 시간과 공간 알고리듬 복잡도를 설명한다. 
- 6. 코드를 작성한다.
- 7. 앞서 예시로 사용했던 입력값을 케이스로 삼아 코드를 테스트 한다.