package base;

import org.testng.annotations.BeforeSuite;
import static java.lang.System.setProperty;

/**
 * Created by vasuha on 25.01.2019.
 */
public abstract class SeleniumBase {

    @BeforeSuite
    public void beforeSuite() {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }
    }

