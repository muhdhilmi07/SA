package sg.edu.rp.c346.id20017533.sa;
/*Muhammad Hilmi Bin Abdul Rahim 20017533*/

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class ItemListActivity extends AppCompatActivity {

    EditText name;
    EditText pos;
    DatePicker exp;
    Button add;
    Button delete;
    Button update;
    ListView lV;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        name = findViewById(R.id.name);
        pos = findViewById(R.id.posNum);
        exp = findViewById(R.id.date);
        add = findViewById(R.id.buttonAdd);
        delete = findViewById(R.id.buttonDelete);
        update = findViewById(R.id.buttonUpdate);
        lV = findViewById(R.id.listViewTodo);


        arrayList = new ArrayList<>();
        arrayList.add("Expires" + " " + "2022-8-6" + ", " + "Jordan Delta 2");
        arrayList.add("Expires" + " " + "2021-9-8" + ", " + "Nike Crater Impact");
        arrayList.add("Expires" + " " + "2022-7-1" + ", " + "Nike React Miler 2");
        arrayList.add("Expires" + " " + "2023-4-6" + ", " + "Zion 1 PF");
        arrayList.add("Expires" + " " + "2022-6-9" + ", " + "Nike Waffle Trainer 2"); /*separates the date and name*/

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
        lV.setAdapter(arrayAdapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = name.getText().toString();
                int y = exp.getYear();
                int m = exp.getMonth() + 1;
                int d = exp.getDayOfMonth();
                String date = y + "-" + m + "-" + d;
                String endProd = "Expires " + date + ", " + n;
                arrayList.add(endProd);
                Collections.sort(arrayList, new Comparator<String>() {
                    @Override
                    public int compare(String item1, String item2) {
                        return item1.split(", ")[1].compareTo(item2.split(", ")[1]); /*split date and name in endProd*/
                    }
                });
                arrayAdapter.notifyDataSetChanged();
                name.setText(""); /*resets editText*/

                update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int p = Integer.parseInt(pos.getText().toString());
                        String n = name.getText().toString();
                        int year = exp.getYear();
                        int month = exp.getMonth() + 1;
                        int day = exp.getDayOfMonth();
                        String date = year + "-" + month + "-" + day;
                        String endProd = "Expires " + date + ", " + n;
                        arrayList.set(p, endProd);
                        arrayAdapter.notifyDataSetChanged();
                        pos.setText("");
                        name.setText("");
                    }
                });

                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int p = Integer.parseInt(pos.getText().toString());
                        if (arrayList.size() == 0) { /*conditions checks array list size to see if its empty so instead of crashing it produces a toast indicating that there is no products to remove*/
                            Toast.makeText(ItemListActivity.this, "You don't have any products to remove", Toast.LENGTH_SHORT).show();
                        } else if (arrayList.size() < p) { /*check if the index number is within the size of the arraylist*/
                            Toast.makeText(ItemListActivity.this, "Wrong index number", Toast.LENGTH_SHORT).show();
                        } else {
                            arrayList.remove(p - 1);
                            arrayAdapter.notifyDataSetChanged();
                            Toast.makeText(ItemListActivity.this, "Product removed successfully", Toast.LENGTH_SHORT).show();
                            pos.setText("");
                        }
                    }
                });
            }
        });
    }
}

