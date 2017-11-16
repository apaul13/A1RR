package aoap.myapplication;

import android.content.Context;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import com.chauthai.swipereveallayout.SwipeRevealLayout;
import com.chauthai.swipereveallayout.ViewBinderHelper;

import java.util.ArrayList;

public class ViewReservationsActivity extends ListActivity {

    GlobalArrayList nameList = GlobalArrayList.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.name_list);
        setListAdapter(new ListAdapter());

        //Intent intent =
    }




    ///

    public class ListAdapter extends BaseAdapter {
        private LayoutInflater inflater;
        private ViewBinderHelper binderHelper;

       /* public ListAdapter(Context context, ArrayList<String> items) {
            inflater = LayoutInflater.from(context);
            binderHelper = new ViewBinderHelper();
        } */

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
                    }
                });
            }


            return convertView;
        }
    }


}
