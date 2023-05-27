import Base.BaseLib;
import Pages.LoginPage;
import Pages.MainPage;
import Pages.RegisterPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.testng.annotations.Test;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class RegisterTest extends BaseLib {

    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();

    @Before
    public void setup() {
        Configuration.browser = "chrome";
        Selenide.open("https://parabank.parasoft.com/parabank/index.htm");
        getWebDriver().manage().window().maximize();
    }

    @Test
    public void TC0001() {
        String username = "testqa" + rondomNumber();

        loginPage
                .register();

        registerPage
                .fillFirstName()
                .fillLastName()
                .fillAddress()
                .fillCity()
                .fillState()
                .fillZipCode()
                .fillPhoneNumber()
                .fillSSN()
                .fillUserName(username)
                .fillPassword()
                .fillConfirm()
                .Register();


        String welcomeText = mainPage.getWelcomeUserName();
        Assert.assertEquals(welcomeText, "Welcome " + username);

        mainPage
                .userNameController("Test QA")
                .leftMenuSelect("Open New Account")
                .leftMenuSelect("Accounts Overview")
                .leftMenuSelect("Log Out");

        loginPage
                .fillUserName(username)
                .fillPassword("test123")
                .login();

        mainPage
                .userNameController("Test QA");
    }


    @Test
    public void TC0002() {
        String username = "testqa" + rondomNumber();

        loginPage
                .register();

        registerPage
                .fillFirstName()
                .fillLastName()
                .fillAddress()
                .fillCity()
                .fillState()
                .fillZipCode()
                .fillPhoneNumber()
                .fillSSN()
                .fillUserName(username)
                .fillPassword()
                .fillConfirm()
                .Register();


        String welcomeText = mainPage.getWelcomeUserName();
        Assert.assertEquals(welcomeText, "Welcome " + username);

        mainPage
                .userNameController("Test QA");
    }


    @After
    public void tearDown() {
        Selenide.closeWindow();
    }

}
