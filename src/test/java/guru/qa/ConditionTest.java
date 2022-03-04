package guru.qa;

import guru.qa.jupiter.OnlyProdEnv;
import org.junit.jupiter.api.Test;

public class ConditionTest {

    @Test
    void first() {

    }

    @OnlyProdEnv
    @Test
    void second() {

    }
}
