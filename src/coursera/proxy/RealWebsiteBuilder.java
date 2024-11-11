package coursera.proxy;

// Real builder implementation
public class RealWebsiteBuilder implements IWebsiteBuilder {
    private String header;
    private String body;
    private String footer;
    private String logo;
    private String developer;

    @Override
    public IWebsiteBuilder header(String header) {
        this.header = header;
        return this;
    }

    @Override
    public IWebsiteBuilder body(String body) {
        this.body = body;
        return this;
    }

    @Override
    public IWebsiteBuilder setFooter(String footer) {
        this.footer = footer;
        return this;
    }

    @Override
    public IWebsiteBuilder setLogo(String logo) {
        this.logo = logo;
        return this;
    }

    @Override
    public IWebsiteBuilder setDeveloper(String developer) {
        this.developer = developer;
        return this;
    }

    @Override
    public Website build() {
        validate();
        return new Website(this);
    }

    private void validate() {
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
    }

    // Getters for Website class
    public String getHeader() {
        return header;
    }

    public String getBody() {
        return body;
    }

    public String getFooter() {
        return footer;
    }

    public String getLogo() {
        return logo;
    }

    public String getDeveloper() {
        return developer;
    }
}
