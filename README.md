# Spring-Test

## 파일 구조

1. [o] 파일의 구조는 recode (사번, 이름, 부서, 부서 코드) 같은 것이 여러 개 가능

2. [o] package -> exam.jar 파일 생성

3. [o] ERD를 그립니다.

4. [o] DataSource에서 connection 얻으면 select 1 query로 connection object를 검증합니다.

5. [o] JPA로 persistence 데이터를 처리합니다.
   5-1. [o] JPA에서 query를 돌리면 로그(콘솔)를 남기도록 설정합니다.
   5-2. [o] Application을 실행할 때마다 데이터베이스를 초기화합니다.
   5-3. [o] @Query 쓰지 마세요.

6. [o] 개발환경 h2, 운영환경 mysql

## Parser 구현

1. [o] DepartmentParser interface를 implements합니다.

2. [o] .csv, .txt, .json 확장자에 따라 동작하는 parser를 구현합니다.

3. [o] 파일 경로는 PathMatchingResourcePatternResolver를 이용합니다.

4. [o] List<?> parsing (File file) method의 return type을 구현합니다.

5. [o] .xml을 위한 parser가 지원되지 않으므로, .xml은 parsing에서 제외합니다.

6. [o] Parser를 구현합니다 JsonDepartmentParser, CsvDepartmentParser, TextDepartmentParser

7. [o] .xml 지원이 필요할 경우, XmlDepartmentParser를 bean으로 등록해 지원할 수 있도록 확장성을 고려하여 구현합니다.

8. [o] Collection Framework를 써서 구현합니다.

9. [o] DepartmentParserServiceTest가 돌아가도록 구현합니다.

## REST API 구현

1. [o] Response object의 순서는 text 파일의 부서 코드, 사번 순서(ASC)를 따릅니다.

2. [o] 부서를 구분할 수 있는 구분자를 parameter로 전달하면 부서에 포함된 모든 사용자에 대해 응답합니다.

3. [o] Parameter departmentIds는 한 개 이상 필요합니다.
   3-1. [o] parameter departmentIds가 없으면, 'HTTP/1.1 400 Bad Request'로 응답합니다.

4. [o]  Accept header가 필요합니다.
   4-1. [o] default : Accept: application/json
   4-2. [o] 'Accept: application/json' or 'Accept: application/xml'가 아니면, 'HTTP/1.1 400 Bad Request'로 응답합니다.

5. [o] Header의 X-USER-ID가 nhnacademy면 인증된 것으로 처리합니다.

6. [o] X-USER-ID 관련된 예외 처리는 Interceptor or Filter를 이용해서 구현합니다.