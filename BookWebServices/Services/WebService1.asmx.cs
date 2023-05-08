using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;


namespace Services
{
    /// <summary>
    /// Summary description for WebService1
    /// </summary>
    [WebService(Namespace = "http://nhopro1.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
     [System.Web.Script.Services.ScriptService]
    public class WebService1 : System.Web.Services.WebService
    {

        public static List<Class1> listbook = new List<Class1>();

        [WebMethod]
        public String add(String id, String title, String author, String price, String publisher)
        {
            Class1 book = new Class1(id, title, author, price, publisher);
            listbook.Add(book);
            return "Thêm thành công";
        }
        [WebMethod]
        public List<Class1> ds()
        {
            return listbook;
        }
        [WebMethod]
        public Class1 ds_id(String id)
        {
            for (int i = 0; i < listbook.Count; i++)
            {
                if (listbook[i].id == id)
                {
                    return listbook[i];
                }
            }

            return null;
        }
        [WebMethod]
        public List<Class1> ds_author(String author)
        {
            List<Class1> s_a = new List<Class1>();
            for (int i = 0; i < listbook.Count; i++)
            {
                if (listbook[i].author == author)
                {
                    s_a.Add(listbook[i]);
                }
            }
            return s_a;
        }
        [WebMethod]
        public List<Class1> ds_published(String pub)
        {
            List<Class1> s_p = new List<Class1>();
            for (int i = 0; i < listbook.Count; i++)
            {
                if (listbook[i].publisher == pub)
                {
                    s_p.Add(listbook[i]);
                }
            }
            return s_p;
        }
        [WebMethod]
        public List<Class1> remove(String id)
        {
            List<Class1> b = new List<Class1>();
            for (int i = 0; i < listbook.Count; i++)
            {
                if (listbook[i].id == id)
                {
                    listbook.Remove(listbook[i]);
                }
            }
            return listbook;
        }



    }
}

