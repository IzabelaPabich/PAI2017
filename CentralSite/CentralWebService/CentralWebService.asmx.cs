using CentralWebService.Data;
using CentralWebService.DataModels;
using CentralWebService.UnitOfWork;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace CentralWebService
{
    /// <summary>
    /// Summary description for CentralWebService
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class CentralWebService : System.Web.Services.WebService
    {
        UnitOfWorkEntity uow = new UnitOfWorkEntity();

        [WebMethod]
        public ProductDataModel GetProducts(int ProductId)
        {
            var product = uow.ProductRepository.Get(x => x.ID == ProductId).FirstOrDefault();
            var res = new ProductDataModel(product);
            return res;
        }

        [WebMethod]
        public List<ProductDataModel> GetAllProducts()
        {
            var result = new List<ProductDataModel>();
            var products = uow.ProductRepository.GetAll();
            foreach(var product in products)
            {
                result.Add(new ProductDataModel(product));
            }

            return result;
        }

        [WebMethod]
        public void EditProduct(ProductDataModel product)
        {
            uow.ProductRepository.Update(new PRODUCT {
                ID = product.Id,
                COLOR = product.Color,
                DESCRIPTION = product.Description,
                NAME = product.Name,
                PRODUCTTYPEID = product.ProductTypeId,
                QUANTITY = product.Quantity
            });

            uow.Save();
        }

        [WebMethod]
        public void DeleteProduct(int productId)
        {
            uow.ProductRepository.Delete(productId);
            uow.Save();
        }

        [WebMethod]
        public void AddProduct(ProductDataModel product)
        {
            uow.ProductRepository.Insert(new PRODUCT
            {
                COLOR = product.Color,
                DESCRIPTION = product.Description,
                NAME = product.Name,
                PRODUCTTYPEID = product.ProductTypeId,
                QUANTITY = product.Quantity
            });
            uow.Save();
        }

        [WebMethod]
        public List<StoreDataModel> GetAllStores()
        {
            var result = new List<StoreDataModel>();
            var stores = uow.StoreRepository.GetAll();
            foreach (var store in stores)
            {
                result.Add(new StoreDataModel(store));
            }

            return result;
        }

        [WebMethod]
        public List<OrderDataModel> GetAllOrders()
        {
            var result = new List<OrderDataModel>();
            var orders = uow.OrderRepository.GetAll();
            foreach (var order in orders)
            {
                result.Add(new OrderDataModel(order));
            }

            return result;
        }

        [WebMethod]
        public List<ProductTypeDataModel> GetAllProductTypes()
        {
            var result = new List<ProductTypeDataModel>();
            var productTypes = uow.ProductTypeRepository.GetAll();
            foreach (var productType in productTypes)
            {
                result.Add(new ProductTypeDataModel(productType));
            }

            return result;
        }
    }
}