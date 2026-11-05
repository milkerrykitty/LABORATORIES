package laba2;
import java.util.List;

public class StudentSort implements Sorting<Student>
{
    @Override
    public void sort(List<Student> students) {
        for (int i = 1; i < students.size(); i++) {
            Student current = students.get(i);
            int j = i;
            for (; j > 0 && students.get(j-1).getAge() > current.getAge(); j--)
            {
                students.set(j, students.get(j-1));
            }
            students.set(j,current);
        }

        for (int i = 1; i < students.size(); i++) {
            Student current = students.get(i);
            int j = i;
            for (; j > 0 && students.get(j-1).getName().compareTo(current.getName()) > 0; j--)
            {
                students.set(j, students.get(j-1));
            }
            students.set(j,current);
        }
    }
}
