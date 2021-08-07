import driver.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.logging.Logger;

import static consts.DriversConfigs.*;

public class BaseTest {
    private Logger LOG = Logger.getLogger(String.valueOf(BaseTest.class));
    private Test test;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method method){
       DriverFactory.initDriver(browsers.CHROME);

        LOG = Logger.getLogger(String.valueOf(method.getDeclaringClass()));
        test = method.getAnnotation(Test.class);
        LOG.info(String.format("Test '%s' started.", method.getName()));
        LOG.info(String.format("Description: '%s'.", test.description()));
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(final Method method){
        LOG.info(String.format("Test '%s' completed.", method.getName()));
        DriverFactory.quitDriver();
    }

}
