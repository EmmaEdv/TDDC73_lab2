package com.example.emmaedv.tddc73_lab2_2;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ExpandableListView;

import com.example.emmaedv.tddc73_lab2_2.Adapter.ExpandListAdapter;
import com.example.emmaedv.tddc73_lab2_2.Classes.ExpandListChild;
import com.example.emmaedv.tddc73_lab2_2.Classes.ExpandListGroup;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MyActivity extends Activity {
    private ExpandListAdapter ExpAdapter;
    private ArrayList<ExpandListGroup> ExpListItems;
    private ExpandableListView ExpandList;
    private EditText TextField;

    // Listview Data
    String groupNames[] = {"Förnamn", "Mellannamn", "Efternamn"};
    String firstNames[] = {"Emma", "Johan", "Molgan"};
    String midNames[] = {"Marie Caroline", "Carl August", "Molganne"};
    String lastNames[] = {"Edvardsson", "Dagvall", "Molgansson"};

    int groupId = -1;
    int childId = -1;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExpandList = (ExpandableListView) findViewById(R.id.ExpList);
        ExpListItems = SetStandardGroups();
        ExpAdapter = new ExpandListAdapter(MyActivity.this, ExpListItems);
        ExpandList.setAdapter(ExpAdapter);
        TextField = (EditText)findViewById(R.id.editText);

        TextField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int lengthBefore, int lengthAfter) {

                String inputString = charSequence.toString().toLowerCase();

                if(inputString.contains("/")){
                    String[] splitString = inputString.split("/");
                    String groupString = splitString[0];
                    String childString = "";
                    if(splitString.length > 1){
                        childString = splitString[1];
                    } else {
                        childString = "";
                    }

                    if((Arrays.asList(groupNames).toString().toLowerCase()).contains(groupString)){

                        TextField.setBackgroundResource(R.color.Success);

                        if((groupNames[0].toString().toLowerCase()).equals(groupString)) {
                            TextField.setBackgroundResource(R.color.Success);
                            //Expand the group
                            ExpandList.collapseGroup(1);
                            ExpandList.collapseGroup(2);
                            ExpandList.expandGroup(0);

                            groupId = 0;

                            if((firstNames[0].toString().toLowerCase()).contains(childString)) {
                                //Select the correct child.....
                                childId = 0;
                                if((firstNames[0].toString().toLowerCase()).equals(childString)) {
                                    ExpAdapter.setIds(groupId, childId);
                                }
                                //ExpAdapter.setIds(groupId, childId);
                            }
                            else if((firstNames[1].toString().toLowerCase()).contains(childString)) {
                                //Expand the group
                                childId = 1;
                                if((firstNames[1].toString().toLowerCase()).equals(childString)) {
                                    ExpAdapter.setIds(groupId, childId);
                                }
                            }
                            else if((firstNames[2].toString().toLowerCase()).contains(childString)) {
                                //Expand the group
                                childId = 2;
                                if((firstNames[2].toString().toLowerCase()).equals(childString)) {
                                    ExpAdapter.setIds(groupId, childId);
                                }
                            }
                            else{
                                TextField.setBackgroundResource(R.color.NoSuccess);
                            }
                        }
                        else if((groupNames[1].toString().toLowerCase()).equals(groupString)) {
                            TextField.setBackgroundResource(R.color.Success);
                            //Expand the group
                            ExpandList.collapseGroup(0);
                            ExpandList.collapseGroup(2);
                            ExpandList.expandGroup(1);

                            groupId = 1;

                            if((midNames[0].toString().toLowerCase()).contains(childString)) {
                                //Select the correct child.....
                                childId = 0;
                                if((midNames[0].toString().toLowerCase()).equals(childString)) {
                                    ExpAdapter.setIds(groupId, childId);
                                }

                            }
                            else if((midNames[1].toString().toLowerCase()).contains(childString)) {
                                //Expand the group
                                childId = 1;
                                if((midNames[1].toString().toLowerCase()).equals(childString)) {
                                    ExpAdapter.setIds(groupId, childId);
                                }
                            }
                            else if((midNames[2].toString().toLowerCase()).contains(childString)) {
                                //Expand the group
                                childId = 2;
                                if((midNames[2].toString().toLowerCase()).equals(childString)) {
                                    ExpAdapter.setIds(groupId, childId);
                                }
                            }
                            else{
                                TextField.setBackgroundResource(R.color.NoSuccess);
                            }
                        }
                        else if((groupNames[2].toString().toLowerCase()).equals(groupString)) {
                            TextField.setBackgroundResource(R.color.Success);
                            //Expand the group
                            ExpandList.collapseGroup(0);
                            ExpandList.collapseGroup(1);
                            ExpandList.expandGroup(2);

                            groupId = 2;

                            if((lastNames[0].toString().toLowerCase()).contains(childString)) {
                                //Select the correct child.....
                                childId = 0;
                                if((lastNames[0].toString().toLowerCase()).equals(childString)) {
                                    ExpAdapter.setIds(groupId, childId);
                                }
                            }
                            else if((lastNames[1].toString().toLowerCase()).contains(childString)) {
                                //Expand the group
                                childId = 1;
                                if((lastNames[1].toString().toLowerCase()).equals(childString)) {
                                    ExpAdapter.setIds(groupId, childId);
                                }
                            }
                            else if((lastNames[2].toString().toLowerCase()).contains(childString)) {
                                //Expand the group
                                childId = 2;
                                if((lastNames[2].toString().toLowerCase()).equals(childString)) {
                                    ExpAdapter.setIds(groupId, childId);
                                }
                            }
                            else{
                                TextField.setBackgroundResource(R.color.NoSuccess);
                            }
                        }
                    }
                    else{
                        TextField.setBackgroundResource(R.color.NoSuccess);
                    }
                }
                else {
                    if((Arrays.asList(groupNames).toString().toLowerCase()).contains(inputString)){
                        TextField.setBackgroundResource(R.color.Success);

                        //Ugly hack
                        if((groupNames[0].toString().toLowerCase()).equals(inputString)) {
                            //Expand the group
                            ExpandList.collapseGroup(1);
                            ExpandList.collapseGroup(2);
                            ExpandList.expandGroup(0);

                        }
                        else if((groupNames[1].toString().toLowerCase()).equals(inputString)) {
                            //Expand the group
                            ExpandList.collapseGroup(0);
                            ExpandList.collapseGroup(2);
                            ExpandList.expandGroup(1);
                        }
                        else if((groupNames[2].toString().toLowerCase()).equals(inputString)) {
                            //Expand the group
                            ExpandList.collapseGroup(0);
                            ExpandList.collapseGroup(1);
                            ExpandList.expandGroup(2);
                        }
                    }
                    else{
                        TextField.setBackgroundResource(R.color.NoSuccess);
                    }
                }
                ExpAdapter.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        ExpandList.setOnGroupClickListener(new OnGroupClickListener() {
           @Override
           public boolean onGroupClick(ExpandableListView expandablelistview,
                                       View clickedView, int groupPosition, long grpId) {
               ExpandListGroup group = (ExpandListGroup) ExpAdapter.getGroup(groupPosition);
               String groupPath = group.getName().toString();
               TextField.setText(groupPath, TextView.BufferType.EDITABLE);

               groupId = (int) grpId;
               ExpAdapter.setIds(groupId, -1);

               return true;
           }
        });

        ExpandList.setOnChildClickListener(new OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandablelistview,
                                        View clickedView, int groupPosition, int childPosition, long chdId) {
                ExpandListChild child = (ExpandListChild) ExpAdapter.getChild(groupPosition, childPosition);
                String path = "/" + child.getName().toString();

                ExpandListGroup group = (ExpandListGroup) ExpAdapter.getGroup(groupPosition);
                String groupPath = group.getName().toString();

                path = groupPath.concat(path);
                TextField.setText(path, TextView.BufferType.EDITABLE);

                return true;
            }
        });
    }

    public ArrayList<ExpandListGroup> SetStandardGroups(){
        ArrayList<ExpandListGroup> list = new ArrayList<ExpandListGroup>();
        ArrayList<ExpandListChild> list2 = new ArrayList<ExpandListChild>();

        ExpandListGroup group1 = new ExpandListGroup();
        group1.setName(groupNames[0]);
        ExpandListChild child1_1 = new ExpandListChild();
        child1_1.setName(firstNames[0]);
        list2.add(child1_1);

        ExpandListChild child1_2 = new ExpandListChild();
        child1_2.setName(firstNames[1]);
        list2.add(child1_2);

        ExpandListChild child1_3 = new ExpandListChild();
        child1_3.setName(firstNames[2]);
        list2.add(child1_3);

        group1.setItems(list2);

        list2 = new ArrayList<ExpandListChild>();

        ExpandListGroup group2 = new ExpandListGroup();
        group2.setName(groupNames[1]);
        ExpandListChild child2_1 = new ExpandListChild();
        child2_1.setName(midNames[0]);
        list2.add(child2_1);

        ExpandListChild child2_2 = new ExpandListChild();
        child2_2.setName(midNames[1]);
        list2.add(child2_2);

        ExpandListChild child2_3 = new ExpandListChild();
        child2_3.setName(midNames[2]);
        list2.add(child2_3);

        group2.setItems(list2);

        list2 = new ArrayList<ExpandListChild>();

        ExpandListGroup group3 = new ExpandListGroup();
        group3.setName(groupNames[2]);
        ExpandListChild child3_1 = new ExpandListChild();
        child3_1.setName(lastNames[0]);
        list2.add(child3_1);

        ExpandListChild child3_2 = new ExpandListChild();
        child3_2.setName(lastNames[1]);
        list2.add(child3_2);

        ExpandListChild child3_3 = new ExpandListChild();
        child3_3.setName(lastNames[2]);
        list2.add(child3_3);

        group3.setItems(list2);

        list.add(group1);
        list.add(group2);
        list.add(group3);

        return list;
    }
}