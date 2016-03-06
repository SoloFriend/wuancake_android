package comFrostmaki.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity implements OnClickListener{

	TextView inputText;
	TextView OutputText;
	
	Button but_zero;
	Button but_one;
	Button but_two;
	Button but_three;
	Button but_four;
	Button but_five;
	Button but_six;
	Button but_seven;
	Button but_eight;
	Button but_nine;
	
	Button but_del;
	Button but_clear;
	
	Button but_add;//+
	Button but_minus;//-
	Button but_multiplied;//*
	Button but_divided;// /
	
	Button but_equal;
	
	Button but_point;
	
	public String inputStr;    
	
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    	inputText =(TextView)findViewById(R.id.textInput);
    	OutputText =(TextView)findViewById(R.id.textOnput);
    	
    	but_zero=(Button)findViewById(R.id.but_zero);
    	but_one=(Button)findViewById(R.id.but_one);
    	but_two=(Button)findViewById(R.id.but_two);
    	but_three=(Button)findViewById(R.id.but_three);
    	but_four=(Button)findViewById(R.id.but_four);
    	but_five=(Button)findViewById(R.id.but_five);
    	but_six=(Button)findViewById(R.id.but_six);
    	but_seven=(Button)findViewById(R.id.but_seven);
    	but_eight=(Button)findViewById(R.id.but_eight);
    	but_nine=(Button)findViewById(R.id.but_nine);
    	
    	but_del=(Button)findViewById(R.id.but_del);
    	but_clear=(Button)findViewById(R.id.but_clear);
    	
    	but_add=(Button)findViewById(R.id.but_add);//+
    	but_minus=(Button)findViewById(R.id.but_minus);//-
    	but_multiplied=(Button)findViewById(R.id.but_multiplied);//*
    	but_divided=(Button)findViewById(R.id.but_divided);// /
    	
    	but_equal=(Button)findViewById(R.id.but_equal);
    	
    	but_point=(Button)findViewById(R.id.but_point);
    	
    	inputStr=inputText.getText().toString();
    	
    	
        but_one.setOnClickListener(this);
        but_two.setOnClickListener(this);
        but_three.setOnClickListener(this);
        but_four.setOnClickListener(this);
        but_five.setOnClickListener(this);
        but_six.setOnClickListener(this);
        but_seven.setOnClickListener(this);
        but_nine.setOnClickListener(this);
        but_eight.setOnClickListener(this);
        but_zero.setOnClickListener(this);
        but_point.setOnClickListener(this);
        
        but_del.setOnClickListener(this);
        but_clear.setOnClickListener(this);
        
        but_add.setOnClickListener(this);
        but_minus.setOnClickListener(this);
        but_multiplied.setOnClickListener(this);
        but_divided.setOnClickListener(this);
        
        but_equal.setOnClickListener(this);
        Log.d("cuowu", "button");
    }

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.but_one:
		case R.id.but_two:
		case R.id.but_three:
		case R.id.but_four:
		case R.id.but_five:
		case R.id.but_six:
		case R.id.but_seven:
		case R.id.but_eight:
		case R.id.but_nine:
		case R.id.but_zero:
		case R.id.but_point:
			
			inputStr=inputStr+((Button)v).getText().toString();
			inputText.setText(inputStr);
			Log.d("cuowu", "123456789");
			break;
		case R.id.but_add:
		case R.id.but_minus:
		case R.id.but_multiplied:
		case R.id.but_divided:
			inputStr=inputStr+" "+((Button)v).getText().toString()+" ";
			inputText.setText(inputStr);
			Log.d("cuowu", "+-*/");
			break;
		case R.id.but_del:
			
				if(inputStr.substring(inputStr.length())!=" "){
			       inputStr=inputStr.substring(0, inputStr.length()-1);
			       
				}else{
					inputStr=inputStr.substring(0, inputStr.length()-2);
				}
				inputText.setText(inputStr);
			
			Log.d("cuowu", "del");
			break;
		case R.id.but_clear:
			inputStr="";
			inputText.setText(inputStr);
			Log.d("cuowu", "clear");
			break;
		case R.id.but_equal:
			getResult();
			Log.d("cuowu", "equal");
			break;
		
		}
	}
	
	public void getResult(){
		int int0=0;
		int int1 =inputStr.indexOf(" ");//��һ���ո�
		String str2 =inputStr.substring(0, int1);//ǰһ������
		double d2=Double.parseDouble(str2);
		int int3 =inputStr.indexOf(" ", int1+2);//������һ���ո�
		String str4 =inputStr.substring(int1+3);//��һ������
		double d4=Double.parseDouble(str4);
		String str5 =inputStr.substring(int1+1);   //���������
		//int0=int0+2;
		double d6 = 0;
		if (str5.equals("+")){
			d6=d2 + d4;
		}else if(str5.equals("-")){
			d6=d2 - d4;
		}else if(str5.equals("*")){
			d6=d2 * d4;
		}else if(str5.equals("/")){
			if(d4==0)
			{
				d6=0;
			}else
			{
			    d6=d2 / d4;
			}
		}
		
		OutputText.setText((int)d6+"");	
		
	}
    
    

   
}
