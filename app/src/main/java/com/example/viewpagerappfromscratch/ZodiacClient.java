package com.example.viewpagerappfromscratch;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * https://raw.githubusercontent.com/JDVila/storybook/master/zodiac.json
 */
public class ZodiacClient {
    private static final String BASE_URL = "https://raw.githubusercontent.com/";
    private static ZodiacClient instance;
    private Retrofit retrofit;


    public static ZodiacClient getInstance(){
        if (instance == null){
            instance = new ZodiacClient();
        }
        return instance;
    }

    private ZodiacClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
    }

    private ZodiacService getZodiacService(){
        return retrofit.create(ZodiacService.class);
    }

    public  Call<ZodiacResponse> getZodiacResponse(){
        return getZodiacService().getZodiacs();
    }


}
