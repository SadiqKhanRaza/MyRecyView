package sadiq.raza.myrecyview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView r1;
    ArrayList<Person> al;
    MyAdapter md;

    EditText et1,et2;
    Button b;

    MyDatabase myDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r1 = findViewById(R.id.rc);
        et1 = findViewById(R.id.etname);
        et2 = findViewById(R.id.etdesc);


        myDatabase = new MyDatabase(this);

        RecyclerView.LayoutManager rlm = new LinearLayoutManager(this);

        r1.setLayoutManager(rlm);

        al = new ArrayList<>();

        r1.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));


    }

    public void dothis(View v)
    {
        Person p = new Person();
        p.setName(et1.getText().toString());
        p.setDesc(et2.getText().toString());
     //   p.setImage(R.drawable.lpu);

        al.add(p);
        myDatabase.insertValues(p);

        md = new MyAdapter(this,myDatabase.showValues());


        r1.setAdapter(md);

    }
}
