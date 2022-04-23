package th.ac.kku.cis.listview01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;
import th.ac.kku.cis.listview01.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageId = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h};
        String[] name = {"ชัชชพล","ณัฐนัย","เอื้ออังกูร","ธนากร","พรรณนิภา","อภิสรา","ภัณฑิรา"};
        String[] id = {"ID:623410060-6","ID:623410049-4","ID:623410034-7","ID:623410007-0","ID:623410036-3","ID:623410035-5","ID:623410059-1"};
        String[] Time = {"00.00 pm","9:33 am","8:59 pm","8:32 pm","5:50 am","3:20 am","7:30 am"};
        String[] phoneNo = {"0647162527","0942905354","0909495510","0610299711","0984955510","0639482510","0863296110"};
        String[] country = {"นครราชสีมา","หนองบัวลำภู","ชัยภูมิ","ชัยภูมิ","อุดรธานี","ศรีสะเกษ","ขอนแก่น"};
        String[] universi = {"Khonkean University","Khonkean University","Khonkean University"
                ,"Khonkean University","Khonkean University","Khonkean University","Khonkean University"
                ,"Khonkean University"};

        ArrayList<User> userArrayList = new ArrayList<>();

        for(int i = 0;i< imageId.length;i++){

            User user = new User(name[i],id[i],Time[i],phoneNo[i],country[i],imageId[i]);
            userArrayList.add(user);

        }


        ListAdapter listAdapter = new ListAdapter(MainActivity.this,userArrayList);

        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(MainActivity.this,UserActivity.class);
                i.putExtra("name",name[position]);
                i.putExtra("phone",phoneNo[position]);
                i.putExtra("country",country[position]);
                i.putExtra("universi",universi[position]);
                i.putExtra("imageid",imageId[position]);
                startActivity(i);

            }
        });

    }
}