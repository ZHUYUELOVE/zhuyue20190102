package zhuyue.bwie.com.zhuyue20190102.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import zhuyue.bwie.com.zhuyue20190102.R;
import zhuyue.bwie.com.zhuyue20190102.bean.HomeBean;


public class XRecyclerViewAdapter extends XRecyclerView.Adapter<XRecyclerViewAdapter.XRecyclerVH> {

    private Context context;
    private List<HomeBean.DataBean> list;

    public XRecyclerViewAdapter(Context context) {
        this.context = context;
        this.list = new ArrayList<>();
    }

    public void setList(List<HomeBean.DataBean> list) {
        if (list != null) {
            this.list = list;
        }
        notifyDataSetChanged();
    }

    public void addList(List<HomeBean.DataBean> list) {
        if (list != null) {
            this.list.addAll(list);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public XRecyclerVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_item,viewGroup,false);
        XRecyclerVH xRecyclerVH  = new XRecyclerVH(view);
        return xRecyclerVH;
    }

    @Override
    public void onBindViewHolder(@NonNull XRecyclerVH xRecyclerVH, int postion) {

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class XRecyclerVH extends XRecyclerView.ViewHolder{

        ImageView iv_productIcon;
        TextView tv_title;

        public XRecyclerVH(View itemView) {
            super(itemView);
            this.iv_productIcon = itemView.findViewById(R.id.IV);
            this.tv_title = itemView.findViewById(R.id.TV);
        }
    }
}

