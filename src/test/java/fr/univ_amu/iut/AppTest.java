package fr.univ_amu.iut;

import javafx.stage.Stage;
import org.junit.jupiter.api.*;
import org.testfx.framework.junit5.ApplicationTest;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.util.NodeQueryUtils.hasText;

@Disabled
public class AppTest extends ApplicationTest {

    @Disabled
    @Test
    public void should_initialize_button_with_text_click() {
        // then:
        verifyThat("#buttonClick", hasText("Click !"));
    }

    @Disabled
    @Test
    public void should_increment_nbClick_when_click_on_button() {
        // when:
        clickOn("#buttonClick");

        // then:
        verifyThat("#buttonClick", hasText("1"));
    }

    @Disabled
    @Test
    public void should_increment_nbClick_when_click_on_button_again() {
        // when:
        clickOn("#buttonClick").clickOn("#buttonClick");

        // then:
        verifyThat("#buttonClick", hasText("2"));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        new App().start(primaryStage);
    }
}
