package com.markef.braincard;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

    private Context context;

    public  ImageAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() { return 12; }

    @Override
    public Object getItem(int position) { return null; }

    @Override
    public long getItemId(int position) { return 0; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView;

        final Animation pulse = AnimationUtils.loadAnimation(context,R.anim.pulse_card);

        if(convertView == null){
            imageView = new ImageView(this.context);
            imageView.setLayoutParams(new GridView.LayoutParams(350,350));
            imageView.startAnimation(pulse);
        }
        else imageView = (ImageView)convertView;
        imageView.setImageResource(R.drawable.dorsal);
        imageView.startAnimation(pulse);
        return imageView;
    }
}
