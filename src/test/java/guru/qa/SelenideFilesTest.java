package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import guru.qa.jupiter.BrowserExtension;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThat;

@BrowserExtension
public class SelenideFilesTest {

    @Test
    void selenideDownloadTest() throws Exception {
        Selenide.open("https://github.com/junit-team/junit5/blob/main/README.md");
        File downloadedFile = Selenide.$("#raw-url").download();
        try (InputStream is = new FileInputStream(downloadedFile)) {
            assertThat(new String(is.readAllBytes(), UTF_8)).contains("This repository is the home of the next generation of JUnit");
        }
    }

    @Test
    void uploadSelenideTest() {
        Selenide.open("https://the-internet.herokuapp.com/upload");
        Selenide.$("input[type='file']")
//                .uploadFile(new File("/Users/dmitriituchs/IdeaProjects/qa_guru/qa_guru_11_9_files/src/test/resources/files/1.txt")); // bad practice!
                .uploadFromClasspath("files/1.txt");
        Selenide.$("#file-submit").click();
        Selenide.$("div.example").shouldHave(Condition.text("File Uploaded!"));
        Selenide.$("#uploaded-files").shouldHave(Condition.text("1.txt"));
    }
}
