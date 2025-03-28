package br.com.fecapccp.n1heltai2;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivitySobre extends AppCompatActivity {

    private Button btnT2Reset;

    private TextView textT2Resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_sobre);

        textT2Resultado = findViewById(R.id.textT2Resultado);
        btnT2Reset = findViewById(R.id.btnT2Reset);

        //Recebendo dados


        double imc = getIntent().getDoubleExtra("IMC", 0.0);

        String resultado = "IMC: " +imc;

        textT2Resultado.setText(resultado);

        btnT2Reset.setOnClickListener(view ->{
            finish();
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i("Ciclo de vida", "Tela 2 - onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i("Ciclo de vida", "Tela 2 - onPause");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("Ciclo de vida", "Tela 2 - onDestroy");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("Ciclo de vida", "Tela 2 - onStop");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i("Ciclo de vida", "Tela 2 - onStart");
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("Ciclo de vida", "Tela 2 - onRestart");
    }
}