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

        setListAdapter(new ListAdapter());

        Intent getTimeNameIntent = getIntent();
        Bundle bdTimeName = getTimeNameIntent.getExtras();
        String source = (String) bdTimeName.get("source");
        if (source.equals("timeName")){

            final String tableNum = (String) bdTimeName.get("tab");
            final String dish = (String) bdTimeName.get("dish");
            final String dishPrice = (String) bdTimeName.get("dishPrice");
            final String name = (String) bdTimeName.get("name");
            final String time = (String) bdTimeName.get("time");

            Reservation newReservation = new Reservation(name, time, dish, dishPrice, tableNum);
            nameList.add(newReservation);
        }
        else {
            //List is not updated
        }

        //setContentView(R.layout.name_list);
    }


    //ListAdapter class that includes SwipeRevealLayout API functionality
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
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            final Reservation item = (Reservation) nameList.get(position);
            String nameString = item.getName();
            String posString = item.toString();

            if (item != null){
                //bind the swipeLayout with the position of the item being swiped
               binderHelper.bind(holder.swipeLayout, posString);

                holder.name.setText(nameString);

                //delete reservation
                holder.deleteView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nameList.remove(pos);
                        notifyDataSetChanged(); //let the list know that it has been updated
                    }
                });

                //go back to MainActivity
                holder.homeView.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Intent toHome = new Intent(ViewReservationsActivity.this, MainActivity.class);
                        startActivity(toHome); //
                    }
                });

                //get details of the reservation
                holder.detailsView.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent toDetails = new Intent(ViewReservationsActivity.this, DetailsActivity.class);
                        final Reservation item = (Reservation) nameList.get(pos);

                        toDetails.putExtra("name", item.getName());
                        toDetails.putExtra("time", item.getTime());
                        toDetails.putExtra("dish", item.getDish());
                        toDetails.putExtra("dishPrice", item.getPrice());
                        toDetails.putExtra("tab", item.getTable());

                        startActivity(toDetails);
                    }
                });
            }
            return convertView;
        }
    }


}
