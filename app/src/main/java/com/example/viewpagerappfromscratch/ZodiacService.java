package com.example.viewpagerappfromscratch;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * https://raw.githubusercontent.com/JDVila/storybook/master/zodiac.json
 */
public interface ZodiacService {
    @GET("JDVila/storybook/master/zodiac.json")
    Call<ZodiacResponse>getZodiacs();

}
