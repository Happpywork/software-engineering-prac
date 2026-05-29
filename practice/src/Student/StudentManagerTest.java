package Student;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentManagerTest {

    private static StudentManager manager;

    
    @BeforeAll
    static void setUp() {
        manager = new StudentManager();
    }
    
    @Order(1)
    @Test
    @DisplayName("학생 추가 성공 테스트")
    void testAddStudent() {
        String studentName = "김철수";
        manager.addStudent(studentName);

        assertTrue(manager.hasStudent(studentName));
    }

    @Order(2)
    @Test
    @DisplayName("학생 제거 성공 테스트")
    void testRemoveStudent() {
    	String studentName = "김철수";
    	
        manager.removeStudent(studentName);
        
        assertFalse(manager.hasStudent(studentName));
    }

    @Order(3)
    @Test
    @DisplayName("중복 학생 추가 시 예외 발생 테스트")
    void testAddDuplicateStudentThrowsException() {
        String studentName = "박민수";
        manager.addStudent(studentName);

       assertThrows(IllegalArgumentException.class, () -> {
            manager.addStudent(studentName);
        });
    }

    @Order(4)
    @Test
    @DisplayName("존재하지 않는 학생 제거 시 예외 발생 테스트")
    void testRemoveNonExistentStudentThrowsException() {
        String studentName = "박철수";

        assertThrows(IllegalArgumentException.class, () -> {
            manager.removeStudent(studentName);
        });

    }
}