package cucumberPractice.smartbearsoftware.assessment.utilities;

import cucumberPractice.smartbearsoftware.assessment.pages.LoginPage;
import cucumberPractice.smartbearsoftware.assessment.pages.WebOrdersPage;

public class Pages {

    private WebOrdersPage webOrdersPage;
    private LoginPage loginPage;

    public Pages() {
        this.webOrdersPage = new WebOrdersPage();
        this.loginPage = new  LoginPage();
    }

    public WebOrdersPage getWebOrdersPage() {
        return webOrdersPage;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }
}