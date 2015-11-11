package com.thejango.androidpallatedemo;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.graphics.Palette;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by ashwani on 11/11/15.
 */
public class SwatchListAdapter extends BaseAdapter {

    private Context context;
    private Resources res;
    private List<Palette.Swatch> data;

    public SwatchListAdapter(Context context, Resources resources, List<Palette.Swatch> data){
        this.context = context;
        this.res = resources;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.swatch_list_row,null);
        }

        ViewHolder holder = new ViewHolder();
        holder.population = (TextView) v.findViewById(R.id.population);
        holder.rgb = (TextView) v.findViewById(R.id.rgb);
        holder.layout = (LinearLayout) v.findViewById(R.id.swatchListRow);

        Palette.Swatch swatch = data.get(position);
        holder.population.setText("Population : "+swatch.getPopulation());
        holder.rgb.setText("RGB : "+swatch.getRgb());
        holder.layout.setBackgroundColor(swatch.getRgb());
        return v;
    }

    private static class ViewHolder{
        TextView population;
        TextView rgb;
        LinearLayout layout;

    }
}
