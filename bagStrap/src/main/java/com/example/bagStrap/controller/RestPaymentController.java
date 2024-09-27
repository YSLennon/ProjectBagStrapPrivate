package com.example.bagStrap.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bagStrap.dao.PaymentService;
import com.google.gson.Gson;

import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;

@RestController
public class RestPaymentController {
	
	final DefaultMessageService messageService;
   
    
	RestPaymentController(){
		 messageService = NurigoApp.INSTANCE.initialize("NCSHXQO3OAHZUOMV", "ZDYOZP2QELY0HMJA6VJY7NT0G3BXLDI0", "https://api.coolsms.co.kr");	
	}
	
	
	@Autowired
	PaymentService paymentService;
	
	@Value("${IMP_API_KEY}")
    private String apiKey;
	 
    @Value("${IMP_API_SECRETKEY}")
    private String secretKey;
	
	@RequestMapping(value = "/refund.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String payment(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap();
		ResponseEntity<Map> resultValue = null;		
		try {
			HashMap<String, Object> tokenMap = getToken();
			resultValue = paymentService.refund(map, tokenMap);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		return new Gson().toJson(resultValue);
	}

    
	public HashMap<String, Object> getToken() throws Exception {
        Gson gson = new Gson();

        // 요청 본문 (JSON 형식의 데이터)
        HashMap<String, Object> impMap = new HashMap<String, Object>();
        impMap.put("imp_key", apiKey);
        impMap.put("imp_secret", secretKey);
        String jsonBody = gson.toJson(impMap);
        
        HashMap<String, Object> resultMap = (HashMap<String, Object>) paymentService.getToken(impMap).getBody(); 
        HashMap<String, Object> response = (HashMap<String, Object>) resultMap.get("response");
        
        return response;
	}
	
	@RequestMapping(value = "confirm.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String confirmPhoneNumb(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap();

		try {

			Random random = new Random();
			int randomInt = random.nextInt(100000, 1000000);
				
			resultMap.put("response", sendOne(map, randomInt));
			resultMap.put("confirmNumb", randomInt);
			
		} catch(Exception e) {
			resultMap.put("response", e.getMessage());
		}
		return new Gson().toJson(resultMap);
	}
	
    private SingleMessageSentResponse sendOne(HashMap<String, Object> map, int randomInt) throws Exception {

        Message message = new Message();
        // 발신번호 및 수신번호는 반드시 01012345678 형태로 입력되어야 합니다.
        message.setFrom("01046548947");
        message.setTo(map.get("userPhone").toString());
		message.setText("비밀번호 확인을 위한 인증번호입니다. 절대 타인에게 공유하지마세요. 인증번호 : " + randomInt);

        SingleMessageSentResponse response = messageService.sendOne(new SingleMessageSendingRequest(message));
        System.out.println(response);

        return response;
    }
}

