using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Services
{
    [Serializable]
    public class Class1
    {
        public String id { get; set; }

        public string title { get; set; }

        public string author { get; set; }

        public String price { get; set; }

        public string publisher { get; set; }

        public Class1() : this("x", "x", "x", "x", "x")
        {
        }
        public Class1(String id, string title, string author, String price, string publisher)
        {
            this.id = id; 
            this.title = title; 
            this.author = author; 
            this.price = price; 
            this.publisher = publisher;

        }

        public override string ToString()
        {
            return id + "\t" + title + "\t" + author + "\t" + price + "\t" + publisher;
        }






    }
}
