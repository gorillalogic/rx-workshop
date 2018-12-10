package com.example.gorilla.rxworkshop.networking;

import com.example.gorilla.rxworkshop.dto.GitHubRepo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface GitHubService {

    @GET("users/{user}/starred")
    Observable<List<GitHubRepo>> getStarredRepositories(@Path("user") String userName);

    //Create new Observable from "users/{user}/repos" endpoint. It returns a List<GitHubRepo> per user.
}
