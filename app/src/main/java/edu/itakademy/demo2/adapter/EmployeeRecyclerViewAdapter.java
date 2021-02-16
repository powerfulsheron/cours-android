package edu.itakademy.demo2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.itakademy.demo2.R;
import edu.itakademy.demo2.entity.Employee;

public class EmployeeRecyclerViewAdapter extends RecyclerView.Adapter<EmployeeRecyclerViewAdapter.ViewHolder> {

    private List<Employee> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mItemClickListener;

    public EmployeeRecyclerViewAdapter(Context context, List<Employee> data){
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.item_employee, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String employeeFullName = mData.get(position).getFullName();
        holder.myTextView.setText(employeeFullName);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView myTextView;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.employeeFullName);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view){
            if (mItemClickListener != null) mItemClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    public int getItem(int position){
        return  mData.get(position).getId();
    }

    public void setClickListener(ItemClickListener itemClickListener){
        this.mItemClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

}
