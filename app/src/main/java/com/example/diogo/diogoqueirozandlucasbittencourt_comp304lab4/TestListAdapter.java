package com.example.diogo.diogoqueirozandlucasbittencourt_comp304lab4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TestListAdapter extends RecyclerView.Adapter<TestListAdapter.MyViewHolder>
{
    private ArrayList<Test> testList;
    private OnCardListener mOnCardListener;
    Context context;

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public TextView BPH;
        public TextView BPL;
        public TextView temperature;
        OnCardListener onCardListener;

        public MyViewHolder(View itemView, OnCardListener onCardListener)
        {
            super(itemView);
            temperature = itemView.findViewById(R.id.textView_temperature_list);
            BPH = itemView.findViewById(R.id.textView_BPH_list);
            BPL = itemView.findViewById(R.id.textView_BPL_list);
            this.onCardListener = onCardListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v)
        {
            onCardListener.onCardClick(getAdapterPosition());
        }
    }

    public interface OnCardListener
    {
        void onCardClick(int position);
    }

    public TestListAdapter(Context context, ArrayList<Test> testsList, OnCardListener onCardListener)
    {
        this.testList = testsList;
        this.context = context;
        this.mOnCardListener = onCardListener;
    }

    @Override
    public TestListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_test_list_item, parent, false);

        return new MyViewHolder(v, mOnCardListener);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position)
    {

        // replace the contents of the layout_listitem view with elements from data set
        holder.temperature.setText(testList.get(position).getTemperature());
        holder.BPH.setText(testList.get(position).getBPH());
        holder.BPL.setText(testList.get(position).getBPL());

    }

    @Override
    public int getItemCount()
    {
        return testList.size();
    }


}
