package com.app.upperside;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by apple on 01/04/16.
 */
public class ListBaseAdapter extends BaseAdapter {


    Context context;

    ArrayList<Bean> bean;
    Typeface fonts1,fonts2;





    public ListBaseAdapter(Context context, ArrayList<Bean> bean) {


        this.context = context;
        this.bean = bean;
    }


    @Override
    public int getCount() {
        return bean.size();
    }

    @Override
    public Object getItem(int position) {
        return bean.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        fonts1 =  Typeface.createFromAsset(context.getAssets(),
                "fonts/Lato-Light.ttf");

        fonts2 = Typeface.createFromAsset(context.getAssets(),
                "fonts/Lato-Regular.ttf");

        ViewHolder viewHolder = null;

        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list,null);

            viewHolder = new ViewHolder();

            viewHolder.newsimage2 = (ImageView)convertView.findViewById(R.id.newsimage2);
//            viewHolder.time = (TextView)convertView.findViewById(R.id.time);
            viewHolder.news = (TextView)convertView.findViewById(R.id.news);
            viewHolder.newssub = (TextView)convertView.findViewById(R.id.newssub);
            viewHolder.click=(LinearLayout)convertView.findViewById(R.id.click);




//            viewHolder.time.setTypeface(fonts1);
            viewHolder.news.setTypeface(fonts2);
            viewHolder.newssub.setTypeface(fonts1);

            viewHolder.click.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context,Detail_Activity.class);
                    context.startActivity(intent);
                }
            });

            convertView.setTag(viewHolder);


        }else {

            viewHolder = (ViewHolder)convertView.getTag();
        }

        Bean bean = (Bean)getItem(position);

        viewHolder.newsimage2.setImageResource(bean.getNewsimage2());
//        viewHolder.time.setText(bean.getTime());
        viewHolder.news.setText(bean.getNews());
        viewHolder.newssub.setText(bean.getNewssub());

        return convertView;
    }

    private class ViewHolder{

        LinearLayout click;
        ImageView newsimage2;
//        TextView time;
        TextView news;
        TextView newssub;






    }
}

