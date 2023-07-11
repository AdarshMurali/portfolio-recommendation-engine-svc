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
import java.util.Objects;

@Service
public class StockWebService {

    @Autowired
    RestTemplate restTemplate;

    String apiKey = "OYNAIBBI5UIVZ5OE";

    @Autowired
    private StockBasicDetailsRepository stockBasicDetailsRepository;


    @Autowired
    private StockTimeSeriesDataRepository stockTimeSeriesDataRepository;


    private List<String> getDistinctSymbol(){
        return stockTimeSeriesDataRepository.getDistinctSymbol();
    }

    private List<StockBasicDetails> getStockBasicDetails(){
        return stockBasicDetailsRepository.findAll();
    }

    public String loadTimeSeriesData() throws IOException {

        ResponseEntity<String> response = null;

        List<StockBasicDetails> stockBasicDetails = stockBasicDetailsRepository.findAll();
        List<String> exisitngSymbol = stockTimeSeriesDataRepository.getDistinctSymbol();

        String uri = "https://www.alphavantage.co/query?function=TIME_SERIES_WEEKLY_ADJUSTED&symbol=input&outputsize=FULL&apikey="+apiKey;

        System.out.println(" ");
        System.out.println("Total trip  "+stockBasicDetails.size());
        System.out.println(" ");
        for(int i = 0; i < stockBasicDetails.size() ; i++){

            if(exisitngSymbol.contains(stockBasicDetails.get(i).getSymbol())){
                System.out.println("Symbol details is already present "+stockBasicDetails.get(i).getSymbol());
                continue;
            }

            if(Objects.isNull(stockBasicDetails.get(i).getSymbol())){
                continue;
            }

            if(Objects.isNull(stockBasicDetails.get(i).getSNO())){
                continue;
            }

            System.out.println(" ");
            System.out.println("Started fetching details for : "+stockBasicDetails.get(i).getSymbol());
            List<StockTimeSeriesData> list = new ArrayList<>();
            String url = uri.replace("input", stockBasicDetails.get(i).getSymbol());
            response = restTemplate.getForEntity(url, String.class);
            String productsJson = response.getBody();

            HashMap<String, Object> result = new ObjectMapper().readValue(productsJson, new TypeReference<Map<String, Object>>(){});
            int counter = 0;
            for (Map.Entry<String,Object> entry : result.entrySet()){
                if(entry.getKey().equalsIgnoreCase("Weekly Adjusted Time Series")){
                   HashMap<String, Object> hm =  ((LinkedHashMap) entry.getValue());
                   for (Map.Entry<String, Object> e : hm.entrySet()) {
                        String key = e.getKey();
                        counter++;
                        System.out.println("Key "+key );
                        if(key.contains("2017")){
                            System.out.println("Breaking "+counter);
                            break;
                        }
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
                        std.setSplit_coefficient( "");
                       list.add(std);
                    }
                    try{
                        System.out.println("INSERTING ROWS "+ list.size());
                        stockTimeSeriesDataRepository.saveAll(list);
                        System.out.println("RESULT : SUCCESS"+ stockBasicDetails.get(i).getSymbol() );
                    }catch (Exception ee){
                        System.out.println("RESULT : FAILURE"+ stockBasicDetails.get(i).getSymbol() );
                        ee.printStackTrace();
                    }
                }
            }
        }



    return "productsJson";
    }
}
