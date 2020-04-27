
create PROCEDURE BooksCount(OUT cnt INT)
LANGUAGE SQL
BEGIN
	select count(*) into cnt from books;
END;

-------------------

CREATE FUNCTION bookscount() returns INTEGER AS $$ 
BEGIN
	RETURN 11;
END; $$
LANGUAGE PLPGSQL;

-------------------

CREATE PROCEDURE bookscount(A INTEGER) 
LANGUAGE SQL
AS $$ 
BEGIN
	
END; $$;

-------------------

CREATE FUNCTION test(val INTEGER) returns INTEGER AS $$ 
BEGIN
	RETURN val + 1;
END; $$
LANGUAGE PLPGSQL;

-------------------

CREATE OR REPLACE FUNCTION insert_data(name1 varchar(255), name2 varchar(255))
RETURNS void AS $$
BEGIN
	INSERT INTO books (name) VALUES (name1);
	INSERT INTO books (name) VALUES (name2);
END;
$$
LANGUAGE plpgsql;

------------------- FINALLY

CREATE OR REPLACE FUNCTION get_books_count(OUT cnt INTEGER)
AS $$
BEGIN
	select count(*) into cnt from books;
END;
$$
LANGUAGE plpgsql;

------------------- 

CREATE OR REPLACE FUNCTION get_book_by_id(bookId INTEGER)
RETURNS SETOF record AS $$
BEGIN
	select * from books where id = bookId;
END;
$$
LANGUAGE plpgsql;





