package cn.xg.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Book extends Product implements Serializable{

	private Integer id;
	private String author;
	private String publishing;
	private Long   publish_time;
	private String publishTime;
	private String word_number;
	private String which_edtion;
	private String total_page;
	private Integer print_time;
	private String	print_number;
	private String isbn;
	private String author_summary;
	private String catalogue;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(Integer id, String author, String publishing, Long publish_time, String word_number,
			String which_edtion, String total_page, Integer print_time, String print_number, String isbn,
			String author_summary, String catalogue) {
		super();
		this.id = id;
		this.author = author;
		this.publishing = publishing;
		this.publish_time = publish_time;
		this.word_number = word_number;
		this.which_edtion = which_edtion;
		this.total_page = total_page;
		this.print_time = print_time;
		this.print_number = print_number;
		this.isbn = isbn;
		this.author_summary = author_summary;
		this.catalogue = catalogue;
	}
	public Book(String author, String publishing, Long publish_time, String word_number, String which_edtion,
			String total_page, Integer print_time, String print_number, String isbn, String author_summary,
			String catalogue) {
		super();
		this.author = author;
		this.publishing = publishing;
		this.publish_time = publish_time;
		this.word_number = word_number;
		this.which_edtion = which_edtion;
		this.total_page = total_page;
		this.print_time = print_time;
		this.print_number = print_number;
		this.isbn = isbn;
		this.author_summary = author_summary;
		this.catalogue = catalogue;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublishing() {
		return publishing;
	}
	public void setPublishing(String publishing) {
		this.publishing = publishing;
	}
	public Long getPublish_time() {
		return publish_time;
	}
	public void setPublish_time(Long publish_time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date  =new Date(publish_time);
		this.publishTime=sdf.format(date);
		this.publish_time = publish_time;
	}
	public String getWord_number() {
		return word_number;
	}
	public void setWord_number(String word_number) {
		this.word_number = word_number;
	}
	public String getWhich_edtion() {
		return which_edtion;
	}
	public void setWhich_edtion(String which_edtion) {
		this.which_edtion = which_edtion;
	}
	public String getTotal_page() {
		return total_page;
	}
	public void setTotal_page(String total_page) {
		this.total_page = total_page;
	}
	public Integer getPrint_time() {
		return print_time;
	}
	public void setPrint_time(Integer print_time) {
		this.print_time = print_time;
	}
	public String getPrint_number() {
		return print_number;
	}
	public void setPrint_number(String print_number) {
		this.print_number = print_number;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getAuthor_summary() {
		return author_summary;
	}
	public void setAuthor_summary(String author_summary) {
		this.author_summary = author_summary;
	}
	public String getCatalogue() {
		return catalogue;
	}
	public void setCatalogue(String catalogue) {
		this.catalogue = catalogue;
	}
	
	public String getPublishTime() {
		return publishTime;
	}
	public void publish_time(String publishTime) {
		this.publishTime = publishTime;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", author=" + author + ", publishing=" + publishing + ", publish_time=" + publish_time
				+ ", word_number=" + word_number + ", which_edtion=" + which_edtion + ", total_page=" + total_page
				+ ", print_time=" + print_time + ", print_number=" + print_number + ", isbn=" + isbn
				+ ", author_summary=" + author_summary + ", catalogue=" + catalogue + "]";
	}
	
	
	
	
}
