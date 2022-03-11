package com.example.bookstore.Tasks;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;

public class DownloadImageTask extends
		AsyncTask<String, Void, Bitmap>
{
	private final ImageView bitmapImageView;
	
	public DownloadImageTask(ImageView bitmapImageView)
	{
		this.bitmapImageView = bitmapImageView;
	}
	
	protected Bitmap doInBackground(String... urls)
	{
		Bitmap bitmap = null;
		
		try
		{
			InputStream inputStream = new java.net.URL(urls[0]).openStream();
			bitmap = BitmapFactory.decodeStream(inputStream);
		}
		catch (Exception e)
		{
			Log.e("Error", e.getMessage());
			e.printStackTrace();
		}
		
		return bitmap;
	}
	
	protected void onPostExecute(Bitmap result)
	{
		bitmapImageView.setImageBitmap(result);
	}
}
