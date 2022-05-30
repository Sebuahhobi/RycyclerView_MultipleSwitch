package sebuahhobi.multipleswitch.adapter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nightonke.jellytogglebutton.JellyToggleButton;
import com.nightonke.jellytogglebutton.State;

import java.util.ArrayList;

import sebuahhobi.multipleswitch.R;

public class AdapterMain extends RecyclerView.Adapter<AdapterMain.ViewHolder> {
    public static final int TYPE_4 = 1;
    public static final int TYPE_1 = 4;

    Context contetxt;
    ArrayList<Integer> listViewType;

    public AdapterMain(ArrayList<Integer> listViewType, Context contetxt, String contoh) {
        this.listViewType = listViewType;
        this.contetxt = contetxt;
        Log.e("TAG", "AdapterMain: "+ contoh );
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case TYPE_1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_frame, null);
                return new HeaderFrame(view);
            case TYPE_4:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.switch_frame, null);
                return new ItemSwitch(view);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int viewType = listViewType.get(position);
        switch (viewType) {
            case TYPE_1:
                HeaderFrame headerSwitch = (HeaderFrame) holder;
                headerSwitch.title_header.setText("Kama " + position);
                break;
            case TYPE_4:
                ItemSwitch itemSwitch = (ItemSwitch) holder;
                if(position == 0){
                    itemSwitch.r1_text.setText("Relay 1");
                } else {
                    itemSwitch.r1_text.setText("Relay 2");
                    itemSwitch.r1.setChecked(true);
                }

        }
    }

    @Override
    public int getItemCount() {
        return listViewType.size();
    }

    @Override
    public int getItemViewType(int position) {
        return listViewType.get(position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    class ItemPertamaViewHolder extends ViewHolder {

        //  komponen
        TextView textViewItemPertama;

        public ItemPertamaViewHolder(View itemView) {
            super(itemView);
            textViewItemPertama = (TextView) itemView.findViewById(R.id.text_view_item_tipe_pertama);
        }
    }

    class ItemSwitch extends ViewHolder {
        JellyToggleButton r1, r2, r3, r4, r5, r6, r7, r8;
        TextView r1_text, r2_text, r3_text, r4_text, r5_text, r6_text, r7_text, r8_text;
        public ItemSwitch(View itemView) {
            super(itemView);
            r1_text = (TextView) itemView.findViewById(R.id.r1_text);
            r1 = (JellyToggleButton) itemView.findViewById(R.id.r1);
            r1.setOnStateChangeListener(new JellyToggleButton.OnStateChangeListener() {
                @Override
                public void onStateChange(float process, State state, JellyToggleButton jtb) {
                    if (state.equals(State.LEFT)) {
                        Log.e("Tes", "onStateChange: Kiri" );
                    }
                    if (state.equals(State.RIGHT)) {
                        Log.e("Tes", "onStateChange: Kanan" );
                        //mWebSocketClient.send("toggle");
                    }
                }
            });
        }
    }

    class HeaderFrame extends ViewHolder{
        TextView title_header;
        public HeaderFrame(View itemView){
            super(itemView);
            title_header = (TextView) itemView.findViewById(R.id.title_header);
        }
    }
}