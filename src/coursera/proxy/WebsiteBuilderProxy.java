package coursera.proxy;

// Proxy implementation with formatting logic
public class WebsiteBuilderProxy implements IWebsiteBuilder {
    private final RealWebsiteBuilder realBuilder;

    public WebsiteBuilderProxy() {
        this.realBuilder = new RealWebsiteBuilder();
    }

    @Override
    public IWebsiteBuilder header(String header) {
        String formattedHeader = formatHeader(header);
        realBuilder.header(formattedHeader);
        return this;
    }

    @Override
    public IWebsiteBuilder body(String body) {
        String formattedBody = formatBody(body);
        realBuilder.body(formattedBody);
        return this;
    }

    @Override
    public IWebsiteBuilder setFooter(String footer) {
        String formattedFooter = formatFooter(footer);
        realBuilder.setFooter(formattedFooter);
        return this;
    }

    @Override
    public IWebsiteBuilder setLogo(String logo) {
        String formattedLogo = formatLogo(logo);
        realBuilder.setLogo(formattedLogo);
        return this;
    }

    @Override
    public IWebsiteBuilder setDeveloper(String developer) {
        String formattedDeveloper = formatDeveloper(developer);
        realBuilder.setDeveloper(formattedDeveloper);
        return this;
    }

    @Override
    public Website build() {
        return realBuilder.build();
    }

    // Formatting methods
    private String formatHeader(String header) {
        return String.format("""
                ================================
                %s
                ================================
                """, header.toUpperCase());
    }

    private String formatBody(String body) {
        return String.format("""
                Content:
                ---------------------------------
                %s
                ---------------------------------
                """, body);
    }

    private String formatFooter(String footer) {
        return String.format("""
                _________________________________
                %s
                _________________________________
                """, footer);
    }

    private String formatLogo(String logo) {
        return String.format("""
                [LOGO]
                <%s>
                [/LOGO]
                """, logo);
    }

    private String formatDeveloper(String developer) {
        return String.format("Developed by: %s", developer);
    }
}
