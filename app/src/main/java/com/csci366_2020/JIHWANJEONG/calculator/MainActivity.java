package com.csci366_2020.JIHWANJEONG.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Stack;
import java.util.StringTokenizer;


public class MainActivity extends AppCompatActivity {

    // DECLARE BUTTON VARIABLES
    Button btn_num0, btn_num00, btn_num1, btn_num2, btn_num3, btn_num4, btn_num5, btn_num6, btn_num7, btn_num8,
        btn_num9, btn_dot, btn_calculation, btn_ac, btn_division, btn_multiplication, btn_subtraction, btn_addition;

    // DECLARE THE EDIT TEXT
    EditText editTextInput;

    // DECLARE THE TEXT VIEW
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // RECEIVE ID FOR EVERY BUTTON
        btn_num0 = findViewById(R.id.button_num0);
        btn_num00 = findViewById(R.id.button_num00);
        btn_num1 = findViewById(R.id.button_num1);
        btn_num2 = findViewById(R.id.button_num2);
        btn_num3 = findViewById(R.id.button_num3);
        btn_num4 = findViewById(R.id.button_num4);
        btn_num5 = findViewById(R.id.button_num5);
        btn_num6 = findViewById(R.id.button_num6);
        btn_num7 = findViewById(R.id.button_num7);
        btn_num8 = findViewById(R.id.button_num8);
        btn_num9 = findViewById(R.id.button_num9);
        btn_dot = findViewById(R.id.button_dot);
        btn_division = findViewById(R.id.button_division);
        btn_multiplication = findViewById(R.id.button_multiplication);
        btn_subtraction = findViewById(R.id.button_subtraction);
        btn_addition = findViewById(R.id.button_addition);
        btn_ac = findViewById(R.id.button_ac);
        btn_calculation = findViewById(R.id.button_calculation);

        // RECEIVE ID FOR EDIT TEXT AND TEXT VIEW
        editTextInput = findViewById(R.id.editTextInput);
        textViewResult = findViewById(R.id.textViewResult);

        // BUTTON MOUSE CLICK LISTENER
        btn_num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextInput.setText(editTextInput.getText().toString()+"0");
            }
        });
        btn_num00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextInput.getText().equals("") || editTextInput.getText().length() == 0)
                    editTextInput.setText("0");
                else
                    editTextInput.setText(editTextInput.getText().toString()+"00");
            }
        });
        btn_num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextInput.setText(editTextInput.getText().toString()+"1");
            }
        });
        btn_num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextInput.setText(editTextInput.getText().toString()+"2");
            }
        });
        btn_num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextInput.setText(editTextInput.getText().toString()+"3");
            }
        });
        btn_num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextInput.setText(editTextInput.getText().toString()+"4");
            }
        });
        btn_num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextInput.setText(editTextInput.getText().toString()+"5");
            }
        });
        btn_num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextInput.setText(editTextInput.getText().toString()+"6");
            }
        });
        btn_num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextInput.setText(editTextInput.getText().toString()+"7");
            }
        });
        btn_num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextInput.setText(editTextInput.getText().toString()+"8");
            }
        });
        btn_num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextInput.setText(editTextInput.getText().toString()+"9");
            }
        });
        btn_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextInput.setText(editTextInput.getText().toString()+".");
            }
        });
        btn_division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(!editTextInput.getText().equals("")) {
                        // PREVENT A USER FROM USING DUPLICATE OPERATOR
                        if(editTextInput.getText().toString().charAt(editTextInput.getText().toString().length()-1)!='÷' &&
                                editTextInput.getText().toString().charAt(editTextInput.getText().toString().length()-1)!='×' &&
                                editTextInput.getText().toString().charAt(editTextInput.getText().toString().length()-1)!='-' &&
                                editTextInput.getText().toString().charAt(editTextInput.getText().toString().length()-1)!='+')
                            editTextInput.setText(editTextInput.getText().toString()+"÷");
                    }
                } catch (Exception e) {
                    textViewResult.setText("Error occurs.");
                }
            }
        });
        btn_multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(!editTextInput.getText().equals("")) {
                        // PREVENT A USER FROM USING DUPLICATE OPERATOR
                        if (editTextInput.getText().toString().charAt(editTextInput.getText().toString().length() - 1) != '÷' &&
                                editTextInput.getText().toString().charAt(editTextInput.getText().toString().length() - 1) != '×' &&
                                editTextInput.getText().toString().charAt(editTextInput.getText().toString().length() - 1) != '-' &&
                                editTextInput.getText().toString().charAt(editTextInput.getText().toString().length() - 1) != '+')
                            editTextInput.setText(editTextInput.getText().toString() + "×");
                    }
                } catch (Exception e) {
                    textViewResult.setText("Error occurs.");
                }
            }
        });
        btn_subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(editTextInput.getText().equals("") || editTextInput.getText().length() == 0) {
                        editTextInput.setText(editTextInput.getText().toString() + "-");
                    }
                    else if(!editTextInput.getText().equals("")) {
                        // PREVENT A USER FROM USING DUPLICATE OPERATOR
                        if (editTextInput.getText().toString().charAt(editTextInput.getText().toString().length() - 1) != '÷' &&
                                editTextInput.getText().toString().charAt(editTextInput.getText().toString().length() - 1) != '×' &&
                                editTextInput.getText().toString().charAt(editTextInput.getText().toString().length() - 1) != '-' &&
                                editTextInput.getText().toString().charAt(editTextInput.getText().toString().length() - 1) != '+')
                            editTextInput.setText(editTextInput.getText().toString() + "-");
                    }
                } catch (Exception e) {
                    textViewResult.setText("Error occurs.");
                }
            }
        });
        btn_addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(editTextInput.getText().equals("") || editTextInput.getText().length() == 0) {
                        editTextInput.setText(editTextInput.getText().toString() + "+");
                    }
                    else if(!editTextInput.getText().equals("")) {
                        // PREVENT A USER FROM USING DUPLICATE OPERATOR
                        if (editTextInput.getText().toString().charAt(editTextInput.getText().toString().length() - 1) != '÷' &&
                                editTextInput.getText().toString().charAt(editTextInput.getText().toString().length() - 1) != '×' &&
                                editTextInput.getText().toString().charAt(editTextInput.getText().toString().length() - 1) != '-' &&
                                editTextInput.getText().toString().charAt(editTextInput.getText().toString().length() - 1) != '+')
                            editTextInput.setText(editTextInput.getText().toString() + "+");
                    }
                } catch (Exception e) {
                    textViewResult.setText("Error occurs.");
                }
            }
        });
        btn_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextInput.setText("");
                textViewResult.setText("");
            }
        });
        btn_calculation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewResult.setText(calculation(editTextInput.getText().toString()) + "");
            }
        });
    }

    public String calculation(String str) {
        try {

            // Using StringTokenizer class, numbers and operators can be stored into multiple tokens.
            StringTokenizer st_number = new StringTokenizer(str, "+-÷× ");
            StringTokenizer st_operator = new StringTokenizer(str, "1234567890. ");

            // Using STACK (LIFO: Last In First Out), it performs each calculation.
            Stack<Double> calcStack = new Stack <>();

            // Check for whether the first index's value of the string is negative or not.
            if (str.charAt(0) == '-') {
                calcStack.push(-1 * Double.parseDouble(st_number.nextToken()));
                // Call the next operator's token.
                st_operator.nextToken();
            }
            // Check for whether the first index's value of the string is positive or not.
            else if(str.charAt(0) == '+') {
                calcStack.push(Double.parseDouble(st_number.nextToken()));
                // Call the next operator's token.
                st_operator.nextToken();
            }
            // If the first index's value of the string is neither negative nor positive, the number is pushed.
            else {
                calcStack.push(Double.parseDouble(st_number.nextToken()));
            }

            while(st_number.hasMoreTokens()) {
                // Receive next tokens of operator and number.
                String operator = st_operator.nextToken();
                String number = st_number.nextToken();
                double stackNum;

                // If the operator is multiplication, the next number is picked(popped) and calculated first.
                if (operator.equals("×")) {
                    stackNum = calcStack.pop();
                    calcStack.push(stackNum * Double.parseDouble(number));
                }
                // If the operator is division, the next number is picked(popped) and calculated first.
                else if (operator.equals("÷")) {
                    // Exception Handling when performing division.
                    try {
                        stackNum = calcStack.pop();
                        if (Double.parseDouble(number) == 0.0) {
                            return "Cannot be divided by 0.";
                        }
                        calcStack.push(stackNum / Double.parseDouble(number));
                    } catch(ArithmeticException e) {
                        return "Arithmetic exception occurs.";
                    } catch(Exception e) {
                        return "Exception occurs.";
                    }
                }
                // If the operator is addition, the number is pushed without any performance.
                else if (operator.equals("+")) {
                    calcStack.push(Double.parseDouble(number));
                }
                // If the operator is subtraction, the number is multiplied by -1 to make the number negative.
                else if (operator.equals("-")) {
                    calcStack.push(-1 * Double.parseDouble(number));
                }
            }

            // INITIALIZE AN VARIABLE FOR THE TOTAL VALUE.
            double total = 0;

            // ADD ALL NUMBERS INSIDE THE STACK.
            while (!calcStack.isEmpty()) {
                total += calcStack.pop();
            }

            // IF THE RESULT IS LIKE 2.0, IT CONVERTS 2 AND RETURN THIS INTEGER.
            if (total == (int) total) {
                int result = (int) total;
                return Integer.toString(result);
            }
            // PRINT UP TO 3 DECIMAL POINTS.
            return Double.toString(Math.round(total * 1000) / 1000.0);
        } catch(Exception ex) {
            // EXCEPTION HANDLING
            return "Error occurs, please check again.";
        }
    }
}