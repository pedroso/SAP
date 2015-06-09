package br.com.felipepedroso.secondapp.menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.felipepedroso.secondapp.R;
import br.com.felipepedroso.secondapp.adapter.ImageAdapter;

/**
 * Created by Felipe on 14/05/2015.
 */
public class ItemGridViewActivity extends Activity {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            // Get the view from singleitemview.xml
            setContentView(R.layout.item_grid_view);

            // Get position from intent passed from MainActivity.java
            Intent i = getIntent();

            Integer position = i.getExtras().getInt("id");

            // Open the Image adapter
            ImageAdapter imageAdapter = new ImageAdapter(this);

            // Locate the ImageView in single_item_view.xml
            //ImageView imageView = (ImageView) findViewById(R.id.image);
            TextView textView = (TextView) findViewById(R.id.txtNumMesa);

            textView.setText("P-" + position.toString());
            //textView.setBackgroundResource(imageAdapter.mThumbIds[position]);
            // Get image and position from ImageAdapter.java and set into ImageView
            //imageView.setImageResource(imageAdapter.mThumbIds[position]);
        }
}
