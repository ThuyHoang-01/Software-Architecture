using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace Caculator
{

    /// <summary>
    /// CalculatorWebService cung cấp 4 dịch vụ cho các phép toán cơ bản
    /// </summary>
    [WebService(Namespace = "http://vovanhai.wordpress.com/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    [System.Web.Script.Services.ScriptService]
    public class CalculatorWebService : System.Web.Services.WebService
    {
        [WebMethod]
        public double add(double a, double b)
        {
            return a + b;
        }
        [WebMethod]
        public double sub(double a, double b)
        {
            return a - b;
        }
        [WebMethod]
        public double product(double a, double b)
        {
            return a * b;
        }
        [WebMethod]
        public double div(double a, double b)
        {
            if (b == 0) throw new System.Exception("divide by zero");
            return a + b;
        }
    }
}
