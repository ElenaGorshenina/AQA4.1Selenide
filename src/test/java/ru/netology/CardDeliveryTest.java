package ru.netology;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryTest {
    @Test
    void shouldTest() {
//        LocalDate today = LocalDate.now();
//        today.plusDays(4);
        open("http://localhost:9999");
        $("[placeholder='Город']").setValue("Санкт-Петербург");
        $("[data-test-id='date'] [type='tel']").setValue("21.09.2021");
        //$(withText("Дата встречи")).shouldBe(exist).setValue("21.09.2021");
        $("[name='name']").setValue("Елена");
        $("[name='phone']").setValue("+79345678931");
        $("[data-test-id='agreement']").click();
        $(byText("Запланировать")).click();
        $(".notification__title").shouldHave(exactText("Успешно!"));
    }
}
