package cn.machine.geek.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class AlipayController {
    @Autowired
    private AlipayClient alipayClient;

    @GetMapping(value = "/order")
    public String order(){
        return "order";
    }

    @PostMapping(value = "/payPage")
    public String payPage(@RequestParam(value = "money")String money, Map<String,Object> map){
        AlipayTradePagePayRequest alipayTradePagePayRequest = new AlipayTradePagePayRequest();
        alipayTradePagePayRequest.setReturnUrl("https://www.baidu.com/");
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("out_trade_no","NAT201503201");
            jsonObject.put("total_amount",money);
            jsonObject.put("product_code","FAST_INSTANT_TRADE_PAY");
            jsonObject.put("total_amount",money);
            jsonObject.put("subject","外星人台式电脑");
            jsonObject.put("body","外星人台式电脑");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String jsonStr = jsonObject.toString();
        System.out.println(jsonStr);
        alipayTradePagePayRequest.setBizContent(jsonStr);
        String form = "";
        try {
            form = alipayClient.pageExecute(alipayTradePagePayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        map.put("redirectForm",form);
        return "payPage";
    }
}
