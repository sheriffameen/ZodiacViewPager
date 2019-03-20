package com.example.viewpagerappfromscratch;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends FragmentActivity implements Callback<ZodiacResponse> {
    final List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getZodiacs();


    }

    private void getZodiacs() {
        Call<ZodiacResponse> zodiacResponseCall = ZodiacClient.getInstance().getZodiacResponse();
        zodiacResponseCall.enqueue(this);
    }

    @Override
    public void onResponse(Call<ZodiacResponse> call, Response<ZodiacResponse> response) {
        ZodiacResponse zodiacResponse = response.body();
        List<Zodiac> zodiacList = zodiacResponse.getZodiac();

        for (Zodiac zodiac : zodiacList) {
            ZodiacFragment zodiacFragment = ZodiacFragment.newInstance(zodiac.getName(), zodiac.getNumber(), zodiac.getImage());
            fragmentList.add(zodiacFragment);
        }

        ViewPager viewPager = findViewById(R.id.mainActivity_viewPager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), fragmentList));


    }

    @Override
    public void onFailure(Call<ZodiacResponse> call, Throwable t) {

    }
}
