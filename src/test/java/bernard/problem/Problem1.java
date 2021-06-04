package bernard.problem;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem1 {

    public void test(){
        List<String> books= Arrays.asList("A","B","C","D");
        List<Employee> empList=new ArrayList<>();
        Employee e1= new Employee();
        e1.setBooks(Arrays.asList(new Book("A"),new Book("B")));
        Employee e2= new Employee();
        e2.setBooks(Arrays.asList(new Book("C"),new Book("D")));
        empList.add(e1);
        empList.add(e2);
;        Assert.assertEquals(books,getBooks(empList));

    }

    private List<String> getBooks(List<Employee> empList) {
        List<String> books = empList.stream().flatMap(x -> x.getBooks().stream()).map(y -> y.getBookName()).collect(Collectors.toList());
       return books;
    }


   static  class Employee {
        List<Book> books;
        public List<Book> getBooks() {
            return books;
        }

        public void setBooks(List<Book> books) {
            this.books = books;
        }
    }

    static class Book{

        String bookName;
        Book(String name){
            bookName=name;
        }

        public String getBookName() {
            return bookName;
        }

        public void setBookName(String bookName) {
            this.bookName = bookName;
        }
    }


}
