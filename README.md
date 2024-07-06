# 🏦 은행 관리 시스템

## ⭐ 프로젝트 목표

OOP 숙달 및 SOLID 적용 연습을 위한 CRUD 서비스 구현
<br>
git 활용을 통한 협업 능력 향상

- **기간**: 24.06.27 ~ 24.07.06 (10일)
- **개발 환경**: Java 17

<hr>

## 📋 구현할 기능

### 유저 (User)

- **회원가입**: 회원가입 시 이름, 전화번호, 아이디(중복제거), 비밀번호(6자리) 입력하여 계정 생성하는 기능입니다.
- **로그인**: ID와 비밀번호를 입력받고 계정이 있을 시 로그인 성공, 계정이 없으면 로그인 실패하는 기능입니다.
- **회원정보 수정**: 사용자가 회원가입할 때 입력했던 비밀번호와 전화번호를 변경하고 싶을 경우, 새로운 비밀번호와 전화번호를 입력받고 변경된 비밀번호와 전화번호를 업데이트하는 기능입니다.

### 계좌 (Account)

- **계좌 생성**: 계좌 번호 랜덤 10자리를 중복 확인 후 계좌 번호를 생성하고 계좌 비밀번호 4자리를 받은 후 재확인까지 성공하면 계좌 생성되는 기능입니다.
- **잔액 조회**: 유저의 전체 계좌 잔액을 조회하는 기능입니다.

### 거래 (Transaction)

- **입금 (deposit)**: 입금할 계좌번호를 입력하고, 입금액을 입력하면 계좌의 잔액에 입금액을 더해주는 기능입니다.
- **출금 (withdraw)**: 출금할 계좌번호와 비밀번호를 입력하고, 출금액을 입력하면 계좌의 잔액에 출금액을 빼주는 기능입니다.
- **거래내역 조회**: 거래내역을 조회할 계좌번호를 입력받은 후, 입력받은 계좌번호의 출금 또는 입금과 거래한 날짜, 거래한 금액을 보여주는 기능입니다.

### 기타 기능

- 사용자(user)가 계좌(account)를 생성할 수 있음
- 계좌를 통해 입금(deposit), 출금(withdraw)이 가능하며, 입출금 내역(transaction)을 조회 가능

<hr>

## ✋ 참여자
<table>
  <tr>
    <td align="center"><a href="https://github.com/kimmin1kk"><img src="https://avatars.githubusercontent.com/u/101302590?v=4" width="100px;" alt=""/><br /><sub><b>kimmin1kk</b></sub></a><br /><br /><sub><b>틀 잡기</b></sub></a><br /></td>
    <td align="center"><a href="https://github.com/DDDDiong"><img src="https://avatars.githubusercontent.com/u/169411018?v=4" width="100px;" alt=""/><br /><sub><b>DDDDiong</b></sub></a><br /><br /><sub><b>회원가입, 로그인 기능 구현</b></sub></a><br /></td>
    <td align="center"><a href="https://github.com/Dowon-95"><img src="https://avatars.githubusercontent.com/u/147986553?v=4" width="100px;" alt=""/><br /><sub><b>Dowon-95</b></sub></a><br /><br /><sub><b>입금, 출금 기능 구현</b></sub></a><br /></td>
    <td align="center"><a href="https://github.com/go-marr"><img src="https://avatars.githubusercontent.com/u/108805823?v=4" width="100px;" alt=""/><br /><sub><b>go-marr</b></sub></a><br /><br /><sub><b>계좌 관련 기능</b></sub></a><br /></td>
    <td align="center"><a href="https://github.com/0237hh"><img src="https://avatars.githubusercontent.com/u/153145663?v=4" width="100px;" alt=""/><br /><sub><b>0237hh</b></sub></a><br /><br /><sub><b>회원 정보 수정, 거래 내역</b></sub></a><br /></td>
  </tr>
</table>

<hr>

## 🙌 도메인 및 패키지 구성 (계층형 구조)

- **service**: 비즈니스 로직
- **view**: 사용자 인터페이스 부분
- **domain**: 비즈니스 도메인 객체
    - user
    - admin
    - transaction
    - account
- **repository**: 데이터 액세스 계층으로, 데이터베이스 또는 파일 시스템 등의 데이터 저장소 CRUD 작업을 처리

<hr>

## 💻 작업 방식

### Branch 관리

각자 자신의 아이디로 된 브랜치를 만들어서 작업 후<br> 기능 구현이 끝나면
main Branch로 Pull Request를 보냅니다.

### Commit 컨벤션
<img src="https://github.com/kimmin1kk/kimmin1kk.github.io/assets/101302590/0d9983dc-a728-4438-b374-94d3ad985b65" style="width: 300px">

- 예시: `feat: 입금 기능 추가`

### Pull-Request (PR)

- 간단하게 무엇을 하는 PR인지 알 수 있게 작성합니다.

### Issue

- 간단하게 내용을 알 수 있도록 작성합니다.

---
