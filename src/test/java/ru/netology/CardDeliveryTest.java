package ru.netology;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryTest {

    String dateFormation(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @Test
    void shouldTest() {
        String dateMeeting = dateFormation(4);

        open("http://localhost:9999");
        $("[placeholder='Город']").setValue("Санкт-Петербург");
        $("[data-test-id='date'] [type='tel']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] [type='tel']").setValue(dateMeeting);
        $("[name='name']").setValue("Елена");
        $("[name='phone']").setValue("+79145678931");
        $("[data-test-id='agreement']").click();
        $(byText("Забронировать")).click();
        $(".notification__title").shouldHave(exactText("Успешно!"), Duration.ofSeconds(15));
        $(".notification__content").shouldHave(exactText("Встреча успешно забронирована на " + dateMeeting));
    }
}
