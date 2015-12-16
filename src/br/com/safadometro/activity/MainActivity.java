package br.com.safadometro.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText campoDia, campoMes, campoAno;
	private TextView vagabundo, anjo;
	private Button btnCalcular;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//romeve a barra de thema
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main_activity);
		
		campoDia = (EditText) findViewById(R.id.campoDia);
		campoDia.setFilters(new InputFilter[]{new InputFilterMinMax(01, 31)});
		
		campoMes = (EditText) findViewById(R.id.campoMes);
		campoMes.setFilters(new InputFilter[]{new InputFilterMinMax(01, 12)});
		
		campoAno = (EditText) findViewById(R.id.campoAno);
		campoAno.setFilters(new InputFilter[]{new InputFilterMinMax(00, 99)});
		
		vagabundo = (TextView) findViewById(R.id.vagabundo);
		anjo = (TextView) findViewById(R.id.anjo);
		btnCalcular = (Button) findViewById(R.id.btnCalcularData);		
		btnCalcular.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				if(verificaPreenchido(campoDia) && verificaPreenchido(campoMes) && verificaPreenchido(campoAno)){
					calcularPorcentagem(converterInt(campoDia), converterInt(campoMes), converterInt(campoAno));					
				}else{
					Toast.makeText(getApplicationContext(), "Preencha todos os Campos!", Toast.LENGTH_SHORT).show();
				}
			}
		});
		
	}
	
	/**
	 * Metodo Que calcula a porcentagem
	 * @param dia
	 * @param mes
	 * @param ano
	 */
	private void calcularPorcentagem(int dia, int mes, int ano){
		Double safadeza, anjo, anoD, diaD, mesD = 0.0;
		diaD = (double) dia;
		mesD = (double) this.somatorio(mes);
		anoD = (double) ano;
		anjo = 100d;
		
		
		safadeza = mesD + (anoD / 100d) * (50d - diaD);
		anjo = anjo - safadeza;
		
		
		this.anjo.setText(Math.round(anjo) +" % Anjo");
		this.vagabundo.setText(safadeza +" % Vagabundo");
		
	}
	
	/**
	 * metodo que calcula o somatorio de um numero (3+2+1...) com recursividade
	 * @param numero
	 * @return
	 */
	private int somatorio(int numero){
		  	if (numero <= 0)
		  	 return 0;
		  	else
		  	 return numero + somatorio(numero - 1);
	}
	
	/**
	 * converte o valor do campo para int
	 * @param campo
	 * @return
	 */
	private int converterInt(EditText campo){
		Integer retorno;
		retorno = Integer.parseInt(campo.getText().toString());
		return retorno;
		
	}
		
	private boolean verificaPreenchido(EditText campo){
		String valor = campo.getText().toString();
		
		if (valor == "" || valor == null){
			return false;			
		}else{
			return true;
		}
	}
	
}
