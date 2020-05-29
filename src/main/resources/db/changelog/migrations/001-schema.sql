CREATE SEQUENCE publisher_id_seq;
CREATE SEQUENCE book_id_seq;
CREATE SEQUENCE publishing_request_id_seq;
CREATE SEQUENCE publication_id_seq;

CREATE TABLE publisher (
    id INT NOT NULL PRIMARY KEY DEFAULT nextval('publisher_id_seq'),
    name VARCHAR(200) NOT NULL
);

CREATE TABLE book (
    id INT NOT NULL PRIMARY KEY DEFAULT nextval('book_id_seq'),
    title VARCHAR(200) NOT NULL,
    type VARCHAR(50) NOT NULL,
    stage VARCHAR(50) NOT NULL
);

CREATE TABLE publication_request (
    id INT NOT NULL PRIMARY KEY DEFAULT nextval('publishing_request_id_seq'),
    book_id INT,
    publisher_id INT,
    requestDate TIMESTAMP NOT NULL,
    responseDate TIMESTAMP,
    CONSTRAINT fk_request_book FOREIGN KEY (book_id) REFERENCES book(id),
    CONSTRAINT fk_request_publisher FOREIGN KEY (publisher_id) REFERENCES publisher(id)
);

CREATE TABLE publication (
    id INT NOT NULL PRIMARY KEY DEFAULT nextval('publication_id_seq'),
    book_id INT,
    publisher_id INT,
    date TIMESTAMP NOT NULL,
    CONSTRAINT fk_request_book FOREIGN KEY (book_id) REFERENCES book(id),
    CONSTRAINT fk_request_publisher FOREIGN KEY (publisher_id) REFERENCES publisher(id)
);



