package bernard.problem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MultiColumnsSorting {


    @Test
   public  void testSorting(){
        List<Employee> list = getList();
        System.out.println("before : "+list.toString());
        sortList(list);
        System.out.println("After: "+list.toString());
    }

    @Test
    public  void testSorting2(){

        List<Employee> list = getList();
        System.out.println("before : "+list.toString());
        //getList().stream().sorted((x,y) -> x.getName().compareTo(y.getName())).sorted((x,y)->x.getCity().compareTo(y.getCity()));
        //list=getList().stream().sorted(Comparator.comparing(Employee::getCity).thenComparing(Employee::getName)).collect(Collectors.toList());
        list=getList().stream().sorted(Comparator.comparing(Employee::getCity)).sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
        System.out.println("After: "+list.toString());
    }

    private List<Employee> sortList(List<Employee> list) {
        //list.sort(new NameComparator().thenComparing(new CityComparator()));
        //list.sort(new CityComparator().thenComparing(new NameComparator()));
        list.sort(new CityComparator().thenComparing(new NameComparator()));
        return list;
    }



    List<Employee> getList(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("B","Amar"));
        list.add(new Employee("B","Ching"));
        list.add(new Employee("B","Bob"));
        list.add(new Employee("A","Babar"));
        list.add(new Employee("A","Zoya"));
        list.add(new Employee("A","Amit"));
     //   list.add(new Employee("C",null));
        return  list;
    }



}

class NameComparator implements Comparator<Employee>{
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
class CityComparator implements Comparator<Employee>{
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getCity().compareTo(o2.getCity());
    }
}
class Employee{
    String name;
    String city;

    public Employee(String city,String name) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

