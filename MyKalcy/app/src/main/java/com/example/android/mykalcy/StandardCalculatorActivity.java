package com.example.android.mykalcy;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fathzer.soft.javaluator.DoubleEvaluator;

public class StandardCalculatorActivity extends AppCompatActivity {

    Button button1, button2, button3, button4, button5, button6, button7,
            button8, button9, button0, buttonDecimal, buttonEquals, buttonAdd, buttonSub, buttonMultiply, buttonDivide,
            buttonOpenBrace, buttonCloseBrace, buttonBackspace, buttonPercentage, buttonChangeSign;
    EditText editor;
    TextView result;
    int braceCounter = 0;

    DrawerLayout mDrawerLayout;
    Button drawerButton;
    LinearLayout drawer;

    Button inverse, degRad, constant, sin, cos, tan, log, ln, hyp, square, root, fact, power, fraction, prem;
    boolean inverseFlag = false, degRadFlag=false, hypFlag=false;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard_calculator);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerButton = (Button) findViewById(R.id.drawer_button);
        drawer = (LinearLayout) findViewById(R.id.drawer);


        drawerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mDrawerLayout.isDrawerOpen(drawer)) {
                    mDrawerLayout.closeDrawer(drawer);
                } else if (!mDrawerLayout.isDrawerOpen(drawer)) {
                    mDrawerLayout.openDrawer(drawer);
                }
            }
        });

        button1 = (Button) findViewById(R.id.Button1);
        button2 = (Button) findViewById(R.id.Button2);
        button3 = (Button) findViewById(R.id.Button3);
        button4 = (Button) findViewById(R.id.Button4);
        button5 = (Button) findViewById(R.id.Button5);
        button6 = (Button) findViewById(R.id.Button6);
        button7 = (Button) findViewById(R.id.Button7);
        button8 = (Button) findViewById(R.id.Button8);
        button9 = (Button) findViewById(R.id.Button9);
        button0 = (Button) findViewById(R.id.Button0);
        buttonDecimal = (Button) findViewById(R.id.ButtonDecimal);
        buttonAdd = (Button) findViewById(R.id.ButtonAdd);
        buttonSub = (Button) findViewById(R.id.ButtonSub);
        buttonMultiply = (Button) findViewById(R.id.ButtonMultiply);
        buttonDivide = (Button) findViewById(R.id.ButtonDivide);
        buttonEquals = (Button) findViewById(R.id.ButtonEquals);
        buttonOpenBrace = (Button) findViewById(R.id.ButtonOpenBrace);
        buttonCloseBrace = (Button) findViewById(R.id.ButtonCloseBrace);
        buttonBackspace = (Button) findViewById(R.id.ButtonBackspace);
        buttonChangeSign = (Button) findViewById(R.id.ButtonChangeSign);
        buttonPercentage = (Button) findViewById(R.id.ButtonPercentage);

        inverse = (Button) findViewById(R.id.inverse);
        degRad = (Button) findViewById(R.id.deg_rad);
        constant = (Button) findViewById(R.id.constant);
        sin = (Button) findViewById(R.id.sin);
        cos = (Button) findViewById(R.id.cos);
        tan = (Button) findViewById(R.id.tan);
        log = (Button) findViewById(R.id.log);
        ln = (Button) findViewById(R.id.ln);
        hyp = (Button) findViewById(R.id.hyp);
        square = (Button) findViewById(R.id.square);
        power = (Button) findViewById(R.id.power);
        root = (Button) findViewById(R.id.root);
        fact = (Button) findViewById(R.id.factorial);
        prem = (Button) findViewById(R.id.permutation);
        fraction = (Button) findViewById(R.id.fraction);

        editor = (EditText) findViewById(R.id.editor);

        result = (TextView) findViewById(R.id.result);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.setText(editor.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.setText(editor.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.setText(editor.getText() + "3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.setText(editor.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.setText(editor.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.setText(editor.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.setText(editor.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.setText(editor.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.setText(editor.getText() + "9");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.setText(editor.getText() + "0");
            }
        });

        buttonDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.setText(editor.getText() + ".");
            }
        });

        buttonOpenBrace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editor==null || editor.length()==0){
                    editor.setText("(");
                    braceCounter++;
                } else {
                    String temp = editor.getText().toString();
                    String value = temp.substring(temp.length() - 1, temp.length());
                    if (value.equals("+") || value.equals("-") || value.equals("×") || value.equals("÷") || value.equals("(")) {
                        editor.setText(editor.getText() + "(");
                        braceCounter++;
                    } else {
                        editor.setText(editor.getText());
                    }
                }
            }
        });

        buttonCloseBrace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(braceCounter>0){
                    String temp = editor.getText().toString();
                    String value = temp.substring(temp.length() - 1, temp.length());
                    if(value.equals("+") || value.equals("-") ||value.equals("×") || value.equals("÷") || value.equals("("))
                        editor.setText(editor.getText());
                    else {
                        editor.setText(editor.getText() + ")");
                        braceCounter--;
                    }
                }
                else {
                    editor.setText(editor.getText());
                }
            }
        });

        buttonBackspace.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                editor.setText(null);
                result.setText(null);
                return true;
            }
        });

        buttonBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editor.getText() == null || editor.getText().toString().length() <= 0) {
                    editor.setText(null);
                    result.setText(null);
                } else {
                    String temp = editor.getText().toString();
                    String value = temp.substring(temp.length() - 1, temp.length());
                    if(value.equals("("))
                        braceCounter--;
                    else if(value.equals(")"))
                        braceCounter++;
                    editor.setText(temp.substring(0, temp.length() - 1));
                    result.setText("");
                }
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editor == null || editor.length() <= 0) {
                    editor.setText("");
                } else {
                    String temp = editor.getText().toString();
                    String value = temp.substring(temp.length() - 1, temp.length());
                    if (value.equals("-") || value.equals("×") || value.equals("÷"))
                        editor.setText(temp.substring(0, temp.length() - 1));
                    if (value.equals("+"))
                        editor.setText(editor.getText());
                    else
                        editor.setText(editor.getText() + "+");
                }
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editor == null || editor.length() <= 0) {
                    editor.setText("");
                } else {
                    String temp = editor.getText().toString();
                    String value = temp.substring(temp.length() - 1, temp.length());
                    if (value.equals("+") || value.equals("×") || value.equals("÷"))
                        editor.setText(temp.substring(0, temp.length() - 1));
                    if (value.equals("-"))
                        editor.setText(editor.getText());
                    else
                        editor.setText(editor.getText() + "-");
                }
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editor == null || editor.length() <= 0) {
                    editor.setText("");
                } else {
                    String temp = editor.getText().toString();
                    String value = temp.substring(temp.length() - 1, temp.length());
                    if (value.equals("-") || value.equals("+") || value.equals("÷"))
                        editor.setText(temp.substring(0, temp.length() - 1));
                    if (value.equals("×"))
                        editor.setText(editor.getText());
                    else
                        editor.setText(editor.getText() + "×");
                }
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editor == null || editor.length() <= 0) {
                    editor.setText("");
                } else {
                    String temp = editor.getText().toString();
                    String value = temp.substring(temp.length() - 1, temp.length());
                    if (value.equals("-") || value.equals("×") || value.equals("+"))
                        editor.setText(temp.substring(0, temp.length() - 1));
                    if (value.equals("÷"))
                        editor.setText(editor.getText());
                    else
                        editor.setText(editor.getText() + "÷");
                }
            }
        });

        buttonPercentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editor.length() <= 0 || editor == null) {
                    editor.setText(null);
                } else {
                    String temp = editor.getText().toString();
                    //float temp = Float.parseFloat(result.getText() + "");
                    DoubleEvaluator evaluator = new DoubleEvaluator();
                    Float value = Float.parseFloat(evaluator.evaluate(temp).toString());
                    setValue(value / 100 + "");
                }
            }
        });

        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editor == null || editor.length() <= 0)
                    editor.setText(null);
                else {
                    String temp = editor.getText().toString();
                    String value = temp.substring(temp.length() - 1, temp.length());
                    if (value.equals("-") || value.equals("×") || value.equals("+") || value.equals("÷"))
                        editor.setText(editor.getText());
                    else {
                        ExtendedDoubleEvaluator evaluator = new ExtendedDoubleEvaluator();
                        setValue(evaluator.evaluate(temp).toString());
                    }
                }
            }
        });

        buttonChangeSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editor.length() != 0) {
                    String s = editor.getText().toString();
                    char arr[] = s.toCharArray();
                    if (arr[0] == '-')
                        editor.setText(s.substring(1, s.length()));
                    else
                        editor.setText("-" + s);
                }
            }
        });

        fraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (result.length() <= 0 || result == null) {
                    result.setText(null);
                } else {
                    String temp = result.getText().toString();
                    Float value = Float.parseFloat(temp);
                    int numberOfDecimalDigits = temp.length() - temp.indexOf('.');
                    int denominator = 1;
                    for (int i = 0; i < numberOfDecimalDigits; i++) {
                        value *= 10;
                        denominator *= 10;
                    }
                    int numerator = (int) Math.round(value);
                    int greatestCommonFactor = greatestCommonFactor(numerator, denominator);
                    numerator = numerator / greatestCommonFactor;
                    denominator = denominator / greatestCommonFactor;
                    if (denominator == 1)
                        result.setText(numerator + "");
                    else
                        result.setText(numerator + "/" + denominator);
                }
            }
        });

        inverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inverseFlag == false){
                    inverseFlag = true;
                    if(hypFlag==false){
                        sin.setText(R.string.sininv);
                        cos.setText(R.string.cosinv);
                        tan.setText(R.string.taninv);
                    } else {
                        sin.setText(R.string.sinhinv);
                        cos.setText(R.string.coshinv);
                        tan.setText(R.string.tanhinv);
                    }
                    log.setText(R.string.tenpow);
                    ln.setText(R.string.epown);
                    square.setText(R.string.cube);
                    root.setText(R.string.cuberoot);
                    fact.setText(R.string.xinv);
                    power.setText(R.string.nrootx);
                    fraction.setText("a b/c");
                    prem.setText("nCr");
                }
                else{
                    inverseFlag = false;
                    if(hypFlag==false){
                        sin.setText("sin");
                        cos.setText("cos");
                        tan.setText("tan");
                    } else {
                        sin.setText("sinh");
                        cos.setText("cosh");
                        tan.setText("tanh");
                    }
                    log.setText("log");
                    ln.setText("ln");
                    square.setText(R.string.square);
                    root.setText(R.string.sqrt);
                    fact.setText("x!");
                    power.setText(R.string.xpown);
                    fraction.setText("a/b");
                    prem.setText("nPr");
                }
            }
        });

        hyp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(hypFlag==false){
                    hypFlag = true;
                    if(inverseFlag==false){
                        sin.setText("sinh");
                        cos.setText("cosh");
                        tan.setText("tanh");
                    } else {
                        sin.setText(R.string.sinhinv);
                        cos.setText(R.string.coshinv);
                        tan.setText(R.string.tanhinv);
                    }
                } else {
                    hypFlag = false;
                    if(inverseFlag==false){
                        sin.setText("sin");
                        cos.setText("cos");
                        tan.setText("tan");
                    } else {
                        sin.setText(R.string.sininv);
                        cos.setText(R.string.cosinv);
                        tan.setText(R.string.taninv);
                    }
                }
            }
        });

        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inverseFlag){
                    if(hypFlag){
                        editor.setText(editor.getText()+ "asinh(");
                    }
                    else
                        editor.setText(editor.getText()+ "asin(");
                } else {
                    if(hypFlag)
                        editor.setText(editor.getText()+ "sinh(");
                    else
                        editor.setText(editor.getText()+ "sin(");
                }

                braceCounter++;
            }
        });

        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inverseFlag){
                    if(hypFlag){
                        editor.setText(editor.getText()+ "acosh(");
                    }
                    else
                        editor.setText(editor.getText()+ "acos(");
                } else {
                    if(hypFlag)
                        editor.setText(editor.getText()+ "cosh(");
                    else
                        editor.setText(editor.getText()+ "cos(");
                }

                braceCounter++;
            }
        });

        tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inverseFlag){
                    if(hypFlag){
                        editor.setText(editor.getText()+ "atanh(");
                    }
                    else
                        editor.setText(editor.getText()+ "atan(");
                } else {
                    if(hypFlag)
                        editor.setText(editor.getText()+ "tanh(");
                    else
                        editor.setText(editor.getText()+ "tan(");
                }

                braceCounter++;
            }
        });

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inverseFlag){
                    editor.setText(editor.getText() + "10^(");
                } else {
                    editor.setText(editor.getText() + "log(");
                }
                braceCounter++;
            }
        });

        ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inverseFlag){
                    editor.setText(editor.getText() + "e^(");
                } else  {
                    editor.setText(editor.getText() + "ln(");
                }
                braceCounter++;
            }
        });

        square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inverseFlag){
                    editor.setText(editor.getText()+"^3");
                } else {
                    editor.setText(editor.getText()+"^2");
                }
            }
        });

        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inverseFlag){
                    editor.setText(editor.getText()+"cbrt(");
                } else {
                    editor.setText(editor.getText()+"sqrt(");
                }
                braceCounter++;
            }
        });

        fact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inverseFlag){
                    editor.setText("1/"+editor.getText());
                } else {
                    int f = factorial(Integer.parseInt(editor.getText().toString()));
                    result.setText(f);
                }
            }
        });
    }


    public void setValue(String resultValue) {
        float temp = Float.parseFloat(resultValue);
        if (Math.floor(temp) == temp) {
            String s = resultValue.substring(0, resultValue.indexOf('.'));
            int i = Integer.parseInt(s);
            result.setText(i + "");
        } else {
            result.setText(temp + "");
        }
    }

    public int greatestCommonFactor(int num, int denom) {
        if (denom == 0) {
            return num;
        }
        return greatestCommonFactor(denom, num % denom);
    }

    public int factorial(int num){
        if(num==0){
            return 1;
        } else {
            return (num * factorial(num-1));
        }
    }

}

