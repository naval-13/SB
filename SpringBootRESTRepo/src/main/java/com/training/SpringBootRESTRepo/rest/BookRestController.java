package com.training.SpringBootRESTRepo.rest;
import com.training.SpringBootRESTRepo.entity.Book;
import com.training.SpringBootRESTRepo.service.BookService;
import com.training.SpringBootRESTRepo.utility.AppConstants;
import com.training.SpringBootRESTRepo.utility.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/books")
public class BookRestController {

    @Autowired
    private BookService bookService;

    public BookRestController() {
        System.out.println("Book Rest Controller default constructor");
    }

//    @GetMapping
//    public List<Book> getBooks(){
//        return bookService.getAllBooks();
//    }

//    @GetMapping("/{id}")
//    public Book getBookById(@PathVariable int id){
//        return bookService.getBookById(id);
//    }
    // updates because in case of failure we were not able to return any msg as return type was book

    //@GetMapping for getting data from server
//    @GetMapping("/{id}")
//    public ResponseEntity<Object> getBookById(@PathVariable int id){
//        Map<String, Object> map = new HashMap<>();
//        try {
//            map.put(AppConstants.STATUS, Status.SUCCESS);
//            map.put("book",bookService.getBookById(id) );
//            return ResponseEntity.ok(map);
//        }
//        catch (RuntimeException e){
//            map.put(AppConstants.STATUS, Status.FAILURE);
//            map.put("error",e.getMessage());
//            return ResponseEntity.badRequest().body(map);
//        }
//    }

    //gives all the books detailys where auther = key
    @GetMapping
    public List<Book> getBooks(@RequestParam(required = false) String author){
        if(author==null)
            return bookService.getAllBooks();
        return bookService.getBooksByAuthor(author);
    }

    //insert the data?  => Post request --> http add data in body
//    @PostMapping
//    public Book addbook(@RequestBody Book book){
//        System.out.println("Book :  " + book);
//        return bookService.addNewBook(book);
//    }
    //only sent bookid = 0 ,
    // how to help string in finding that we are sending data and map it to the book class

    //@PostMapping for adding data to server
//    @PostMapping
//    public ResponseEntity<Object> addBook(Book book){
//        System.out.println("Book "+book);
//        Map<String, Object> map = new HashMap<>();
//        try {
//            map.put(AppConstants.STATUS, Status.SUCCESS);
//            map.put("book",bookService.addNewBook(book) );
//            return ResponseEntity.ok(map);
//        }
//        catch (RuntimeException e){
//            map.put(AppConstants.STATUS, Status.FAILURE);
//            map.put("error",e.getMessage());
//            return ResponseEntity.badRequest().body(map);
//        }
//    }

    //Step 8: @PutMapping
    //1. To update a book add below method:
//    @PostMapping
//    public ResponseEntity<Object> addBook(Book book){
//        System.out.println("Book "+book);
//        Map<String, Object> map = new HashMap<>();
//        try {
//            map.put(AppConstants.STATUS, Status.SUCCESS);
//            map.put("book",bookService.addNewBook(book) );
//            return ResponseEntity.ok(map);
//        }
//        catch (RuntimeException e){
//            map.put(AppConstants.STATUS, Status.FAILURE);
//            map.put("error",e.getMessage());
//            return ResponseEntity.badRequest().body(map);
//        }
//    }
//    @PostMapping
//    public ResponseEntity<Object> addBook(@RequestBody Book book){
//        System.out.println("Book "+book);
//        Map<String, Object> map = new HashMap<>();
//        try {
//            map.put(AppConstants.STATUS, Status.SUCCESS);
//            map.put("book",bookService.addNewBook(book) );
//            return ResponseEntity.ok(map);
//        }
//        catch (RuntimeException e){
//            map.put(AppConstants.STATUS, Status.FAILURE);
//            map.put("error",e.getMessage());
//            return ResponseEntity.badRequest().body(map);
//        }
//    }

    @PutMapping
    public ResponseEntity<Object> updateBook(@RequestBody Book book){
        System.out.println("Book "+book);
        Map<String, Object> map = new HashMap<>();
        try {
            map.put(AppConstants.STATUS, Status.SUCCESS);
            map.put("book",bookService.updateBook(book) );
            return ResponseEntity.ok(map);
        }
        catch (RuntimeException e){
            map.put(AppConstants.STATUS, Status.FAILURE);
            map.put("error",e.getMessage());
            return ResponseEntity.badRequest().body(map);
        }
    }




    //Step 9: @DeleteMapping
    //1. To delete a book add below method:

    @DeleteMapping ("/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable int id){
        Map<String, Object> map = new HashMap<>();
        try {
            map.put(AppConstants.STATUS, Status.SUCCESS);
            if(bookService.deleteBook(id)) {
                map.put("message", "Book deleted successfully");
                return ResponseEntity.ok(map);
            }
        }
        catch (RuntimeException e){
            map.put(AppConstants.STATUS, Status.FAILURE);
            map.put("error",e.getMessage());
        }
        return ResponseEntity.badRequest().body(map);
    }


}