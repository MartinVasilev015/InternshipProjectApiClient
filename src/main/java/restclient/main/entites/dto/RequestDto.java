package restclient.main.entites.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestDto
{
	private String transactionId;
	private String dateTime;
	private String merchantId;
	private String amount;
	private String subscrNumber;
}
