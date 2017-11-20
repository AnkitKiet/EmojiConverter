package edu.texttoemoji.retrofit;

/**
 * Created by Ankit on 02/11/17.
 */


import java.util.List;

import edu.texttoemoji.model.EmojiResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface SOService {

    @GET("/SubhrajyotiSen/EmojiAPI/master/emoji.json")
    Call<List<EmojiResponse>> getEmojis();

}