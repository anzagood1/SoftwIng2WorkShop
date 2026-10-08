package workshop;

import java.util.*;
import java.util.logging.Logger;
import java.util.logging.Level;

class Student {
    String id;
    String name;
    List<Float> grades;
    String pass = "unknown";
    boolean honor;

    Logger logger = Logger.getLogger(Student.class.getName());

    public Student(String name, String id) {
        this.id = id;
        this.name = name;
        grades = new ArrayList<Float>();
    }

    public void addGrade(float g) {
        if (g >= 0 && g <= 100) {
            grades.add(g);
        } else {
            logger.log(Level.WARNING, "Invalid grade: {0}", g);
        }
    }

    public void removeGrade(int index){
        if (index >= 0 && index < grades.size()) {
            grades.remove(index);
        } else {
            logger.log(Level.WARNING, "Invalid index: {0}", index);
        }
    }

    public char average() {
        float total = 0;
        for (Float g : grades) {
            total += g; // ClassCastException
        }
        float average = total / grades.size();
        logger.log(Level.INFO, "Average grade: {0}", average);

        if (average >= 90) return 'A';
        if (average >= 80) return 'B';
        if (average >= 70) return 'C';
        if (average >= 60) return 'D';
        return 'F';
    }

    public void checkHonorStatus() {
        if (average() == 'A') {
            honor = true;   
        }
    }

    public void isPassed() {
        if (average() == 'F') {
            pass = "Fail";
        } else {
            pass = "Pass";
        }
    }

    public void reportCard() {
        logger.log(Level.INFO, "Reporting card for: {0}", name);
        logger.log(Level.INFO, "Student: {0}", name);
        logger.log(Level.INFO, "ID: {0}", id);
        logger.log(Level.INFO, "Grades #: {0}", grades.size());
        logger.log(Level.INFO, "Average: {0}", average());
        logger.log(Level.INFO, "Honor Roll: {0}", honor);
        logger.log(Level.INFO, "Pass: {0}", pass);
    }
}

public class Main {
    public static void main() {
        Student s = new Student("abc", null);
        s.addGrade(100);
        s.addGrade(90);
        s.average();
        s.checkHonorStatus();
        s.removeGrade(9);
        s.reportCard();
    }
}
