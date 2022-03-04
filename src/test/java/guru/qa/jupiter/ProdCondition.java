package guru.qa.jupiter;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

public class ProdCondition implements ExecutionCondition {
    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
        if (System.getProperty("env", "null").equals("prod")) {
            return ConditionEvaluationResult.enabled("Тест запущен!");
        } else {
            return ConditionEvaluationResult.disabled("Тест только для прода :( ");
        }
    }
}
