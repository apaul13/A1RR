package aoap.myapplication;

import android.app.Application;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Austin on 11/15/2017.
 */

public class GlobalArrayList extends Application {
    private ArrayList nameList;

    public GlobalArrayList(){
        nameList = new ArrayList();
    }

    /* public void sort(){
        Collections.sort(nameList);
    } */

    public int size() {
        return nameList.size();
    }

    public Object get(int position){
        return nameList.get(position);
    }

    public void remove(int position){
        nameList.remove(position);
    }

    public void add(Object o){
        nameList.add(o);
    }

    private static GlobalArrayList instance;

    public static GlobalArrayList getInstance(){
        if (instance == null) instance = new GlobalArrayList();
        return instance;
    }
}