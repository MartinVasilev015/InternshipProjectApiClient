package restclient.main.tests;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import restclient.main.entites.Bill;
import restclient.main.entites.Merchant;
import restclient.main.entites.Payment;
import restclient.main.entites.Transaction;
import restclient.main.entites.dto.RequestDto;
import restclient.main.services.RestClientService;

@SpringBootTest
class IntershipApiClientApplicationTests 
{
	RestClientService service = new RestClientService();
	
	
	void getMerchantsTest() 
	{
		List<Merchant> merchants = service.getAllMerchants();
		int a = 2;
		
		assertThat(a = merchants.size());
	}
	
	@Test
	void checkBillTest() 
	{
		RequestDto request = new RequestDto();
		request.setMerchantId("0001111");
		request.setSubscrNumber("1121212");
		request.setTransactionId("120");
		
		Bill bill = service.checkBill(request);
		
		int a = 1000;
		String b = "00";
		
		assertThat(a = bill.getAmount());
		assertThat(b = bill.getStatus());
	}
	
	@Test
	void checkBillBlockedTest() 
	{
		RequestDto request = new RequestDto();
		request.setMerchantId("0001111");
		request.setSubscrNumber("1121212");
		request.setTransactionId("120");
		request.setDateTime("20221212");
		
		Payment p = service.checkBillBlocked(request);
		
		int a = 1000;
		String b = "00";
		
		assertThat(a = p.getAmount());
		assertThat(b = p.getStatus());
	}

	@Test
	void payBillTest() 
	{
		RequestDto request = new RequestDto();
		request.setMerchantId("0000001");
		request.setSubscrNumber("1000007");
		request.setTransactionId("100000");
		request.setDateTime("20101201101224");
		request.setAmount("1032");
		
		Payment p = service.payBill(request);
		
		String status = "00";
		String shortDesc = "OK";
		
		assertThat(status.equals(p.getStatus()));
		assertThat(shortDesc.equals(p.getShortDesc()));
	}
	
	@Test
	void reverseBillTest() 
	{
		RequestDto request = new RequestDto();
		request.setMerchantId("0000001");
		request.setSubscrNumber("1000007");
		request.setTransactionId("100000");
		request.setDateTime("20101201101224");
		request.setAmount("1032");
		
		Payment p = service.reverseBill(request);
		
		String status = "00";
		String shortDesc = "OK";

		assertThat(status.equals(p.getStatus()));
		assertThat(shortDesc.equals(p.getShortDesc()));
	}
	
	@Test
	void checkDepositTest() 
	{
		RequestDto request = new RequestDto();
		request.setMerchantId("0000001");
		request.setSubscrNumber("1000007");
		request.setTransactionId("100000");
		request.setDateTime("20101201101224");
		request.setAmount("1032");
		
		Transaction t = service.checkDeposit(request);
		
		String status = "00";
		String shortDesc = "OK";
		int total = 1042;

		assertThat(status.equals(t.getStatus()));
		assertThat(shortDesc.equals(t.getShortDesc()));
		assertThat(total = t.getTotal());
	}
	
	@Test
	void payDepositTest() 
	{
		RequestDto request = new RequestDto();
		request.setMerchantId("0000001");
		request.setSubscrNumber("1000007");
		request.setTransactionId("100000");
		request.setDateTime("20101201101224");
		request.setAmount("1032");
		
		Payment p = service.payDeposit(request);
		
		String status = "00";
		String shortDesc = "OK";

		assertThat(status.equals(p.getStatus()));
		assertThat(shortDesc.equals(p.getShortDesc()));
	}
}
