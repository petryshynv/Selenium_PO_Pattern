package consts;

import java.security.SecureRandom;

public class BusinessConfigs {

    public enum page {

        HOME_PAGE_URL("http://167.71.33.250:8080/shop/");

        private String url;

        page(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }
    }

    public enum userInputs {
        EMAIL("petryshyn.v@gmail.com"),
        INCORRECT_EMAIL("petryshyn@gmail.com"),
        PASSWORD("123456"),
        INCORRECT_PASSWORD("111111");

        private String input;

        userInputs(String input) {
            this.input = input;
        }

        public String getInput() {
            return input;
        }
    }

    public static String randomString(int len) {
        final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        final SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }
}

