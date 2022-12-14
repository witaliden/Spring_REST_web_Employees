
import com.spring.mastery.dto.Employee;
import com.spring.mastery.dto.Gender;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Sandbox {
    public static void main(String[] args) {

        // Number list
        System.out.println("Random numbers:");
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            numbers.add(new Random().nextInt());
        }
        System.out.println(numbers);

        System.out.println("Positive numbers:");
        Set<Integer> l = numbers.stream().filter(integer -> integer > 0).collect(Collectors.toSet());
        System.out.println(l);


        }

/*        Set<Employee> streamSet = employeeSet*/

/*        Set<Employee> newSet = employeeSet.stream().filter(e -> e.getEmployeeID() > 4).collect(Collectors.toSet());
        newSet.stream().map(Employee::toString).forEach(System.out::println);
        System.out.println("[TreeSet] Random employees:");
        employeeSet.stream().map(Employee::toString).forEach(System.out::println);
        System.out.println("*****");
        System.out.println("[Hashmap] Random employees:");
        employeeMap.values().forEach(System.out::println);
        employeeMap.entrySet().forEach(System.out::println);
        System.out.println("*****");*/

/*        System.out.println("Employees with department ID 1-5:");
        employees.stream().filter(e -> e.getDepartmentID() < 5).forEach(System.out::println);
        System.out.println("*****");
        System.out.println("Job titles:");
        employees.stream().map(Employee::getJobTitle).forEach(System.out::println);
        System.out.println("*****");
        System.out.println("Min department ID");
        System.out.println(employees.stream().map(Employee::getDepartmentID).min(Integer::compare).get());
        System.out.println("Average department ID");
        System.out.println(employees.stream().mapToInt(Employee::getDepartmentID).average().getAsDouble());*/

//        System.out.println("[SET] Employees with department ID 1-5:");
//        employees.stream().filter(e -> e.getDepartmentID() < 5).forEach(System.out::println);
//        System.out.println("*****");
//        System.out.println("[SET] Job titles:");
//        employees.stream().map(Employee::getJobTitle).forEach(System.out::println);
//        System.out.println("*****");
//        System.out.println("[SET] Min department ID");
//        System.out.println(employees.stream().map(Employee::getDepartmentID).min(Integer::compare).get());
//        System.out.println("[SET] Average department ID");
//        System.out.println(employees.stream().mapToInt(Employee::getDepartmentID).average().getAsDouble());
}
