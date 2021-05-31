package sg.edu.rp.c346.id20008460.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDbs , tvOcbc , tvUob ;
    String company;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDbs = findViewById(R.id.dbs);
        tvOcbc = findViewById(R.id.ocbc);
        tvUob = findViewById(R.id.UOB);

        registerForContextMenu(tvDbs);
        registerForContextMenu(tvOcbc);
        registerForContextMenu(tvUob);

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0, R.string.website);
        menu.add(0,1,1, R.string.contact);
        menu.add(0,2,2, R.string.toggleFav);

        if (v == tvDbs) {
            company = getString(R.string.dbs);
        } else if (v == tvOcbc) {
            company = getString(R.string.ocbc);
        } else if (v == tvUob) {
            company = getString(R.string.uob);
        }

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        if (company.equalsIgnoreCase(getString(R.string.dbs))) {

            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.dbs_web)));
                startActivity(intent);
            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.dbs_phone)));
                startActivity(intentCall);

            } else if (item.getItemId() == 2) {

                if (tvDbs.getCurrentTextColor() == Color.BLACK) {
                    tvDbs.setTextColor(Color.parseColor("#FF0000"));
                } else if (tvDbs.getCurrentTextColor() == Color.RED) {
                    tvDbs.setTextColor(Color.parseColor("#000000"));
                }
            }
        } else if (company.equalsIgnoreCase(getString(R.string.ocbc))) {

            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.ocbc_web)));
                startActivity(intent);
            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.ocbc_phone)));
                startActivity(intentCall);
            }  else if (item.getItemId() == 2) {

                if (tvOcbc.getCurrentTextColor() == Color.BLACK) {
                    tvOcbc.setTextColor(Color.parseColor("#FF0000"));
                } else if (tvOcbc.getCurrentTextColor() == Color.RED) {
                    tvOcbc.setTextColor(Color.parseColor("#000000"));
                }
            }

        } else if (company.equalsIgnoreCase(getString(R.string.uob))) {

            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.uob_web)));
                startActivity(intent);
            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.uob_phone)));
                startActivity(intentCall);
            }  else if (item.getItemId() == 2) {

                if (tvUob.getCurrentTextColor() == Color.BLACK) {
                    tvUob.setTextColor(Color.parseColor(getString(R.string.red)));
                } else if (tvUob.getCurrentTextColor() == Color.RED) {
                    tvUob.setTextColor(Color.parseColor(getString(R.string.black)));
                }
            }
        }

            return super.onContextItemSelected(item);
        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDbs.setText(R.string.dbs);
            tvOcbc.setText(R.string.ocbc);
            tvUob.setText(R.string.uob);
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvDbs.setText(R.string.dbs_chi);
            tvOcbc.setText(R.string.ocbc_chi);
            tvUob.setText(R.string.uob_chi);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



}