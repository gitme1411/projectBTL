package bkap.android.appbkaplbr;

import android.content.Context;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class BkConnectSv {
    public void jsonData(String url, Context mCtx, ListView lstView) {
        // Xử lý dữ liệu trả về
        Response.Listener<String> listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(mCtx, "Connect Service", Toast.LENGTH_SHORT).show();
                // Toast.makeText(mCtx, response, Toast.LENGTH_SHORT).show();
                Gson gson = new Gson();
                TypeToken<List<Book1>> token = new TypeToken<List<Book1>>() {
                }; // Định nghĩa dữ liệu chuyển đổi từ JSON về collection

                List<Book1> lst = gson.fromJson(response, token.getType());
                AdapterBook adapter = new AdapterBook(mCtx, R.layout.item_book, lst);
                lstView.setAdapter(adapter);
            }
        };
    }
}
