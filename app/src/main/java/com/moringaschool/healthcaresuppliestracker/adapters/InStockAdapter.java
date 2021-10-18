package com.moringaschool.healthcaresuppliestracker.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.healthcaresuppliestracker.R;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class InStockAdapter extends RecyclerView.Adapter<InStockAdapter.ViewHolder> implements Filterable {
    private static final String TAG = "InStockAdapter";
    List<String> stockList;
    List<String> stockListAll;

    public InStockAdapter(List<String> stockList){
        this.stockList = stockList;
        this.stockListAll = new ArrayList<>(stockList);
    }


    @NonNull
    @Override
    public InStockAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.fragment_in_stock, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.rowCountTextView.setText(String.valueOf(position));
        holder.textView.setText(stockList.get(position));

    }

    @Override
    public int getItemCount() {
        return stockList.size();
    }


    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<String> filteredList = new ArrayList<>();

            if (charSequence.toString().isEmpty()) {
                filteredList.addAll(stockListAll);
            }else {
                for (String stock: stockListAll){
                    if (stock.toLowerCase().contains(charSequence.toString().toLowerCase())){
                        filteredList.add(stock);
                    }
                }
            }

            FilterResults filterResults =  new FilterResults();
            filterResults.values = filteredList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            stockList.clear();
            stockList.addAll((Collection<? extends String>) filterResults.values);
            notifyDataSetChanged();

        }
    };

    public class ViewHolder extends RecyclerView.ViewHolder {
        public BreakIterator rowCountTextView;
        public BreakIterator textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
