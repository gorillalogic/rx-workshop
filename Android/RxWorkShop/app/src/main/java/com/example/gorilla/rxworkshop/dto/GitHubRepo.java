package com.example.gorilla.rxworkshop.dto;

public class GitHubRepo {

    public int id;
    public String name;
    public String htmlUrl;
    public String description;
    public String language;
    public int stargazersCount;

    public GitHubRepo(int id, String name, String htmlUrl, String description, String language, int stargazersCount) {
        this.id = id;
        this.name = name;
        this.htmlUrl = htmlUrl;
        this.description = description;
        this.language = language;
        this.stargazersCount = stargazersCount;
    }
}
