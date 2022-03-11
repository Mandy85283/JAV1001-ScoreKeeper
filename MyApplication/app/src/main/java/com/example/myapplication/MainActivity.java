
package com.example.myapplication;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public class MainActivity extends AppCompatActivity {
TextView Working;
TextView Result;
String Workings = "";
    Double Results = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTextViews();
    }

    private void initTextViews() {
        Working = (TextView)findViewById(R.id.Working);
        Result = (TextView)findViewById(R.id.Result);
    }
private void setWorkings(String Value)
{
    Workings = Workings + Value;
    Working.setText(Workings);
}


    public void clearOnClick(View view){
        Working.setText("");
        Workings = "";
        Result.setText("");
    }
    public void EqualOnClick(View view){

ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
try{
    Results = (Double)engine.eval(Workings);
}catch (ScriptException e){
    Toast.makeText(this,"Invalid Input",Toast.LENGTH_SHORT).show();
}
if (Results != null){
    Result.setText(String.valueOf(Results.doubleValue()));
}
    }
    public void PlusMinusOnClick(View view){
Results = Results * -1;
        Result.setText(String.valueOf(Results.doubleValue()));
    }
    public void PercentOnClick(View view){
        setWorkings("%");
    }
    public void DivideOnClick(View view){
        setWorkings("/");
    }
    public void MultiplyOnClick(View view){
        setWorkings("*");
    }
    public void MinusOnClick(View view){
        setWorkings("-");
    }
    public void AddOnClick(View view){
        setWorkings("+");
    }
    public void PointOnClick(View view){
        setWorkings(".");
    }
    public void ZeroOnClick(View view){
        setWorkings("0");
    }
    public void OneOnClick(View view){
        setWorkings("1");
    }
    public void TwoOnClick(View view){
        setWorkings("2");
    }
    public void ThreeOnClick(View view){
        setWorkings("3");
    }
    public void FourOnClick(View view){
        setWorkings("4");
    }
    public void FiveOnClick(View view){
        setWorkings("5");
    }
    public void SixOnClick(View view){
        setWorkings("6");
    }
    public void SevenOnClick(View view){
        setWorkings("7");
    }
    public void EightOnClick(View view){
        setWorkings("8");
    }
    public void NineOnClick(View view){
        setWorkings("9");
    }

}