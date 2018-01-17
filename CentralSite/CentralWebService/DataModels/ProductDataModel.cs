using CentralWebService.Data;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace CentralWebService.DataModels
{
    public class ProductDataModel
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public string Description { get; set; }
        public string Color { get; set; }
        public int ProductTypeId { get; set; }
        public int Quantity { get; set; }
        public string ProductType { get; set; }

        public ProductDataModel(PRODUCT product)
        {
            Id = product.ID;
            ProductTypeId = product.PRODUCTTYPEID;
            Name = product.NAME;
            Description = product.DESCRIPTION;
            Color = product.COLOR;
            Quantity = product.QUANTITY;
            ProductType = product.PRODUCT_TYPE.NAME;
        }

        public ProductDataModel() { }
    }
}