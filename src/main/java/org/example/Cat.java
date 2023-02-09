package org.example;

public class Cat {
    // Here we had to add a dependency called 'Dotenv' to get an environment variable from the system

    private String id;
    private String url;
    // The API Key given by the website (thecatapi.com) is stored in the environment variables for security
    private String apikey = System.getenv("CATS_API_KEY"); // With the getenv() method we get the apikey from the environment variables
    private String image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
