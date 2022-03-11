package com.example.bookstore.View;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.bookstore.R;
import com.example.bookstore.Tasks.DownloadImageTask;

import org.jetbrains.annotations.NotNull;

public class BasketAdapter extends
		RecyclerView.Adapter<BasketAdapter.BasketItemViewHolder>
{
	static class BasketItemViewHolder extends RecyclerView.ViewHolder
	{
		ImageView bookImage;
		TextView bookName;
		TextView bookPrice;
		
		public BasketItemViewHolder(@NotNull View itemView)
		{
			super(itemView);
			
			bookImage = itemView.findViewById(R.id.bookImage);
			bookName = itemView.findViewById(R.id.bookName);
			bookPrice = itemView.findViewById(R.id.bookPrice);
		}
	}
	
	private final Book[] books;
	
	public BasketAdapter(Book[] books)
	{
		this.books = books;
	}
	
	@Override
	public int getItemCount()
	{
		return books.length;
	}
	
	@Override
	@NotNull
	public BasketItemViewHolder onCreateViewHolder(@NotNull ViewGroup parent,int viewType)
	{
		LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
		
		return new BasketItemViewHolder(layoutInflater.inflate(R.layout.list_item_basket, parent, false));
	}
	
	@Override
	public void onBindViewHolder(@NotNull BasketItemViewHolder viewHolder, int position)
	{
		Book book = books[position];
		
		new DownloadImageTask(viewHolder.bookImage).execute(book.getImageUrl());
		viewHolder.bookName.setText(book.getName());
		viewHolder.bookPrice.setText(Integer.toString(book.getPrice()));
	}
}
