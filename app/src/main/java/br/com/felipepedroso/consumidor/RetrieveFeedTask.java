package br.com.felipepedroso.consumidor;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import br.com.felipepedroso.secondapp.FragmentConteudo;

/**
 * Created by Felipe on 26/02/2015.
 */
public class RetrieveFeedTask extends AsyncTask<String, Void, String> {

    private Exception exception;
    private FragmentConteudo fragmentConteudo;
    private String pathUrl = "";

    protected String doInBackground(String... urls) {
        try {


            String[] response = WebService.getInstance().get("http://192.168.1.104:8080/WSRest-SAPBR/web/" + pathUrl);
            return response[1];
        } catch (Exception e) {
            this.exception = e;
            return "Não foi possível acessar o web-service! Dick! =@";
        }
    }

    public void setPathUrl(String pathUrl) {
        this.pathUrl = pathUrl;
    }

    public String getPathUrl() {
        return pathUrl;
    }

    public void setFragmentConteudo(FragmentConteudo fragmentConteudo){
        this.fragmentConteudo = fragmentConteudo;
    }

    protected void onPostExecute(String response) {
        // TODO: check this.exception
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        try {
            if (response != null) {
                JsonArray jArray = parser.parse(response).getAsJsonArray();
            }
        }catch (Exception e){

        }

        if(this.fragmentConteudo != null){
            //this.fragmentConteudo.alterarTextView("Alterado pelo menu! RESPONSE: " + response);
        }
    }
}