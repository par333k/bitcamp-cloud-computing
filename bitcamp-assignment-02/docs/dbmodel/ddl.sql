-- 회원
CREATE TABLE P2_MEMB (
    MNO   INTEGER      NOT NULL, -- 회원번호
    EMAIL VARCHAR(40)  NOT NULL, -- 이메일
    NAME  VARCHAR(50)  NOT NULL, -- 이름
    PWD   VARCHAR(255) NOT NULL  -- 암호
);

-- 회원 기본키
CREATE UNIQUE INDEX PK_P2_MEMB
    ON P2_MEMB ( -- 회원
        MNO ASC -- 회원번호
    );

-- 회원 유니크 인덱스
CREATE UNIQUE INDEX UIX_P2_MEMB
    ON P2_MEMB ( -- 회원
        EMAIL ASC -- 이메일
    );

-- 회원
ALTER TABLE P2_MEMB
    ADD
        CONSTRAINT PK_P2_MEMB -- 회원 기본키
        PRIMARY KEY (
            MNO -- 회원번호
        );

-- 회원
ALTER TABLE P2_MEMB
    ADD
        CONSTRAINT UK_P2_MEMB -- 회원 유니크 제약
        UNIQUE (
            EMAIL -- 이메일
        );

-- 명함
CREATE TABLE P2_BIZCARD (
    BCNO  INTEGER     NOT NULL, -- 명함번호
    MNO   INTEGER     NOT NULL, -- 회원번호
    NAME  VARCHAR(50) NOT NULL, -- 이름
    MTEL  VARCHAR(30) NULL,     -- 휴대전화
    TEL   VARCHAR(30) NULL,     -- 일반전화
    FAX   VARCHAR(30) NULL,     -- 팩스
    EMAIL VARCHAR(40) NULL,     -- 이메일
    MEMO  TEXT        NULL      -- 메모
);

-- 명함 기본키
CREATE UNIQUE INDEX PK_P2_BIZCARD
    ON P2_BIZCARD ( -- 명함
        BCNO ASC -- 명함번호
    );

-- 명함 인덱스
CREATE INDEX IX_P2_BIZCARD
    ON P2_BIZCARD( -- 명함
        NAME ASC -- 이름
    );

-- 명함
ALTER TABLE P2_BIZCARD
    ADD
        CONSTRAINT PK_P2_BIZCARD -- 명함 기본키
        PRIMARY KEY (
            BCNO -- 명함번호
        );

-- 명함
ALTER TABLE P2_BIZCARD
    ADD
        CONSTRAINT FK_P2_MEMB_TO_P2_BIZCARD -- 회원 -> 명함
        FOREIGN KEY (
            MNO -- 회원번호
        )
        REFERENCES P2_MEMB ( -- 회원
            MNO -- 회원번호
        );