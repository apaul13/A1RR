package aoap.myapplication;

import android.content.Context;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.chauthai.swipereveallayout.SwipeRevealLayout;
import com.chauthai.swipereveallayout.ViewBinderHelper;


public class ViewReservationsActivity extends ListActivity {

    GlobalArrayList nameList = GlobalArrayList.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        nameList.add(new Reservation("Kim", "4:00", "Soup", "$3.00", "4"));
        nameList.add(new Reservation("John", "4:00", "Soup", "$3.00", "4"));



        setListAdapter(new ListAdapter());

      //  Log.i("test", "Before Button Initialization");

        LayoutInflater inflater = (LayoutInflater) ViewReservationsActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewGroup parent = findViewById(android.R.id.content);
        View view = inflater.inflate(R.layout.name_list, parent, false);

        Button homeButton = view.findViewById(R.id.home_button);
     //   Log.i("test", "After Button Initialization");

        View.OnClickListener homeListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toHome = new Intent(ViewReservationsActivity.this, MainActivity.class);
                startActivity(toHome);
            }
        };

        homeButton.setOnClickListener(homeListener);

        Intent intent = getIntent();
        String source = intent.getStringExtra("source");
        if (source == "mainActivity"){

        }
        else {
            String name = intent.getStringExtra("name");
            String time = intent.getStringExtra("time");
            String dish = intent.getStringExtra("dish");
            String price = intent.getStringExtra("table");
            String table = intent.getStringExtra("table");

            Reservation newReservation = new Reservation(name, time, dish, price, table);
            nameList.add(newReservation);

        }

        //setContentView(R.layout.name_list);
    }

    public class ListAdapter extends BaseAdapter {
        private LayoutInflater inflater;

        ViewBinderHelper binderHelper = new ViewBinderHelper();


        public Object getItem(int i) {
            return nameList.get(i);
        }

        public long getItemId(int i) {
            return i;
        }

        public int getCount() {
            return nameList.size();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            ViewHolder holder;
            final int pos = position;

            if (convertView == null) {
                if (inflater == null) inflater = (LayoutInflater) ViewReservationsActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.name_list, parent, false);

                holder = new ViewHolder();
                holder.name = convertView.findViewById(R.id.name_tv);
                holder.deleteView = convertView.findViewById(R.id.delete_button);
                holder.swipeLayout = convertView.findViewById(R.id.swipe_layout);

                convertView.setTag(holder);
            }
            else {
                holder = (ViewHolder) convertView.getTag();
            }

            final Reservation item = (Reservation) nameList.get(position);
            String nameString = item.getName();
            if (item != null){
                binderHelper.bind(holder.swipeLayout, nameString);

                holder.name.setText(nameString);
                holder.deleteView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nameList.remove(pos);
                        notifyDataSetChanged();
                    }
                });
            }


            return convertView;
        }
    }


}
