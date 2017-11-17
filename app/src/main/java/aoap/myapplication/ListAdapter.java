package aoap.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import com.chauthai.swipereveallayout.SwipeRevealLayout;
import com.chauthai.swipereveallayout.ViewBinderHelper;

import java.util.ArrayList;

/**
 * Created by Austin on 11/15/2017.
 */

public class ListAdapter  {
  /*  private final LayoutInflater inflater;
    private final ViewBinderHelper binderHelper;

    public ListAdapter(Context context, ArrayList<String> items) {
        super(context, R.layout.name_list, items);
        inflater = LayoutInflater.from(context);
        binderHelper = new ViewBinderHelper();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.name_list, parent, false);

            holder = new ViewHolder();
            holder.name = convertView.findViewById(R.id.name_tv);
            holder.deleteView = convertView.findViewById(R.id.delete);
            holder.swipeLayout = (SwipeRevealLayout) convertView.findViewById(R.id.swipe_layout);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        Reservation item = getItem(position);
        if (item != null){
            binderHelper.bind(holder.swipeLayout, item);

            holder.name.setText(item);
            holder.deleteView.setOnClickListener();
        }


        return convertView;
    } */
}
