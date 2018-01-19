package pl.ftims.pai.central;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import pl.ftims.pai.central.client.GetAllProducts;
import pl.ftims.pai.central.client.GetAllProductsResponse;
import pl.ftims.pai.central.client.ProductDataModel;
import pl.ftims.pai.entities.Product;
import pl.ftims.pai.entities.ProductType;

import java.util.List;
import java.util.stream.Collectors;

public class CentralDao extends WebServiceGatewaySupport {

    private String webserviceUrl;

    public CentralDao(String webserviceUrl) {
        this.webserviceUrl = webserviceUrl;
    }

    public List<Product> getProductsFromCentral() {

        GetAllProducts allProductsRequest = new GetAllProducts();
        GetAllProductsResponse allProductsResponse =
                (GetAllProductsResponse) getWebServiceTemplate()
                        .marshalSendAndReceive(webserviceUrl, allProductsRequest,
                                new SoapActionCallback("http://tempuri.org/GetAllProducts"));

        List<ProductDataModel> productsFromCentral =
                allProductsResponse.getGetAllProductsResult().getProductDataModel();

        return productsFromCentral.stream()
                .map(this::productDataModelToProduct)
                .collect(Collectors.toList());
    }

    private Product productDataModelToProduct(ProductDataModel productDataModel) {
        Product product = new Product();
        product.setName(productDataModel.getName());
        product.setColor(productDataModel.getColor());
        product.setDescription(productDataModel.getDescription());

        ProductType productType = new ProductType();
        productType.setName(productDataModel.getProductType());
        productType.setDescription(productDataModel.getProductType());
        product.setProductType(productType);

        return product;
    }
}
