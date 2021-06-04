package bernard.collections;

import org.junit.Test;

import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.stream.Stream;

public class TreeMapTest {


    @Test
    public void testTreeMap(){
        TreeMap<Employee,String> tree = new TreeMap<>(new EmpComparator());

        tree.put(new Employee(2,"b"),"B");
        tree.put(new Employee(3,"C"),"C");
        tree.put(new Employee(1,"A"),"A");

        tree.keySet().stream().forEach(x-> System.out.println(tree.get(x)));
    }

    static class EmpComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
                return o1.id-o2.id;
        }
    }

    static class Employee{
        int id;
        String name;

        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return id == employee.id &&
                    Objects.equals(name, employee.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }


        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
