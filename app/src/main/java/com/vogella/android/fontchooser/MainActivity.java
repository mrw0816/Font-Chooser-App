package com.vogella.android.fontchooser;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    SeekBar fontSeekBar;
    Spinner typeFaceSpinner;
    Spinner styleSpinner;
    EditText input;
    TextView output;


    SeekBar redSeekBar;
    SeekBar greenSeekBar;
    SeekBar blueSeekBar;

    int redNumber = 0;
    int greenNumber = 0;
    int blueNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText) findViewById(R.id.editText2);
        output = (TextView) findViewById(R.id.textView2);

        typeFaceSpinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.typeface_choices, android.R.layout.simple_spinner_item);
        typeFaceSpinner.setAdapter(adapter);
        typeFaceSpinner.setOnItemSelectedListener(this);

        styleSpinner = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter styleAdapter = ArrayAdapter.createFromResource(this, R.array.style_choices, android.R.layout.simple_spinner_item);
        styleSpinner.setAdapter(styleAdapter);
        styleSpinner.setOnItemSelectedListener(this);

        createFontSeekBar();
        createColorSeekBars();

    }


    public void onClick(View view) {
        String message = input.getText().toString();
        output.setText(message);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView selected = (TextView) view;

        switch (parent.getId()) {
            case R.id.spinner:
                switch (selected.getText().toString()) {
                    case "Default":
                        output.setTypeface(Typeface.DEFAULT, output.getTypeface().getStyle());

                        break;
                    case "Monospace":
                        output.setTypeface(Typeface.MONOSPACE, output.getTypeface().getStyle());
                        break;
                    case "Sans Serif":
                        output.setTypeface(Typeface.SANS_SERIF, output.getTypeface().getStyle());
                        break;
                    case "Serif":
                        output.setTypeface(Typeface.SERIF, output.getTypeface().getStyle());
                        break;
                }

                break;
            case R.id.spinner2:
                switch (selected.getText().toString()) {
                    case "Bold":
                        output.setTypeface(output.getTypeface(), Typeface.BOLD);
                        break;
                    case "Bold Italic":
                        output.setTypeface(output.getTypeface(), Typeface.BOLD_ITALIC);
                        break;
                    case "Italic":
                        output.setTypeface(output.getTypeface(), Typeface.ITALIC);
                        break;
                    case "Normal":
                        Typeface tf = Typeface.create(output.getTypeface(), Typeface.NORMAL);

                        output.setTypeface(tf);
                        Toast.makeText(MainActivity.this,
                                "Normal", Toast.LENGTH_LONG).show();
                        break;
                }
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void createFontSeekBar() {
        fontSeekBar = (SeekBar) findViewById(R.id.seekBar);

        fontSeekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        output.setTextSize(15 + progress);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }

        );
    }

    public void createColorSeekBars() {
        redSeekBar = (SeekBar) findViewById(R.id.red_seek_bar);
        greenSeekBar = (SeekBar) findViewById(R.id.green_seek_bar);
        blueSeekBar = (SeekBar) findViewById(R.id.blue_seek_bar);

        redSeekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        redNumber = (255 / 100) * progress;
                        output.setTextColor(Color.rgb(redNumber, greenNumber, blueNumber));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );

        greenSeekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        greenNumber = (255 / 100) * progress;
                        output.setTextColor(Color.rgb(redNumber, greenNumber, blueNumber));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );

        blueSeekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener(){
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        blueNumber = (255/100) * progress;
                        output.setTextColor(Color.rgb(redNumber, greenNumber, blueNumber));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );
    }
}
