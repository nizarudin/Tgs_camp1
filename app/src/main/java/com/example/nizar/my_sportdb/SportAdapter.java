package com.example.nizar.my_sportdb;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SportAdapter extends ArrayAdapter<Sport> {
    private List<Sport> sportList;
    private Context context;

    public SportAdapter( List<Sport> sportList,Context context) {
        super(context,R.layout.activity_sport_item,sportList);
        this.sportList = sportList;
        this.context = context;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,  @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View ListViewItem = inflater.inflate(R.layout.activity_sport_item,null,true);
        CircleImageView imageView = (CircleImageView) ListViewItem.findViewById(R.id.imgAnime);
        TextView tvSport = (TextView)ListViewItem.findViewById(R.id.tvSport);
//        TextView descrip = (TextView)ListViewItem.findViewById(R.id.tvdescrip);

        Sport itemSport = sportList.get(position);

        Glide.with(context).load(itemSport.getStrSportThumb()).into(imageView);
        tvSport.setText(itemSport.getStrSport());
//        descrip.setText(itemSport.getStrSportDescription());

        return ListViewItem;

    }
}
