package execution.core;

/**
 * Builder pattern — collects every knob for a driver run in one place.
 *
 * Reads from system properties so Gradle / CI can pass values without
 * touching source code:
 *
 *   ./gradlew test -Dbrowser=chrome -Dheadless=true -Dremote=true -DgridUrl=http://grid:4444
 *
 * All fields have sensible defaults so tests work out-of-the-box.
 */
public class DriverConfig {

    public enum Browser { CHROME, FIREFOX, EDGE }

    private final Browser browser;
    private final boolean headless;
    private final boolean remote;
    private final String  gridUrl;

    // ------------------------------------------------------------------ //
    //  Private constructor — always built through the Builder             //
    // ------------------------------------------------------------------ //
    private DriverConfig(Builder b) {
        this.browser  = b.browser;
        this.headless = b.headless;
        this.remote   = b.remote;
        this.gridUrl  = b.gridUrl;
    }

    // ------------------------------------------------------------------ //
    //  Factory method — reads system properties (Gradle -D flags)         //
    // ------------------------------------------------------------------ //
    public static DriverConfig fromSystemProperties() {
        return new Builder()
                .browser (System.getProperty("browser",  "firefox"))
                .headless(System.getProperty("headless", "false"))
                .remote  (System.getProperty("remote",   "false"))
                .gridUrl (System.getProperty("gridUrl",  "http://localhost:4444"))
                .build();
    }

    // ------------------------------------------------------------------ //
    //  Accessors                                                          //
    // ------------------------------------------------------------------ //
    public Browser getBrowser()  { return browser;  }
    public boolean isHeadless()  { return headless;  }
    public boolean isRemote()    { return remote;    }
    public String  getGridUrl()  { return gridUrl;   }

    @Override
    public String toString() {
        return String.format("DriverConfig{browser=%s, headless=%b, remote=%b, gridUrl=%s}",
                browser, headless, remote, gridUrl);
    }

    // ------------------------------------------------------------------ //
    //  Builder                                                            //
    // ------------------------------------------------------------------ //
    public static class Builder {

        private Browser browser  = Browser.FIREFOX;
        private boolean headless = false;
        private boolean remote   = false;
        private String  gridUrl  = "http://localhost:4444";

        /** Accepts the string value coming from -Dbrowser=chrome */
        public Builder browser(String value) {
            this.browser = Browser.valueOf(value.toUpperCase().trim());
            return this;
        }

        public Builder browser(Browser value) {
            this.browser = value;
            return this;
        }

        /** Accepts "true" / "false" string coming from -Dheadless=true */
        public Builder headless(String value) {
            this.headless = Boolean.parseBoolean(value);
            return this;
        }

        public Builder headless(boolean value) {
            this.headless = value;
            return this;
        }

        public Builder remote(String value) {
            this.remote = Boolean.parseBoolean(value);
            return this;
        }

        public Builder remote(boolean value) {
            this.remote = value;
            return this;
        }

        public Builder gridUrl(String value) {
            this.gridUrl = value;
            return this;
        }

        public DriverConfig build() {
            if (remote && (gridUrl == null || gridUrl.isBlank())) {
                throw new IllegalStateException("gridUrl must be set when remote=true");
            }
            return new DriverConfig(this);
        }
    }
}
