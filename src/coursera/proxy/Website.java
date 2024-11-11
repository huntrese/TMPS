package coursera.proxy;

// Website class recreation for proxy package
public class Website {
    private final String header;
    private final String body;
    private final String footer;
    private final String logo;
    private final String developer;

    Website(RealWebsiteBuilder builder) {
        this.header = builder.getHeader();
        this.body = builder.getBody();
        this.footer = builder.getFooter();
        this.logo = builder.getLogo();
        this.developer = builder.getDeveloper();
    }

    @Override
    public String toString() {
        return String.format(
                """
                        %s
                        %s
                        %s
                        %s
                        %s
                        """,
                header, body, footer, logo, developer);
    }
}
