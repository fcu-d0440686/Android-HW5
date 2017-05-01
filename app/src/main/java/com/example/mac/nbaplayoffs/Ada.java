package com.example.mac.nbaplayoffs;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by MAC on 2017/5/2.
 */

public class Ada extends ArrayAdapter<Game> {
    private Context context;

    public Ada(Context context, List objects){
        super(context,0,objects);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater in = LayoutInflater.from(context);
        LinearLayout item = null;
        if(convertView ==null){
            item =(LinearLayout)in.inflate(R.layout.layout,null);
        }
        else
            item =(LinearLayout)convertView;
        Game game =(Game)getItem(position);

        ImageView hostlogo = (ImageView)item.findViewById(R.id.imageView7);
        hostlogo.setImageResource(game.hostlogo);
        TextView hostname = (TextView)item.findViewById(R.id.textView1);
        hostname.setText(game.hostname);
        TextView hostscore = (TextView)item.findViewById(R.id.textView2);
        hostscore.setText(game.hostscore);
        ImageView guestlogo = (ImageView)item.findViewById(R.id.imageView8);
        guestlogo.setImageResource(game.guestlogo);
        TextView guestname = (TextView)item.findViewById(R.id.textView3);
        guestname.setText(game.guestname);
        TextView guestscore = (TextView)item.findViewById(R.id.textView4);
        guestscore.setText(game.guestscore);

        if(Integer.parseInt(game.hostscore)>Integer.parseInt(game.guestscore))
            hostscore.setTextColor(Color.RED);
        else
            guestscore.setTextColor(Color.RED);

        return  item;
    }



}
