package br.com.safadometro.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	private View campoDia, campoMes, campoAno;
	private Button btnCalcular;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		campoDia = findViewById(R.id.campoDia);
		campoMes = findViewById(R.id.campoMes);
		campoAno = findViewById(R.id.campoAno);
		btnCalcular = (Button) findViewById(R.id.btnCalcularData);
		
		btnCalcular.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

	
	//	private OnDateSetListener listener = new OnDateSetListener() {
//		@Override
//		public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//			StringBuilder builderDate = new StringBuilder();
//			ano = year;
//			mes = monthOfYear;
//			dia = dayOfMonth;
//			builderDate.append(dia);
//			builderDate.append("/");
//			builderDate.append(mes+1);
//			builderDate.append("/");
//			builderDate.append(ano);
//			btnCalcular.setText(builderDate);
//		
//		}
//	};
	
	
//	public void bindView(){
//		DateTime dateTime = new DateTime();
//		StringBuilder builderDate = new StringBuilder();
//		ano = dateTime.getYear();
//		mes = dateTime.getMonthOfYear();
//		dia = dateTime.getDayOfMonth();
//		builderDate.append(dia);
//		builderDate.append("/");
//		builderDate.append(mes);
//		builderDate.append("/");
//		builderDate.append(ano);
//		btnCalcular.setText(builderDate);
//	}
	
	
//	@Override
//	protected Dialog onCreateDialog(int id) {
//		if(R.id.btnSelecionarData == id){
//			if(ano == 1988 && mes == 9 && dia == 6){
//				Toast.makeText(getBaseContext(), "SAFADO", Toast.LENGTH_LONG).show();
//			}
//			return new DatePickerDialog(this, listener, ano, mes, dia);
//		}
//	   return null;
//	}
	
}