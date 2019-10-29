package uc.benkkstudio.nativeme;



import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.ads.nativetemplates.NativeTemplateStyle;
import com.google.android.ads.nativetemplates.TemplateView;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.formats.UnifiedNativeAd;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TemplateView my_template = findViewById(R.id.my_template);

        AdLoader adLoader = new AdLoader.Builder(this, getString(R.string.admob_native_unit_id))
                .forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
                    @Override
                    public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
                        NativeTemplateStyle styles = new NativeTemplateStyle.Builder()
                                .setSecondaryTextColor(getResources().getColor(R.color.colorAccent))
                                .setPrimaryTextColor(getResources().getColor(R.color.colorAccent))
                                .build();
                        my_template.setStyles(styles);
                        my_template.setNativeAd(unifiedNativeAd);
                    }
                })
                .build();
        adLoader.loadAd(new AdRequest.Builder().build());
    }
}
