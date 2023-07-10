package com.wellsfargo.portfoliorecommendationengine.service;

import com.wellsfargo.portfoliorecommendationengine.entity.TimeSeriesResponse;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StockWebService {

    @Autowired
    RestTemplate restTemplate;

    String apiKey = "X8N115V4N6A1QCIG";


    public String loadTimeSeriesData() {
        String[] stocks = new String[] {"CARR", "CBOE", "IBM"};

        String uri1 = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol=CARR&outputsize=compact&apikey="+apiKey;
        String uri2 = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol=CBOE&outputsize=compact&apikey="+apiKey;
        String uri3 = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol=ARE&outputsize=compact&apikey="+apiKey;



        for(int i = 0; i < stocks.length ; i++){
            ResponseEntity<String> response
                    = restTemplate.getForEntity(uri1, String.class);

            String productsJson = response.getBody();
            Object data = response.getBody();
            System.out.println(productsJson);

            JSONObject parser = new JSONObject(productsJson);
//            JSONObject timeSeriesParser = parser.get("Time Series (Daily)").entrySet().stream().findFirst().get().value;
            JSONObject parser2 = new JSONObject(productsJson);
        }



    return "productsJson";
    }
}
