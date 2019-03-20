package com.example.viewpagerappfromscratch;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class ZodiacFragment extends Fragment {

    private static final String NAME_KEY = "name key";
    private static final String NUMBER_KEY = "number key";
    private static final String IMAGE_KEY = "image key";
    private String name;
    private String number;
    private String image;
    private TextView nameTextView;
    private TextView numberTextView;
    private ImageView imageTextView;



    public ZodiacFragment() {
        // Required empty public constructor
    }


    public static ZodiacFragment newInstance(String name, String number, String image) {
        ZodiacFragment fragment = new ZodiacFragment();
        Bundle args = new Bundle();
        args.putString(NAME_KEY, name);
        args.putString(NUMBER_KEY, number);
        args.putString(IMAGE_KEY, image);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(NAME_KEY);
            number = getArguments().getString(NUMBER_KEY);
            image = getArguments().getString(IMAGE_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_zodiac, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        nameTextView = view.findViewById(R.id.name_textView);
        numberTextView = view.findViewById(R.id.number_textViewNumber);
        imageTextView = view.findViewById(R.id.image_imageview);


        nameTextView.setText(name);
        numberTextView.setText(number);
        Picasso.get().load(image).into(imageTextView);
    }
}
