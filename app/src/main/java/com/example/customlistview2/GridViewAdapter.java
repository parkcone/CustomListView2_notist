package com.example.customlistview2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;


//안드로이드 SDK에서 제공하는 Adapter 중 BaseAdapter 상속
public class GridViewAdapter extends BaseAdapter implements Filterable
{
    //Adapter에 들어오는 데이터를 저장하기 위한 배열
    private ArrayList<GridViewitem> girdView_item_ArrayList = new ArrayList<GridViewitem>();

    //ListViewAdapter의 생성자
    public GridViewAdapter() {
    }

    //필터링 결과 데이터를 저장하기 위한 배열
    private ArrayList<GridViewitem> filteredItemList = girdView_item_ArrayList;

    // filter 구현
    Filter gridFilter;

    @Override
    public Filter getFilter() {
        if (gridFilter == null) {
            gridFilter = new ListFilter();
        }

        return gridFilter;
    }

    // custom filter class 구현
    private class ListFilter extends Filter
    {
        //필터링 수행함수(필터링 수행 루프 포함, 필터링 결과를 리턴)
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();

            if (constraint == null || constraint.length() == 0)
            {
                results.values = girdView_item_ArrayList;
                results.count = girdView_item_ArrayList.size();
            }
            else
            {
                ArrayList<GridViewitem> itemList = new ArrayList<GridViewitem>();

                for (GridViewitem item : girdView_item_ArrayList)
                {
                    if (item.getRecordtitle().toUpperCase().contains(constraint.toString().toUpperCase()))
                    {
                        itemList.add(item);
                    }
                }

                results.values = itemList;
                results.count = itemList.size();
            }
            return results;
        }

        // 위의 함수에서 필터링 된 결과를 UI에 갱신
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            // update gridview by filtered data list.
            filteredItemList = (ArrayList<GridViewitem>) results.values;

            // notify
            if (results.count > 0)
            {
                notifyDataSetChanged();
            }
            else
            {
                notifyDataSetInvalidated();
            }

        }
    }


    //필수로 override하는 메소드 4가지

    // 1. Adapter에 사용되는 데이터개수 리턴메소드
    @Override
    public int getCount()
    {
        return filteredItemList.size();
    }

    // 2. 지정한 위치(position)에 있는 데이터를 리턴
    @Override
    public Object getItem(int position)
    {
        return filteredItemList.get(position);
    }

    // 3. 지정한 위치에 있는 데이터와 관계된 아이템의 ID를 리턴
    @Override
    public long getItemId(int position)
    {
        return position;
    }


    // 4. position에 위치한 데이터를 화면에 출력되는데 사용될 view 리턴
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.grieview_item, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        TextView TextView = (TextView) convertView.findViewById(R.id.grid_view);

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        GridViewitem gridViewItem = filteredItemList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        TextView.setText(gridViewItem.getRecordtitle());

        return convertView;

    }

    // 아이템 데이터 추가를 위한 함수
    public void addItem(String title) {
        GridViewitem item = new GridViewitem();

        item.setRecordtitle(title);
        girdView_item_ArrayList.add(item);
    }


}
