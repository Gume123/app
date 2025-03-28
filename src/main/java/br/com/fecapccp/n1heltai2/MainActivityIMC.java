package br.com.fecapccp.n1heltai2;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivityIMC extends AppCompatActivity {
    private Button btn;
    private Button btnReset;
    DecimalFormat df = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_imc);
        btnReset = findViewById(R.id.reset);

        btn = findViewById(R.id.set);

        // Configura o botão
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculo();
            }
        });

        btnReset.setOnClickListener(view ->{
            finish();
        });

        // Ajuste de padding para a barra de status (evita erro)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void calculo() {
        EditText peso = findViewById(R.id.peso);
        EditText altura = findViewById(R.id.altura);

        String valorPeso = peso.getText().toString();
        String valorAltura = altura.getText().toString();

        // Verifica se os campos estão vazios antes de tentar converter
        if (valorPeso.isEmpty() || valorAltura.isEmpty()) {
            return; // Evita erro de conversão
        }

        double intPeso = Double.parseDouble(valorPeso);
        double intAltura = Double.parseDouble(valorAltura);

        // Evita divisão por zero
        if (intAltura == 0) {
            return;
        }

        double imc = intPeso / (intAltura * intAltura);
        String resultado = df.format(imc);


        Class<?> activityDestino;
        if (imc < 18.5) {
            activityDestino = MainActivityAbaixo.class;
        } else if (imc < 24.9) {
            activityDestino = MainActivityNormal.class;
        } else if (imc < 29.9) {
            activityDestino = MainActivitySobre.class;
        } else if (imc < 34.9) {
            activityDestino = MainActivityOb1.class;
        } else if (imc < 39.9) {
            activityDestino = MainActivityOb2.class;
        } else {
            activityDestino = MainActivityOb3.class;
        }

        Intent intent = new Intent(this, activityDestino);
        intent.putExtra("IMC", resultado);
        startActivity(intent);
    }




    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Ciclo de vida", "Home - onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Ciclo de vida", "Home - onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Ciclo de vida", "Home - onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Ciclo de vida", "Home - onStop");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Ciclo de vida", "Home - onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Ciclo de vida", "Home - onRestart");
    }
}
