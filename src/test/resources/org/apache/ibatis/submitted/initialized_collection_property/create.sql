CREATE MEMORY TABLE POST(POST_ID INTEGER NOT NULL PRIMARY KEY,CONTENT VARCHAR(255) NOT NULL,AUTHOR_ID INTEGER NOT NULL);
CREATE MEMORY TABLE AUTHOR(AUTHOR_ID INTEGER NOT NULL PRIMARY KEY,NAME VARCHAR(255));
INSERT INTO POST VALUES(1,'content 1',1);
INSERT INTO POST VALUES(2,'content 2',1);
INSERT INTO POST VALUES(3,'content 3',1);
INSERT INTO AUTHOR VALUES(1,'James Brown');
ALTER TABLE POST ADD CONSTRAINT AUTHOR_CONSTRAINT FOREIGN KEY(AUTHOR_ID) REFERENCES AUTHOR(AUTHOR_ID);
