package org.example;

import io.github.cdimascio.dotenv.Dotenv;

public class Cat {
    // Here we had to add a dependency called 'Dotenv' to get an environment variable from the system
    public Dotenv dotenv = Dotenv.load();

    private int id;
    private String url;
    private String apikey = dotenv.get("CATS_API_KEY"); // With the get method we get the apikey from the environment variables
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
