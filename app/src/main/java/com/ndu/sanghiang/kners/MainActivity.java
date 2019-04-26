package com.ndu.sanghiang.kners;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.ndu.sanghiang.kners.firebase.LoginActivity;
import com.ndu.sanghiang.kners.indevelopment.HistoryActivity;
import com.ndu.sanghiang.kners.indevelopment.InventoryManagerActivity;
import com.ndu.sanghiang.kners.indevelopment.ProdukKnowledgeActivity;
import com.ndu.sanghiang.kners.ocr.OcrCaptureActivity;

public class MainActivity extends AppCompatActivity {
    Button buttonProdukKnowledge, buttonAbout, buttonInventoryManager, buttonBarcodeList, buttonOcrCapture, buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Sample AdMob app ID: ca-app-pub-4368595636314473~7130779124
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~6300978111");
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        buttonProdukKnowledge = findViewById(R.id.button_produk_knowledge);
        buttonInventoryManager = findViewById(R.id.button_inventory_manager);
        buttonAbout = findViewById(R.id.button_about);
        buttonBarcodeList = findViewById(R.id.button_history);
        buttonOcrCapture = findViewById(R.id.button_ocr_activity);
        buttonLogin = findViewById(R.id.button_login);
        Toolbar tToolbar = findViewById(R.id.tToolbar);
        setSupportActionBar(tToolbar);

        //Permission Marshmelo
        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{Manifest.permission.INTERNET},
                1);

        buttonProdukKnowledge.setOnClickListener(view -> {
            Intent produkIntent = new
                    Intent(MainActivity.this, ProdukKnowledgeActivity.class);
            startActivity(produkIntent);
        });

        buttonInventoryManager.setOnClickListener(view -> {
            Intent inventIntent = new
                    Intent(MainActivity.this, InventoryManagerActivity.class);
            startActivity(inventIntent);
        });

        buttonAbout.setOnClickListener(view -> {

            Intent aboutIntent = new
                    Intent(MainActivity.this,AboutActivity.class);
            startActivity(aboutIntent);
        });

        buttonLogin.setOnClickListener(view ->{
            Intent loginIntent = new
                    Intent(MainActivity.this, LoginActivity.class);
            startActivity(loginIntent);
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);

        /*/Searchable
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search)
                .getActionView();
        searchView.setSearchableInfo(SearchManager
                .getSearchableinfo(getComponentName()));*/

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        //Tentukan actionnya setiap klik
        switch (item.getItemId()){
            case R.id.action_search:
                return true;
            case R.id.action_about:
                AboutActivity();
                return true;
            /*case R.id.action_check_updates:
                in developement */
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    //Permission Marshmelo
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions, @NonNull int[] grantResults) {
        // If request is cancelled, the textViewResult arrays are empty.
        if (requestCode == 1) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                // permission was granted, yay! Do the
                // contacts-related task you need to do.
                //Toast.makeText(MainActivity.this, "Internet diijinkan", Toast.LENGTH_SHORT).show();
            } else {

                // permission denied, boo! Disable the
                // functionality that depends on this permission.
                Toast.makeText(MainActivity.this, "Ijin untuk mengakses internet ditolak", Toast.LENGTH_SHORT).show();
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }

    }

    private void AboutActivity(){
        Intent aboutIntent = new
                Intent(MainActivity.this,AboutActivity.class);
        startActivity(aboutIntent);
    }

    public void goToBrowser(View view) {
        //activity baru
        Intent browserIntent = new
                Intent(MainActivity.this,WebViewActivity.class);
        startActivity(browserIntent);
    }

    public void codeMatchActivity(View view) {
        //activity baru
        Intent myIntent = new
                Intent(MainActivity.this,CodeMatchActivity.class);
        startActivity(myIntent);
    }

    public void barcodeListActivity(View view) {
        //activity baru
        Intent myIntent = new
                Intent(MainActivity.this, HistoryActivity.class);
        startActivity(myIntent);
    }

    public void ocrCaptureActivity(View view) {
        //activity baru
        Intent myIntent = new
                Intent(MainActivity.this, OcrCaptureActivity.class);
        startActivity(myIntent);
    }

}
