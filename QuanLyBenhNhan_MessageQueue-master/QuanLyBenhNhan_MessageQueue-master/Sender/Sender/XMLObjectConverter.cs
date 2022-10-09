using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Serialization;

namespace Sender
{
    public class XMLObjectConverter<T>
    {
        public String objectToXML(T p)
        {
            string xml = "";

            XmlSerializer serializer = new XmlSerializer(typeof(T));
            using (MemoryStream ms = new MemoryStream())
            {
                serializer.Serialize(ms, p);    
                ms.Position = 0;
                xml = new StreamReader(ms).ReadToEnd(); 
            }

            return xml;
        }
    }
}
