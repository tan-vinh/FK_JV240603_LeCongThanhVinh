package ra.entity;

import java.util.Scanner;

public class Book implements IBookManagement {
    private int bookId;
    private String bookName;
    private String title;
    private String author;
    private int totalPages;
    private String content;
    private String publisher;
    private float price;
    private int typeId;
    private boolean isDeleted;

    public Book() {
    }

    public Book(int bookId, String bookName, String title, String author, int totalPages, String content, String publisher, float price, int typeId, boolean isDeleted) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.author = author;
        this.totalPages = totalPages;
        this.content = content;
        this.publisher = publisher;
        this.price = price;
        this.typeId = typeId;
        this.isDeleted = isDeleted;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập tên sách: ");
        bookName = scanner.nextLine();
        System.out.println("Nhập tiêu đề: ");
        title = scanner.nextLine();
        System.out.println("Nhập tác giả: ");
        author = scanner.nextLine();
        System.out.println("Nhập số trang sách: ");
        totalPages = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập nội dung: ");
        content = scanner.nextLine();
        System.out.println("Nhập nhà xuất bản: ");
        publisher = scanner.nextLine();
        System.out.println("Nhập giá: ");
        price = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập mã loại sách: ");
        typeId = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập trạng thái sách: ");
        isDeleted = Boolean.parseBoolean(scanner.nextLine());
    }

    @Override
    public void displayData() {
        System.out.println("Mã sách: " + bookId);
        System.out.println("Tên sách: " + bookName);
        System.out.println("Tiêu đề sách: " + title);
        System.out.println("Tác giả sách: " + author);
        System.out.println("Số trang sách: " + totalPages);
        System.out.println("Nội dung sách: " + content);
        System.out.println("Nhà xuất bản: " + publisher);
        System.out.println("Giá sách: " + price);
        System.out.println("Mã loại sách: " + typeId);
        System.out.println("Trạng thái sách: " + (isDeleted ? "Deleted" : "Not Deleted"));
    }
}
