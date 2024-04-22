package th.ac.utcc.kradadtodapi.services;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import th.ac.utcc.kradadtodapi.models.slip.TransactionResponse;

@Service
public class SlipOKService {
    public TransactionResponse fetchSlipOkData(String qrValue) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Authorization", "SLIPOKEGP0L4Q");
        headers.setContentType(MediaType.APPLICATION_JSON);

        String requestBody = "{\"data\":\"" + qrValue + "\"}";

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<TransactionResponse> response = restTemplate.exchange(
                "https://api.slipok.com/api/line/apikey/20443",
                HttpMethod.POST,
                entity,
                TransactionResponse.class
        );

        return response.getBody();
    }
}
