package kr.ac.baekseok.calculator20240311;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // 전역변수영역 위젯의 객체참조변수를 선언 위젯을 사용하려면 객체참조변수선언
        EditText edtNum1,edtNum2;
        Button btnAdd;

        Button btnMinus;
        Button btnDiv;
        Button btnMiltiple;
        TextView textResult;
        // 클래스 사용에러위치에서 alt+enter 자동으로 클래스 추가

        String num1, num2; // 임시변수 a,b
        Integer sum;
        Double DivResult;
        String DivResult2; // String.format("%.1f", DivResult); 실수형 출력형식 지정문자

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 화면을 열자마자 위젯이 사용하게 설정되어 있어야함. 인스턴스생성, 이벤트설정완료
        //모든 위젯은 클래스라서 인스턴스생성해서 사용
        edtNum1=(EditText)findViewById(R.id.edtNum1);// R.jar 파일의 id필드에서 메모리할당
        edtNum2=(EditText)findViewById(R.id.edtNum2);
        btnAdd=(Button)findViewById(R.id.Add);// 이번 안드로이드 스튜디오의 버그 에러선이 나오는데, 오류가 아님
        textResult=(TextView) findViewById(R.id.textResult);
        // 시나이로 버튼을 누르면 입력란 1,2에 입력한 숫자를 연산하는 클릭이벤트를 설정
        //숫자는 사용자가 입력했다고 보고 클릭이벤트 버튼에 설정
        btnMinus=(Button)findViewById(R.id.Minus);
        btnDiv=(Button)findViewById(R.id.Div);
        btnMiltiple=(Button)findViewById(R.id.Multiple);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //클랙 했을 때 동작을 기술
                num1= edtNum1.getText().toString(); // 임시변수 입력란에서 글자가져와서 String 형으로 변환
                num2= edtNum2.getText().toString();
                // 연산 + 산술연산 정수형으로 연산 한다고 가정. String => Int Integer.parseInt()를 사용하려고 Integer형으로 변환
                sum =Integer.parseInt(num1) + Integer.parseInt(num2); // 합을 구해짐 TextView 계산결과 : 15 <= String 타입
                textResult.setText("계산결과: "+ sum.toString()); //+는 문자열 연결 연산자, sum은 Integer타입 String형으로 형변환 하자 텍스트뷰에 글자를 설정하는 메소드

            }
        }); // btnAdd

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edtNum1.getText().toString();
                num2 = edtNum2.getText().toString();
                sum = Integer.parseInt(num1) - Integer.parseInt(num2);
                textResult.setText("계산결과: " + sum.toString());
            }
        }); // btnMinus

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edtNum1.getText().toString();
                num2 = edtNum2.getText().toString();
                DivResult = Double.parseDouble(num1) / Double.parseDouble(num2);
                DivResult2 = String.format("%.1f",DivResult);
                textResult.setText("계산결과: " +DivResult2);
            }
        }); // btnDiv
        // 실수형은 어떻게 할 것인가?

        btnMiltiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edtNum1.getText().toString();
                num2 = edtNum2.getText().toString();
                sum = Integer.parseInt(num1) * Integer.parseInt(num2);
                textResult.setText("계산결과 : " + sum.toString());

            }
        });


    }// oncreate()
}// MainActivity