package com.example.doctorcatcher;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class GpsAdapter extends ArrayAdapter<String > {

    final Context context;
    private final String name[];
    final Integer img[];
    private final String  latitude[];
    private final String longitude[];

    public GpsAdapter(@NonNull Context context,  String name[],Integer img[], String latitude[], String longitude[])
    // public GpsAdapter(@NonNull Context context,  String name[],Integer img[])
    {
        super(context, R.layout.customlayout, name);

        this.context = context;
        this.name = name;
        this.img = img;
        this.latitude=latitude;
        this.longitude=longitude;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inf = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inf.inflate(R.layout.customlayout,null,true);

        TextView Cname= view.findViewById(R.id.textView);
        ImageView image= view.findViewById(R.id.imageView);
        TextView Clatitude= view.findViewById(R.id.textView30);
        TextView Clongitude= view.findViewById(R.id.textView31);

        Cname.setText(name[position]);
        image.setImageResource(img[position]);
        Clatitude.setText(latitude[position]);
        Clongitude.setText(longitude[position]);

        return view;

    }
}
