package com.wellsfargo.portfoliorecommendationengine.service;

import com.wellsfargo.portfoliorecommendationengine.entity.StockBasicDetails;
import com.wellsfargo.portfoliorecommendationengine.entity.StockTimeSeriesData;
import com.wellsfargo.portfoliorecommendationengine.entity.TimeSeriesResponse;
import com.wellsfargo.portfoliorecommendationengine.repository.StockBasicDetailsRepository;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class StockWebService {

    @Autowired
    RestTemplate restTemplate;

    String apiKey = "X8N115V4N6A1QCIG";

    @Autowired
    private StockBasicDetailsRepository stockBasicDetailsRepository;


    public String loadTimeSeriesData() throws IOException {

        ResponseEntity<String> response = null;
        List<StockBasicDetails> stockBasicDetails = stockBasicDetailsRepository.findAll();

        String uri = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol=input&outputsize=compact&apikey="+apiKey;




        for(int i = 0; i < stockBasicDetails.size() ; i++){
            String url = uri.replace("input", stockBasicDetails.get(i).getSymbol());
            System.out.println(" Url "+url);
            response = restTemplate.getForEntity(url, String.class);
            String productsJson = response.getBody();
            System.out.println(productsJson);

            JSONObject parser = new JSONObject(productsJson);
            JSONObject timeSeriesParser = (JSONObject) parser.get("Time Series (Daily)");
            LinkedHashMap<String, Object> result = new ObjectMapper().readValue(String.valueOf(timeSeriesParser), new TypeReference<Object>(){});

            try {
//                StockBasicDetails stockBasicDetailsResponse = (StockBasicDetails) result.get("2023-07-07");
                ObjectMapper mapper = new ObjectMapper();
                StockTimeSeriesData data = mapper.convertValue(result.get("2023-07-07"), new TypeReference<StockTimeSeriesData>() { });
            }catch (Exception e){
                e.printStackTrace();
            }
            int k = 0;

break;
        }



    return "productsJson";
    }
}
