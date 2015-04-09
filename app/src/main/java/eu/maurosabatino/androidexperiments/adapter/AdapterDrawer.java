package eu.maurosabatino.androidexperiments.adapter;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import eu.maurosabatino.androidexperiments.Entity.ItemRowDrawer;
import eu.maurosabatino.androidexperiments.R;


public class AdapterDrawer extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<ItemRowDrawer> data= Collections.emptyList();
    private static final int TYPE_HEADER=0;
    private static final int TYPE_ITEM=1;
    private LayoutInflater inflater;
    private Context context;
    public AdapterDrawer(Context context, List<ItemRowDrawer> data){
        this.context=context;
        inflater=LayoutInflater.from(context);
        this.data=data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==TYPE_HEADER){
            View view=inflater.inflate(R.layout.header, parent,false);
            HeaderHolder holder=new HeaderHolder(view);
            return holder;
        }
        else{
            View view=inflater.inflate(R.layout.item_row, parent,false);
            ItemHolder holder=new ItemHolder(view);
            return holder;
        }

    }

    @Override
    public int getItemViewType(int position) {
        if(position==0){
            return TYPE_HEADER;
        }
        else {
            return TYPE_ITEM;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof HeaderHolder ){
            HeaderHolder headerHolder = (HeaderHolder) holder;
            headerHolder.email.setText("info@giglio-onlus.it");
            headerHolder.Name.setText("Giglio Onlus");
            headerHolder.profile.setImageResource(R.drawable.ic_action_giglio_logo);
        }
        else{
            ItemHolder itemHolder= (ItemHolder) holder;
            ItemRowDrawer current=data.get(position-1);
            itemHolder.title.setText(current.title);
            itemHolder.icon.setImageResource(current.iconId);
        }

    }
    @Override
    public int getItemCount() {
        return data.size()+1;
    }

    class ItemHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView icon;
        public ItemHolder(View itemView) {
            super(itemView);
            title= (TextView) itemView.findViewById(R.id.rowText);
            icon= (ImageView) itemView.findViewById(R.id.rowIcon);
        }
    }
    class HeaderHolder extends RecyclerView.ViewHolder {
        ImageView profile;
        TextView Name;
        TextView email;
        public HeaderHolder(View itemView) {
            super(itemView);
            Name = (TextView) itemView.findViewById(R.id.name);
            email = (TextView) itemView.findViewById(R.id.email);
            profile = (ImageView) itemView.findViewById(R.id.circleView);
        }
    }

}
