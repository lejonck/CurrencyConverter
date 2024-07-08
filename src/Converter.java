import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Converter {
   private double conversionRate;

   public double getValue(String original, String goal){
       convert(original, goal);
       return conversionRate;
   }

   private void convert(String original, String goal){

       //Vai retornar todas as taxas
       String address = "https://v6.exchangerate-api.com/v6/d2bf95069a817e9ed49738f2/latest/" + original;

       try {
           HttpClient client = HttpClient.newHttpClient();
           HttpRequest request = HttpRequest.newBuilder()
                   .uri(URI.create(address))
                   .build();

           HttpResponse<String> response = client
                   .send(request, HttpResponse.BodyHandlers.ofString());

           String json = response.body();

           Gson gson = new Gson();
           JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
           JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
           conversionRate = conversionRates.get(goal).getAsDouble();


       } catch (IOException | InterruptedException e) {
               System.out.println(e.getMessage());
       }
   }
}
