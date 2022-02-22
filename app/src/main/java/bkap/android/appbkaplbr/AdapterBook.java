package bkap.android.appbkaplbr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class AdapterBook extends ArrayAdapter<Book1> {
    private Context mCtx;
    private int mLayout;
    private List<Book1> mLst;

    public AdapterBook(@NonNull Context context, int resource, @NonNull List<Book1> objects) {
        super(context, resource, objects);
        this.mCtx = context;
        this.mLayout = resource;
        this.mLst = objects;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View item = convertView;

        if (item == null) {
            item = LayoutInflater.from(mCtx).inflate(mLayout, null);
        }

        // Dữ liệu object
        Book1 b = mLst.get(position);

        ((TextView) item.findViewById(R.id.itemTitle)).setText(b.getTitle());
        NumberFormat fmt = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        String strPrice = fmt.format(b.getPrice());
        ((TextView) item.findViewById(R.id.itemPrice)).setText(strPrice);

        return item;
    }
}
