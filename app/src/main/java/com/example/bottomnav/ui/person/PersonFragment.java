package com.example.bottomnav.ui.person;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.bottomnav.Login;
import com.example.bottomnav.MainActivity;
import com.example.bottomnav.R;
import com.example.bottomnav.webview;

import java.util.HashMap;

public class PersonFragment extends Fragment {

    private PersonViewModel mViewModel;
    SliderLayout sliderLayout;
    View root;
    Button btn,btnsign;


    public static PersonFragment newInstance() {
        return new PersonFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel =
                ViewModelProviders.of(this).get(PersonViewModel.class);
        root = inflater.inflate(R.layout.person_fragment, container, false);
        sliderLayout = root.findViewById(R.id.sliderLayout);
        btn=root.findViewById(R.id.btnacc);
        btnsign=root.findViewById(R.id.btnlogin);
        loadpic();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent webi=new Intent(root.getContext(), webview.class);
                startActivity(webi);
            }
        });

        btnsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sign=new Intent(root.getContext(), Login.class);
                startActivity(sign);
            }
        });

        return root;
    }

    private void loadpic() {

        HashMap<String,Integer> sliderImages = new HashMap<>();
        sliderImages.put("Great Indian Deal",R.drawable.hotel1);
        sliderImages.put("New Deal Every Hour",R.drawable.hotel11);
        sliderImages.put("Appliances Sale", R.drawable.setsel1);
        sliderImages.put("UnBox snapdeal",R.drawable.setsel2);
        sliderImages.put("Great Deals", R.drawable.setsel4);

        for (String name : sliderImages.keySet()) {

            TextSliderView textSliderView = new TextSliderView(root.getContext());
            textSliderView
                    .description(name)
                    .image(sliderImages.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);
            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(3000);

    }

}
