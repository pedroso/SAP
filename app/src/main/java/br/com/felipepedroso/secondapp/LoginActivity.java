package br.com.felipepedroso.secondapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import br.com.felipepedroso.consumidor.RetrieveFeedTask;


public class LoginActivity extends Activity {
    public static final String PREFS_NAME = "UserLogin";
    EditText edtUsuario;
    EditText edtSenha;
    CheckBox chkSalvarCredenciais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsuario = (EditText) findViewById(R.id.edtUsuario);
        edtSenha = (EditText) findViewById(R.id.edtSenha);
        chkSalvarCredenciais = (CheckBox) findViewById(R.id.chkSalvarCredenciais);

        this.load();
    }

    public void load(){
        SharedPreferences sharedPreferences = getSharedPreferences("UserLogin", Context.MODE_PRIVATE);

        String usuarioText = sharedPreferences.getString("usuario", "EmptyValue");
        String senhaText = sharedPreferences.getString("senha", "EmptyValue");

        if(!"EmptyValue".equals(usuarioText) && !"EmptyValue".equals(senhaText)) {
            edtUsuario.setText(usuarioText);
            edtSenha.setText(senhaText);
            chkSalvarCredenciais.setChecked(true);
        }
    }

    public void logar(View view){

        SharedPreferences sharedPreferences = getSharedPreferences("UserLogin", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String usuario = edtUsuario.getText().toString();
        String senha = edtSenha.getText().toString();
        boolean salvarCredenciais = chkSalvarCredenciais.isChecked();

        boolean usuarioValido = "felipe".equals(usuario) && "123".equals(senha);

        RetrieveFeedTask feedTask = new RetrieveFeedTask();
        feedTask.setPathUrl(usuario + "/" + senha);

        feedTask.execute();

        if(usuarioValido){

            if(salvarCredenciais) {
                editor.putString("usuario", usuario);
                editor.putString("senha", senha);
                Toast.makeText(this, "Adicionado ao Shared Preferences !", Toast.LENGTH_SHORT).show();
            }else{
                editor.remove("usuario");
                editor.remove("senha");
            }

            editor.commit();

            //Realizar consulta ao WebService para autenticação!
            Intent intent = new Intent(this,  MainActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Üsuário e/ou senha inválido(s) !", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
