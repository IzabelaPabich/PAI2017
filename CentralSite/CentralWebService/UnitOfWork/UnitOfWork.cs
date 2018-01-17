using CentralWebService.Data;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace CentralWebService.UnitOfWork
{
    public class UnitOfWorkEntity
    {
        private pai2017Entities context = new pai2017Entities();
        private GenericRepository<LOCALIZATION> localizationRepository;
        private GenericRepository<ORDER> orderRepository;
        private GenericRepository<ORDERSTATUS> orderStatusRepository;
        private GenericRepository<PRODUCT> productRepository;
        private GenericRepository<PRODUCT_TYPE> productTypeRepository;
        private GenericRepository<STORE> storeRepository;

        public GenericRepository<LOCALIZATION> LocalizationRepository
        {
            get
            {
                return this.localizationRepository ?? new GenericRepository<LOCALIZATION>(context);
            }
        }
        
        public GenericRepository<ORDER> OrderRepository
        {
            get
            {
                return this.orderRepository ?? new GenericRepository<ORDER>(context);
            }
        }

        public GenericRepository<ORDERSTATUS> OrderStatusRepository
        {
            get
            {
                return this.orderStatusRepository ?? new GenericRepository<ORDERSTATUS>(context);
            }
        }

        public GenericRepository<PRODUCT> ProductRepository
        {
            get
            {
                return this.productRepository ?? new GenericRepository<PRODUCT>(context);
            }
        }

        public GenericRepository<PRODUCT_TYPE> ProductTypeRepository
        {
            get
            {
                return this.productTypeRepository ?? new GenericRepository<PRODUCT_TYPE>(context);
            }
        }

        public GenericRepository<STORE> StoreRepository
        {
            get
            {
                return this.storeRepository ?? new GenericRepository<STORE>(context);
            }
        }

        public void Save()
        {
            context.SaveChanges();
        }

        //private bool disposed = false;

        //protected virtual void Dispose(bool disposing)
        //{
        //    if (!this.disposed)
        //    {
        //        if (disposing)
        //        {
        //            context.Dispose();
        //        }
        //    }
        //    this.disposed = true;
        //}

        //public void Dispose()
        //{
        //    Dispose(true);
        //    GC.SuppressFinalize(this);
        //}
    }
}