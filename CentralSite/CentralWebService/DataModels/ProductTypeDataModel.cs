using CentralWebService.Data;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace CentralWebService.DataModels
{
    public class ProductTypeDataModel
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public string Description { get; set; }

        public ProductTypeDataModel(PRODUCT_TYPE productType)
        {
            Id = productType.ID;
            Name = productType.NAME;
            Description = productType.DESCRIPTION;
        }

        public ProductTypeDataModel() { }
    }
}