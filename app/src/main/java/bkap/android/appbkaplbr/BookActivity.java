package bkap.android.appbkaplbr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class BookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
    }

    public void actionAdd(View view) {
        String title = ((EditText) findViewById(R.id.formTitle)).getText().toString();
        String author = ((EditText) findViewById(R.id.formAuthor)).getText().toString();
        String price = ((EditText) findViewById(R.id.formPrice)).getText().toString();

        Book1 b = new Book1();
        b.setTitle(title);
        b.setAuthor(author);
        b.setPrice(Double.parseDouble(price));

        Gson gson = new Gson();
        String jsonBook = gson.toJson(b);

        // Đẩy dữ liệu tới server bằng thư viện Volley
        Response.Listener<JSONObject> listener = new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = new Gson();
                Messages msg = gson.fromJson(response.toString(), Messages.class);
                Toast.makeText(BookActivity.this, msg.getMsg(), Toast.LENGTH_SHORT).show();
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(BookActivity.this, "Lỗi thêm dữ liệu", Toast.LENGTH_SHORT).show();
            }

        };
        String url = "http://192.168.0.1:8080/WSV/rest/book/insert";
        try {
            JsonObjectRequest jor = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(jsonBook), listener, errorListener);
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(jor);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
