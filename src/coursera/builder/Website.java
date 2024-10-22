package coursera.builder;

public class Website {

    private String header;
    private String body;
    private String footer;
    private String logo;
    private String developer;

    private Website(WebsiteBuilder builder) {
        this.header = builder.header;
        this.body = builder.body;
        this.footer = builder.footer;
        this.logo = builder.logo;
        this.developer = builder.developer;
    }

    public static final class WebsiteBuilder {
        private String header;
        private String body;
        private String footer;
        private String logo;
        private String developer;

        public WebsiteBuilder header(String header) {
            this.header = header;
            return this;
        }

        public WebsiteBuilder body(String body) {
            this.body = body;
            return this;
        }

        public WebsiteBuilder setDeveloper(String developer) {
            this.developer = developer;
            return this;
        }

        public WebsiteBuilder setFooter(String footer) {
            this.footer = footer;
            return this;
        }

        public WebsiteBuilder setLogo(String logo) {
            this.logo = logo;
            return this;
        }

        public Website build() {
            if (header == null) {
                throw new IllegalStateException("Site should have a header");
            }
            if (body == null) {
                throw new IllegalStateException("Site should have a body");
            }
            if (footer == null) {
                throw new IllegalStateException("Site should have a footer");
            }
            if (logo == null) {
                throw new IllegalStateException("Site should have a logo");
            }
            if (developer == null) {
                throw new IllegalStateException("Site should have a developer");
            }
            return new Website(this); // Return new Website object
        }
    }

    @Override
    public String toString() {
        return String.format(
                """
                Website:
                    header= %s
                    body= %s
                    footer= %s
                    logo= %s
                    developer= %s
                """,
                header, body, footer, logo, developer);
    }
}
