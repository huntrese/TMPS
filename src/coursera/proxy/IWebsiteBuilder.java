package coursera.proxy;

// Base interface for Website Builder
public interface IWebsiteBuilder {
    IWebsiteBuilder header(String header);
    IWebsiteBuilder body(String body);
    IWebsiteBuilder setFooter(String footer);
    IWebsiteBuilder setLogo(String logo);
    IWebsiteBuilder setDeveloper(String developer);
    Website build();
}

