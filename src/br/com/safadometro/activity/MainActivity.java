package br.com.safadometro.activity;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
				if(Validator.validateNotNull(campoDia, "Preencha!") && Validator.validateNotNull(campoMes, "Preencha!") && Validator.validateNotNull(campoAno, "Preencha!")){
					calcularPorcentagem(converterInt(campoDia), converterInt(campoMes), converterInt(campoAno));					
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
		DecimalFormat df = new DecimalFormat("0.00");
		float safadeza, anjo, anoF, diaF, mesF = 0f;
		diaF = (float) dia;
		mesF = (float) this.somatorio(mes);
		anoF = (float) ano;
		anjo = 100f;
		
		if(dia == 6 &&  mes == 9 && ano == 88){
			this.anjo.setText(99 +" % Anjo");
			this.vagabundo.setText(1 +" % Vagabundo");
		}else{
			safadeza = calcularSafadeza(diaF, mesF, anoF);	
			anjo = anjo - safadeza;			
			this.anjo.setText(df.format(anjo) +" % Anjo");
			this.vagabundo.setText(df.format(safadeza) +" % Vagabundo");
		}
	}

	private float calcularSafadeza(float dia, float mes, float ano) {		
		float safadeza = (float) (mes + (ano / 100F) * (50F - dia));
		return safadeza;
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
	
}
