# 과제 제출 방법
1. 본인 이름으로 브랜치 생성
2. 매 주차마다 폴더 생성 (폴더 이름: n주차)
3. 해당 폴더에 매 주차 과제 제출

브랜치 구조
```
e.g.
본인 브랜치: 박현우
    ┝ 1주차
        └ Main.java
    ┝ 2주차
    ┝ 3주차
    ┝ ...
```

## 터미널에서 하는 법
### 과제 첫 제출 시
- git clone https://github.com/Like-Lion-for-DAU/LLDAU-Study-BE.git

- LLDAU-Study-BE 폴더로 이동

- git branch [자기이름 or 아이디/닉네임]<br>
e.g., git branch 박현우

- git checkout [본인 브랜치] / git switch [본인 브랜치]<br>
e.g., git chekcout 박현우 / git switch 박현우

> 브랜치 생성과 브랜치 이동 동시에 하기<br>
git checkout -b [자기이름 or 아이디/닉네임]
e.g., git checkout -b 박현우

### 앞으로 과제 제출 시
- LLDAU-Study-BE 폴더에서 n주차 폴더 생성 및 해당 폴더로 이동

- 해당 폴더에 작업물 작성 및 저장

- git add .

- git commit -m "메세지 작성"

- git push origin [본인 브랜치]
e.g., git push origin 박현우