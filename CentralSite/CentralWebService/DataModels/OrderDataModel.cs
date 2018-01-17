using CentralWebService.Data;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace CentralWebService.DataModels
{
    public class OrderDataModel
    {
        public int Id { get; set; }
        public int ProductId { get; set; }
        public int StoreId { get; set; }
        public int OrderStatusId { get; set; }
        public int Quantity { get; set; }
        public bool IsRealized { get; set; }

        public OrderDataModel(ORDER order)
        {
            Id = order.ID;
            ProductId = order.PRODUCTID;
            StoreId = order.STOREID;
            OrderStatusId = order.ORDERSTATUSID;
            Quantity = order.QUANTITY;
            IsRealized = order.ISREALIZED;
        }

        public OrderDataModel() { }
    }
}