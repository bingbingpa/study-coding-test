### 코테 관련 코틀린 정리

- until 은 마지막 값 제외 ..은 마지막 값 포함
  - ~~~kotlin
    1 until 5 // 1,2,3,4
    1 .. 5 // 1,2,3,4,5
    ~~~
- 자바 new int[n] 처럼 사이즈 배열 만들기
  - arrayof() 는 파라미터로 엘리먼트들을 넣어줘야 한다
  - ~~~kotlin
    arrayOfNulls<T>(size) // 값 조회시 null 체크 해줘야 해서 귀찮음
    Array(size) { 0 } // 0으로 초기화 해주면 not null 이므로 null 체크 필요 없음
    ~~~