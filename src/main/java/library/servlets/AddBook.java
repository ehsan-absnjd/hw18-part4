package library.servlets;

import library.entity.Book;
import library.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "AddBook", value = "/books")
public class AddBook extends HttpServlet {
    BookService bookService = new BookService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        List<Book> allBooks = bookService.findAll();
        writer.write("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Add Book Page</title>\n" +
                "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\n" +
                "          integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">\n" +
                "    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js\"\n" +
                "            integrity=\"sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM\"\n" +
                "            crossorigin=\"anonymous\"></script>\n" +
                "    <link rel=\"stylesheet\" href=\"styles.css\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"container mt-5\">");
        writer.println("<table class=\"table\">\n" +
                "  <thead>\n" +
                "    <tr>\n" +
                "      <th scope=\"col\">id</th>\n" +
                "      <th scope=\"col\">Title</th>\n" +
                "      <th scope=\"col\">Author</th>\n" +
                "      <th scope=\"col\">Publisher</th>\n" +
                "      <th scope=\"col\">Price</th>\n" +
                "    </tr>\n" +
                "  </thead>\n" +
                "  <tbody>");
        for (Book book : allBooks) {
            writer.println(" <tr>\n" +
                    "      <th scope=\"row\">" +book.getId() +"</th>\n" +
                    "      <td>" + book.getTitle()+"</td>\n" +
                    "      <td>" + book.getAuthor()+"</td>\n" +
                    "      <td>" + book.getPublisher()+"</td>\n" +
                    "      <td>" + book.getPrice()+"</td>\n" +
                    "    </tr>");
        }
        writer.write(" </tbody>\n" +

                "</table>" +
                "    <div>\n" +
                "\n" +
                "    <a href=\"/part4_war_exploded/\">add book</a>\n" +
                "    </div>"+
                "</div></body>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String publisher = request.getParameter("publisher");
        double price = Double.parseDouble(request.getParameter("price"));
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setPrice(price);
        bookService.saveOrUpdate(book);
        doGet(request,response);
    }
}
