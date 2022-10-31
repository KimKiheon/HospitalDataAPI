import com.example.hospitaldata.domain.dto.Hospital;
import com.example.hospitaldata.parser.HospitalParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HospitalParserTest {
    String line1="1,의원,3620000,PHMA119993620020041100004,19990612,1,13,062-515-2875,광주광역시 북구 풍향동 565번지 4호 3층,광주광역시 북구 동문대로 24, 3층 (풍향동),효치과의원,치과의원,1,0,0,52.29";
    @Test
    @DisplayName("csv 1줄 Hospital로 잘 만드나?")
    void convertHospital(){
        HospitalParser hp = new HospitalParser();
        Hospital hospital = hp.parse("line1");
    }
}
