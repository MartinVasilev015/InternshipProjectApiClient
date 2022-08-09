package restclient.main.services;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import restclient.main.entites.Bill;
import restclient.main.entites.Merchant;
import restclient.main.entites.Payment;
import restclient.main.entites.Transaction;
import restclient.main.entites.dto.RequestDto;
import restclient.main.entites.dto.getMerchantResponseEntity;

@Component
public class RestClientService
{
	RestTemplate restTemplate = new RestTemplate();

    //@Value("${service.url}")
    private final String url = "http://localhost:8787";
     
	public List<Merchant> getAllMerchants()
	{	
		String modifiedUrl = url + "/merchants";
		
		ResponseEntity<getMerchantResponseEntity> response = restTemplate.getForEntity(modifiedUrl, getMerchantResponseEntity.class);
		
		List<Merchant> result = response.getBody().getMerchants();
		
		for(Merchant m : result) 
		{
			System.out.print(m.getFullName());
		}
		
		return result;
	}
	
	public Bill checkBill(RequestDto dto) 
	{
		return restTemplate.postForEntity(url + "/merchants", dto, Bill.class).getBody();
	}
	
	public Payment checkBillBlocked(RequestDto dto) 
	{
		return restTemplate.postForEntity(url + "/merchants/blocked", dto, Payment.class).getBody();
	}
	
	public Payment payBill(RequestDto dto) 
	{
		return restTemplate.postForEntity(url + "/merchants/pay", dto, Payment.class).getBody();
	}
	
	public Payment reverseBill(RequestDto dto) 
	{
		return restTemplate.postForEntity(url + "/merchants/reverse", dto, Payment.class).getBody();
	}
	
	public Transaction checkDeposit(RequestDto dto) 
	{
		return restTemplate.postForEntity(url + "/merchants/deposit", dto, Transaction.class).getBody();
	}
	
	public Payment payDeposit(RequestDto dto) 
	{
		return restTemplate.postForEntity(url + "/merchants/pay/deposit", dto, Payment.class).getBody();
	}
	
	public Payment reverseDeposit(RequestDto dto) 
	{
		return restTemplate.postForEntity(url + "/merchants/deposit/reverse", dto, Payment.class).getBody();
	}
}
