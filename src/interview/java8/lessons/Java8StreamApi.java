package interview.java8.lessons;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8StreamApi {

    public static void main(String[] args) {
//        final Collection<Integer> list = Arrays.asList(3, 8, 1, 5, 9, 12, 81);
//        final Collection<Integer> list = Arrays.asList(1, 2, 3, 4, 1, 2, 3);

        Student student1 = new Student("Student1", 21, 1);
        Student student2 = new Student("Student2", 22, 1);
        Student student3 = new Student("Student3", 23, 2);
        Student student4 = new Student("Student4", 24, 3);
        List<Student> students = Arrays.asList(student1, student2, student3, student4);

//        Collection<Integer> result = sorted(list);
//        Integer result = reduce(list);
//        Integer result = methodChaining(list);
//        concat();
//        List<Integer> result = distinct(list);
//        long result = count(list);
//        long result = peek(list);
//        Collection result = flatMap();
//        mapVsPeek();

//        Object result = groupingBy();
//        Object result = partitioningBy(students);
//        Student result = minMax(students);
//        limit(students);
//        List<Student> result = skip(students);
        List<Integer> result = mapToInt(students);

        System.out.println(result);
    }

    /* list = Arrays.asList(3, 8, 1, 5, 9, 12, 81); */
    private static <E> Collection<E> sorted(Collection<E> collection) {
//        return collection.stream().sorted().collect(Collectors.toList());
        return collection.stream().sorted(Comparator.comparing(e -> e.hashCode())).collect(Collectors.toList()); // [1, 3, 5, 8, 9, 12, 81]
//        return collection.stream().sorted(Comparator.comparing(e -> e.toString())).collect(Collectors.toList()); // [1, 12, 3, 5, 8, 81, 9]
    }

    /* list = Arrays.asList(3, 8, 1, 5, 9, 12, 81); */
    private static Integer reduce(Collection<Integer> collection) {
        return collection.stream().reduce((accumulator, element) -> accumulator * element).get(); // 1049760
    }

    private static Integer methodChaining(Collection<Integer> collection) {
        return collection.stream().filter(e -> (e % 2) == 1).reduce((a, e) -> a + e).get();
    }

    private static void concat() {
        Stream<Integer> stream1 = Stream.of(1, 2, 3);
        Stream<Integer> stream2 = Stream.of(4, 5, 6);
        Stream<Integer> result = Stream.concat(stream1, stream2);
        result.forEach(System.out::println);
    }

    private static List<Integer> distinct(Collection<Integer> collection) {
        return collection.stream().distinct().collect(Collectors.toList());
    }

    private static long count(Collection<Integer> collection) {
//        java.lang.IllegalStateException: stream has already been operated upon or closed
//        Stream stream = collection.stream();
//        long count = stream.count();
//        return stream.distinct().count();

        return collection.stream().distinct().count();
    }

    private static long peek(Collection<Integer> collection) {
        return collection.stream().distinct().peek(System.out::println).reduce((a, c) -> a + c).get();
    }

    private static List<Object> flatMap() {
        Student student1 = new Student("Student1");
        Student student2 = new Student("Student2");
        Student student3 = new Student("Student3");
        Student student4 = new Student("Student4");

        Faculty faculty1 = new Faculty("Economics");
        Faculty faculty2 = new Faculty("Mathematics");

        faculty1.addStudent(student1);
        faculty1.addStudent(student2);
        faculty2.addStudent(student3);

        List<Faculty> faculties = Arrays.asList(faculty1, faculty2);

        return faculties.stream().flatMap(f -> f.getStudents().stream()).collect(Collectors.toList());
    }

    private static void mapVsPeek() {
        Student student1 = new Student("Student1");
        List<Student> target = Collections.singletonList(student1);
//        List<Student> map = target.stream().map(s -> s).collect(Collectors.toList());
        List<Student> map = target.stream().map(s -> new Student(s.getName())).collect(Collectors.toList()); // new student
        List<Student> peek = target.stream().peek(s -> {}).collect(Collectors.toList()); // same student
        System.out.println(map.get(0) == peek.get(0));
    }

    private static Object groupingBy(Collection<Student> students) {
        Map<Integer, List<Student>> studentsMap = students.stream().collect(Collectors.groupingBy(s -> s.getCourse()));
        return studentsMap;
    }

    private static Object partitioningBy(Collection<Student> students) {
        Map<Boolean, List<Student>> studentsMap = students.stream().collect(Collectors.partitioningBy(s -> s.getAge() > 22));
        return studentsMap;
    }

    private static Student findFirst(Collection<Student> students) {
        return students.stream().findFirst().get();
    }

    private static Student minMax(Collection<Student> students) {
//        return students.stream().min(((o1, o2) -> o1.getAge() - o2.getAge())).get();
//        return students.stream().min((Comparator.comparingInt(Student::getAge))).get();

        return students.stream().max((Comparator.comparingInt(Student::getAge))).get();
    }

    private static List<Student> limit(Collection<Student> students) {
        return students.stream().limit(2).collect(Collectors.toList());
    }

    private static List<Student> skip(Collection<Student> students) {
        return students.stream().skip(2).collect(Collectors.toList());
    }

    private static List<Integer> mapToInt(Collection<Student> students) {
        return students.stream().mapToInt(s -> s.getAge())
                .boxed()    // int -> Integer
                .collect(Collectors.toList());
    }

    static class Student {
        String name;
        int age;
        int course;

        Student(String name) {
            this.name = name;
        }

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Student(String name, int age, int course) {
            this.name = name;
            this.age = age;
            this.course = course;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public int getCourse() {
            return course;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    static class Faculty {
        String name;
        List<Student> students = new ArrayList<>();

        Faculty(String name) {
            this.name = name;
        }

        public List<Student> getStudents() {
            return students;
        }

        public void addStudent(Student student) {
            this.students.add(student);
        }
    }

}
