package br.com.safadometro.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
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
		setContentView(R.layout.main_activity);
		campoDia = (EditText) findViewById(R.id.campoDia);
		campoMes = (EditText) findViewById(R.id.campoMes);
		campoAno = (EditText) findViewById(R.id.campoAno);
		vagabundo = (TextView) findViewById(R.id.vagabundo);
		anjo = (TextView) findViewById(R.id.anjo);
		btnCalcular = (Button) findViewById(R.id.btnCalcularData);		
		btnCalcular.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				calcularPorcentagem(converterInt(campoDia), converterInt(campoMes), converterInt(campoAno));
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
		int safadeza, anjo;
		
		safadeza = this.somatorio(mes) + (ano / 100) * (50 - dia);
		anjo = 100 - safadeza;
		
		this.anjo.setText(anjo +" % Anjo");
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
		

}
