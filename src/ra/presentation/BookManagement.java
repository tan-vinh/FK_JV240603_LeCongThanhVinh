package ra.presentation;

import ra.business.BookBusiness;
import ra.business.BookTypeBusiness;
import ra.business.CountResult;
import ra.entity.Book;
import ra.entity.BookType;

import java.util.List;
import java.util.Scanner;

public class BookManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("******************BOOK-MANAGEMENT******************\n" +
                    "1. Quản lý loại sách\n" +
                    "2. Quản lý sách\n" +
                    "3. Thoát\n" +
                    "Lựa chọn của bạn:");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    BookManagement.menuTypeBook(sc);
                    break;
                case 2:
                    BookManagement.menuBook(sc);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.err.println("Mời bạn nhập lại");
            }
        } while (true);
    }

    public static void menuTypeBook(Scanner scanner) {
        boolean flag = true;
        do {
            System.out.println("**********************BOOKTYPE-MENU********************\n" +
                    "1. Danh sách loại sách\n" +
                    "2. Tạo mới loại sách\n" +
                    "3. Cập nhật thông tin loại sách\n" +
                    "4. Xóa loại sách\n" +
                    "5. Thống kê số lượng sách theo mã loại sách\n" +
                    "6. Thoát \n" +
                    "Lựa chọn của bạn:\n");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    BookManagement.findAllBookType();
                    break;
                case 2:
                    BookManagement.createBookType(scanner);
                    break;
                case 3:
                    BookManagement.updateBookType(scanner);
                    break;
                case 4:
                    BookManagement.deleteBookType(scanner);
                    break;
                case 5:
                    BookManagement.countBookType();
                    break;
                case 6:
                    flag = false;
                    break;
            }
        } while (flag);
    }

    public static void findAllBookType() {
        List<BookType> bookTypes = BookTypeBusiness.getAllBookTypes();
        for (BookType bookType : bookTypes) {
            bookType.displayData();
        }
    }

    public static void createBookType(Scanner scanner) {
        BookType bookType = new BookType();
        bookType.inputData(scanner);
        BookTypeBusiness.createBookType(bookType);
    }

    public static void updateBookType(Scanner scanner) {
        System.out.println("Nhập vào id cần sửa: ");
        int id = Integer.parseInt(scanner.nextLine());
        BookType bookType = BookTypeBusiness.findBookTypeById(id);
        if (bookType != null) {
            System.out.println("Thông tin");
            bookType.displayData();
            boolean isExit = true;
            do {
                System.out.println("Trường muốn sửa");
                System.out.println("1. Tên loại sách");
                System.out.println("2. Mô tả");
                System.out.println("3. Trạng thái");
                System.out.println("4. Thoát");
                System.out.println("Mời bạn chọn:");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Tên loại sách mới");
                        bookType.setTypeName(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Mô tả mới");
                        bookType.setDescription(scanner.nextLine());
                        break;
                    case 3:
                        System.out.println("Trạng thái mới");
                        bookType.setDeleted(Boolean.parseBoolean(scanner.nextLine()));
                        break;
                    case 4:
                        isExit = false;
                        break;
                }
            } while (isExit);
            boolean result = BookTypeBusiness.updateBookType(bookType);
            if (result) {
                System.out.println("Cập nhật thành công");
            } else {
                System.out.println("Cập nhật thất bại");
            }
        } else {
            System.out.println("Không tìm thấy loại sách");
        }
    }

    public static void deleteBookType(Scanner scanner) {
        System.out.println("Nhập vào id cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (BookTypeBusiness.findBookTypeById(id) != null) {
            boolean result = BookTypeBusiness.deleteBookType(id);
            if (result) {
                System.out.println("Xóa thành công");
            } else {
                System.out.println("Xóa nhật thất bại");
            }
        } else {
            System.out.println("Không tìm thấy loại sách");
        }
    }

    public static void countBookType() {
        List<CountResult> countResults = BookTypeBusiness.countBookType();
        for (CountResult countResult : countResults) {
            countResult.print();
        }
    }

    public static void menuBook(Scanner scanner) {
        boolean flag = true;
        do {
            System.out.println("***********************BOOK-MENU***********************\n" +
                    "1. Danh sách sách\n" +
                    "2. Tạo mới sách\n" +
                    "3. Cập nhật thông tin sách\n" +
                    "4. Xóa sách\n" +
                    "5. Hiển thị danh sách các cuốn sách theo giá giảm dần\n" +
                    "6. Tìm kiếm sách theo tên hoặc nội dung\n" +
                    "7. Thống kê số lượng sách theo nhóm \n" +
                    "8. Thoát\n" +
                    "\n" +
                    "Lựa chọn của bạn:\n");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    BookManagement.findAllBook();
                    break;
                case 2:
                    BookManagement.createBook(scanner);
                    break;
                case 3:
                    BookManagement.updateBook(scanner);
                    break;
                case 4:
                    BookManagement.deleteBook(scanner);
                    break;
                case 5:
                    break;
                case 6:
                    BookManagement.searchBook(scanner);
                    break;
                case 7:
                    break;
                case 8:
                    flag = false;
                    break;
            }
        } while (flag);
    }

    public static void findAllBook() {
        List<Book> books = BookBusiness.getAllBook();
        for (Book book : books) {
            book.displayData();
        }
    }

    public static void createBook(Scanner scanner) {
        Book book = new Book();
        book.inputData(scanner);
        BookBusiness.createBook(book);
    }

    public static void updateBook(Scanner scanner) {
        System.out.println("Nhập vào id cần sửa: ");
        int id = Integer.parseInt(scanner.nextLine());
        Book book = BookBusiness.findBookById(id);
        if (book != null) {
            System.out.println("Thông tin");
            book.displayData();
            boolean isExit = true;
            do {
                System.out.println("Trường muốn sửa");
                System.out.println("1. Tên sách");
                System.out.println("2. Tiêu đề sách");
                System.out.println("3. Tác giả sách");
                System.out.println("4. Số trang sách");
                System.out.println("5. Nội dung sách");
                System.out.println("6. Nhà xuất bản");
                System.out.println("7. Giá sách");
                System.out.println("8. Mã loại sách");
                System.out.println("9. Trạng thái");
                System.out.println("10. Thoát");
                System.out.println("Mời bạn chọn:");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Tên loại sách mới");
                        book.setBookName(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Tiêu đề sách mới");
                        book.setTitle(scanner.nextLine());
                        break;
                    case 3:
                        System.out.println("Tác giả sách mới");
                        book.setAuthor(scanner.nextLine());
                        break;
                    case 4:
                        System.out.println("Số trang sách mới");
                        book.setTotalPages(scanner.nextInt());
                        break;
                    case 5:
                        System.out.println("Nội dung sách mới");
                        book.setContent(scanner.nextLine());
                        break;
                    case 6:
                        System.out.println("Nhà xuất bản mới");
                        book.setPublisher(scanner.nextLine());
                        break;
                    case 7:
                        System.out.println("Giá sách mới");
                        book.setPrice(Float.parseFloat(scanner.nextLine()));
                        break;
                    case 8:
                        System.out.println("Mã loại sách mới");
                        book.setTypeId(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 9:
                        System.out.println("Trạng thái mới");
                        book.setDeleted(Boolean.parseBoolean(scanner.nextLine()));
                        break;
                    case 10:
                        isExit = false;
                        break;
                }
            } while (isExit);
            boolean result = BookBusiness.updateBook(book);
            if (result) {
                System.out.println("Cập nhật thành công");
            } else {
                System.out.println("Cập nhật thất bại");
            }
        } else {
            System.out.println("Không tìm thấy sách");
        }
    }

    public static void deleteBook(Scanner scanner) {
        System.out.println("Nhập vào id cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (BookBusiness.findBookById(id) != null) {
            boolean result = BookBusiness.deleteBook(id);
            if (result) {
                System.out.println("Xóa thành công");
            } else {
                System.out.println("Xóa nhật thất bại");
            }
        } else {
            System.out.println("Không tìm thấy loại sách");
        }
    }

    public static void searchBook(Scanner scanner) {
        System.out.println("Tên sách muốn tìm kiếm");
        String bookName = scanner.nextLine();
        List<Book> books = BookBusiness.searchBookByName(bookName);
        for (Book book : books) {
            book.displayData();
        }
    }
}
