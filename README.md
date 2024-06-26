# spring-module-base
## 💡 목적
개발 효율을 높이기 위해 자주 사용되는 부분/공통되는 부분을 묶음

## 💡 기능
**1. 데이터 구조 통일**
<br> `createdAt`, `id`, `is_deleted`의 경우 모든 엔티티가 공통적으로 사용하기에 이를 묶음

- 위의 내용을 entity가 상속해서 필요한 내용만 객체 엔티티에 담을 수 있도록 함
- 엔티티의 목적 상 관련 내용이 필요없다면 상속하지 않아도 괜찮음

**2. CRUD 단순화**
<br>CRUD 개발 시간을 단축하기 위해 공통 서비스, 컨트롤러 생성

- 비즈니스 로직에 더 집중할 수 있도록 기본 CRUD는 추상화 해서 사용
  - 어플리케이션의 경우 공통 CRUD가 아닌 비즈니스 로직이 CRUD에 영향을 미치기에 위의 내용을 상속하지 않음
  - 엡의 경우 공통 CRUD를 주로 사용하고, 추가적으로 필요한 부분만 새로 구현해서 사용
- 필요 시, 이를 상속해서 사용
