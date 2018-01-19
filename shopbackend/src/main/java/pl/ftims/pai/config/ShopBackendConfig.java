package pl.ftims.pai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import pl.ftims.pai.central.CentralDao;

@Configuration
public class ShopBackendConfig {

    private static String WS_CENTRAL_URI = "http://localhost:63160/CentralWebService.asmx";

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("pl.ftims.pai.central.client");
        return marshaller;
    }

    @Bean
    public CentralDao centralDao(Jaxb2Marshaller marshaller) {
        CentralDao centralDao = new CentralDao(WS_CENTRAL_URI);
        centralDao.setDefaultUri(WS_CENTRAL_URI);
        centralDao.setMarshaller(marshaller);
        centralDao.setUnmarshaller(marshaller);
        return centralDao;
    }
}
