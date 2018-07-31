package com.example.bohdan.weatherbitweather;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.bohdan.weatherbitweather.databinding.CustomBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class Adapternew extends RecyclerView.Adapter<Adapternew.ViewHolder> {

    public LayoutInflater inflater;

    public List<Datum> listDatum;

    public Adapternew(List<Datum> listDatum) {
        this.listDatum = listDatum;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public CustomBinding customBinding;

        public ViewHolder(CustomBinding customBinding) {
            super(customBinding.getRoot());
            this.customBinding = customBinding;
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        if (listDatum != null && !listDatum.isEmpty()) {
            return listDatum.size();
        }
        return 0;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        CustomBinding customBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.custom, parent, false);
        ViewHolder viewHolder = new ViewHolder(customBinding);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.customBinding.setModelFor(listDatum.get(position));

        long timeInMilliseconds = listDatum.get(position).getTs();
        String forcastdayname = formatDateTime(timeInMilliseconds);

        holder.customBinding.textView.setText(forcastdayname);


    }

    private static String formatDateTime(long timeInMilliseconds) {

        String dateFormat = "dd-MM-yyyy HH:mm";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat, Locale.ENGLISH);
    /*    GregorianCalendar calendar = new GregorianCalendar(TimeZone.getTimeZone("US/Central"));
        //Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeInMilliseconds);*/
        return simpleDateFormat.format(new Date(timeInMilliseconds * 1000));

        //return simpleDateFormat.format(calendar.getTime()*1000);
   /*
        SimpleDateFormat formatter = new SimpleDateFormat(("E"), Locale.ENGLISH);
        return formatter.format(new Date(timeInMilliseconds * 1000));*/
    }

}
