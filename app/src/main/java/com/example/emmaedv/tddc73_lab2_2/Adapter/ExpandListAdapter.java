package com.example.emmaedv.tddc73_lab2_2.Adapter;

import com.example.emmaedv.tddc73_lab2_2.Classes.ExpandListChild;
import com.example.emmaedv.tddc73_lab2_2.Classes.ExpandListGroup;
import com.example.emmaedv.tddc73_lab2_2.R;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

/**
 * Created by emmaedv on 04/12/14.
 */
public class ExpandListAdapter extends BaseExpandableListAdapter{
    private Context context;
    private ArrayList<ExpandListGroup> groups;
    private List<String> arrayListNames;
    private int groupId, childId;

    //Constructor
    public ExpandListAdapter(Context theContext, ArrayList<ExpandListGroup> theGroups){
        this.context = theContext;
        this.groups = theGroups;
    }

    //Funktion för att sätta senaste barnet
    public void setIds(int grId, int chId){
        groupId = grId;
        childId = chId;
    }

    public void addItem(ExpandListChild theItem, ExpandListGroup theGroup){
        //If group doesn't exist in groups, add it!
        if(!groups.contains(theGroup)){
            groups.add(theGroup);
        }

        //add item to child
        int index = groups.indexOf(theGroup);
        ArrayList<ExpandListChild> child = groups.get(index).getItems();
        child.add(theItem);
        groups.get(index).setItems(child);
    }

    public Object getChild(int groupPosition, int childPosition){
        //Get the list that contains child
        ArrayList<ExpandListChild> childList = groups.get(groupPosition).getItems();

        //Return the correct child
        return childList.get(childPosition);
    }

    public long getChildId(int groupPosition, int childPosition){
        return childPosition;
    }

    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup parent){

        ExpandListChild child = (ExpandListChild) getChild(groupPosition, childPosition);
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.expandlist_child_item, null);
        }
//        Log.e("CHILD id:" + childId + " position:" + childPosition, "GROUP id: " + groupId + ", position: " + groupPosition);

        if(childPosition == childId && groupPosition == groupId){
            view.setBackgroundResource(R.color.ClickedItem);
        }
        else {
            view.setBackgroundResource(R.color.Success);
        }

        TextView tv = (TextView) view.findViewById(R.id.tvChild);
        tv.setText(child.getName().toString());

        return view;
    }

    public int getChildrenCount(int groupPosition){
        ArrayList<ExpandListChild> childList = groups.get(groupPosition).getItems();
        return childList.size();
    }

    public Object getGroup(int groupPosition){
        return groups.get(groupPosition);
    }

    public int getGroupCount(){
        return groups.size();
    }

    public long getGroupId(int groupPosition){
        return groupPosition;
    }

    public View getGroupView(int groupPosition, boolean isLastChild, View view, ViewGroup parent){
        ExpandListGroup group = (ExpandListGroup) getGroup(groupPosition);

        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.expandlist_group_item, null);
        }

        TextView tv = (TextView) view.findViewById(R.id.tvGroup);
        tv.setText(group.getName());

        return view;
    }

    public boolean hasStableIds(){
        return true;
    }

    public boolean isChildSelectable(int groupPosition, int childPosition){
        return true;
    }

}