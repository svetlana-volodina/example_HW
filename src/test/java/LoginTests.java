import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTests {
	@AfterEach
	void  closeWebDriver(){
		Selenide.closeWebDriver();
	}

	@Test
	void successfulLoginTest() {
		open("https://school.qa.guru/");
		$("[name=email]").setValue("qagurubot@gmail.com").pressEnter();
		$("[name=password]").setValue("somepasshere").pressEnter();

		$("[class=page-header]").shouldHave(text("Список тренингов"));

	}

	@Test
	void negativeLoginTest() {
		open("https://school.qa.guru/");
		$("[name=email]").setValue("qagurubot@gmail.com").pressEnter();
		$("[name=password]").setValue("kjsdgdfdgf").pressEnter();

		$("[id=xdget33092_1]").shouldHave(text("Не заполнено поле пароль"));

	}

	@Test
	void emptyLoginTest() {
		open("https://school.qa.guru/");
		$("[name=email]").setValue("").pressEnter();
		$("[name=password]").setValue("kjsdgdfdgf").pressEnter();

		$("[id=xdget33092_1]").shouldHave(text("Не заполнено поле E-Mail"));

	}

	@Test
	void emptyPasswordTest() {
		open("https://school.qa.guru/");
		$("[name=email]").setValue("qagurubot@gmail.com").pressEnter();
		$("[name=password]").setValue("").pressEnter();

		$("[id=xdget33092_1]").shouldHave(text("Не заполнено поле Пароль"));

	}
}