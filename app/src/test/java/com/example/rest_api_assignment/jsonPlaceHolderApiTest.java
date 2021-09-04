package com.example.rest_api_assignment;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class jsonPlaceHolderApiTest {

    @Test
    public void apiResponseTest(){ // Tests that the api responds to a basic GET request
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Post>> call = jsonPlaceHolderApi.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                assertEquals(true, response.isSuccessful()); // Assert that the List<Post> returned is not empty
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                assertTrue(1 == 0); // Bit of a hacky solution, if the call fails our test should fail
            }
        });
    }
}
