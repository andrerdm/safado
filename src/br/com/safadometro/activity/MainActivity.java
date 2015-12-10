package br.com.safadometro.activity;

import org.joda.time.DateTime;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import br.com.safadometro.activity.R;

public class MainActivity extends Activity {

	//private EditText editTextData;
	private Integer dia, mes, ano;
	private Button btnCalcular;

	private OnDateSetListener listener = new OnDateSetListener() {
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
			StringBuilder builderDate = new StringBuilder();
			ano = year;
			mes = monthOfYear;
			dia = dayOfMonth;
			builderDate.append(dia);
			builderDate.append("/");
			builderDate.append(mes+1);
			builderDate.append("/");
			builderDate.append(ano);
			btnCalcular.setText(builderDate);
		
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		//editTextData = (EditText) findViewById(R.id.editTextData);
		btnCalcular = (Button) findViewById(R.id.btnSelecionarData);
		bindView();
	}
	
	public void bindView(){
		DateTime dateTime = new DateTime();
		StringBuilder builderDate = new StringBuilder();
		ano = dateTime.getYear();
		mes = dateTime.getMonthOfYear();
		dia = dateTime.getDayOfMonth();
		builderDate.append(dia);
		builderDate.append("/");
		builderDate.append(mes);
		builderDate.append("/");
		builderDate.append(ano);
		btnCalcular.setText(builderDate);
	}
	
	public void selecionarData(View view){
		showDialog(view.getId());
	}
	
	@Override
	protected Dialog onCreateDialog(int id) {
		if(R.id.btnSelecionarData == id){
			if(ano == 1988 && mes == 9 && dia == 6){
				Toast.makeText(getBaseContext(), "SAFADO", Toast.LENGTH_LONG).show();
			}
			return new DatePickerDialog(this, listener, ano, mes, dia);
		}
	   return null;
	}
}