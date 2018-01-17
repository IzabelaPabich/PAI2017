using CentralWebService.Data;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace CentralWebService.DataModels
{
    public class StoreDataModel
    {
        public int Id { get; set; }
        public int LocalizationId { get; set; }
        public string Name { get; set; }
        public string Description { get; set; }
        public string PhoneNumber { get; set; }
        public string Email { get; set; }
        public string WebSite { get; set; }
        public string Localizaton { get; set; }

        public StoreDataModel(STORE store)
        {
            Id = store.ID;
            LocalizationId = store.LOCALIZATIONID;
            Name = store.NAME;
            Description = store.DESCRIPTION;
            PhoneNumber = store.PHONENUMBER;
            Email = store.EMAIL;
            WebSite = store.WEBSITE;
            Localizaton = store.LOCALIZATION.COUNTRY + " " + store.LOCALIZATION.CITY + " " + store.LOCALIZATION.STREET + " " + store.LOCALIZATION.NUMBER;
        }

        public StoreDataModel() { }
    }
}