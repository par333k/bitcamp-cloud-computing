-- 학생
CREATE TABLE 6_Student (
	sNum      INTEGER      NOT NULL, -- 학생고유번호
	sNo       INTEGER      NOT NULL, -- 학번
	sPassword VARCHAR(255) NOT NULL, -- 암호
	sName     VARCHAR(50)  NOT NULL, -- 이름
	sTel      VARCHAR(30)  NULL,     -- 연락처
	sMajor    VARCHAR(255) NULL,     -- 전공
	sEmail    VARCHAR(40)  NULL,     -- 이메일
	sYear     INTEGER      NOT NULL, -- 학년
	sMaxClass INTEGER      NOT NULL  -- 학점제한
);

-- 학생 기본키
CREATE UNIQUE INDEX PK_6_Student
	ON 6_Student ( -- 학생
		sNum ASC -- 학생고유번호
	);

-- 학생 유니크 인덱스
CREATE UNIQUE INDEX UIX_6_Student
	ON 6_Student ( -- 학생
		sNo ASC -- 학번
	);

-- 학생
ALTER TABLE 6_Student
	ADD
		CONSTRAINT PK_6_Student -- 학생 기본키
		PRIMARY KEY (
			sNum -- 학생고유번호
		);

-- 학생
ALTER TABLE 6_Student
	ADD
		CONSTRAINT UK_6_Student -- 학생 유니크 제약
		UNIQUE (
			sNo -- 학번
		);

-- 교수
CREATE TABLE 6_Professor (
	pNum       INTEGER      NOT NULL, -- 교수고유번호
	pNo        INTEGER      NOT NULL, -- 교번
	pName      VARCHAR(50)  NOT NULL, -- 이름
	pPassword  VARCHAR(255) NOT NULL, -- 암호
	pMajor     VARCHAR(255) NOT NULL, -- 전공
	pTel       VARCHAR(30)  NULL,     -- 연락처
	pEmail     VARCHAR(40)  NULL,     -- 이메일
	pClassAble VARCHAR(2)   NOT NULL  -- 개설강좌제한
);

-- 교수 기본키
CREATE UNIQUE INDEX PK_6_Professor
	ON 6_Professor ( -- 교수
		pNum ASC -- 교수고유번호
	);

-- 교수 유니크 인덱스
CREATE UNIQUE INDEX UIX_6_Professor
	ON 6_Professor ( -- 교수
		pNo ASC -- 교번
	);

-- 교수
ALTER TABLE 6_Professor
	ADD
		CONSTRAINT PK_6_Professor -- 교수 기본키
		PRIMARY KEY (
			pNum -- 교수고유번호
		);

-- 교수
ALTER TABLE 6_Professor
	ADD
		CONSTRAINT UK_6_Professor -- 교수 유니크 제약
		UNIQUE (
			pNo -- 교번
		);

-- 강좌
CREATE TABLE 6_Class (
	cNo        INTEGER     NOT NULL, -- 강의번호
	sNum       INTEGER     NOT NULL, -- 학생고유번호
	pNum       INTEGER     NOT NULL, -- 교수고유번호
	cName      VARCHAR(50) NOT NULL, -- 강의제목
	cSubject   VARCHAR(50) NOT NULL, -- 강좌과목
	cContent   CLOB        NOT NULL, -- 강의내용
	cRoom      VARCHAR(15) NOT NULL, -- 강의실
	cFile      BLOB        NULL,     -- 강의교안파일
	cMaxMember INTEGER     NOT NULL, -- 수강인원
	cAble      VARCHAR(2)  NOT NULL, -- 수강가능여부
	cStartDay  DATE        NOT NULL, -- 강의시작일
	cEndDay    DATE        NOT NULL, -- 강의끝나는일
	cTime      TIMESTAMP   NOT NULL  -- 강의시간
);

-- 강좌 기본키
CREATE UNIQUE INDEX PK_6_Class
	ON 6_Class ( -- 강좌
		cNo ASC -- 강의번호
	);

-- 강좌
ALTER TABLE 6_Class
	ADD
		CONSTRAINT PK_6_Class -- 강좌 기본키
		PRIMARY KEY (
			cNo -- 강의번호
		);

-- 강좌
ALTER TABLE 6_Class
	ADD
		CONSTRAINT FK_6_Student_TO_6_Class -- 학생 -> 강좌
		FOREIGN KEY (
			sNum -- 학생고유번호
		)
		REFERENCES 6_Student ( -- 학생
			sNum -- 학생고유번호
		);

-- 강좌
ALTER TABLE 6_Class
	ADD
		CONSTRAINT FK_6_Professor_TO_6_Class -- 교수 -> 강좌
		FOREIGN KEY (
			pNum -- 교수고유번호
		)
		REFERENCES 6_Professor ( -- 교수
			pNum -- 교수고유번호
		);