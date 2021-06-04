package bernard.java8.practices;

import org.junit.Test;

import java.time.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaTraining {


    @Test
    public void testPalindrom(){

        Predicate<String> isPalindrom = x -> {
            int length= x.length();
            StringBuilder sb = new StringBuilder();
            for (int i =length-1 ; i >= 0 ;i--) {
                sb.append(x.charAt(i));
            }
            return sb.toString().equalsIgnoreCase(x);
        };

        String[] array = new String[]{"aba","abc","abba"};


        List<String> result = Arrays.stream(array).filter(isPalindrom).collect(Collectors.toList());

        result.stream().forEach(System.out::println);
    }

    @Test
    public void testSquareAndReduce(){

        List<Integer> list = Arrays.asList(12, 13, 7, 4, 8, 9, 3, 2, 4, 1, 5, 6);

        Predicate<? super Integer> isEven= x -> x%2==0;
        Function<? super Integer, Integer> squre= x -> x*x;
        Integer result = list
                //.stream()
                .parallelStream()
                //.filter(x -> x%2==0)
                .filter(isEven)
                //.map(x -> x*x)
                .map(squre)
                .reduce(0, (a, b) -> a + b);

        System.out.println("result : "+result);
    }

    @Test
    public void testStream(){

        int result = IntStream.of(10, 13, 12, 15, 19, 20).findFirst().getAsInt();
        System.out.println("result "+ result);
        Stream<Integer> integerStream = IntStream.of(10, 13, 12, 15, 19, 20).boxed();

        IntStream.range(0,20).forEach(x->System.out.println(x));
    }

    @Test
    public  void employeeStreamTest(){

        //getPersonList().stream().filter(x->x.getGender().equals("M")).forEach(System.out::println);

        getPersonList().stream().filter(x->x.getGender().equals("M")).map(x-> x.getName()).forEach(System.out::println);

        String result = getPersonList().stream()
                .map(Person::getName)
                .collect(Collectors.joining(", "));
        System.out.println( "result : "+result);

        System.out.println("result:  "+getPersonList().stream()
                .collect(Collectors.partitioningBy(x->x.getGender().equalsIgnoreCase("M"))));

    }

    @Test
    public void testDateApi(){
        LocalDate date = LocalDate.now();
        LocalTime date4 = LocalTime.now();
        LocalDateTime date2 = LocalDateTime.now();
        ZonedDateTime date3 = ZonedDateTime.now();
        System.out.println("date : "+date);
        System.out.println("date2 : "+date2);
        System.out.println("date3 : "+date3);
        System.out.println("date4 : "+date4);

        System.out.println("EST : "+ZonedDateTime.of(date3.toLocalDateTime(), ZoneId.of("-05:00")));

        LocalDateTime dob = LocalDateTime.of(1989, 9, 21,9,33);
        LocalDateTime pinudob = LocalDateTime.of(1994, 8, 30,0,55);
        LocalDateTime pinu_off_dob = LocalDateTime.of(1995, 5, 30,0,55);
        LocalDateTime off_dob = LocalDateTime.of(1990, 6, 20,9,33);

        Period period = Period.between(dob.toLocalDate(), date);
        Period period1 = Period.between(off_dob.toLocalDate(), date);
        Period period2 = Period.between(dob.toLocalDate(), off_dob.toLocalDate());

        Period period3 = Period.between(pinudob.toLocalDate(), date);
        Period period4 = Period.between(pinu_off_dob.toLocalDate(), date);
        Period period5 = Period.between(pinudob.toLocalDate(), pinu_off_dob.toLocalDate());

        System.out.println("actual : "+period.getYears()+"years : "+period.getMonths()+" months  :"+period.getDays()+" days");
        System.out.println("actual : "+period1.getYears()+"years : "+period1.getMonths()+" months  :"+period1.getDays()+" days");
        System.out.println("actual : "+period2.getYears()+"years : "+period2.getMonths()+" months  :"+period2.getDays()+" days");


        System.out.println("pinu actual : "+period3.getYears()+"years : "+period3.getMonths()+" months  :"+period3.getDays()+" days");
        System.out.println("pinu ofiicial : "+period4.getYears()+"years : "+period4.getMonths()+" months  :"+period4.getDays()+" days");
        System.out.println("pinu diff : "+period5.getYears()+"years : "+period5.getMonths()+" months  :"+period5.getDays()+" days");

        Properties p = new Properties();


    }


    public List<Person> getPersonList(){
        List<Person> list = new ArrayList<>();
        Person p1 = new Person("A",1,25,"M");
        Person p2 = new Person("B",2,17,"F");
        Person p3 = new Person("C",3,28,"M");
        Person p4 = new Person("D",4,40,"F");
        Person p5 = new Person("E",5,26,"M");
        Person p6 = new Person("F",6,45,"F");
        Person p7 = new Person("G",7,60,"M");
        Person p8 = new Person("H",8,8,"F");
        Person p9 = new Person("I",9,10,"M");
        Person p10 = new Person("J",10,11,"F");
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);
        list.add(p7);
        list.add(p8);
        list.add(p9);
        list.add(p10);
        return list;
    }





    class Person{
        private String name;
        private int id;
        private int age;
        private String gender;
        private List<Integer> phoneNumbers;
        private String city;
        private String country;

        public Person(String name, int id, int age, String gender) {
            this.name = name;
            this.id = id;
            this.age = age;
            this.gender = gender;
            phoneNumbers=new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public List<Integer> getPhoneNumbers() {
            return phoneNumbers;
        }

        public void setPhoneNumbers(List<Integer> phoneNumbers) {
            this.phoneNumbers.addAll(phoneNumbers);
        }

        public void addPhoneNumber(Integer phoneNumber) {
            this.phoneNumbers.add(phoneNumber);
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    ", age=" + age +
                    ", gender='" + gender + '\'' +
                    ", phoneNumbers=" + phoneNumbers +
                    ", city='" + city + '\'' +
                    ", country='" + country + '\'' +
                    '}';
        }
    }

}
