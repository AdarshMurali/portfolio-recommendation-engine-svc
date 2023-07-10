package com.wellsfargo.portfoliorecommendationengine.service;

import com.wellsfargo.portfoliorecommendationengine.entity.StockBasicDetails;
import com.wellsfargo.portfoliorecommendationengine.entity.StockTimeSeriesData;
import com.wellsfargo.portfoliorecommendationengine.entity.TimeSeriesResponse;
import com.wellsfargo.portfoliorecommendationengine.repository.StockBasicDetailsRepository;
import com.wellsfargo.portfoliorecommendationengine.repository.StockTimeSeriesDataRepository;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
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


    @Autowired
    private StockTimeSeriesDataRepository stockTimeSeriesDataRepository;


    public String loadTimeSeriesData() throws IOException {

        ResponseEntity<String> response = null;
        List<StockBasicDetails> stockBasicDetails = stockBasicDetailsRepository.findAll();

        String uri = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol=input&outputsize=compact&apikey="+apiKey;




        for(int i = 0; i < stockBasicDetails.size() ; i++){
            List<StockTimeSeriesData> list = new ArrayList<>();
            String url = uri.replace("input", stockBasicDetails.get(i).getSymbol());
//            System.out.println(" Url "+url);
            response = restTemplate.getForEntity(url, String.class);
            String productsJson = response.getBody();



            HashMap<String, Object> result = new ObjectMapper().readValue(productsJson, new TypeReference<Map<String, Object>>(){});

            for (Map.Entry<String,Object> entry : result.entrySet()){



                if(entry.getKey().equalsIgnoreCase("Time Series (Daily)")){
                    System.out.println("Key = " + entry.getKey() +
                            ", Value = " + entry.getValue());

                   HashMap<String, Object> hm =  ((LinkedHashMap) entry.getValue());


                   for (Map.Entry<String, Object> e : hm.entrySet()) {
                        String key = e.getKey();
                        HashMap<String, String> valueMap = (LinkedHashMap)e.getValue();
                        StockTimeSeriesData std = new StockTimeSeriesData();
                        std.setS_No(stockBasicDetails.get(i).getSNO());
                        std.setSymbol(stockBasicDetails.get(i).getSymbol());
                        std.setOpen( valueMap.get("1. open"));
                        std.setHigh( valueMap.get("2. high"));
                        std.setLow( valueMap.get("3. low"));
                        std.setClose( valueMap.get("4. close"));
                        std.setRefreshed(key.toString());
                        std.setAdjusted_close( valueMap.get("5. adjusted close"));
                        std.setVolume( valueMap.get("6. volume"));
                        std.setDividend_amount( valueMap.get("7. dividend amount"));
                        std.setSplit_coefficient( valueMap.get("8. split coefficient"));
                        try{
                            stockTimeSeriesDataRepository.save(std);
                        }catch (Exception ee){
                            ee.printStackTrace();
                        }
                       list.add(std);
                    }

                }

                int k =0;
            }

            int k =0;

        }



    return "productsJson";
    }
}
