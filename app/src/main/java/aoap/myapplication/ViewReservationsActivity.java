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
import android.widget.ListView;

import com.chauthai.swipereveallayout.ViewBinderHelper;


public class ViewReservationsActivity extends ListActivity {

    GlobalArrayList nameList = GlobalArrayList.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        nameList.add(new Reservation("Kim", "4:00", "Soup", "$3.00", "4"));
        nameList.add(new Reservation("John", "4:00", "Soup", "$3.00", "4"));

        setListAdapter(new ListAdapter());

        Intent intent = getIntent();
        String source = intent.getStringExtra("source");
        if (source.equals("timeName")){
            String name = intent.getStringExtra("name");
            String time = intent.getStringExtra("time");
            String dish = intent.getStringExtra("dish");
            String price = intent.getStringExtra("price");
            String table = intent.getStringExtra("table");

            Reservation newReservation = new Reservation(name, time, dish, price, table);
            nameList.add(newReservation);
        }
        else {
            //List is not updated
        }

        //setContentView(R.layout.name_list);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent toDetails = new Intent(ViewReservationsActivity.this, DetailsActivity.class);
        final Reservation item = (Reservation) nameList.get(position);

        toDetails.putExtra("name", item.getName());
        toDetails.putExtra("time", item.getTime());
        toDetails.putExtra("dish", item.getDish());
        toDetails.putExtra("price", item.getPrice());
        toDetails.putExtra("table", item.getTable());

        startActivity(toDetails);
    }


    class ListAdapter extends BaseAdapter {
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
                holder.homeView = convertView.findViewById(R.id.home_button);
                holder.detailsView = convertView.findViewById(R.id.details_button);

                convertView.setTag(holder);
            }
            else {
                holder = (ViewHolder) convertView.getTag();
            }

            final Reservation item = (Reservation) nameList.get(position);
            String nameString = item.getName();
            String posString = item.toString();

            if (item != null){
               binderHelper.bind(holder.swipeLayout, posString);

                holder.name.setText(nameString);
                holder.deleteView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nameList.remove(pos);
                        notifyDataSetChanged();
                    }
                });

                holder.homeView.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Intent toHome = new Intent(ViewReservationsActivity.this, MainActivity.class);
                        startActivity(toHome);
                    }
                });

                holder.detailsView.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent toDetails = new Intent(ViewReservationsActivity.this, DetailsActivity.class);
                        final Reservation item = (Reservation) nameList.get(pos);

                        toDetails.putExtra("name", item.getName());
                        toDetails.putExtra("time", item.getTime());
                        toDetails.putExtra("dish", item.getDish());
                        toDetails.putExtra("price", item.getPrice());
                        toDetails.putExtra("table", item.getTable());

                        startActivity(toDetails);
                    }
                });
            }

            return convertView;
        }
    }


}
