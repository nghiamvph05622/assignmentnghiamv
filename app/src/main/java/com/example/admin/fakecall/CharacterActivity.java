package com.example.admin.fakecall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

public class CharacterActivity extends AppCompatActivity {
    static final /* synthetic */ boolean $assertionsDisabled = (!CharacterActivity.class.desiredAssertionStatus());
    public static int[] prgmImages = new int[]{R.drawable.avt1, R.drawable.avt2, R.drawable.avt3, R.drawable.avt4, R.drawable.avt5};
    public static String[] prgmNameList = new String[]{"Bạn thân", "CSKH", "Vợ yêu", "Mẹ", "Bố"};
    public static String[] prgmPhoneList = new String[]{"0969569142", "18008198", "0969127422", "0453245987", "0328755726"};
    CharAdapter adapter;
    ArrayList<Charactor> categroyList;
    Intent returnIntent;
//    AdView mAdView;

    public void onBackPressed() {
        super.onBackPressed();
        setResult(0, returnIntent);
        finish();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("0224C93FFD644350DCD7F3D7557C6A5C").build();
        categroyList = new ArrayList();
        ListView listView = (ListView) findViewById(R.id.list_view);
        for (int i = 0; i < prgmNameList.length; i++) {
            categroyList.add(new Charactor(prgmNameList[i], prgmPhoneList[i], prgmImages[i]));
        }
        adapter = new CharAdapter(this, categroyList);
        if ($assertionsDisabled || listView != null) {
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new OnItemClickListener() {
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    characterClick(position);
                }
            });
            returnIntent = new Intent();
            return;
        }
        throw new AssertionError();
    }

    public void characterClick(int pos) {
        switch (pos) {
            case 0:
                returnIntent.putExtra("name", "Bạn thân");
                returnIntent.putExtra("number", "0969569142");
                returnIntent.putExtra("img", "0");
                setResult(-1, returnIntent);
                finish();
                return;
            case 1:
                returnIntent.putExtra("name", "CSKH");
                returnIntent.putExtra("number", "18008198");
                returnIntent.putExtra("img", "1");
                setResult(-1, returnIntent);
                finish();
                return;
            case 2:
                returnIntent.putExtra("name", "Vợ yêu");
                returnIntent.putExtra("number", "0969127422");
                returnIntent.putExtra("img", "2");
                setResult(-1, returnIntent);
                finish();
                return;
            case 3:
                returnIntent.putExtra("name", "Mẹ");
                returnIntent.putExtra("number", "0453245987");
                returnIntent.putExtra("img", "3");
                setResult(-1, returnIntent);
                finish();
                return;
            case 4:
                returnIntent.putExtra("name", "Bố");
                returnIntent.putExtra("number", "0328755726");
                returnIntent.putExtra("img", "4");
                setResult(-1, returnIntent);
                finish();
                return;
            default:
        }
    }
}