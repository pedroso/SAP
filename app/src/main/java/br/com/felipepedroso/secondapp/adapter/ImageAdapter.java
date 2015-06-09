package br.com.felipepedroso.secondapp.adapter;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.felipepedroso.secondapp.R;

/**
 * Created by Felipe on 14/05/2015.
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return this.mThumbIds[position];
    }

    public long getItemId(int position) {
        return 0;
    }

    // Create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;
        // if it's not recycled, initialize some attributes
        if (convertView == null) {
            textView = new TextView(mContext);
            // Center crop image
            //imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            textView = (TextView) convertView;
        }
        // Set images into ImageView
        textView.setText(String.valueOf(position + 1));
        textView.setBackgroundResource(mThumbIds[position]);
        textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        return textView;
    }

    // References to our images in res > drawable
    public Integer[] mThumbIds = { R.drawable.mesa, R.drawable.mesa,
            R.drawable.mesa, R.drawable.mesa, R.drawable.mesa,
            R.drawable.mesa, R.drawable.mesa, R.drawable.mesa,
            R.drawable.mesa, R.drawable.mesa, R.drawable.mesa,
            R.drawable.mesa, R.drawable.mesa, R.drawable.mesa,
            R.drawable.mesa, R.drawable.mesa, R.drawable.mesa,
            R.drawable.mesa, R.drawable.mesa };
}
