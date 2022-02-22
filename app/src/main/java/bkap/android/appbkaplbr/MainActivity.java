package bkap.android.appbkaplbr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AdapterBook mAdapterBook;
    private List<Book1> mLst;
    private ListView lstView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstView = findViewById(R.id.listviewBook);
        loadData();
    }
    private void loadData() {
        // Khởi tạo đối tượng kết nối và thực hiện request tới web service
        String url = "http://192.168.0.1:8080/WSV/rest/book/all";
        BkConnectSv cnnServ = new BkConnectSv();
        cnnServ.jsonData(url, this, lstView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menuAdd:
                Intent intent = new Intent(this, BookActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}