package com.damasofc.tabby.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.damasofc.tabby.Models.Person;
import com.damasofc.tabby.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by damasofc on 11-16-17.
 */

public class MyAdapter extends BaseAdapter {
    private Context context;
    private	int	layout;
    private List<Person> persons;

    public MyAdapter(Context context, int layout, List<Person> persons) {
        this.context = context;
        this.layout = layout;
        this.persons = persons;
    }

    @Override
    public int getCount() {
        return this.persons.size();
    }

    @Override
    public Person getItem(int position) {
        return this.persons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder	holder;
        if	(convertView	==	null)	{
            LayoutInflater layoutInflater	=	LayoutInflater.from(this.context);
            convertView	=	layoutInflater.inflate(this.layout,	null);
            holder	=	new	ViewHolder();
            holder.name	=	(TextView)	convertView.findViewById(R.id.personName);
            holder.country	=	(TextView)	convertView.findViewById(R.id.countryName);
            holder.flag = (ImageView) convertView.findViewById(R.id.countryFlag);
            convertView.setTag(holder);
        }	else	{
            holder	=	(ViewHolder)	convertView.getTag();
        }
        Person person = persons.get(position);
        holder.name.setText(person.getName());
        holder.country.setText(person.getCountry().getName());
        Picasso.with(context).load(person.getCountry().getFlagUrl()).fit().into(holder.flag);
        return convertView;
    }

    static	class	ViewHolder	{
        private TextView name;
        private TextView country;
        private ImageView flag;
    }
}
