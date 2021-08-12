package consts;

public class DriversConfigs {
    public enum browsers {

        FIREFOX("webdriver.gecko.driver",
                "src\\main\\resources\\geckodriver.exe"),

        CHROME("webdriver.chrome.driver",
                "src\\main\\resources\\chromedriver.exe");

        private final String property;
        private final String path;

        browsers(String property, String path) {
            this.property = property;
            this.path = path;
        }

        public String getProperty() {
            return property;
        }

        public String getPath() {
            return path;
        }
    }

    public enum waitersValue {
        IMPLICIT_WAIT_VALUE(10),
        EXPLICIT_WAIT_VALUE(20);

        private final int value;

        waitersValue(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}

