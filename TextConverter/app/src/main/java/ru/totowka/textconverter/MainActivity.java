package ru.totowka.textconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import static java.util.Map.entry;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText input;
    TextView output;
    Button button;

    Map<String, String> ru2en = new HashMap<String, String>() {{
        put("а", "f");
        put("б", ",");
        put("в", "d");
        put("г", "u");
        put("д", "l");
        put("е", "t");
        put("ё", "`");
        put("ж", ";");
        put("з", "p");
        put("и", "b");
        put("й", "q");
        put("к", "r");
        put("л", "k");
        put("м", "v");
        put("н", "y");
        put("о", "j");
        put("п", "g");
        put("р", "h");
        put("с", "c");
        put("т", "n");
        put("у", "e");
        put("ф", "a");
        put("х", "[");
        put("ц", "w");
        put("ч", "x");
        put("ш", "i");
        put("щ", "o");
        put("ъ", "]");
        put("ы", "s");
        put("ь", "m");
        put("э", "'");
        put("ю", ".");
        put("я", "z");
    }};

    public static <K,V> Map<V,K> reverse(Map<K,V> map) {
        HashMap<V,K> rev = new HashMap<V, K>();
        for(Map.Entry<K,V> entry : map.entrySet())
            rev.put(entry.getValue(), entry.getKey());
        return rev;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = (EditText)findViewById(R.id.edit_input);
        output = (TextView)findViewById(R.id.edit_output);
        button = (Button)findViewById(R.id.button);
        Map<String, String> en2ru = reverse(ru2en);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input.getText().toString().isEmpty()) {
                    Toast.makeText(getBaseContext(), "Empty input",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    // At the momemnt, it just outputs the initial text with no converting.
                    // Converting is under development.
                    output.setText(input.getText());
                }
            }
        });
    }

}