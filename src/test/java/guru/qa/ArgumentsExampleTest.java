package guru.qa;

import guru.qa.domain.Teacher;
import guru.qa.jupiter.TeacherFile;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ArgumentsExampleTest {

    @CsvSource(value = {
            "1, true",
            "2, false"
    })
    @ParameterizedTest
    void paramTest(int first, boolean second) {
        System.out.println(String.valueOf(first) + second);
    }

    @ValueSource(strings = {"dima.json", "stas.json"})
    @ParameterizedTest
    void apiParamTest(@TeacherFile Teacher teacher) throws Exception {
        // в реальности будем отправлять обьект teacher куда-нибудь в апи
        System.out.println(teacher.toString());
    }
}
