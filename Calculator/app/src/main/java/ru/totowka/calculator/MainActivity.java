package ru.totowka.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView input;
    TextView output;
    Button plus;
    Button minus;
    Button multiply;
    Button divide;
    Button result;
    Button zero;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (TextView)findViewById(R.id.edit);
        output = (TextView)findViewById(R.id.output);
        plus = (Button)findViewById(R.id.plus);
        minus = (Button)findViewById(R.id.minus);
        multiply = (Button)findViewById(R.id.multiply);
        divide = (Button)findViewById(R.id.divide);
        result = (Button)findViewById(R.id.result);
        zero = (Button)findViewById(R.id.zero);
        one = (Button)findViewById(R.id.one);
        two = (Button)findViewById(R.id.two);
        three = (Button)findViewById(R.id.three);
        four = (Button)findViewById(R.id.four);
        five = (Button)findViewById(R.id.five);
        six = (Button)findViewById(R.id.six);
        seven = (Button)findViewById(R.id.seven);
        eight = (Button)findViewById(R.id.eight);
        nine = (Button)findViewById(R.id.nine);

        result.setEnabled(false);

        View.OnClickListener onClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.plus:
                        if(!input.getText().toString().equals("")) {
                            input.append("+");
                            disableOperations();
                        }
                        break;
                    case R.id.minus:
                        if(!input.getText().toString().equals("")) {
                            input.append("-");
                            disableOperations();
                        }
                        break;
                    case R.id.multiply:
                        if(!input.getText().toString().equals("")) {
                            input.append("*");
                            disableOperations();
                        }
                        break;
                    case R.id.divide:
                        if(!input.getText().toString().equals("")) {
                            input.append("/");
                            disableOperations();
                        }
                        break;
                    case R.id.result:
                        output.setText(calculcate(input.getText().toString()));
                        input.setText("");
                        result.setEnabled(false);
                        enableCalculations();
                        break;
                    case R.id.zero:
                        input.append("0");
                        if(isEnough(input.getText().toString())){
                            result.setEnabled(true);
                        }
                        break;
                    case R.id.one:
                        input.append("1");
                        if(isEnough(input.getText().toString())){
                            result.setEnabled(true);
                        }
                        break;
                    case R.id.two:
                        input.append("2");
                        if(isEnough(input.getText().toString())){
                            result.setEnabled(true);
                        }
                        break;
                    case R.id.three:
                        input.append("3");
                        if(isEnough(input.getText().toString())){
                            result.setEnabled(true);
                        }
                        break;
                    case R.id.four:
                        input.append("4");
                        if(isEnough(input.getText().toString())){
                            result.setEnabled(true);
                        }
                        break;
                    case R.id.five:
                        input.append("5");
                        if(isEnough(input.getText().toString())){
                            result.setEnabled(true);
                        }
                        break;
                    case R.id.six:
                        input.append("6");
                        if(isEnough(input.getText().toString())){
                            result.setEnabled(true);
                        }
                        break;
                    case R.id.seven:
                        input.append("7");
                        if(isEnough(input.getText().toString())){
                            result.setEnabled(true);
                        }
                        break;
                    case R.id.eight:
                        input.append("8");
                        if(isEnough(input.getText().toString())){
                            result.setEnabled(true);
                        }
                        break;
                    case R.id.nine:
                        input.append("9");
                        if(isEnough(input.getText().toString())){
                            result.setEnabled(true);
                        }
                        break;
                    default:
                        if(isEnough(input.getText().toString())){
                            result.setEnabled(true);
                        }
                }
            }
        };

        plus.setOnClickListener(onClick);
        minus.setOnClickListener(onClick);
        divide.setOnClickListener(onClick);
        multiply.setOnClickListener(onClick);
        result.setOnClickListener(onClick);
        zero.setOnClickListener(onClick);
        one.setOnClickListener(onClick);
        two.setOnClickListener(onClick);
        three.setOnClickListener(onClick);
        four.setOnClickListener(onClick);
        five.setOnClickListener(onClick);
        six.setOnClickListener(onClick);
        seven.setOnClickListener(onClick);
        eight.setOnClickListener(onClick);
        nine.setOnClickListener(onClick);
    }

    private boolean hasPlus(String text) {
        return text.contains("+");
    }

    private boolean hasMinus(String text) {
        return text.contains("-");
    }

    private boolean hasDivide(String text) {
        return text.contains("/");
    }

    private boolean hasMultiply(String text) {
        return text.contains("*");
    }

    private boolean isEnough(String text) {
        String[] splitted = text.split("[+-/*]");
        return splitted.length == 2;
    }

    private void disableOperations() {
        plus.setEnabled(false);
        minus.setEnabled(false);
        multiply.setEnabled(false);
        divide.setEnabled(false);
    }

    private void enableCalculations() {
        plus.setEnabled(true);
        minus.setEnabled(true);
        multiply.setEnabled(true);
        divide.setEnabled(true);    }

    private String calculcate(String text) {
        Double result;
        String[] splitted = text.split("[+-/*]");
        Double leftValue = Double.parseDouble(splitted[0]);
        Double rightValue = Double.parseDouble(splitted[1]);
        if(hasPlus(text)){
            result = leftValue + rightValue;
            return result.toString();
        }
        else if(hasDivide(text)){
            if(splitted[1].equals("0")) {
                return "Denominator shouldn't be 0";
            } else {
                result = leftValue / rightValue;
                return result.toString();
            }
        }
        else if(hasMinus(text)) {
            result = leftValue - rightValue;
            return result.toString();
        }
        else {
            result = leftValue * rightValue;
            return result.toString();
        }
    }
}