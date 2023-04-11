CREATE TABLE IF NOT EXISTS users
(
    id        BIGINT AUTO_INCREMENT PRIMARY KEY,
    name      VARCHAR(50)  NOT NULL,
    email     VARCHAR(100) NOT NULL,
    image_url VARCHAR(255) NOT NULL,
    status    VARCHAR(7)   NOT NULL
);