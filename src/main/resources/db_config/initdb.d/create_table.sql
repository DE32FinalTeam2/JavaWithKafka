CREATE TABLE chatting_supervisor(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, -- 'id' 컬럼에 PRIMARY KEY 추가
    `offset` VARCHAR(100) NOT NULL, -- offset
    chat_time DATETIME NOT NULL, -- 채팅 시각
    username VARCHAR(50) NOT NULL, -- 유저 이름
    chatting_content VARCHAR(500) NOT NULL, -- 채팅 내용
    chat_ip VARCHAR(20), -- 해당 IP
    chat_check BOOLEAN -- O 외에 나머지는 null값으로 주든 X로 줌
);