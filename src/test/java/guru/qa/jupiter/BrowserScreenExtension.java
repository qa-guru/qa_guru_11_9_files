package guru.qa.jupiter;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BrowserScreenExtension implements
//        TestExecutionExceptionHandler,
        TestWatcher,
        AfterEachCallback {

//    @Override
//    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
//        byte[] screenshot = ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
//        // add to allure
//        throw throwable;
//    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        WebDriverRunner.getWebDriver().close();
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        byte[] screenshot = ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
//      add to allure
    }

}
