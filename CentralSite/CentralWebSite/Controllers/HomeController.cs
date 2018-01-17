using CentralWebSite.CentralWebService;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace CentralWebSite.Controllers
{
    public class HomeController : Controller
    {
        public static readonly CentralWebService.CentralWebService service = new CentralWebService.CentralWebService();

        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Products()
        {
            return View(service.GetAllProducts().ToList());
        }

        public ActionResult Stores()
        {
            return View(service.GetAllStores().ToList());
        }

        public ActionResult Orders()
        {
            return View(service.GetAllOrders().ToList());
        }

        public ActionResult CreateProduct()
        {
            ViewBag.ProductTypeId = new SelectList(service.GetAllProductTypes(), "Id", "Name");

            return View(new ProductDataModel());
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult CreateProduct([Bind(Include = "Id, Name, Description, Color, ProductTypeId, Quantity, ProductType")] ProductDataModel productDataModel)
        {
            if(ModelState.IsValid)
            {
                service.AddProduct(productDataModel);

                return RedirectToAction("Index");
            }

            ViewBag.ProductTypeId = new SelectList(service.GetAllProductTypes(), "Id", "Name");

            return View(productDataModel);
        }

        public ActionResult EditProduct(int id)
        {
            ProductDataModel product = service.GetProducts(id);

            ViewBag.ProductTypeId = new SelectList(service.GetAllProductTypes(), "Id", "Name");

            return View(product);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult EditProduct([Bind(Include = "Id, Name, Description, Color, ProductTypeId, Quantity, ProductType")] ProductDataModel productDataModel)
        {
            if(ModelState.IsValid)
            {
                service.EditProduct(productDataModel);

                return RedirectToAction("Index");
            }

            ViewBag.ProductTypeId = new SelectList(service.GetAllProductTypes(), "Id", "Name");

            return View(productDataModel);
        }

        public ActionResult DeleteProduct(int id)
        {
            ProductDataModel product = service.GetProducts(id);
            return View(product);
        }

        [HttpPost, ActionName("DeleteProduct")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteProductConfirmed(int id)
        {
            service.DeleteProduct(id);
            return RedirectToAction("Index");
        }
    }
}