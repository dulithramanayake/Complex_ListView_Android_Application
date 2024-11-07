package com.example.complex_listview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /*
        Steps
        1) Create string resources
        2) Create single item row design
        3)Create a class and extend ArrayAdapter<String>
        4) Create a constructor and override method

        Steps
        5) Override getView method
        6) Inflate the single row design
        7) Get references to the item in single row and return the view
        8) Create lisView in activity and get references to that listView
        9) Create object of Adapter
        10) Set adapter to the listView
     */

    ListView listView;


    String title[]={"Dulith Ramanayake","Jhone Doe","Alexa Redolf","Thomas Mishel","Mary Munro","Jhone","Bosco",
    "Lary Roy"};

    String description []={"0743579754","65287539","2179287","87456","8563","92736373383",
    "98279","908230"};

    int image[]={R.drawable.a, R.drawable.b, R.drawable.c,R.drawable.d, R.drawable.e, R.drawable.f, R.drawable.g, R.drawable.i };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listview);
        CustomAdapter adapter=new CustomAdapter(this,title,image,description);
        listView.setAdapter(adapter);
    }
}
class CustomAdapter extends ArrayAdapter<String>{


    Context context;
    String[] title;
    String[] des;

    int[] images;

    CustomAdapter(Context context, String [] title,int[] images, String[] des){
        super(context,R.layout.single_row,R.id.title1,title);
        this.context=context;
        this.images=images;
        this.title=title;
        this.des=des;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View row=inflater.inflate(R.layout.single_row,parent,false);

        ImageView imageView=row.findViewById(R.id.imageView);
        TextView titleView=row.findViewById(R.id.title1);
        TextView descriptionView=row.findViewById(R.id.description);

        imageView.setImageResource(images[position]);
        titleView.setText(title[position]);
        descriptionView.setText(des[position]);

        return row;
    }
}