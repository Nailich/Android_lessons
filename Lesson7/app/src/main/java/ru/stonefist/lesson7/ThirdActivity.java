package ru.stonefist.lesson7;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.ToggleButton;

/**
 * Created by ntairov on 14.06.2016.
 */
public class ThirdActivity extends AppCompatActivity {

    private final String editText_TEXT = "Lesson7.editText";
    private final String toggleButtom_STATE = "Lesson7.toggleButton";
    EditText editText;
    ToggleButton toggleButton;
    SharedPreferences preferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);

        editText = (EditText)findViewById(R.id.edName);
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);

        // /data/data/YOUR_PACKAGE_NAME/shared_prefs/YOUR_PREFS_NAME.xml
        preferences = getSharedPreferences("Lesson7", MODE_PRIVATE);   // сохранение параметров в файл

        editText.setText(preferences.getString(editText_TEXT, "EMPTY!!!"));
        toggleButton.setChecked(preferences.getBoolean(toggleButtom_STATE, true));
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(getClass().getSimpleName(), "onStop");

        preferences.edit().putString(editText_TEXT, editText.getText().toString()).apply();
        preferences.edit().putBoolean(toggleButtom_STATE, toggleButton.isChecked()).apply();
    }
}
