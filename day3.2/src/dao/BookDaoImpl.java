package dao;

import static utils.DBUtils.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pojos.Book;

public class BookDaoImpl implements IBookDao {
	private Connection cn;
	private PreparedStatement pst1, pst2, pst3;

	// constr
	public BookDaoImpl() throws Exception {
		// get cn
		cn = getConnection();
		pst1 = cn.prepareStatement("select distinct category from dac_books");
		pst2 = cn.prepareStatement("select * from dac_books where category=?");
		pst3 = cn.prepareStatement("select * from dac_books where id=?");
		System.out.println("book dao created");
	}

	public void cleanUp() throws Exception {
		if (pst1 != null)
			pst1.close();
		if (pst2 != null)
			pst2.close();
		if (pst3 != null)
			pst3.close();
		System.out.println("book dao cleaned up");
	}

	@Override
	public List<String> getAllCategories() throws Exception {
		ArrayList<String> categories = new ArrayList<>();
		try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next())
				categories.add(rst.getString(1));
		}
		System.out.println("book dao ret  " + categories);
		return categories;
	}

	@Override
	public List<Book> getBooksByCategory(String catName) throws Exception {
		ArrayList<Book> books = new ArrayList<>();
		// set IN param
		pst2.setString(1, catName);
		try (ResultSet rst = pst2.executeQuery()) {
			while (rst.next())
				books.add(new Book(rst.getInt(1), rst.getString(2), rst.getString(3), catName, rst.getDouble(5)));
		}
		System.out.println("dao reted " + books);
		return books;
	}

	@Override
	public Book getBookDetails(int bookId) throws Exception {
		pst3.setInt(1, bookId);
		try (ResultSet rst = pst3.executeQuery()) {
			if (rst.next())
				return new Book(bookId, rst.getString(2), rst.getString(3), rst.getString(4), rst.getDouble(5));
		}
		return null;
	}

}
