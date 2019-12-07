package dao;

import java.util.List;

import pojos.Book;

public interface IBookDao {
	List<String> getAllCategories() throws Exception;
	List<Book> getBooksByCategory(String catName) throws Exception;
	Book getBookDetails(int bookId) throws Exception;
}
