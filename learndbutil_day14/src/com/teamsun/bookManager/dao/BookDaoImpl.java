package com.teamsun.bookManager.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.teamsun.bookManager.domain.Book;
import com.teamsun.bookManager.util.C3P0Util;

public class BookDaoImpl {
	
	/**
	 * 查找所有图书
	 * @return
	 * @throws SQLException
	 */
	public List<Book> findAllBooks() throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from book", new BeanListHandler<Book>(Book.class));
	}
	/**
	 * 添加图书信息
	 * @param book
	 * @throws SQLException
	 */
	public void addBook(Book book) throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("INSERT INTO book VALUES(?,?,?,?,?,?)",book.getId(),book.getName(),book.getPrice(),book.getPnum(),book.getCategory(),book.getDescription());
	}
	
	/**
	 * 
	 * @param id
	 * @return 
	 * @throws SQLException 
	 */
	public Book findBookById(String id) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from book where id=?", new BeanHandler<Book>(Book.class),id);
	}
	
	/**
	 * 修改图书信息
	 * @param book
	 * @throws SQLException
	 */
	public void updateBook(Book book) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("update book set name=?,price=?,pnum=?,category=?,description=? where id=?",
				book.getName(),book.getPrice(),book.getPnum(),book.getCategory(),book.getDescription(),book.getId());
		
		
	}
}
