package org.servDroid.web;

import org.servDroid.preference.AccessPreferences;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

import android.app.Activity;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;

public class AdFrame {

	private static AdView adView;
	private static String MY_AD_UNIT_ID = "";

	public static void load(ViewGroup layout, Activity context) {
		if (AccessPreferences.getShowAds()) {
			if (adView == null) {
				adView = new AdView(context, AdSize.BANNER, MY_AD_UNIT_ID);
				adView.setVisibility(View.VISIBLE);
				layout.setVisibility(View.VISIBLE);
				layout.invalidate();

				AdRequest request = new AdRequest();
				// request.addTestDevice("028841c3435f5057");
				adView.loadAd(request);
				layout.addView(adView);
			}
		} else if (adView != null) {
			adView.setVisibility(View.INVISIBLE);
			layout.setVisibility(View.INVISIBLE);
			layout.invalidate();
		}
	}

}
